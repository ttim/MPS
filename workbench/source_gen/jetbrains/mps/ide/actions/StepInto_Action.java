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

public class StepInto_Action extends GeneratedAction {
  private static final Icon ICON = IconManager.loadIcon(MacrosUtil.expandPath("${solution_descriptor}/icons/debug/stepInto.png", "jetbrains.mps.ide"), true);
  protected static Log log = LogFactory.getLog(StepInto_Action.class);

  private Project project;

  public StepInto_Action() {
    super("Step Into", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return " F7";
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      event.getPresentation().setEnabled(StepInto_Action.this.getDebugSession() != null && StepInto_Action.this.getDebugSession().isPaused());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "StepInto", t);
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
      StepInto_Action.this.getDebugSession().stepInto();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "StepInto", t);
      }
    }
  }

  private DebugSession getDebugSession() {
    return DebugManagerComponent.getInstance(StepInto_Action.this.project).getCurrentDebugSession();
  }
}
