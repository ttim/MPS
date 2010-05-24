package jetbrains.mps.lang.smodel.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
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

public class EnumMemberReference_enumMember_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public EnumMemberReference_enumMember_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.smodel.structure.EnumMemberReference", "enumMember", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.smodel.structure.EnumMemberReference", "enumMember");
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

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c895902fb(jetbrains.mps.lang.smodel.constraints)", "1213104858409");
  }
}
