package jetbrains.mps.bootstrap.smodelLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.search.SimpleSearchScope;
import jetbrains.mps.bootstrap.structureLanguage.constraints.AbstractConceptDeclaration_Behavior;

public class Node_IsRoleOperation_linkInParent_ReferentConstraint implements IModelConstraints, INodeReferentSearchScopeProvider {

  public Node_IsRoleOperation_linkInParent_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsRoleOperation", "linkInParent", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsRoleOperation", "linkInParent");
  }

  public boolean canCreateNodeReferentSearchScope(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return true;
  }

  public ISearchScope createNodeReferentSearchScope(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode conceptOfParent = SLinkOperations.getTarget(_context.getReferenceNode(), "conceptOfParent", false);
    return new SimpleSearchScope(AbstractConceptDeclaration_Behavior.call_getAggregationLinkDeclarations_1212184463482(conceptOfParent));
  }

  public String getNodeReferentSearchScopeDescription() {
    return "<no description>";
  }

}
