package jetbrains.mps.debugger.java.runtime.ui.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.debug.api.programState.IValue;
import jetbrains.mps.debugger.api.ui.tree.VariablesTree;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaValue;
import jetbrains.mps.debugger.api.ui.DebugActionsUtil;
import jetbrains.mps.debugger.java.runtime.evaluation.EvaluationProvider;
import jetbrains.mps.debugger.java.runtime.JavaUiStateImpl;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;
import jetbrains.mps.ide.datatransfer.CopyPasteUtil;
import jetbrains.mps.debug.evaluation.EvaluationUtils;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaThread;

public class CopyValueAction_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(CopyValueAction_Action.class);

  public CopyValueAction_Action() {
    super("Copy Value", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        IValue value = VariablesTree.MPS_DEBUGGER_VALUE.getData(event.getDataContext());
        event.getPresentation().setVisible(value != null && value instanceof JavaValue && DebugActionsUtil.getEvaluationProvider(event) != null);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "CopyValueAction", t);
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
      IValue value = VariablesTree.MPS_DEBUGGER_VALUE.getData(event.getDataContext());
      if (value == null || !(value instanceof JavaValue)) {
        return;
      }

      EvaluationProvider evaluationProvider = (EvaluationProvider) DebugActionsUtil.getEvaluationProvider(event);
      if (evaluationProvider == null) {
        return;
      }

      JavaUiStateImpl uiState = evaluationProvider.getDebugSession().getUiState();

      ThreadReference thread = check_d54g7t_a0i0a(check_d54g7t_a0a8a0(uiState));
      if (thread == null) {
        return;
      }

      Value jdiValue = ((JavaValue) value).getValue();
      CopyPasteUtil.copyTextToClipboard(EvaluationUtils.getInstance().getStringPresentation(jdiValue, thread));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "CopyValueAction", t);
      }
    }
  }

  private static ThreadReference check_d54g7t_a0i0a(JavaThread checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getThread();
    }
    return null;
  }

  private static JavaThread check_d54g7t_a0a8a0(JavaUiStateImpl checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getThread();
    }
    return null;
  }
}
