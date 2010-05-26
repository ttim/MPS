package jetbrains.mps.lang.typesystem.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class ReportErrorStatement_DataFlow extends DataFlowBuilder {
  public ReportErrorStatement_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    _context.getBuilder().build((SNode) SLinkOperations.getTarget(_context.getNode(), "errorString", true));
    _context.getBuilder().build((SNode) SLinkOperations.getTarget(_context.getNode(), "nodeToReport", true));
    if ((SLinkOperations.getTarget(_context.getNode(), "messageTarget", true) != null)) {
      _context.getBuilder().build((SNode) SLinkOperations.getTarget(_context.getNode(), "messageTarget", true));
    }
    if ((SLinkOperations.getTarget(_context.getNode(), "helginsIntention", true) != null)) {
      _context.getBuilder().build((SNode) SLinkOperations.getTarget(_context.getNode(), "helginsIntention", true));
    }
    if ((SLinkOperations.getTarget(_context.getNode(), "foreignMessageSource", true) != null)) {
      _context.getBuilder().build((SNode) SLinkOperations.getTarget(_context.getNode(), "foreignMessageSource", true));
    }
  }
}
