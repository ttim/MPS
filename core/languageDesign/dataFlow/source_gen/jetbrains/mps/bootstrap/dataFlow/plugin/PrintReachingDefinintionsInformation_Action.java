package jetbrains.mps.bootstrap.dataFlow.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import jetbrains.mps.logging.Logger;
import javax.swing.Icon;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.dataFlow.framework.Program;
import jetbrains.mps.dataFlow.DataFlowManager;
import jetbrains.mps.dataFlow.framework.AnalysisResult;
import java.util.Set;
import jetbrains.mps.dataFlow.framework.instructions.WriteInstruction;
import jetbrains.mps.dataFlow.framework.analyzers.ReachingDefinitionsAnalyzer;

public class PrintReachingDefinintionsInformation_Action extends GeneratedAction {
  public static final Logger LOG = Logger.getLogger(PrintReachingDefinintionsInformation_Action.class);
  public static final Icon ICON = null;

  private SNode node;

  public PrintReachingDefinintionsInformation_Action() {
    super("Print DFA Reaching Definitions Information", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull() AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "PrintReachingDefinintionsInformation", t);
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    {
      SNode node = event.getData(MPSDataKeys.SNODE);
      if (node != null) {
      }
      this.node = node;
    }
    if (this.node == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull() final AnActionEvent event) {
    try {
      Program program = DataFlowManager.getInstance().buildProgramFor(PrintReachingDefinintionsInformation_Action.this.node);
      AnalysisResult<Set<WriteInstruction>> result = program.analyze(new ReachingDefinitionsAnalyzer());
      System.out.println(result.toString());
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "PrintReachingDefinintionsInformation", t);
    }
  }

}
