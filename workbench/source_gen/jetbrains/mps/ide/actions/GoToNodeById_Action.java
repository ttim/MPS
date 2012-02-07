package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import javax.swing.JOptionPane;
import java.awt.Frame;
import jetbrains.mps.smodel.SModelDescriptor;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.openapi.project.Project;
import jetbrains.mps.workbench.editors.MPSEditorOpener;
import jetbrains.mps.smodel.IOperationContext;

public class GoToNodeById_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(GoToNodeById_Action.class);

  public GoToNodeById_Action() {
    super("Go to Node by ID", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "GoToNodeById", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("model", event.getData(MPSDataKeys.CONTEXT_MODEL));
    if (MapSequence.fromMap(_params).get("model") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      String value = JOptionPane.showInputDialog(((Frame) MapSequence.fromMap(_params).get("frame")), "Enter node ID:", "Find node in model " + ((SModelDescriptor) MapSequence.fromMap(_params).get("model")).getLongName(), JOptionPane.QUESTION_MESSAGE);
      if (value == null) {
        return;
      }
      value = StringUtils.trim(value);
      final Wrappers._T<SNode> node = new Wrappers._T<SNode>();
      final SNodeId id = SNodeId.fromString(value);
      if (id == null) {
        JOptionPane.showMessageDialog(((Frame) MapSequence.fromMap(_params).get("frame")), "Wrong node ID format " + value);
        return;
      }
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          node.value = ((SModelDescriptor) MapSequence.fromMap(_params).get("model")).getSModel().getNodeById(id);
        }
      });
      if (node.value == null) {
        JOptionPane.showMessageDialog(((Frame) MapSequence.fromMap(_params).get("frame")), "Can't find node with id " + value);
        return;
      }
      ((Project) MapSequence.fromMap(_params).get("project")).getComponent(MPSEditorOpener.class).openNode(node.value, ((IOperationContext) MapSequence.fromMap(_params).get("context")), true, true);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "GoToNodeById", t);
      }
    }
  }
}
