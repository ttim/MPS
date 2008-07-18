package jetbrains.mps.bootstrap.helgins.dataFlow;

/*Generated by MPS */

import jetbrains.mps.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class InequationReplacementRule_DataFlow extends DataFlowBuilder {

  public InequationReplacementRule_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    _context.getBuilder().build((SNode)SLinkOperations.getTarget(_context.getNode(), "applicableNode", true));
    _context.getBuilder().build((SNode)SLinkOperations.getTarget(_context.getNode(), "supertypeNode", true));
    _context.getBuilder().build((SNode)SLinkOperations.getTarget(_context.getNode(), "body", true));
  }

}
