package jetbrains.mps.lang.editor.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Vertical;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Indent;
import java.util.Arrays;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class DeleteLine_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(DeleteLine_Action.class);

  private EditorComponent editor;
  private EditorCell currentCell;

  public DeleteLine_Action() {
    super("Delete Line", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "ctrl Y";
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "DeleteLine", t);
      this.disable(event.getPresentation());
    }
  }

  @Override
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.editor = event.getData(MPSDataKeys.EDITOR_COMPONENT);
    if (this.editor == null) {
      return false;
    }
    this.currentCell = event.getData(MPSDataKeys.EDITOR_CELL);
    if (this.currentCell == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      if (DeleteLine_Action.this.currentCell instanceof EditorCell_Collection) {
        EditorCell_Collection collection = (EditorCell_Collection) DeleteLine_Action.this.currentCell;
        List<EditorCell_Collection> cells = ListSequence.fromList(new ArrayList<EditorCell_Collection>());
        List<EditorCell_Collection> newFrontier = ListSequence.fromList(new ArrayList<EditorCell_Collection>());
        ListSequence.fromList(cells).addElement(collection);
        while (!(ListSequence.fromList(cells).isEmpty())) {
          for (EditorCell_Collection cellCollection : cells) {
            if (cellCollection.getCellLayout() instanceof CellLayout_Vertical) {
              return;
            }
            for (EditorCell cell : cellCollection) {
              if (cell instanceof EditorCell_Collection) {
                ListSequence.fromList(newFrontier).addElement((EditorCell_Collection) cell);
              }
            }
          }
          cells = newFrontier;
          newFrontier = ListSequence.fromList(new ArrayList<EditorCell_Collection>());
        }
      }
      EditorCell current = DeleteLine_Action.this.currentCell;
      List<SNode> nodesToDelete = new ArrayList<SNode>();
      while (true) {
        if (current.getParent() == null) {
          break;
        }
        CellLayout layout = current.getParent().getCellLayout();
        if (layout instanceof CellLayout_Indent) {
          EditorCell root = current.getRootParent();
          EditorCell[] siblings = current.getParent().getCells();
          int finish = siblings.length - 1;
          for (int i = Arrays.asList(siblings).indexOf(current); i <= siblings.length - 1; i++) {
            EditorCell sibling = siblings[i];
            ListSequence.fromList(nodesToDelete).addElement(sibling.getSNode());
            if (CellLayout_Indent.isNewLineAfter(root, sibling)) {
              break;
            }
          }
          break;
        } else if (layout instanceof CellLayout_Vertical) {
          if (current.isBigCell()) {
            ListSequence.fromList(nodesToDelete).addElement(current.getSNode());
            break;
          }
        }
        current = current.getParent();
      }
      for (SNode nodeToDelete : nodesToDelete) {
        if ((nodeToDelete != null) && SNodeOperations.getParent(nodeToDelete) != null) {
          SNodeOperations.deleteNode(nodeToDelete);
        }
      }
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "DeleteLine", t);
    }
  }
}
