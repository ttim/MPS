package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.workbench.dialogs.DeleteDialog;
import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.actions.nodes.DeleteNodesHelper;
import jetbrains.mps.smodel.IOperationContext;

public class DeleteNode_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(DeleteNode_Action.class);

  public DeleteNode_Action() {
    super("Delete", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ((List<SNode>) MapSequence.fromMap(_params).get("nodes")).size() != 0;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "DeleteNode", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("nodes", event.getData(MPSCommonDataKeys.NODES));
    if (MapSequence.fromMap(_params).get("nodes") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final Wrappers._boolean safe = new Wrappers._boolean(false);
      final Wrappers._boolean dialogNeeded = new Wrappers._boolean(false);
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          for (SNode node : ((List<SNode>) MapSequence.fromMap(_params).get("nodes"))) {
            if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.ConceptDeclaration") && node.isRoot()) {
              dialogNeeded.value = true;
              break;
            }
          }
        }
      });
      if (dialogNeeded.value) {
        DeleteDialog dialog = new DeleteDialog(((Project) MapSequence.fromMap(_params).get("project")), "Delete Node", "Are you sure you want to delete selected node?");
        dialog.setOptions(false, true, false, false);
        dialog.show();
        if (!(dialog.isOK())) {
          return;
        }
        safe.value = dialog.isSafe();
      }
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          new DeleteNodesHelper(((List<SNode>) MapSequence.fromMap(_params).get("nodes")), ((IOperationContext) MapSequence.fromMap(_params).get("context")), safe.value).deleteNodes(true);
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "DeleteNode", t);
      }
    }
  }
}
