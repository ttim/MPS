package jetbrains.mps.lang.access.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilders;
import jetbrains.mps.lang.dataFlow.DataFlowManager;

public class DFABuilders extends DataFlowBuilders {
  public void install(DataFlowManager manager) {
    manager.register("jetbrains.mps.lang.access.structure.BaseExecuteCommandStatement", new BaseExecuteCommandStatement_DataFlow());
    manager.register("jetbrains.mps.lang.access.structure.BaseExecuteCommandStatementSync", new BaseExecuteCommandStatementSync_DataFlow());
    manager.register("jetbrains.mps.lang.access.structure.CommandClosureLiteral", new CommandClosureLiteral_DataFlow());
  }
}
