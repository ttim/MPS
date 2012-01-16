package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.smodel.DefaultSModelDescriptor;
import org.jetbrains.annotations.NotNull;

public class RevertMemoryChanges_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(RevertMemoryChanges_Action.class);

  public RevertMemoryChanges_Action() {
    super("Revert Memory Changes", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ((SModelDescriptor) MapSequence.fromMap(_params).get("model")) instanceof DefaultSModelDescriptor;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "RevertMemoryChanges", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("model", event.getData(MPSCommonDataKeys.MODEL));
    if (MapSequence.fromMap(_params).get("model") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      ((DefaultSModelDescriptor) ((SModelDescriptor) MapSequence.fromMap(_params).get("model"))).reloadFromDisk();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "RevertMemoryChanges", t);
      }
    }
  }
}
