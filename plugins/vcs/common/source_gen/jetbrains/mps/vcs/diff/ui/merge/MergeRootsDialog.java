package jetbrains.mps.vcs.diff.ui.merge;

/*Generated by MPS */

import com.intellij.openapi.ui.DialogWrapper;
import jetbrains.mps.vcs.diff.merge.MergeSession;
import jetbrains.mps.vcs.diff.ui.common.ChangeEditorMessage;
import jetbrains.mps.smodel.SNodeId;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import jetbrains.mps.vcs.diff.ui.common.DiffEditor;
import java.util.List;
import jetbrains.mps.vcs.diff.ui.common.ChangeGroupLayout;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.vcs.diff.ui.common.DiffEditorSeparator;
import jetbrains.mps.vcs.diff.ui.common.DiffEditorsGroup;
import jetbrains.mps.vcs.diff.merge.MergeSessionState;
import com.intellij.openapi.diff.ex.DiffStatusBar;
import com.intellij.openapi.diff.impl.util.TextDiffType;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.ModelAccess;
import javax.swing.JSplitPane;
import jetbrains.mps.vcs.diff.ui.common.NextPreviousTraverser;
import jetbrains.mps.workbench.action.ActionUtils;
import com.intellij.openapi.actionSystem.Separator;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.Dimension;
import com.intellij.openapi.util.DimensionService;
import java.awt.Point;
import jetbrains.mps.vcs.diff.ui.common.DiffChangeGroupLayout;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.vcs.diff.ui.common.ChangeGroupMessages;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.vcs.diff.ui.common.DiffTemporaryModule;
import org.jetbrains.annotations.Nullable;
import javax.swing.JComponent;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import javax.swing.Action;
import jetbrains.mps.project.Project;
import jetbrains.mps.ide.project.ProjectHelper;
import java.awt.GraphicsDevice;
import java.awt.HeadlessException;
import jetbrains.mps.vcs.diff.ui.common.GoToNeighbourRootActions;
import org.jetbrains.annotations.NotNull;

public class MergeRootsDialog extends DialogWrapper {
  private MergeSession myMergeSession;
  private boolean myDisposed = false;
  private ChangeEditorMessage.ConflictChecker myConflictChecker;
  private MergeModelsDialog myModelsDialog;
  private SNodeId myRootId;
  private JPanel myContainer = new JPanel(new BorderLayout());
  private JPanel myTopPanel = new JPanel(new GridBagLayout());
  private JPanel myBottomPanel = new JPanel(new GridBagLayout());
  private DiffEditor myResultEditor;
  private DiffEditor myMineEditor;
  private DiffEditor myRepositoryEditor;
  private List<ChangeGroupLayout> myChangeGroupLayouts = ListSequence.fromList(new ArrayList<ChangeGroupLayout>());
  private List<DiffEditorSeparator> myEdtiorSeparators = ListSequence.fromList(new ArrayList<DiffEditorSeparator>());
  private DiffEditorsGroup myDiffEditorsGroup = new DiffEditorsGroup();
  private MergeSessionState myStateToRestore;
  private DiffStatusBar myStatusBar = new DiffStatusBar(TextDiffType.MERGE_TYPES);
  private DefaultActionGroup myActionGroup;

