package jetbrains.mps.debug.evaluation.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.constraints.ProviderGeneratedSearchScope;
import jetbrains.mps.smodel.SNodePointer;

public class LowLevelVariableReference_variableDeclaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public LowLevelVariableReference_variableDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.debug.evaluation.structure.LowLevelVariableReference", "baseVariableDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.debug.evaluation.structure.LowLevelVariableReference", "baseVariableDeclaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.debug.evaluation.structure.EvaluatorConcept", false, false), "variables", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return !(SPropertyOperations.getBoolean(it, "isOutOfScope"));
      }
    });
  }

  public ISearchScope createNodeReferentSearchScope(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return new ProviderGeneratedSearchScope(this, operationContext, _context) {
      public boolean isInScope(SNode checkedNode) {
        return !(SPropertyOperations.getBoolean(checkedNode, "isOutOfScope"));
      }
    };
  }

  public SNodePointer getSearchScopeValidatorNodePointer() {
    return new SNodePointer("r:edfcb13b-e239-462c-8aae-e4b4a03e7c8b(jetbrains.mps.debug.evaluation.constraints)", "6146091894852366855");
  }
}
