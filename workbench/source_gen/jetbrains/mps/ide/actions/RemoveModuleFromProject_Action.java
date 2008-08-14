package jetbrains.mps.ide.actions;

/*Generated by MPS */

import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import jetbrains.mps.project.DevKit;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.Solution;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.workbench.MPSDataKeys;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;

public class RemoveModuleFromProject_Action extends GeneratedAction {
  public static final Logger LOG = Logger.getLogger(RemoveModuleFromProject_Action.class);
  public static final Icon ICON = null;

  public IOperationContext context;
  public MPSProject project;

  public RemoveModuleFromProject_Action() {
    super("Remove From Project", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event) {
    IModule module = RemoveModuleFromProject_Action.this.context.getModule();
    if (module == null) {
      return false;
    }
    return RemoveModuleFromProject_Action.this.project.isProjectModule(module);
  }

  public void doUpdate(@NotNull()AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "RemoveModuleFromProject", t);
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    try {
      if (!(super.collectActionData(event))) {
        return false;
      }
      this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
      if (this.context == null) {
        return false;
      }
      this.project = event.getData(MPSDataKeys.MPS_PROJECT);
      if (this.project == null) {
        return false;
      }
    } catch (Throwable t) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull() final AnActionEvent event) {
    try {
      IModule module = RemoveModuleFromProject_Action.this.context.getModule();
      if (module instanceof Language) {
        RemoveModuleFromProject_Action.this.project.removeProjectLanguage((Language) module);
      } else if (module instanceof Solution) {
        RemoveModuleFromProject_Action.this.project.removeProjectSolution((Solution) module);
      } else if (module instanceof DevKit) {
        RemoveModuleFromProject_Action.this.project.removeProjectDevKit((DevKit) module);
      }
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "RemoveModuleFromProject", t);
    }
  }

}
