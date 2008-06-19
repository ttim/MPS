package jetbrains.mps.bootstrap.smodelLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.behavior.SNodeOperation_Behavior;
import jetbrains.mps.smodel.search.SimpleSearchScope;
import jetbrains.mps.bootstrap.structureLanguage.behavior.AbstractConceptDeclaration_Behavior;

public class SConceptLinkAccess_conceptLinkDeclaration_ReferentConstraint implements IModelConstraints, INodeReferentSearchScopeProvider {

  public SConceptLinkAccess_conceptLinkDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptLinkAccess", "conceptLinkDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptLinkAccess", "conceptLinkDeclaration");
  }

  public boolean canCreateNodeReferentSearchScope(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return true;
  }

  public ISearchScope createNodeReferentSearchScope(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode operandConcept;
    SNode leftType = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getEnclosingNode(), "operand", true));
    if (SNodeOperations.isInstanceOf(leftType, "jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptType")) {
      operandConcept = SLinkOperations.getTarget(leftType, "conceptDeclaraton", false);
    } else
    {
      operandConcept = SNodeOperation_Behavior.getLeftNodeConcept_1213877508847(_context.getEnclosingNode());
    }
    return new SimpleSearchScope(AbstractConceptDeclaration_Behavior.call_getConceptLinkDeclarations_1213877394578(operandConcept));
  }

  public String getNodeReferentSearchScopeDescription() {
    return "concept links from hierarchy";
  }

}
