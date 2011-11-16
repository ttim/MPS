package jetbrains.mps.vcs.changesmanager.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorMessageOwner;
import jetbrains.mps.nodeEditor.EditorComponent;
import java.util.Map;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import java.util.List;
import jetbrains.mps.vcs.diff.ui.common.ChangeEditorMessage;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.vcs.changesmanager.CurrentDifference;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.project.Project;
import jetbrains.mps.vcs.changesmanager.CurrentDifferenceRegistry;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.vcs.diff.ChangeSet;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.ide.ThreadUtils;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.nodeEditor.NodeHighlightManager;
import jetbrains.mps.nodeEditor.leftHighlighter.LeftEditorHighlighter;
import jetbrains.mps.vcs.changesmanager.CurrentDifferenceAdapter;

public class ChangesEditorHighlighter implements EditorMessageOwner {
  private EditorComponent myEditorComponent;
  private final Map<ModelChange, List<ChangeEditorMessage>> myChangesMessages = MapSequence.fromMap(new HashMap<ModelChange, List<ChangeEditorMessage>>());
  private CurrentDifference myCurrentDifference;
  private ChangeStripsPainter myFoldingAreaPainter;
  private ChangesEditorHighlighter.MyCurrentDifferenceListener myListener;
  private final Object myDisposedLock = new Object();
  private boolean myDisposed = false;

