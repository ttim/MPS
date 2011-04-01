package jetbrains.mps.execution.commands.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilders;
import jetbrains.mps.lang.dataFlow.DataFlowManager;

public class DFABuilders extends DataFlowBuilders {
  public void install(DataFlowManager manager) {
    manager.register("jetbrains.mps.execution.commands.structure.CommandBuilderExpression", new CommandBuilderExpression_DataFlow());
    manager.register("jetbrains.mps.execution.commands.structure.ProcessBuilderExpression", new ProcessBuilderExpression_DataFlow());
    manager.register("jetbrains.mps.execution.commands.structure.ProcessBuilderPart", new ProcessBuilderPart_DataFlow());
  }
}
