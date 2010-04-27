package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.SModel;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.changesmanager.ModelChangesManager;
import jetbrains.mps.changesmanager.ChangesManager;

public class ForceRefreshModelChanges_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ForceRefreshModelChanges_Action.class);

  private SModel model;
  private Project project;

  public ForceRefreshModelChanges_Action() {
    super("Force Refresh Model Changes", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      event.getPresentation().setText("Force Refresh Model Changes for " + ForceRefreshModelChanges_Action.this.model.getModelDescriptor().getName());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ForceRefreshModelChanges", t);
      }
      this.disable(event.getPresentation());
    }
  }

  @Override
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    if (event.getData(MPSDataKeys.CONTEXT_MODEL) == null) {
      return false;
    }
    this.model = event.getData(MPSDataKeys.CONTEXT_MODEL).getSModel();
    if (this.model == null) {
      return false;
    }
    this.project = event.getData(MPSDataKeys.PROJECT);
    if (this.project == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      final Wrappers._T<ModelChangesManager> modelChangesManager = new Wrappers._T<ModelChangesManager>();
      ChangesManager.getInstance(ForceRefreshModelChanges_Action.this.project).getCommandQueue().runTask(new Runnable() {
        public void run() {
          modelChangesManager.value = ChangesManager.getInstance(ForceRefreshModelChanges_Action.this.project).getModelChangesManager(ForceRefreshModelChanges_Action.this.model.getModelDescriptor());
        }
      });
      if (modelChangesManager.value != null) {
        modelChangesManager.value.update(null);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ForceRefreshModelChanges", t);
      }
    }
  }
}
