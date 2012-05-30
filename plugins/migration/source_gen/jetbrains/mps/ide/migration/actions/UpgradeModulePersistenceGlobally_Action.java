package jetbrains.mps.ide.migration.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.smodel.MPSModuleRepository;

public class UpgradeModulePersistenceGlobally_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(UpgradeModulePersistenceGlobally_Action.class);

  public UpgradeModulePersistenceGlobally_Action() {
    super("Upgrade Modules Persistence", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "UpgradeModulePersistenceGlobally", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      for (IModule module : SetSequence.fromSet(MPSModuleRepository.getInstance().getAllModules())) {
        if (module.isPackaged()) {
          continue;
        }
        module.save();
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "UpgradeModulePersistenceGlobally", t);
      }
    }
  }
}
