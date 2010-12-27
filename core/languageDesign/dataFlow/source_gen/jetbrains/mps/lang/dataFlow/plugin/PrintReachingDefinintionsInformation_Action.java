package jetbrains.mps.lang.dataFlow.plugin;

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
import jetbrains.mps.lang.dataFlow.framework.Program;
import jetbrains.mps.lang.dataFlow.DataFlowManager;
import jetbrains.mps.lang.dataFlow.framework.AnalysisResult;
import java.util.Set;
import jetbrains.mps.lang.dataFlow.framework.instructions.WriteInstruction;
import jetbrains.mps.lang.dataFlow.framework.analyzers.ReachingDefinitionsAnalyzer;

public class PrintReachingDefinintionsInformation_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(PrintReachingDefinintionsInformation_Action.class);

  public PrintReachingDefinintionsInformation_Action() {
    super("Print DFA Reaching Definitions Information", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "PrintReachingDefinintionsInformation", t);
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
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      Program program = DataFlowManager.getInstance().buildProgramFor(((SNode) MapSequence.fromMap(_params).get("node")));
      AnalysisResult<Set<WriteInstruction>> result = program.analyze(new ReachingDefinitionsAnalyzer());
      System.out.println(result.toString());
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "PrintReachingDefinintionsInformation", t);
    }
  }
}
