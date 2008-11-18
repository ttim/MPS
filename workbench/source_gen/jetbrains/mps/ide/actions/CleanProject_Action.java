package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import jetbrains.mps.logging.Logger;

import javax.swing.Icon;

import jetbrains.mps.smodel.IOperationContext;
import com.intellij.openapi.project.Project;
import jetbrains.mps.project.MPSProject;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;

import java.util.Set;

import jetbrains.mps.project.IModule;

import java.util.LinkedHashSet;

import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.make.ModuleMaker;

public class CleanProject_Action extends GeneratedAction {
  private static final Logger LOG = Logger.getLogger(CleanProject_Action.class);
  private static final Icon ICON = null;

  public IOperationContext context;
  public Project ideaProject;
  public MPSProject project;

  public CleanProject_Action() {
    super("Clean", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull()
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull() AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "CleanProject", t);
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.context == null) {
      return false;
    }
    this.ideaProject = event.getData(MPSDataKeys.PROJECT);
    if (this.ideaProject == null) {
      return false;
    }
    this.project = event.getData(MPSDataKeys.MPS_PROJECT);
    if (this.project == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull() final AnActionEvent event) {
    try {
      final Set<IModule> modulesToBuild = new LinkedHashSet<IModule>();
      modulesToBuild.addAll(CleanProject_Action.this.project.getProjectSolutions());
      modulesToBuild.addAll(CleanProject_Action.this.project.getProjectLanguages());
      modulesToBuild.addAll(CleanProject_Action.this.project.getProjectDevKits());
      ProgressManager.getInstance().run(new Task.Modal(CleanProject_Action.this.ideaProject, "Cleaning", true) {

        public void run(@NotNull() final ProgressIndicator indicator) {
          ModelAccess.instance().runReadAction(new Runnable() {

            public void run() {
              ModuleMaker maker = new ModuleMaker();
              maker.clean(modulesToBuild, indicator);
            }

          });
        }

      });
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "CleanProject", t);
    }
  }

}
