package jetbrains.mps.baseLanguage.collections.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class MultiForEachStatement_DataFlow extends DataFlowBuilder {
  public MultiForEachStatement_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    for (SNode it : ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "forEach", true))) {
      _context.getBuilder().build((SNode) SLinkOperations.getTarget(it, "input", true));
      _context.getBuilder().build((SNode) SLinkOperations.getTarget(it, "variable", true));
    }
    _context.getBuilder().emitLabel("foreach");
    _context.getBuilder().emitIfJump(_context.getBuilder().after(_context.getNode()));
    _context.getBuilder().build((SNode) SLinkOperations.getTarget(_context.getNode(), "body", true));
    _context.getBuilder().emitMayBeUnreachable(new Runnable() {
      public void run() {
        _context.getBuilder().emitJump(_context.getBuilder().label(_context.getNode(), "foreach"));
      }
    });
  }
}
