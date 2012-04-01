package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.awt.datatransfer.StringSelection;
import com.intellij.ide.CopyPasteManagerEx;
import java.awt.Frame;
import jetbrains.mps.smodel.IOperationContext;
import com.intellij.openapi.project.Project;

public class AnalyzeStacktrace_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(AnalyzeStacktrace_Action.class);

  public AnalyzeStacktrace_Action() {
    super("Analyze Stacktrace...", "Open console with the navigation stacktrace", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
    this.setMnemonic("s".charAt(0));
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    if (MPSActionPlaces.MPS_MESSAGES_POPUP.equals(event.getPlace())) {
      return ((Throwable) MapSequence.fromMap(_params).get("exception")) != null;
    }
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "AnalyzeStacktrace", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSCommonDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("exception", event.getData(MPSCommonDataKeys.EXCEPTION));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      Throwable exc = ((Throwable) MapSequence.fromMap(_params).get("exception"));
      if (exc != null) {
        StringWriter writer = new StringWriter();
        exc.printStackTrace(new PrintWriter(writer));
        StringSelection contents = new StringSelection(writer.toString());
        CopyPasteManagerEx.getInstanceEx().setContents(contents);
      }
      AnalyzeStacktraceDialog dialog = new AnalyzeStacktraceDialog(((Frame) MapSequence.fromMap(_params).get("frame")), ((IOperationContext) MapSequence.fromMap(_params).get("context")), ((Project) MapSequence.fromMap(_params).get("project")));
      dialog.showDialog();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "AnalyzeStacktrace", t);
      }
    }
  }
}
