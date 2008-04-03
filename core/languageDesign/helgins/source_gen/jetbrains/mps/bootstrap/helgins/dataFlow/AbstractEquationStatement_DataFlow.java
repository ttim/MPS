package jetbrains.mps.bootstrap.helgins.dataFlow;

/*Generated by MPS */

import jetbrains.mps.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class AbstractEquationStatement_DataFlow extends DataFlowBuilder {

  public  AbstractEquationStatement_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    _context.getBuilder().build(SLinkOperations.getTarget(_context.getNode(), "leftExpression", true));
    _context.getBuilder().build(SLinkOperations.getTarget(_context.getNode(), "rightExpression", true));
    if ((SLinkOperations.getTarget(_context.getNode(), "errorString", true) != null)) {
      _context.getBuilder().build(SLinkOperations.getTarget(_context.getNode(), "errorString", true));
    }
    if ((SLinkOperations.getTarget(_context.getNode(), "nodeToCheck", true) != null)) {
      _context.getBuilder().build(SLinkOperations.getTarget(_context.getNode(), "nodeToCheck", true));
    }
  }

}
