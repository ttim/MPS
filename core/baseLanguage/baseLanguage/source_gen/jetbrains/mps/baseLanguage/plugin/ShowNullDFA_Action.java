package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.lang.dataFlow.framework.AnalyzerRunner;
import jetbrains.mps.baseLanguage.dataFlow.NullableState;
import jetbrains.mps.baseLanguage.dataFlow.NullableAnalyzerRunner;
import jetbrains.mps.ide.dataFlow.presentation.ShowCFGDialog;
import jetbrains.mps.smodel.IOperationContext;
import java.awt.Frame;

public class ShowNullDFA_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(ShowNullDFA_Action.class);

  public ShowNullDFA_Action() {
    super("Show Nullable DFA", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "ShowNullDFA", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      SNode node = event.getData(MPSDataKeys.NODE);
      if (node != null) {
      }
      MapSequence.fromMap(_params).put("node", node);
    }
    if (MapSequence.fromMap(_params).get("node") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      AnalyzerRunner<Map<SNode, NullableState>> runner = new NullableAnalyzerRunner(((SNode) MapSequence.fromMap(_params).get("node")));
      new ShowCFGDialog(runner.getProgramCopy(), ((IOperationContext) MapSequence.fromMap(_params).get("context")), ((Frame) MapSequence.fromMap(_params).get("frame")));
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "ShowNullDFA", t);
    }
  }
}
