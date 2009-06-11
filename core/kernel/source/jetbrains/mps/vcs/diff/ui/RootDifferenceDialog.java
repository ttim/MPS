package jetbrains.mps.vcs.diff.ui;


import jetbrains.mps.ide.dialogs.BaseDialog;
import jetbrains.mps.ide.NodeEditor;
import jetbrains.mps.smodel.*;
import jetbrains.mps.nodeEditor.*;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.vcs.diff.changes.*;
import jetbrains.mps.vcs.diff.DiffBuilder;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

public class RootDifferenceDialog extends BaseDialog implements EditorMessageOwner {
  private JPanel myComponent;
  private SModel myNewModel;
  private SModel myOldModel;
  private List<ChangeEditorMessage> myNewChanges = new ArrayList<ChangeEditorMessage>();
  private List<ChangeEditorMessage> myOldChanges = new ArrayList<ChangeEditorMessage>();
  private static final Color NEW_COLOR = new Color(186, 238, 186);
  private static final Color CHANGE_COLOR = new Color(188, 207, 249);
  private static final Color DELETE_COLOR = new Color(203, 203, 203);
  private DiffEditorComponent myNewEditorComponent;
  private DiffEditorComponent myOldEditorComponent;

  public RootDifferenceDialog(Frame parent, final SModel newModel, final SModel oldModel, boolean editable) throws HeadlessException {
    super(parent, "Difference");
    myComponent = new JPanel(new GridLayout(1, 2));
    myNewModel = newModel;
    myOldModel = oldModel;
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        myNewEditorComponent.dispose();
        myOldEditorComponent.dispose();
      }
    });
  }

  public void init(final IOperationContext context, final SNode node, String newRevisionName, String oldRevisionName) {
    final SNode[] oldNode = new SNode[1];
    final SNode[] newNode = new SNode[1];

    ModelAccess.instance().runWriteActionInCommand(new Runnable() {

      public void run() {
        oldNode[0] = myOldModel.getRootByName(node.getName());
        newNode[0] = myNewModel.getRootByName(node.getName());
      }
    });

    myOldEditorComponent = addEditor(context, oldNode[0], oldRevisionName);
    myNewEditorComponent = addEditor(context, newNode[0], newRevisionName);

    myNewEditorComponent.getViewport().addChangeListener(new ChangeListener() {

      public void stateChanged(ChangeEvent e) {
        myOldEditorComponent.getViewport().setViewPosition(myNewEditorComponent.getViewport().getViewPosition());
      }
    });

    myOldEditorComponent.getViewport().addChangeListener(new ChangeListener() {

      public void stateChanged(ChangeEvent e) {
        myNewEditorComponent.getViewport().setViewPosition(myOldEditorComponent.getViewport().getViewPosition());
      }
    });


    rebuildChangeBlocks();
  }

  private DiffEditorComponent addEditor(IOperationContext context, SNode node, String revisionName) {
    DiffEditorComponent result = new DiffEditorComponent(context, node);
    result.editNode(node, context);
    result.setEditable(false);
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(new JLabel(revisionName), BorderLayout.NORTH);
    panel.add(result.getExternalComponent(), BorderLayout.CENTER);
    myComponent.add(panel);
    return result;
  }

  private void rebuildChangeBlocks() {
    for (ChangeEditorMessage message: myNewChanges) {
      myNewEditorComponent.getHighlightManager().removeMessage(message);
    }
    for (ChangeEditorMessage message: myOldChanges) {
      myOldEditorComponent.getHighlightManager().removeMessage(message);
    }
    myNewEditorComponent.removeAllChanges();
    myOldEditorComponent.removeAllChanges();
    myNewChanges.clear();
    myOldChanges.clear();

    List<Change> revertChanges = new DiffBuilder(myNewModel, myOldModel).getChanges();
    myNewChanges = hightlight(revertChanges, myNewEditorComponent, myNewModel, true);
    myOldChanges = hightlight(revertChanges, myOldEditorComponent, myOldModel, false);
    makeChangeBlocks(myNewEditorComponent, new ArrayList<ChangeEditorMessage>(myNewChanges));
    makeChangeBlocks(myOldEditorComponent, new ArrayList<ChangeEditorMessage>(myOldChanges));    
  }

  private void makeChangeBlocks(EditorComponent editorComponent, List<ChangeEditorMessage> changes) {
    editorComponent.relayout();
    final NodeHighlightManager highlightManager = editorComponent.getHighlightManager();
    highlightManager.rebuildMessages();
    for (Iterator<ChangeEditorMessage> iterator = changes.iterator(); iterator.hasNext();) {
      ChangeEditorMessage change = iterator.next();
      if (highlightManager.getCell(change) == null) {
        iterator.remove();
      }
    }
    Collections.sort(changes, new Comparator<ChangeEditorMessage>() {

      public int compare(ChangeEditorMessage o1, ChangeEditorMessage o2) {
        return highlightManager.getCell(o1).getY() - highlightManager.getCell(o2).getY();
      }
    });

    ChangesBlock block = null;

    for (ChangeEditorMessage m: changes) {    
      EditorCell cell = highlightManager.getCell(m);
      if (block == null) {
        block = createChangeBlock(editorComponent, changes);
      } else {
        if (block.getY2() < cell.getY()) {
          editorComponent.addChanges(block);
          block = createChangeBlock(editorComponent, changes);          
        }
      }
      block.addChange(m, cell);
    }
    if (block != null) {
      editorComponent.addChanges(block);
    }
  }

  private ChangesBlock createChangeBlock(final EditorComponent editorComponent, final List<ChangeEditorMessage> changes) {
    return new ChangesBlock() {

      protected void revert() {
        ModelAccess.instance().runWriteActionInCommand(new Runnable() {

          public void run() {
            List<ChangeEditorMessage> notAppliedChanges = new ArrayList<ChangeEditorMessage>();
            notAppliedChanges.addAll(myNewChanges);
            notAppliedChanges.addAll(myOldChanges);
            
            for (ChangeEditorMessage m: getChanges()) {
              applyMeassage(notAppliedChanges, m);
            }
          }
        });
        ModelAccess.instance().runReadAction(new Runnable() {

          public void run() {
            rebuildChangeBlocks();
          }
        });
      }
    };
  }

  private void applyMeassage(List<ChangeEditorMessage> notAppliedChanges, ChangeEditorMessage m) {
    if (!notAppliedChanges.contains(m)) {
      return;
    }
    for (SNodeId usedNodeId: m.getChange().getDependences()) {
      for (ChangeEditorMessage message: notAppliedChanges) {
        Change change = message.getChange();
        if (change instanceof NewNodeChange || change instanceof DeleteNodeChange || change instanceof MoveNodeChange) {
          if (change.getAffectedNodeId().equals(usedNodeId)) {
            applyMeassage(notAppliedChanges, message);
            break;
          }
        }
      }
    }
    m.getChange().apply(myNewModel);    
    notAppliedChanges.remove(m);
  }


  private List hightlight(final List<Change> revertChanges, final EditorComponent editorComponent, final SModel model, final boolean isNew) {
    final List resultChanges = new ArrayList<Change>();
    ModelAccess.instance().runReadAction(new Runnable() {

      public void run() {
        for (Change change: revertChanges) {

          if (change instanceof SetReferenceChange) {
            SetReferenceChange referenceChange = (SetReferenceChange)change;            

            ChangeEditorMessage message = new ChangeEditorMessage(change, model.getNodeById(change.getAffectedNodeId()), CHANGE_COLOR, "", RootDifferenceDialog.this);
            message.setRole(referenceChange.getRole());

            resultChanges.add(message);
            editorComponent.getHighlightManager().mark(message);
          }

          if (change instanceof MoveNodeChange || change instanceof ChangeConceptChange) {            
            ChangeEditorMessage message = new ChangeEditorMessage(change, model.getNodeById(change.getAffectedNodeId()), CHANGE_COLOR, "", RootDifferenceDialog.this);
            resultChanges.add(message);
            editorComponent.getHighlightManager().mark(message);
          }

          if (change instanceof NewNodeChange) {
            if (!isNew) {
            SNode removedNode = model.getNodeById(change.getAffectedNodeId());

            ChangeEditorMessage message = new ChangeEditorMessage(change, removedNode, DELETE_COLOR, "", RootDifferenceDialog.this);
            resultChanges.add(message);
            editorComponent.getHighlightManager().mark(message);
            }
          }

          if (change instanceof SetPropertyChange) {
            SetPropertyChange propertyChange = (SetPropertyChange)change;
            ChangeEditorMessage message = new ChangeEditorMessage(change, model.getNodeById(change.getAffectedNodeId()), CHANGE_COLOR, "", RootDifferenceDialog.this);
            message.setProperty(propertyChange.getProperty());
            resultChanges.add(message);
            editorComponent.getHighlightManager().mark(message);
          }

          if (change instanceof DeleteNodeChange) {
            if (isNew) {
              SNode removedNode = model.getNodeById(change.getAffectedNodeId());
              ChangeEditorMessage message = new ChangeEditorMessage(change, removedNode, NEW_COLOR, "", RootDifferenceDialog.this);
              resultChanges.add(message);
              editorComponent.getHighlightManager().mark(message);
            }
          }
          
        }
      }
    });

    return resultChanges;
  }

  protected JComponent getMainComponent() {
    return myComponent;
  }
}
