package jetbrains.mps.lang.smodel.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class ConceptSwitchStatement_DataFlow extends DataFlowBuilder {
  public ConceptSwitchStatement_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    _context.getBuilder().build((SNode) SLinkOperations.getTarget(_context.getNode(), "expression", true));

    for (SNode switchCase : SLinkOperations.getTargets(_context.getNode(), "case", true)) {
      _context.getBuilder().emitIfJump(_context.getBuilder().after(switchCase));
      _context.getBuilder().build((SNode) switchCase);
    }
  }
}
