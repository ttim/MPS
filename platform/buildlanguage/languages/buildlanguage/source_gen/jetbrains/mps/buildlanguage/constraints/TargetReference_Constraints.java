package jetbrains.mps.buildlanguage.constraints;

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
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.buildlanguage.behavior.Project_Behavior;
import jetbrains.mps.smodel.SNodePointer;

public class TargetReference_Constraints extends ConstraintsDataHolder {
  public TargetReference_Constraints() {
  }

  public String getConceptFqName() {
    return "jetbrains.mps.buildlanguage.structure.TargetReference";
  }

  public Map<String, INodeReferentSearchScopeProvider> getNodeNonDefaultSearchScopeProviders() {
    HashMap<String, INodeReferentSearchScopeProvider> result = new HashMap<String, INodeReferentSearchScopeProvider>();
    result.put("targetDeclaration", new BaseNodeReferenceSearchScopeProvider() {
      public void registerSelf(ModelConstraintsManager manager) {
      }

      public void unRegisterSelf(ModelConstraintsManager manager) {
      }

      public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
        SNode project = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.buildlanguage.structure.Project", true, false);
        return Project_Behavior.call_getAllTargets_1213877351828(project);
      }

      public SNodePointer getSearchScopeValidatorNodePointer() {
        return new SNodePointer("r:00000000-0000-4000-0000-011c895904c1(jetbrains.mps.buildlanguage.constraints)", "1213104847184");
      }
    });
    return result;
  }
}
