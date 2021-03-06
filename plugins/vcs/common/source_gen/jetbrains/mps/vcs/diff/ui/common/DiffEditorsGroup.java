package jetbrains.mps.vcs.diff.ui.common;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import java.awt.Point;
import java.awt.Rectangle;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.nodeEditor.selection.SingularSelectionListenerAdapter;
import jetbrains.mps.nodeEditor.selection.SingularSelection;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import jetbrains.mps.internal.collections.runtime.IVisitor;

public class DiffEditorsGroup {
  private List<DiffEditor> myDiffEditors = ListSequence.fromList(new ArrayList<DiffEditor>());
  private DiffEditorsGroup.MyCellSelectionListener myCellSelectionListener = new DiffEditorsGroup.MyCellSelectionListener();
  private boolean myViewportSetInProgress = false;

  public DiffEditorsGroup() {
  }

  public void add(DiffEditor diffEditor) {
    ListSequence.fromList(myDiffEditors).addElement(diffEditor);
    diffEditor.getMainEditor().getSelectionManager().addSelectionListener(myCellSelectionListener);
    diffEditor.getMainEditor().getViewport().addChangeListener(new DiffEditorsGroup.MyViewportChangeListener(diffEditor));
  }

  private static void synchronizeViewWithOther(@NotNull final EditorComponent thisEditor, @NotNull final EditorComponent otherEditor) {
    if (thisEditor == otherEditor) {
      return;
    }
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        int viewY = thisEditor.getViewport().getViewPosition().y;
        SNode visibleNode = thisEditor.getEditedNode();
        if (viewY > thisEditor.getRootCell().getY()) {
          visibleNode = check_s6qw4f_a0a0c0a1a0(thisEditor.findCellWeak(1, viewY));
        }
        SModel otherModel = check_s6qw4f_a0d0a1a0(otherEditor.getEditedNode());
        if (otherModel == null) {
          return;
        }

        while (visibleNode != null) {
          SNodeId id = visibleNode.getSNodeId();
          EditorCell thisCell = thisEditor.findNodeCell(visibleNode);
          if (thisCell != null) {
            int newRelativePos = viewY - thisCell.getY();
            EditorCell otherCell = otherEditor.findNodeCell(otherModel.getNodeById(id));
            Point position = thisEditor.getViewport().getViewPosition();
            if (otherCell != null) {
              Rectangle viewRect = otherEditor.getViewport().getViewRect();
              int newX = Math.min((int) position.getX(), otherEditor.getWidth() - viewRect.width);
              int newY = Math.min(newRelativePos + otherCell.getY(), otherEditor.getHeight() - viewRect.height);
              otherEditor.getViewport().setViewPosition(new Point(newX, newY));
              return;
            }
          }

          SNode prevSibling = SNodeOperations.getPrevSibling(visibleNode);
          if (visibleNode.getRole_().equals(check_s6qw4f_a0a5a6a0b0a(prevSibling))) {
            visibleNode = prevSibling;
          } else {
            visibleNode = visibleNode.getParent();
          }
        }
      }
    });
  }

  private static SNode check_s6qw4f_a0a0c0a1a0(EditorCell checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getSNode();
    }
    return null;
  }

  private static SModel check_s6qw4f_a0d0a1a0(SNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModel();
    }
    return null;
  }

  private static String check_s6qw4f_a0a5a6a0b0a(SNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getRole_();
    }
    return null;
  }

  private static SNodeId check_s6qw4f_a0a0a0a0a(SNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getSNodeId();
    }
    return null;
  }

  private static SNode check_s6qw4f_a0a0a0a0a0(EditorCell checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getSNode();
    }
    return null;
  }

  private static SNode check_s6qw4f_a0a0a0a1a0a0a0(SModel checkedDotOperand, SNodeId selectionId) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getNodeById(selectionId);
    }
    return null;
  }

  private static SModel check_s6qw4f_a0a0a0a0b0a0a0a(SNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModel();
    }
    return null;
  }

  private class MyCellSelectionListener extends SingularSelectionListenerAdapter {
    public MyCellSelectionListener() {
    }

    @Override
    protected void selectionChangedTo(EditorComponent component, final SingularSelection newSelection) {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          SNodeId selectionId = check_s6qw4f_a0a0a0a0a(check_s6qw4f_a0a0a0a0a0(newSelection.getEditorCell()));
          if (selectionId != null) {
            for (DiffEditor diffEditor : ListSequence.fromList(myDiffEditors)) {
              diffEditor.inspect(check_s6qw4f_a0a0a0a1a0a0a0(check_s6qw4f_a0a0a0a0b0a0a0a(diffEditor.getMainEditor().getEditedNode()), selectionId));
            }
          }
        }
      });
    }
  }

  private class MyViewportChangeListener implements ChangeListener {
    private DiffEditor myDiffEditor;

    private MyViewportChangeListener(DiffEditor diffEditor) {
      myDiffEditor = diffEditor;
    }

    public void stateChanged(ChangeEvent event) {
      if (myViewportSetInProgress) {
        return;
      }
      myViewportSetInProgress = true;
      ListSequence.fromList(myDiffEditors).visitAll(new IVisitor<DiffEditor>() {
        public void visit(DiffEditor other) {
          synchronizeViewWithOther(myDiffEditor.getMainEditor(), other.getMainEditor());
        }
      });
      myViewportSetInProgress = false;
    }
  }
}
