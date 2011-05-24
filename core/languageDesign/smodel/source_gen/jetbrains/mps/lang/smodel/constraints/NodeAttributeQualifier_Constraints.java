package jetbrains.mps.lang.smodel.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.ConstraintsDataHolder;
import java.util.Map;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import java.util.HashMap;
import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.PresentationReferentConstraintContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.lang.smodel.behavior.AttributeQualifier_Behavior;
import jetbrains.mps.smodel.SNodePointer;

public class NodeAttributeQualifier_Constraints extends ConstraintsDataHolder {
  public NodeAttributeQualifier_Constraints() {
  }

  public String getConceptFqName() {
    return "jetbrains.mps.lang.smodel.structure.NodeAttributeQualifier";
  }

  public Map<String, INodeReferentSearchScopeProvider> getNodeNonDefaultSearchScopeProviders() {
    HashMap<String, INodeReferentSearchScopeProvider> result = new HashMap<String, INodeReferentSearchScopeProvider>();
    result.put("attributeConcept", new BaseNodeReferenceSearchScopeProvider() {
      public boolean hasPresentation() {
        return true;
      }

      public String getPresentation(final IOperationContext operationContext, final PresentationReferentConstraintContext _context) {
        return SConceptPropertyOperations.getString(((SNode) _context.getParameterNode()), "role");
      }

      public void registerSelf(ModelConstraintsManager manager) {
      }

      public void unRegisterSelf(ModelConstraintsManager manager) {
      }

      public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
        return AttributeQualifier_Behavior.getApplicableRoles_959482772563105834(_context.getEnclosingNode(), "jetbrains.mps.lang.core.structure.NodeAttribute", _context.getModel(), operationContext.getScope());
      }

      public SNodePointer getSearchScopeValidatorNodePointer() {
        return new SNodePointer("r:00000000-0000-4000-0000-011c895902fb(jetbrains.mps.lang.smodel.constraints)", "6407023681583036866");
      }
    });
    return result;
  }
}
