package jetbrains.mps.lang.typesystem.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class TypesystemIntention_DataFlow extends DataFlowBuilder {

  public TypesystemIntention_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    for(SNode argument : SLinkOperations.getTargets(_context.getNode(), "actualArgument", true)) {
      _context.getBuilder().build((SNode)argument);
    }
  }

}
