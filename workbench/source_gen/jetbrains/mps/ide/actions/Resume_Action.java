package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.plugins.MacrosUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.debug.runtime.DebugSession;
import jetbrains.mps.debug.runtime.DebugManagerComponent;

public class Resume_Action extends GeneratedAction {
  private static final Icon ICON = IconManager.loadIcon(MacrosUtil.expandPath("${solution_descriptor}/icons/debug/resume.png", "jetbrains.mps.ide"), true);
  protected static Log log = LogFactory.getLog(Resume_Action.class);

  private Project project;

  public Resume_Action() {
    super("Resume", "Resume Execution", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return " F9";
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      event.getPresentation().setEnabled(Resume_Action.this.getDebugSession() != null && Resume_Action.this.getDebugSession().isPaused());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "Resume", t);
      }
      this.disable(event.getPresentation());
    }
  }

  @Override
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
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
      Resume_Action.this.getDebugSession().resume();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "Resume", t);
      }
    }
  }

  private DebugSession getDebugSession() {
    return DebugManagerComponent.getInstance(Resume_Action.this.project).getCurrentDebugSession();
  }
}
