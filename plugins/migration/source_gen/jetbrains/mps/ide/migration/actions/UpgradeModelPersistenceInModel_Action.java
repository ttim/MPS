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
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.ide.migration.persistence.PersistenceUpdater;
import jetbrains.mps.smodel.SModelDescriptor;
import java.awt.Frame;

public class UpgradeModelPersistenceInModel_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(UpgradeModelPersistenceInModel_Action.class);

  public UpgradeModelPersistenceInModel_Action() {
    super("Upgrade Model Persistence in Selected Model", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
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
        log.error("User's action doUpdate method failed. Action:" + "UpgradeModelPersistenceInModel", t);
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
    MapSequence.fromMap(_params).put("modelDescriptor", event.getData(MPSCommonDataKeys.MODEL));
    if (MapSequence.fromMap(_params).get("modelDescriptor") == null) {
      return false;
    }
    if (!(MapSequence.fromMap(_params).get("modelDescriptor") instanceof EditableSModelDescriptor) || ((EditableSModelDescriptor) MapSequence.fromMap(_params).get("modelDescriptor")).isReadOnly()) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      PersistenceUpdater persistenceUpdater = new PersistenceUpdater();
      persistenceUpdater.upgradePersistenceInModel(((SModelDescriptor) MapSequence.fromMap(_params).get("modelDescriptor")), ((Frame) MapSequence.fromMap(_params).get("mainFrame")));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "UpgradeModelPersistenceInModel", t);
      }
    }
  }
}