  public MergeRootsDialog(MergeModelsDialog mergeModelsDialog, MergeSession mergeSession, SNodeId rootId, String rootName) {
    super(mergeModelsDialog.getWindow(), true);
    setTitle("Merging " + rootName);
    myConflictChecker = new ChangeEditorMessage.ConflictChecker() {
      public boolean isChangeConflicted(ModelChange ch) {
        return Sequence.fromIterable(myMergeSession.getConflictedWith(ch)).isNotEmpty();
      }
    };
    myModelsDialog = mergeModelsDialog;
    myMergeSession = mergeSession;
    myRootId = rootId;
    myStateToRestore = myMergeSession.getCurrentState();

    myMineEditor = addEditor(0, myMergeSession.getMyModel());
    myResultEditor = addEditor(1, myMergeSession.getResultModel());
    myRepositoryEditor = addEditor(2, myMergeSession.getRepositoryModel());

    linkEditors(true, false);
    linkEditors(false, false);
    linkEditors(true, true);
    linkEditors(false, true);

    myMergeSession.setChangesInvalidateHandler(new MergeSession.ChangesInvalidateHandler() {
      public void someChangesInvalidated() {
        ModelAccess.instance().runWriteInEDT(new Runnable() {
          public void run() {
            rehighlight();
          }
        });
      }
    });

    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, myTopPanel, myBottomPanel);
    splitPane.setResizeWeight(0.7);
    MergeRootsDialog.MyGoToNeighbourRootActions neighbourActions = new MergeRootsDialog.MyGoToNeighbourRootActions();
    NextPreviousTraverser neighbourTraverser = new NextPreviousTraverser(myChangeGroupLayouts, myResultEditor.getMainEditor());
    myActionGroup = ActionUtils.groupFromActions(new ApplyNonConflictsForRoot(this), Separator.getInstance(), neighbourActions.previous(), neighbourActions.next(), Separator.getInstance(), neighbourTraverser.previousAction(), neighbourTraverser.nextAction());
    ActionToolbar toolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, myActionGroup, true);
    neighbourTraverser.setActionToolbar(toolbar);

    myContainer.add(toolbar.getComponent(), BorderLayout.NORTH);
    myContainer.add(splitPane, BorderLayout.CENTER);
    myContainer.add(this.myStatusBar, BorderLayout.SOUTH);
    highlightAllChanges();

    neighbourTraverser.goToFirstChangeLater();
    DisplayMode displayMode = check_3816sg_a0hb0a(check_3816sg_a0a33a0(GraphicsEnvironment.getLocalGraphicsEnvironment()));
    int width = (displayMode == null ?
      800 :
      displayMode.getWidth() - 100
    );
    int height = (displayMode == null ?
      600 :
      displayMode.getHeight() - 100
    );
    final Dimension size = DimensionService.getInstance().getSize(getDimensionServiceKey());
    if (size == null) {
      myContainer.setPreferredSize(new Dimension(width, height));
    }

    final Point location = DimensionService.getInstance().getLocation(getDimensionServiceKey());
    if (location == null) {
      setLocation(50, 50);
    }
    init();

  }

  private ChangeGroupLayout createChangeGroupLayout(boolean mine, boolean inspector) {
    return new DiffChangeGroupLayout(myConflictChecker, (mine ?
      myMergeSession.getMyChangeSet() :
      myMergeSession.getRepositoryChangeSet()
    ), (mine ?
      myMineEditor :
      myResultEditor
    ), (mine ?
      myResultEditor :
      myRepositoryEditor
    ), inspector);
  }

  public String getDimensionServiceKey() {
    return getClass().getName();
  }

  public void rehighlight() {
    if (myDisposed) {
      return;
    }
    myMineEditor.unhighlightAllChanges();
    myResultEditor.unhighlightAllChanges();
    myRepositoryEditor.unhighlightAllChanges();

    if (myResultEditor.getEditedNode() == null) {
      SModel resultModel = myMergeSession.getResultModel();
      SNodeId nodeId = getRootNodeId(resultModel);
      if (nodeId != null) {
        myResultEditor.editRoot(myModelsDialog.getProject(), nodeId, resultModel);
      }
    }

    myResultEditor.getMainEditor().rebuildEditorContent();

    highlightAllChanges();
  }

  private void highlightAllChanges() {
    ListSequence.fromList(myChangeGroupLayouts).visitAll(new IVisitor<ChangeGroupLayout>() {
      public void visit(ChangeGroupLayout b) {
        b.invalidate();
      }
    });

    List<ModelChange> changesForRoot = ListSequence.fromList(myMergeSession.getChangesForRoot(myRootId)).where(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange ch) {
        return !(myMergeSession.isChangeResolved(ch));
      }
    }).toListSequence();
    for (ModelChange change : ListSequence.fromList(changesForRoot)) {
      higlightChange(myResultEditor, myMergeSession.getResultModel(), change);
      if (myMergeSession.isMyChange(change)) {
        higlightChange(myMineEditor, myMergeSession.getMyModel(), change);
      } else {
        higlightChange(myRepositoryEditor, myMergeSession.getRepositoryModel(), change);
      }
    }
    ListSequence.fromList(myChangeGroupLayouts).visitAll(new IVisitor<ChangeGroupLayout>() {
      public void visit(ChangeGroupLayout b) {
        b.invalidate();
      }
    });

    myMineEditor.repaintAndRebuildEditorMessages();
    myResultEditor.repaintAndRebuildEditorMessages();
    myRepositoryEditor.repaintAndRebuildEditorMessages();
    int conflictingChanges = ListSequence.fromList(changesForRoot).where(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange ch) {
        return Sequence.fromIterable(myMergeSession.getConflictedWith(ch)).isNotEmpty();
      }
    }).count();
    myStatusBar.setText(MergeModelsDialog.generateUnresolvedChangesText(ListSequence.fromList(changesForRoot).count(), conflictingChanges));
  }

  private void higlightChange(DiffEditor diffEditor, SModel model, ModelChange change) {
    diffEditor.highlightChange(model, change, myConflictChecker);
  }

  private void linkEditors(boolean mine, boolean inspector) {
    // create change group builder, trapecium strip and merge buttons painter 
    // 'mine' parameter means mine changeset, 'inspector' - highlight inspector editor component 
    ChangeGroupLayout layout = createChangeGroupLayout(mine, inspector);
    ChangeGroupMessages.startMaintaining(layout);
    ListSequence.fromList(myChangeGroupLayouts).addElement(layout);
    DiffEditorSeparator separator = new DiffEditorSeparator(layout);
    JPanel panel = (inspector ?
      myBottomPanel :
      myTopPanel
    );
    GridBagConstraints gbc = new GridBagConstraints((mine ?
      1 :
      3
    ), 0, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 0, 5, 0), 0, 0);
    panel.add(separator, gbc);
    ListSequence.fromList(myEdtiorSeparators).addElement(separator);
    MergeButtonsPainter.addTo(this, (mine ?
      myMineEditor :
      myRepositoryEditor
    ), layout, inspector);
  }

  private SNodeId getRootNodeId(SModel model) {
    SNode node = model.getNodeById(myRootId);
    if (node != null && node.getParent() == null) {
      return myRootId;
    }
    if (model == myMergeSession.getResultModel()) {
      SNodeId replacement = myMergeSession.getReplacementId(myRootId);
      if (replacement != null) {
        return replacement;
      }
    }
    return null;
  }

  private DiffEditor addEditor(int index, SModel model) {
    SNodeId rootId = getRootNodeId(model);
    SNode root = (rootId == null ?
      null :
      model.getNodeById(rootId)
    );
    final DiffEditor result = new DiffEditor(DiffTemporaryModule.getOperationContext(myModelsDialog.getProject(), model), root, myModelsDialog.getContentTitles()[index], index == 0);

    GridBagConstraints gbc = new GridBagConstraints(index * 2, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, (index == 0 ?
      5 :
      0
    ), 5, (index == 2 ?
      5 :
      0
    )), 0, 0);
    myTopPanel.add(result.getTopComponent(), gbc);
    myBottomPanel.add(result.getInspector().getExternalComponent(), gbc);

    myDiffEditorsGroup.add(result);
    return result;
  }

  public SNodeId getRootId() {
    return myRootId;
  }

  /*package*/ MergeModelsDialog getModelsDialog() {
    return myModelsDialog;
  }

  @Nullable
  protected JComponent createCenterPanel() {
    return myContainer;
  }

  protected void doOKAction() {
    MergeConfirmation.showMergeConfirmationAndTakeAction(this, myMergeSession, myMergeSession.getChangesForRoot(myRootId), new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        myMergeSession.applyChanges(myMergeSession.getApplicableChangesForRoot(myRootId));
      }
    }, new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        saveAndClose();
      }
    });
  }

  protected Action[] createActions() {
    List<Action> actions = ListSequence.fromList(new ArrayList<Action>());
    ListSequence.fromList(actions).addElement(getOKAction());
    ListSequence.fromList(actions).addElement(getCancelAction());
    return ListSequence.fromList(actions).toGenericArray(Action.class);
  }

  public void saveAndClose() {
    myStateToRestore = null;
    close(DialogWrapper.OK_EXIT_CODE);
  }

  /*package*/ MergeSession getMergeSession() {
    return myMergeSession;
  }

  public void resetState() {
    Project project = ProjectHelper.toMPSProject(myModelsDialog.getProject());
    Runnable r = new Runnable() {
      public void run() {
        myModelsDialog.restoreState(myStateToRestore);
      }
    };
    if (project != null) {
      ModelAccess.instance().runCommandInEDT(r, project);
    } else {
      ModelAccess.instance().runWriteActionInCommand(r);
    }
  }

  @Override
  public void dispose() {
    synchronized (this) {
      if (myDisposed) {
        return;
      }
      if (myStateToRestore == null) {
        myModelsDialog.rebuildLater();
      } else {
        resetState();
      }
      myActionGroup.removeAll();
      myModelsDialog.rootsDialogClosed();
      myMineEditor.dispose();
      myMineEditor = null;
      myResultEditor.dispose();
      myResultEditor = null;
      myRepositoryEditor.dispose();
      myRepositoryEditor = null;
      ListSequence.fromList(myEdtiorSeparators).visitAll(new IVisitor<DiffEditorSeparator>() {
        public void visit(DiffEditorSeparator s) {
          s.dispose();
        }
      });
      ListSequence.fromList(myEdtiorSeparators).clear();
      myDisposed = true;
    }
    super.dispose();
  }

  private static DisplayMode check_3816sg_a0hb0a(GraphicsDevice checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getDisplayMode();
    }
    return null;
  }

  private static GraphicsDevice check_3816sg_a0a33a0(GraphicsEnvironment checkedDotOperand) throws HeadlessException {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getDefaultScreenDevice();
    }
    return null;
  }

  private class MyGoToNeighbourRootActions extends GoToNeighbourRootActions {
    public MyGoToNeighbourRootActions() {
    }

    protected void goTo(@NotNull SNodeId rootId) {
      saveAndClose();
      myModelsDialog.invokeMergeRoots(rootId);
    }

    @Nullable
    protected SNodeId getNeighbourId(boolean next) {
      return myModelsDialog.getNeighbourRoot(myRootId, next);
    }
  }
}
