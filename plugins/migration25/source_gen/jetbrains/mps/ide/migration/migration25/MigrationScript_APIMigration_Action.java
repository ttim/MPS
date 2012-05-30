package jetbrains.mps.ide.migration.migration25;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.ide.script.plugin.migrationtool.MigrationScriptExecutor;
import jetbrains.mps.smodel.IOperationContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.command.CommandProcessorEx;
import jetbrains.mps.progress.ProgressMonitorAdapter;
import com.intellij.openapi.progress.EmptyProgressIndicator;
import java.awt.Frame;

public class MigrationScript_APIMigration_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(MigrationScript_APIMigration_Action.class);

  public MigrationScript_APIMigration_Action() {
    super("Apply MPS API Migration", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "MigrationScript_APIMigration", t);
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
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSCommonDataKeys.FRAME));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      SNodePointer script = new SNodePointer("r:00000000-0000-4000-0000-011c89590367(jetbrains.mps.lang.plugin.scripts)", "8954236049244973041");

      MigrationScriptExecutor executor = new MigrationScriptExecutor(script, "MPS API Migration", ((IOperationContext) MapSequence.fromMap(_params).get("context")), ((Project) MapSequence.fromMap(_params).get("project")));
      if (CommandProcessorEx.getInstance().getCurrentCommand() != null) {
        executor.execImmediately(new ProgressMonitorAdapter(new EmptyProgressIndicator()));
      } else {
        executor.execAsCommand(((Frame) MapSequence.fromMap(_params).get("frame")));
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "MigrationScript_APIMigration", t);
      }
    }
  }
}
