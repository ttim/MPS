package jetbrains.mps.baseLanguage.math.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class MatrixConstructor_DataFlow extends DataFlowBuilder {
  public MatrixConstructor_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    for (SNode item : ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "components", true))) {
      _context.getBuilder().build((SNode)item);
    }
  }
}
