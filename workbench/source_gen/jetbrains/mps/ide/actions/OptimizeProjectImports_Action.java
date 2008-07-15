package jetbrains.mps.ide.actions;

/*Generated by MPS */

import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.ide.MessageDialog;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.Solution;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.workbench.action.ActionEventData;
import jetbrains.mps.workbench.actions.language.OptimizeLanguageImportsAction;
import jetbrains.mps.workbench.actions.solution.OptimizeSolutionImportsAction;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;
import java.awt.Frame;

public class OptimizeProjectImports_Action extends GeneratedAction {
  public static final Logger LOG = Logger.getLogger(OptimizeProjectImports_Action.class);
  public static final Icon ICON = null;

  private MPSProject project;
  private IOperationContext context;
  private Frame frame;

  public OptimizeProjectImports_Action() {
    super("Optimize Imports", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull()AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "OptimizeProjectImports", t);
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    try {
      this.project = new ActionEventData(event).getMPSProject();
      if (this.project == null) {
        return false;
      }
      this.context = new ActionEventData(event).getOperationContext();
      if (this.context == null) {
        return false;
      }
      this.frame = new ActionEventData(event).getFrame();
      if (this.frame == null) {
        return false;
      }
    } catch (Throwable t) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull() final AnActionEvent event) {
    try {
      String report = this.optimizeImports(this.context, this.project);
      new MessageDialog(this.frame, report).showDialog();
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "OptimizeProjectImports", t);
    }
  }

  private String optimizeImports(IOperationContext c, MPSProject p) {
    StringBuilder sb = new StringBuilder();
    for (Language l : p.getProjectLanguages()) {
      sb.append(OptimizeLanguageImportsAction.optimizeImports(c, l));
    }
    for (Solution s : p.getProjectSolutions()) {
      sb.append(OptimizeSolutionImportsAction.optimizeImports(c, s));
    }
    return sb.toString();
  }

}
