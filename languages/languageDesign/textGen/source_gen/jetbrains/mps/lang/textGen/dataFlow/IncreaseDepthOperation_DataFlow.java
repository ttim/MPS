package jetbrains.mps.lang.textGen.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.dataFlow.DataFlowBuilderContext;

public class IncreaseDepthOperation_DataFlow extends DataFlowBuilder {
  public IncreaseDepthOperation_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    _context.getBuilder().emitNop();
  }
}
