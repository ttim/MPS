package jetbrains.mps.lang.behavior.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class ConceptBehavior_defaultConcreteConcept_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {

  public ConceptBehavior_defaultConcreteConcept_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.behavior.structure.ConceptBehavior", "defaultConcreteConcept", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.behavior.structure.ConceptBehavior", "defaultConcreteConcept");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode concept = SLinkOperations.getTarget(SNodeOperations.getAncestor(_context.getReferenceNode(), "jetbrains.mps.lang.behavior.structure.ConceptBehavior", true, false), "concept", false);
    List<SNode> concepts = SConceptOperations.getAllSubConcepts(concept, _context.getModel(), operationContext.getScope());
    return concepts;
  }

}
