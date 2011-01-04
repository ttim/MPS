package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.plugins.MacrosUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.debug.api.AbstractDebugSession;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.debug.api.AbstractUiState;
import jetbrains.mps.debug.api.programState.IThread;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.debug.api.programState.IStackFrame;
import jetbrains.mps.debug.api.programState.ILocation;
import jetbrains.mps.smodel.IOperationContext;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;

public class ExportThreads_Action extends GeneratedAction {
  private static final Icon ICON = IconManager.loadIcon(MacrosUtil.expandPath("${solution_descriptor}/icons/debug/export.png", "jetbrains.mps.ide"), true);
  protected static Log log = LogFactory.getLog(ExportThreads_Action.class);

  public ExportThreads_Action() {
    super("Export Threads", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        AbstractDebugSession debugSession = DebugActionsUtil.getDebugSession(event);
        event.getPresentation().setEnabled(debugSession != null);
        event.getPresentation().setVisible(true);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ExportThreads", t);
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
    MapSequence.fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      AbstractDebugSession debugSession = DebugActionsUtil.getDebugSession(event);
      AbstractUiState uiState = ((AbstractUiState) debugSession.getUiState());
      StringBuffer sb = new StringBuffer();
      for (IThread thread : ListSequence.fromList(uiState.getThreads())) {
        sb.append(thread.getPresentation());
        sb.append('\n');
        for (IStackFrame frame : ListSequence.fromList(thread.getFrames())) {
          ILocation location = frame.getLocation();
          sb.append('\t');
          sb.append("at ");
          sb.append(location.getUnitName());
          sb.append(".");
          sb.append(location.getRoutineName());
          sb.append("(");
          sb.append(frame.getLocation().getFileName());
          sb.append(":");
          sb.append(location.getLineNumber());
          sb.append(")");
          sb.append('\n');
        }
        sb.append('\n');
      }

      final ExportThreadsDialog dialog = new ExportThreadsDialog(((IOperationContext) MapSequence.fromMap(_params).get("context")), sb);

      ApplicationManager.getApplication().invokeLater(new Runnable() {
        public void run() {
          dialog.showDialog();
        }
      }, ModalityState.NON_MODAL);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ExportThreads", t);
      }
    }
  }
}
