package jetbrains.mps.debugger.api.ui.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.debug.api.breakpoints.IBreakpoint;
import jetbrains.mps.debugger.api.ui.breakpoints.BreakpointsUtil;
import jetbrains.mps.debug.api.breakpoints.ILocationBreakpoint;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.smodel.IOperationContext;

public class ViewBreakpointSourceAction_Action extends BaseAction {
  private static final Icon ICON = IconUtil.getIcon("view_source.png");
  protected static Log log = LogFactory.getLog(ViewBreakpointSourceAction_Action.class);

  public ViewBreakpointSourceAction_Action() {
    super("View Source", "View Source", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        IBreakpoint breakpoint = BreakpointsUtil.MPS_BREAKPOINT.getData(event.getDataContext());
        event.getPresentation().setEnabled(breakpoint != null && breakpoint instanceof ILocationBreakpoint);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ViewBreakpointSourceAction", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      IBreakpoint breakpoint = BreakpointsUtil.MPS_BREAKPOINT.getData(event.getDataContext());
      if (breakpoint == null || !(breakpoint instanceof ILocationBreakpoint)) {
        return;
      }
      BreakpointsUtil.openNode(((IOperationContext) MapSequence.fromMap(_params).get("context")), (ILocationBreakpoint) breakpoint, false, true);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ViewBreakpointSourceAction", t);
      }
    }
  }
}
