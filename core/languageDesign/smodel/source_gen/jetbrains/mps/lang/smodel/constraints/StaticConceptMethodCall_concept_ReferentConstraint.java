package jetbrains.mps.lang.smodel.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.lang.smodel.behavior.StaticConceptMethodCall_Behavior;

public class StaticConceptMethodCall_concept_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {

  public StaticConceptMethodCall_concept_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.smodel.structure.StaticConceptMethodCall", "concept", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.smodel.structure.StaticConceptMethodCall", "concept");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return StaticConceptMethodCall_Behavior.getClassifiersWithStaticMethods_1213877485028(_context.getModel(), operationContext.getScope(), _context.getEnclosingNode());
  }

}
