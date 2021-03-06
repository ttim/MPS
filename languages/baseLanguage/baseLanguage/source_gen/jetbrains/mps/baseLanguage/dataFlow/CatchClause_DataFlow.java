package jetbrains.mps.baseLanguage.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SNode;

public class CatchClause_DataFlow extends DataFlowBuilder {
  public CatchClause_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    _context.getBuilder().emitWrite(SLinkOperations.getTarget(_context.getNode(), "throwable", true));
    _context.getBuilder().build((SNode) SLinkOperations.getTarget(_context.getNode(), "catchBody", true));
  }
}
