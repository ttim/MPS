package jetbrains.mps.lang.smodel.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.ConstraintsDataHolder;
import java.util.Map;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import java.util.HashMap;
import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.behavior.SModelLanguageUtil;
import jetbrains.mps.lang.structure.behavior.DataTypeDeclaration_Behavior;
import jetbrains.mps.smodel.search.SimpleSearchScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SNodePointer;

public class EnumMemberReference_Constraints extends ConstraintsDataHolder {
  public EnumMemberReference_Constraints() {
  }

  public String getConceptFqName() {
    return "jetbrains.mps.lang.smodel.structure.EnumMemberReference";
  }

  public Map<String, INodeReferentSearchScopeProvider> getNodeNonDefaultSearchScopeProviders() {
    HashMap<String, INodeReferentSearchScopeProvider> result = new HashMap<String, INodeReferentSearchScopeProvider>();
    result.put("enumMember", new BaseNodeReferenceSearchScopeProvider() {
      public void registerSelf(ModelConstraintsManager manager) {
      }

      public void unRegisterSelf(ModelConstraintsManager manager) {
      }

      public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
        if (SNodeOperations.isInstanceOf(_context.getEnclosingNode(), "jetbrains.mps.lang.smodel.structure.Property_SetOperation") || SNodeOperations.isInstanceOf(_context.getEnclosingNode(), "jetbrains.mps.lang.smodel.structure.Property_HasValue_Enum")) {
          SNode datatype = SModelLanguageUtil.getDatatypeFromLeft_SPropertyAccess(SNodeOperations.cast(_context.getEnclosingNode(), "jetbrains.mps.lang.smodel.structure.SNodeOperation"));
          if (DataTypeDeclaration_Behavior.call_isEnum_1220268692373(datatype)) {
            return new SimpleSearchScope(SLinkOperations.getTargets(SNodeOperations.cast(datatype, "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration"), "member", true));
          }
        }
        return null;
      }

      public SNodePointer getSearchScopeValidatorNodePointer() {
        return new SNodePointer("r:00000000-0000-4000-0000-011c895902fb(jetbrains.mps.lang.smodel.constraints)", "1213104858409");
      }
    });
    return result;
  }
}
