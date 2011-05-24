package jetbrains.mps.lang.constraints.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.ConstraintsDataHolder;
import java.util.Map;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import java.util.HashMap;
import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.constraints.behavior.NodePropertyConstraint_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.SNodePointer;

public class NodePropertyConstraint_Constraints extends ConstraintsDataHolder {
  public NodePropertyConstraint_Constraints() {
  }

  public String getConceptFqName() {
    return "jetbrains.mps.lang.constraints.structure.NodePropertyConstraint";
  }

  public Map<String, INodeReferentSearchScopeProvider> getNodeNonDefaultSearchScopeProviders() {
    HashMap<String, INodeReferentSearchScopeProvider> result = new HashMap<String, INodeReferentSearchScopeProvider>();
    result.put("applicableProperty", new BaseNodeReferenceSearchScopeProvider() {
      public void registerSelf(ModelConstraintsManager manager) {
      }

      public void unRegisterSelf(ModelConstraintsManager manager) {
      }

      public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
        // properties declared in specified concept 
        SNode applicableConcept = NodePropertyConstraint_Behavior.call_getApplicableConcept_1213877292345(_context.getReferenceNode());
        if (applicableConcept == null) {
          SNode root = SNodeOperations.getContainingRoot(_context.getEnclosingNode());
          if (SNodeOperations.isInstanceOf(root, "jetbrains.mps.lang.constraints.structure.ConceptConstraints")) {
            applicableConcept = SLinkOperations.getTarget(SNodeOperations.cast(root, "jetbrains.mps.lang.constraints.structure.ConceptConstraints"), "concept", false);
          } else {
            applicableConcept = SLinkOperations.getTarget(SNodeOperations.cast(root, "jetbrains.mps.lang.behavior.structure.ConceptBehavior"), "concept", false);
          }
        }
        return AbstractConceptDeclaration_Behavior.call_getPropertyDeclarations_1213877394546(applicableConcept);
      }

      public SNodePointer getSearchScopeValidatorNodePointer() {
        return new SNodePointer("r:00000000-0000-4000-0000-011c89590307(jetbrains.mps.lang.constraints.constraints)", "1213104781821");
      }
    });
    return result;
  }
}
