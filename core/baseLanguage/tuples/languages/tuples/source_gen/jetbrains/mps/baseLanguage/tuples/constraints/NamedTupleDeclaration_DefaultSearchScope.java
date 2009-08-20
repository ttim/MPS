package jetbrains.mps.baseLanguage.tuples.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class NamedTupleDeclaration_DefaultSearchScope extends BaseNodeReferenceSearchScopeProvider {
  public NamedTupleDeclaration_DefaultSearchScope() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeDefaultSearchScopeProvider("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeDefaultSearchScopeProvider("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    final SModel refModel = SNodeOperations.getModel(_context.getReferenceNode());
    return ListSequence.fromList(SModelOperations.getNodesIncludingImported(_context.getModel(), operationContext.getScope(), "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration")).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode ntd) {
        return SNodeOperations.getModel(ntd) == refModel || (SLinkOperations.getTarget(ntd, "visibility", true) != null);
      }
    });
  }
}
