package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import jetbrains.mps.logging.Logger;
import javax.swing.Icon;
import jetbrains.mps.project.MPSProject;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;

public class ShowModelRepository_Action extends GeneratedAction {
  public static final Logger LOG = Logger.getLogger(ShowModelRepository_Action.class);
  public static final Icon ICON = null;

  public MPSProject project;

  public ShowModelRepository_Action() {
    super("Show Model Repository", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull() AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "ShowModelRepository", t);
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    try {
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
      ModelRepository_Tool tool = this.project.getPluginManager().getTool(ModelRepository_Tool.class);
      assert tool != null;
      tool.openTool(true);
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "ShowModelRepository", t);
    }
  }

}
