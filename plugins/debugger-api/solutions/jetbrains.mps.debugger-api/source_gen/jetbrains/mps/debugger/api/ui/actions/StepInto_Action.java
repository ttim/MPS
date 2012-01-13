package jetbrains.mps.debugger.api.ui.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.debug.api.AbstractDebugSession;
import jetbrains.mps.debugger.api.ui.DebugActionsUtil;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import javax.swing.ImageIcon;
import com.intellij.openapi.util.io.StreamUtil;
import com.intellij.util.io.URLUtil;
import java.io.IOException;

public class StepInto_Action extends GeneratedAction {
  private static final Icon ICON = getIcon();
  protected static Log log = LogFactory.getLog(StepInto_Action.class);

  public StepInto_Action() {
    super("Step Into", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        AbstractDebugSession debugSession = DebugActionsUtil.getDebugSession(event);
        event.getPresentation().setEnabled(debugSession != null && debugSession.isStepEnabled());
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "StepInto", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      DebugActionsUtil.getDebugSession(event).stepInto();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "StepInto", t);
      }
    }
  }

  private static Icon getIcon() {
    try {
      return new ImageIcon(StreamUtil.loadFromStream(URLUtil.openStream(StepInto_Action.class.getResource("stepInto.png"))));
    } catch (IOException e) {
      if (log.isWarnEnabled()) {
        log.warn("Couldn't load icon for StepInto", e);
      }
      return null;
    }
  }
}
