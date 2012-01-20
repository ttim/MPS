package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.ide.properties.StandardDialogs;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.IOperationContext;

public class ModelProperties_Action extends BaseAction {
  private static final Icon ICON = IconUtil.getIcon("modelProperties.png");
  protected static Log log = LogFactory.getLog(ModelProperties_Action.class);

  public ModelProperties_Action() {
    super("Model Properties", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ((Integer) MapSequence.fromMap(_params).get("size")) == 1;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ModelProperties", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("model", event.getData(MPSCommonDataKeys.CONTEXT_MODEL));
    if (MapSequence.fromMap(_params).get("model") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("size", event.getData(MPSDataKeys.LOGICAL_VIEW_SELECTION_SIZE));
    if (MapSequence.fromMap(_params).get("size") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("place", event.getData(MPSCommonDataKeys.PLACE));
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
        log.error("User's action execute method failed. Action:" + "ModelProperties", t);
      }
    }
  }
}
