package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.plugins.MacrosUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.ide.properties.StandardDialogs;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.IOperationContext;

public class ModelPropertiesWOShortcut_Action extends GeneratedAction {
  private static final Icon ICON = IconManager.loadIcon(MacrosUtil.expandPath("${solution_descriptor}/icons/modelProperties.png", "jetbrains.mps.ide"), true);
  protected static Log log = LogFactory.getLog(ModelPropertiesWOShortcut_Action.class);

  public ModelPropertiesWOShortcut_Action() {
    super("Model Properties", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ModelPropertiesWOShortcut", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("model", event.getData(MPSDataKeys.CONTEXT_MODEL));
    if (MapSequence.fromMap(_params).get("model") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("place", event.getData(MPSDataKeys.PLACE));
    if (MapSequence.fromMap(_params).get("place") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      StandardDialogs.createModelPropertiesDialog(((SModelDescriptor) MapSequence.fromMap(_params).get("model")), ((IOperationContext) MapSequence.fromMap(_params).get("context"))).showDialog();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ModelPropertiesWOShortcut", t);
      }
    }
  }
}
