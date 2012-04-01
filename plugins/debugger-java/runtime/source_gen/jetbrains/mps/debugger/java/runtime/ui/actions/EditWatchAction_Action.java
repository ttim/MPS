package jetbrains.mps.debugger.java.runtime.ui.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.debugger.java.runtime.ui.evaluation.EvaluationUi;
import jetbrains.mps.debugger.java.runtime.evaluation.model.AbstractEvaluationModel;
import jetbrains.mps.debugger.java.runtime.evaluation.EvaluationProvider;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;

public class EditWatchAction_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(EditWatchAction_Action.class);

  public EditWatchAction_Action() {
    super("Edit Watch", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      event.getPresentation().setVisible(EvaluationUi.EVALUATION_MODEL.getData(event.getDataContext()) != null);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "EditWatchAction", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      AbstractEvaluationModel model = EvaluationUi.EVALUATION_MODEL.getData(event.getDataContext());
      // todo remove cast 
      ((EvaluationProvider) model.getDebugSession().getEvaluationProvider()).showEditWatchDialog(MPSCommonDataKeys.OPERATION_CONTEXT.getData(event.getDataContext()), model);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "EditWatchAction", t);
      }
    }
  }
}
