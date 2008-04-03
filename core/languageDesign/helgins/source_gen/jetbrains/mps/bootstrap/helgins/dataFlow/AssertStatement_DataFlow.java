package jetbrains.mps.bootstrap.helgins.dataFlow;

/*Generated by MPS */

import jetbrains.mps.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class AssertStatement_DataFlow extends DataFlowBuilder {

  public  AssertStatement_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    _context.getBuilder().build(SLinkOperations.getTarget(_context.getNode(), "condition", true));
    _context.getBuilder().emitIfJump(_context.getBuilder().after(_context.getNode()));
    _context.getBuilder().build(SLinkOperations.getTarget(_context.getNode(), "errorString", true));
    _context.getBuilder().build(SLinkOperations.getTarget(_context.getNode(), "nodeToReport", true));
  }

}
