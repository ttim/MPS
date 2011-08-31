package jetbrains.mps.ide.migration.actions;

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
import jetbrains.mps.ide.migration.persistence.PersistenceUpdater;
import jetbrains.mps.smodel.SModelDescriptor;
import java.awt.Frame;

public class UpgradeModelPersistenceInModel_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(UpgradeModelPersistenceInModel_Action.class);

  public UpgradeModelPersistenceInModel_Action() {
    super("Upgrade Model Persistence in Selected Model", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "UpgradeModelPersistenceInModel", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("mainFrame", event.getData(MPSDataKeys.FRAME));
    if (MapSequence.<String,Object>fromMap(_params).get("mainFrame") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("modelDescriptor", event.getData(MPSDataKeys.MODEL));
    if (MapSequence.<String,Object>fromMap(_params).get("modelDescriptor") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      PersistenceUpdater persistenceUpdater = new PersistenceUpdater();
      persistenceUpdater.upgradePersistenceInModel(((SModelDescriptor) MapSequence.<String,Object>fromMap(_params).get("modelDescriptor")), ((Frame) MapSequence.<String,Object>fromMap(_params).get("mainFrame")));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "UpgradeModelPersistenceInModel", t);
      }
    }
  }
}
