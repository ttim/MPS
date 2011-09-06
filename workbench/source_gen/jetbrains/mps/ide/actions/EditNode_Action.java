package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.workbench.editors.MPSEditorOpener;
import jetbrains.mps.smodel.IOperationContext;

public class EditNode_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(EditNode_Action.class);

  public EditNode_Action() {
    super("Edit", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "EditNode", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      List<SNode> nodes = event.getData(MPSDataKeys.NODES);
      boolean error = false;
      if (nodes != null) {
      }
      if (error || nodes == null) {
        MapSequence.fromMap(_params).put("nodes", null);
      } else {
        MapSequence.fromMap(_params).put("nodes", ListSequence.fromListWithValues(new ArrayList<SNode>(), nodes));
      }
    }
    if (MapSequence.fromMap(_params).get("nodes") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      MPSEditorOpener opener = ((IOperationContext) MapSequence.fromMap(_params).get("context")).getComponent(MPSEditorOpener.class);
      for (SNode node : ((List<SNode>) MapSequence.fromMap(_params).get("nodes"))) {
        if (node != null) {
          opener.editNode(node, ((IOperationContext) MapSequence.fromMap(_params).get("context")));
        }
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "EditNode", t);
      }
    }
  }
}