  public ChangesEditorHighlighter(@NotNull final Project project, @NotNull final EditorComponent editorComponent) {
    myEditorComponent = editorComponent;

    CurrentDifferenceRegistry.getInstance(project).getCommandQueue().runTask(new Runnable() {
      public void run() {
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            synchronized (myDisposedLock) {
              if (myDisposed) {
                return;
              }
              SNode editedNode = editorComponent.getEditedNode();
              if (editedNode == null || editedNode.isDisposed()) {
                return;
              }
              final SModel model = editedNode.getModel();
              SModelDescriptor descriptor = (model != null ?
                model.getModelDescriptor() :
                null
              );
              if (descriptor instanceof EditableSModelDescriptor) {
                myCurrentDifference = CurrentDifferenceRegistry.getInstance(project).getCurrentDifference((EditableSModelDescriptor) descriptor);
                myListener = new ChangesEditorHighlighter.MyCurrentDifferenceListener();
              }
              if (myListener != null) {
                myCurrentDifference.setEnabled(true);

                ChangeSet changeSet = myCurrentDifference.getChangeSet();
                if (changeSet != null) {
                  ListSequence.fromList(changeSet.getModelChanges()).visitAll(new IVisitor<ModelChange>() {
                    public void visit(ModelChange c) {
                      createMessages(c);
                    }
                  });
                }
                synchronized (myChangesMessages) {
                  Sequence.fromIterable(MapSequence.fromMap(myChangesMessages).values()).visitAll(new IVisitor<List<ChangeEditorMessage>>() {
                    public void visit(List<ChangeEditorMessage> messages) {
                      ListSequence.fromList(messages).visitAll(new IVisitor<ChangeEditorMessage>() {
                        public void visit(ChangeEditorMessage m) {
                          getHighlightManager().mark(m);
                        }
                      });
                    }
                  });
                }
                getHighlightManager().repaintAndRebuildEditorMessages();
                ThreadUtils.runInUIThreadNoWait(new Runnable() {
                  public void run() {
                    myFoldingAreaPainter = new ChangeStripsPainter(ChangesEditorHighlighter.this);
                    myEditorComponent.getLeftEditorHighlighter().addFoldingAreaPainter(myFoldingAreaPainter);
                    myFoldingAreaPainter.relayout();
                  }
                });
                myCurrentDifference.addDifferenceListener(myListener);
              }
            }
          }
        });
      }
    });
  }

  private List<ChangeEditorMessage> createMessages(final ModelChange change) {
    final Wrappers._T<List<ChangeEditorMessage>> messages = new Wrappers._T<List<ChangeEditorMessage>>(null);
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        SModel model;
        SNode editedNode = myEditorComponent.getEditedNode();
        if (editedNode == null || editedNode.isDisposed()) {
          return;
        }
        model = editedNode.getModel();
        if (model == null || model.isDisposed()) {
          return;
        }
        messages.value = ChangeEditorMessage.createMessages(model, change, ChangesEditorHighlighter.this, null, false);
      }
    });
    if (messages.value == null) {
      messages.value = ListSequence.fromList(new ArrayList<ChangeEditorMessage>());
    }
    synchronized (myChangesMessages) {
      if (MapSequence.fromMap(myChangesMessages).containsKey(change)) {
        return ListSequence.fromList(new ArrayList<ChangeEditorMessage>());
      }
      MapSequence.fromMap(myChangesMessages).put(change, messages.value);
    }
    return messages.value;
  }

  private List<ChangeEditorMessage> removeMessages(ModelChange change) {
    synchronized (myChangesMessages) {
      List<ChangeEditorMessage> messages = MapSequence.fromMap(myChangesMessages).get(change);
      if (messages == null || getHighlightManager() == null || ListSequence.fromList(messages).any(new IWhereFilter<ChangeEditorMessage>() {
        public boolean accept(ChangeEditorMessage m) {
          return m.getNode() == null;
        }
      })) {
        return ListSequence.fromList(new ArrayList<ChangeEditorMessage>());
      }
      MapSequence.fromMap(myChangesMessages).removeKey(change);
      return messages;
    }
  }

  /*package*/ List<ChangeEditorMessage> getMessages(ModelChange change) {
    synchronized (myChangesMessages) {
      return MapSequence.fromMap(myChangesMessages).get(change);
    }
  }

  public void dispose() {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        synchronized (myDisposedLock) {
          myDisposed = true;
          try {
            synchronized (myChangesMessages) {
              SetSequence.fromSet(MapSequence.fromMap(myChangesMessages).keySet()).toListSequence().visitAll(new IVisitor<ModelChange>() {
                public void visit(ModelChange ch) {
                  removeMessages(ch);
                }
              });
            }
            getHighlightManager().clearForOwner(ChangesEditorHighlighter.this);
            if (myFoldingAreaPainter != null) {
              getLeftEditorHighlighter().removeFoldingAreaPainter(myFoldingAreaPainter);
            }
          } finally {
            if (myCurrentDifference != null) {
              myCurrentDifference.removeDifferenceListener(myListener);
              myListener = null;
            }
          }
        }
      }
    });
  }

  @Nullable
  /*package*/ ChangeSet getChangeSet() {
    return check_z1nuaw_a0a4(myCurrentDifference);
  }

  /*package*/ EditorComponent getEditorComponent() {
    return myEditorComponent;
  }

  /*package*/ NodeHighlightManager getHighlightManager() {
    return myEditorComponent.getHighlightManager();
  }

  /*package*/ LeftEditorHighlighter getLeftEditorHighlighter() {
    return myEditorComponent.getLeftEditorHighlighter();
  }

  private static ChangeSet check_z1nuaw_a0a4(CurrentDifference checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getChangeSet();
    }
    return null;
  }

  private static void check_z1nuaw_a3a0a2a(ChangeStripsPainter checkedDotOperand) {
    if (null != checkedDotOperand) {
      checkedDotOperand.relayout();
    }

  }

  public class MyCurrentDifferenceListener extends CurrentDifferenceAdapter {
    private List<ChangeEditorMessage> myAddedMessages = ListSequence.fromList(new ArrayList<ChangeEditorMessage>());
    private List<ChangeEditorMessage> myRemovedMessages = ListSequence.fromList(new ArrayList<ChangeEditorMessage>());

    public MyCurrentDifferenceListener() {
    }

    public void changeAdded(@NotNull ModelChange change) {
      List<ChangeEditorMessage> messages = createMessages(change);
      ListSequence.fromList(myRemovedMessages).removeSequence(ListSequence.fromList(messages));
      ListSequence.fromList(myAddedMessages).addSequence(ListSequence.fromList(messages));
    }

    public void changeRemoved(@NotNull ModelChange change) {
      List<ChangeEditorMessage> messages = removeMessages(change);
      ListSequence.fromList(myRemovedMessages).addSequence(ListSequence.fromList(messages));
      ListSequence.fromList(myAddedMessages).removeSequence(ListSequence.fromList(messages));
    }

    @Override
    public void changeUpdateFinished() {
      if (!(ListSequence.fromList(myAddedMessages).isEmpty()) || !(ListSequence.fromList(myRemovedMessages).isEmpty())) {
        NodeHighlightManager nodeHighlightManager = getHighlightManager();
        for (ChangeEditorMessage removedMessage : ListSequence.fromList(myRemovedMessages)) {
          nodeHighlightManager.unmark(removedMessage);
        }
        for (ChangeEditorMessage addedMessage : ListSequence.fromList(myAddedMessages)) {
          nodeHighlightManager.mark(addedMessage);
        }
        check_z1nuaw_a3a0a2a(myFoldingAreaPainter);
        nodeHighlightManager.repaintAndRebuildEditorMessages();
        ListSequence.fromList(myAddedMessages).clear();
        ListSequence.fromList(myRemovedMessages).clear();
      }
    }
  }
}
