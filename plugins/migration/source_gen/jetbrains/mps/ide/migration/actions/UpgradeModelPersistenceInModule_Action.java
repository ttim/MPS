package jetbrains.mps.ide.migration.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.ide.migration.persistence.PersistenceUpdater;
import jetbrains.mps.project.IModule;
import java.awt.Frame;

public class UpgradeModelPersistenceInModule_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(UpgradeModelPersistenceInModule_Action.class);

  public UpgradeModelPersistenceInModule_Action() {
    super("Upgrade Models Persistence in Selected Module", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "UpgradeModelPersistenceInModule", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("mainFrame", event.getData(MPSCommonDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("mainFrame") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("module", event.getData(MPSDataKeys.MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      PersistenceUpdater persistenceUpdater = new PersistenceUpdater();
      persistenceUpdater.upgradePersistenceInModule(((IModule) MapSequence.fromMap(_params).get("module")), ((Frame) MapSequence.fromMap(_params).get("mainFrame")));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "UpgradeModelPersistenceInModule", t);
      }
    }
  }
}
