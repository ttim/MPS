package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import jetbrains.mps.logging.Logger;
import javax.swing.Icon;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.plugins.MacrosUtil;
import jetbrains.mps.project.MPSProject;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;

public class ShowTodoViewer_Action extends GeneratedAction {
  public static final Logger LOG = Logger.getLogger(ShowTodoViewer_Action.class);
  public static final Icon ICON = IconManager.loadIcon(MacrosUtil.expandPath("${language_descriptor}\\source\\jetbrains\\mps\\baseLanguage\\plugin\\todo.png", "jetbrains.mps.baseLanguage"), true);

  public MPSProject project;

  public ShowTodoViewer_Action() {
    super("Show Todo Tool", "", ICON);
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
      LOG.error("User's action doUpdate method failed. Action:" + "ShowTodoViewer", t);
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
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
      ShowTodoViewer_Action.this.project.getPluginManager().getTool(TodoViewer_Tool.class).openToolLater(true);
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "ShowTodoViewer", t);
    }
  }

}
