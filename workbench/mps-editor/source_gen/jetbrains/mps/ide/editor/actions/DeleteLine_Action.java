package jetbrains.mps.ide.editor.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import com.intellij.featureStatistics.FeatureUsageTracker;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import java.util.Queue;
import jetbrains.mps.internal.collections.runtime.QueueSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Vertical;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Indent;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Arrays;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.nodeEditor.cells.CellConditions;

public class DeleteLine_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(DeleteLine_Action.class);

  public DeleteLine_Action() {
    super("Delete Line", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return !(((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).isReadOnly());
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "DeleteLine", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorComponent", event.getData(MPSEditorDataKeys.EDITOR_COMPONENT));
    if (MapSequence.fromMap(_params).get("editorComponent") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("currentCell", event.getData(MPSEditorDataKeys.EDITOR_CELL));
    if (MapSequence.fromMap(_params).get("currentCell") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      FeatureUsageTracker.getInstance().triggerFeatureUsed("editing.deleteLine");
      if (((EditorCell) MapSequence.fromMap(_params).get("currentCell")) instanceof EditorCell_Collection) {
        EditorCell_Collection collection = (EditorCell_Collection) ((EditorCell) MapSequence.fromMap(_params).get("currentCell"));
        Queue<EditorCell_Collection> collections = QueueSequence.fromQueue(new LinkedList<EditorCell_Collection>());
        QueueSequence.fromQueue(collections).addLastElement(collection);
        while (QueueSequence.fromQueue(collections).isNotEmpty()) {
          EditorCell_Collection nextCollection = QueueSequence.fromQueue(collections).removeFirstElement();
          if (nextCollection.getCellLayout() instanceof CellLayout_Vertical) {
            return;
          }
          for (EditorCell childCell : Sequence.fromIterable(nextCollection)) {
            if (childCell instanceof EditorCell_Collection) {
              QueueSequence.fromQueue(collections).addLastElement((EditorCell_Collection) childCell);
            }
          }
        }
      }
      EditorCell current = ((EditorCell) MapSequence.fromMap(_params).get("currentCell"));
      List<SNode> nodesToDelete = new ArrayList<SNode>();
      EditorCell cellToSelect = null;
      while (true) {
        if (current.getParent() == null) {
          break;
        }
        CellLayout layout = current.getParent().getCellLayout();
        if (layout instanceof CellLayout_Indent) {
          SNode currentNode = current.getSNode();
          if (SNodeOperations.isInstanceOf(currentNode, "jetbrains.mps.baseLanguage.structure.Statement") || (SNodeOperations.getAncestor(currentNode, "jetbrains.mps.baseLanguage.structure.Statement", false, false) == null)) {
            EditorCell root = current.getRootParent();
            EditorCell[] siblings = current.getParent().getCells();
            for (int i = Arrays.asList(siblings).indexOf(current); i <= siblings.length - 1; i++) {
              EditorCell sibling = siblings[i];
              ListSequence.fromList(nodesToDelete).addElement(sibling.getSNode());
              if (CellLayout_Indent.isNewLineAfter(root, sibling)) {
                cellToSelect = sibling.getNextLeaf(CellConditions.SELECTABLE);
                break;
              }
            }
            if (cellToSelect == null) {
              cellToSelect = current.getNextLeaf(CellConditions.SELECTABLE);
            }
            break;
          }
        } else if (layout instanceof CellLayout_Vertical) {
          if (current.isBigCell()) {
            ListSequence.fromList(nodesToDelete).addElement(current.getSNode());
            cellToSelect = current.getNextLeaf(CellConditions.SELECTABLE);
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
      if (cellToSelect != null) {
        ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).changeSelection(cellToSelect);
        cellToSelect.home();
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "DeleteLine", t);
      }
    }
  }
}
