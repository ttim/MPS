package jetbrains.mps.baseLanguage.dataFlow;

/*Generated by MPS */

import jetbrains.mps.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.baseLanguage.behavior.ContinueStatement_Behavior;

public class ContinueStatement_DataFlow extends DataFlowBuilder {

  public ContinueStatement_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    if ((ContinueStatement_Behavior.call_getLoop_1213877346346(_context.getNode()) != null)) {
      _context.getBuilder().emitJump(_context.getBuilder().before(ContinueStatement_Behavior.call_getLoop_1213877346346(_context.getNode())));
    } else
    {
      _context.getBuilder().emitNop();
    }
  }

}
