package jetbrains.mps.ide.make.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.make.IMakeService;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.List;
import jetbrains.mps.smodel.SModelDescriptor;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.workbench.MPSDataKeys;

public class MakeSelectedModels_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(MakeSelectedModels_Action.class);

  public MakeSelectedModels_Action() {
    super("Make Model", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    if (IMakeService.INSTANCE.get().isSessionActive()) {
      return false;
    }
    String text = new MakeActionParameters(((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context")), ((List<SModelDescriptor>) MapSequence.<String,Object>fromMap(_params).get("models")), ((SModelDescriptor) MapSequence.<String,Object>fromMap(_params).get("cmodel")), null, null).actionText(false);
    if (text != null) {
      event.getPresentation().setText(text);
      return true;
    }
    return false;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "MakeSelectedModels", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.<String,Object>fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("models", event.getData(MPSDataKeys.MODELS));
    MapSequence.<String,Object>fromMap(_params).put("cmodel", event.getData(MPSDataKeys.CONTEXT_MODEL));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      new MakeActionImpl(((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context")), new MakeActionParameters(((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context")), ((List<SModelDescriptor>) MapSequence.<String,Object>fromMap(_params).get("models")), ((SModelDescriptor) MapSequence.<String,Object>fromMap(_params).get("cmodel")), null, null), false).executeAction();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "MakeSelectedModels", t);
      }
    }
  }
}
