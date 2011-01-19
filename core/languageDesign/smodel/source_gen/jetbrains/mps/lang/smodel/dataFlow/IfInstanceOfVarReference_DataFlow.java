package jetbrains.mps.lang.smodel.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class IfInstanceOfVarReference_DataFlow extends DataFlowBuilder {
  public IfInstanceOfVarReference_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    _context.getBuilder().emitRead(SLinkOperations.getTarget(_context.getNode(), "baseVariableDeclaration", false));
  }
}
