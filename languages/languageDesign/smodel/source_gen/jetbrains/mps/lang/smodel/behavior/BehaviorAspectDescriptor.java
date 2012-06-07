package jetbrains.mps.lang.smodel.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"jetbrains.mps.lang.smodel.structure.AllAttributeQualifier", "jetbrains.mps.lang.smodel.structure.AttributeAccess", "jetbrains.mps.lang.smodel.structure.CheckedModuleReference", "jetbrains.mps.lang.smodel.structure.ConceptFqNameRefExpression", "jetbrains.mps.lang.smodel.structure.ConceptPropertyNameRefExpression", "jetbrains.mps.lang.smodel.structure.ConceptProperty_SetOperation", "jetbrains.mps.lang.smodel.structure.ConceptRefExpression", "jetbrains.mps.lang.smodel.structure.ConceptReference", "jetbrains.mps.lang.smodel.structure.ConceptSwitchStatement", "jetbrains.mps.lang.smodel.structure.ConceptSwitchStatementCase", "jetbrains.mps.lang.smodel.structure.Concept_FindInstances", "jetbrains.mps.lang.smodel.structure.Concept_GetAllSubConcepts", "jetbrains.mps.lang.smodel.structure.Concept_GetAllSuperConcepts", "jetbrains.mps.lang.smodel.structure.Concept_GetDirectSuperConcepts", "jetbrains.mps.lang.smodel.structure.Concept_GetHierarchy", "jetbrains.mps.lang.smodel.structure.Concept_IsExactlyOperation", "jetbrains.mps.lang.smodel.structure.Concept_IsSubConceptOfOperation", "jetbrains.mps.lang.smodel.structure.Concept_IsSuperConceptOfOperation", "jetbrains.mps.lang.smodel.structure.Concept_NewInstance", "jetbrains.mps.lang.smodel.structure.EnumMemberReference", "jetbrains.mps.lang.smodel.structure.EnumMember_NameOperation", "jetbrains.mps.lang.smodel.structure.EnumMember_ValueOperation", "jetbrains.mps.lang.smodel.structure.EqualsStructurallyExpression", "jetbrains.mps.lang.smodel.structure.IfInstanceOfStatement", "jetbrains.mps.lang.smodel.structure.IfInstanceOfVarReference", "jetbrains.mps.lang.smodel.structure.IfInstanceOfVariable", "jetbrains.mps.lang.smodel.structure.LanguageReferenceExpression", "jetbrains.mps.lang.smodel.structure.LinkAttributeQualifier", "jetbrains.mps.lang.smodel.structure.LinkList_AddAllOperation", "jetbrains.mps.lang.smodel.structure.LinkList_AddChildOperation", "jetbrains.mps.lang.smodel.structure.LinkList_AddNewChildOperation", "jetbrains.mps.lang.smodel.structure.LinkList_GetCountOperation", "jetbrains.mps.lang.smodel.structure.LinkList_InsertChildFirstOperation", "jetbrains.mps.lang.smodel.structure.LinkList_RemoveAllChildrenOperation", "jetbrains.mps.lang.smodel.structure.LinkNameRefExpression", "jetbrains.mps.lang.smodel.structure.LinkQualifier", "jetbrains.mps.lang.smodel.structure.LinkRefExpression", "jetbrains.mps.lang.smodel.structure.LinkRefQualifier", "jetbrains.mps.lang.smodel.structure.Link_DeleteChildOperation", "jetbrains.mps.lang.smodel.structure.Link_SetNewChildOperation", "jetbrains.mps.lang.smodel.structure.Link_SetTargetOperation", "jetbrains.mps.lang.smodel.structure.ModelReferenceExpression", "jetbrains.mps.lang.smodel.structure.Model_AddRootOperation", "jetbrains.mps.lang.smodel.structure.Model_CreateNewNodeOperation", "jetbrains.mps.lang.smodel.structure.Model_CreateNewRootNodeOperation", "jetbrains.mps.lang.smodel.structure.Model_GetLongNameOperation", "jetbrains.mps.lang.smodel.structure.Model_GetModule", "jetbrains.mps.lang.smodel.structure.Model_NodesIncludingImportedOperation", "jetbrains.mps.lang.smodel.structure.Model_NodesOperation", "jetbrains.mps.lang.smodel.structure.Model_RootsIncludingImportedOperation", "jetbrains.mps.lang.smodel.structure.Model_RootsOperation", "jetbrains.mps.lang.smodel.structure.ModuleReferenceExpression", "jetbrains.mps.lang.smodel.structure.NodeAttributeQualifier", "jetbrains.mps.lang.smodel.structure.NodePointerExpression", "jetbrains.mps.lang.smodel.structure.NodeRefExpression", "jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall", "jetbrains.mps.lang.smodel.structure.Node_CopyOperation", "jetbrains.mps.lang.smodel.structure.Node_DeleteOperation", "jetbrains.mps.lang.smodel.structure.Node_DetachOperation", "jetbrains.mps.lang.smodel.structure.Node_GetAdapterOperation", "jetbrains.mps.lang.smodel.structure.Node_GetAllSiblingsOperation", "jetbrains.mps.lang.smodel.structure.Node_GetAncestorOperation", "jetbrains.mps.lang.smodel.structure.Node_GetAncestorsOperation", "jetbrains.mps.lang.smodel.structure.Node_GetChildrenOperation", "jetbrains.mps.lang.smodel.structure.Node_GetConceptOperation", "jetbrains.mps.lang.smodel.structure.Node_GetContainingLinkOperation", "jetbrains.mps.lang.smodel.structure.Node_GetContainingRoleOperation", "jetbrains.mps.lang.smodel.structure.Node_GetContainingRootOperation", "jetbrains.mps.lang.smodel.structure.Node_GetDescendantsOperation", "jetbrains.mps.lang.smodel.structure.Node_GetIndexInParentOperation", "jetbrains.mps.lang.smodel.structure.Node_GetModelOperation", "jetbrains.mps.lang.smodel.structure.Node_GetNextSiblingOperation", "jetbrains.mps.lang.smodel.structure.Node_GetNextSiblingsOperation", "jetbrains.mps.lang.smodel.structure.Node_GetParentOperation", "jetbrains.mps.lang.smodel.structure.Node_GetPrevSiblingOperation", "jetbrains.mps.lang.smodel.structure.Node_GetPrevSiblingsOperation", "jetbrains.mps.lang.smodel.structure.Node_GetReferenceOperation", "jetbrains.mps.lang.smodel.structure.Node_GetReferencesOperation", "jetbrains.mps.lang.smodel.structure.Node_GetReferentSearchScopeOperation", "jetbrains.mps.lang.smodel.structure.Node_InsertNewNextSiblingOperation", "jetbrains.mps.lang.smodel.structure.Node_InsertNewPrevSiblingOperation", "jetbrains.mps.lang.smodel.structure.Node_InsertNextSiblingOperation", "jetbrains.mps.lang.smodel.structure.Node_InsertPrevSiblingOperation", "jetbrains.mps.lang.smodel.structure.Node_IsAttributeOperation", "jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation", "jetbrains.mps.lang.smodel.structure.Node_IsNotNullOperation", "jetbrains.mps.lang.smodel.structure.Node_IsNullOperation", "jetbrains.mps.lang.smodel.structure.Node_IsRoleOperation", "jetbrains.mps.lang.smodel.structure.Node_ReplaceWithAnotherOperation", "jetbrains.mps.lang.smodel.structure.Node_ReplaceWithNewOperation", "jetbrains.mps.lang.smodel.structure.OperationParm_Concept", "jetbrains.mps.lang.smodel.structure.OperationParm_ConceptList", "jetbrains.mps.lang.smodel.structure.OperationParm_Inclusion", "jetbrains.mps.lang.smodel.structure.OperationParm_LinkQualifier", "jetbrains.mps.lang.smodel.structure.OperationParm_Root", "jetbrains.mps.lang.smodel.structure.OperationParm_SameMetaLevel", "jetbrains.mps.lang.smodel.structure.OperationParm_StopConceptList", "jetbrains.mps.lang.smodel.structure.PoundExpression", "jetbrains.mps.lang.smodel.structure.PropertyAttributeQualifier", "jetbrains.mps.lang.smodel.structure.PropertyNameRefExpression", "jetbrains.mps.lang.smodel.structure.PropertyQualifier", "jetbrains.mps.lang.smodel.structure.Property_HasValue_Enum", "jetbrains.mps.lang.smodel.structure.Property_HasValue_Simple", "jetbrains.mps.lang.smodel.structure.Property_RemoveOperation", "jetbrains.mps.lang.smodel.structure.Property_SetOperation", "jetbrains.mps.lang.smodel.structure.ReadConceptReferenceExpression", "jetbrains.mps.lang.smodel.structure.RefConcept_Reference", "jetbrains.mps.lang.smodel.structure.Reference_GetLinkDeclarationOperation", "jetbrains.mps.lang.smodel.structure.Reference_GetResolveInfo", "jetbrains.mps.lang.smodel.structure.Reference_GetRoleOperation", "jetbrains.mps.lang.smodel.structure.Reference_GetTargetOperation", "jetbrains.mps.lang.smodel.structure.SConceptLinkAccess", "jetbrains.mps.lang.smodel.structure.SConceptPropertyAccess", "jetbrains.mps.lang.smodel.structure.SConceptType", "jetbrains.mps.lang.smodel.structure.SEnumMemberType", "jetbrains.mps.lang.smodel.structure.SEnumOperationInvocation", "jetbrains.mps.lang.smodel.structure.SEnum_MemberForNameOperation", "jetbrains.mps.lang.smodel.structure.SEnum_MemberForValueOperation", "jetbrains.mps.lang.smodel.structure.SEnum_MemberOperation", "jetbrains.mps.lang.smodel.structure.SEnum_MembersOperation", "jetbrains.mps.lang.smodel.structure.SLinkAccess", "jetbrains.mps.lang.smodel.structure.SLinkImplicitSelect", "jetbrains.mps.lang.smodel.structure.SLinkListAccess", "jetbrains.mps.lang.smodel.structure.SModelType", "jetbrains.mps.lang.smodel.structure.SNodeCreator", "jetbrains.mps.lang.smodel.structure.SNodeListCreator", "jetbrains.mps.lang.smodel.structure.SNodeListType", "jetbrains.mps.lang.smodel.structure.SNodeType", "jetbrains.mps.lang.smodel.structure.SNodeTypeCastExpression", "jetbrains.mps.lang.smodel.structure.SPropertyAccess", "jetbrains.mps.lang.smodel.structure.SReferenceType", "jetbrains.mps.lang.smodel.structure.SearchScopeType", "jetbrains.mps.lang.smodel.structure.SearchScope_ContainsOperation", "jetbrains.mps.lang.smodel.structure.SemanticDowncastExpression", "jetbrains.mps.lang.smodel.structure.StaticConceptMethodCall", "jetbrains.mps.lang.smodel.structure._LinkAccessT"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 127:
        return new SNodeType_BehaviorDescriptor();
      case 129:
        return new SPropertyAccess_BehaviorDescriptor();
      case 120:
        return new SLinkAccess_BehaviorDescriptor();
      case 122:
        return new SLinkListAccess_BehaviorDescriptor();
      case 104:
        return new Property_SetOperation_BehaviorDescriptor();
      case 19:
        return new EnumMemberReference_BehaviorDescriptor();
      case 39:
        return new Link_SetNewChildOperation_BehaviorDescriptor();
      case 30:
        return new LinkList_AddNewChildOperation_BehaviorDescriptor();
      case 73:
        return new Node_GetParentOperation_BehaviorDescriptor();
      case 84:
        return new Node_IsInstanceOfOperation_BehaviorDescriptor();
      case 79:
        return new Node_InsertNewNextSiblingOperation_BehaviorDescriptor();
      case 89:
        return new Node_ReplaceWithNewOperation_BehaviorDescriptor();
      case 29:
        return new LinkList_AddChildOperation_BehaviorDescriptor();
      case 32:
        return new LinkList_InsertChildFirstOperation_BehaviorDescriptor();
      case 38:
        return new Link_DeleteChildOperation_BehaviorDescriptor();
      case 88:
        return new Node_ReplaceWithAnotherOperation_BehaviorDescriptor();
      case 57:
        return new Node_DeleteOperation_BehaviorDescriptor();
      case 128:
        return new SNodeTypeCastExpression_BehaviorDescriptor();
      case 40:
        return new Link_SetTargetOperation_BehaviorDescriptor();
      case 80:
        return new Node_InsertNewPrevSiblingOperation_BehaviorDescriptor();
      case 81:
        return new Node_InsertNextSiblingOperation_BehaviorDescriptor();
      case 82:
        return new Node_InsertPrevSiblingOperation_BehaviorDescriptor();
      case 123:
        return new SModelType_BehaviorDescriptor();
      case 70:
        return new Node_GetModelOperation_BehaviorDescriptor();
      case 43:
        return new Model_CreateNewNodeOperation_BehaviorDescriptor();
      case 74:
        return new Node_GetPrevSiblingOperation_BehaviorDescriptor();
      case 71:
        return new Node_GetNextSiblingOperation_BehaviorDescriptor();
      case 92:
        return new OperationParm_Inclusion_BehaviorDescriptor();
      case 94:
        return new OperationParm_Root_BehaviorDescriptor();
      case 90:
        return new OperationParm_Concept_BehaviorDescriptor();
      case 56:
        return new Node_CopyOperation_BehaviorDescriptor();
      case 87:
        return new Node_IsRoleOperation_BehaviorDescriptor();
      case 126:
        return new SNodeListType_BehaviorDescriptor();
      case 133:
        return new SemanticDowncastExpression_BehaviorDescriptor();
      case 31:
        return new LinkList_GetCountOperation_BehaviorDescriptor();
      case 125:
        return new SNodeListCreator_BehaviorDescriptor();
      case 72:
        return new Node_GetNextSiblingsOperation_BehaviorDescriptor();
      case 75:
        return new Node_GetPrevSiblingsOperation_BehaviorDescriptor();
      case 60:
        return new Node_GetAllSiblingsOperation_BehaviorDescriptor();
      case 112:
        return new SConceptPropertyAccess_BehaviorDescriptor();
      case 101:
        return new Property_HasValue_Enum_BehaviorDescriptor();
      case 102:
        return new Property_HasValue_Simple_BehaviorDescriptor();
      case 91:
        return new OperationParm_ConceptList_BehaviorDescriptor();
      case 7:
        return new ConceptReference_BehaviorDescriptor();
      case 44:
        return new Model_CreateNewRootNodeOperation_BehaviorDescriptor();
      case 59:
        return new Node_GetAdapterOperation_BehaviorDescriptor();
      case 68:
        return new Node_GetDescendantsOperation_BehaviorDescriptor();
      case 67:
        return new Node_GetContainingRootOperation_BehaviorDescriptor();
      case 50:
        return new Model_RootsOperation_BehaviorDescriptor();
      case 48:
        return new Model_NodesOperation_BehaviorDescriptor();
      case 61:
        return new Node_GetAncestorOperation_BehaviorDescriptor();
      case 63:
        return new Node_GetChildrenOperation_BehaviorDescriptor();
      case 86:
        return new Node_IsNullOperation_BehaviorDescriptor();
      case 85:
        return new Node_IsNotNullOperation_BehaviorDescriptor();
      case 28:
        return new LinkList_AddAllOperation_BehaviorDescriptor();
      case 64:
        return new Node_GetConceptOperation_BehaviorDescriptor();
      case 15:
        return new Concept_IsExactlyOperation_BehaviorDescriptor();
      case 113:
        return new SConceptType_BehaviorDescriptor();
      case 6:
        return new ConceptRefExpression_BehaviorDescriptor();
      case 62:
        return new Node_GetAncestorsOperation_BehaviorDescriptor();
      case 111:
        return new SConceptLinkAccess_BehaviorDescriptor();
      case 49:
        return new Model_RootsIncludingImportedOperation_BehaviorDescriptor();
      case 106:
        return new RefConcept_Reference_BehaviorDescriptor();
      case 69:
        return new Node_GetIndexInParentOperation_BehaviorDescriptor();
      case 13:
        return new Concept_GetDirectSuperConcepts_BehaviorDescriptor();
      case 55:
        return new Node_ConceptMethodCall_BehaviorDescriptor();
      case 17:
        return new Concept_IsSuperConceptOfOperation_BehaviorDescriptor();
      case 16:
        return new Concept_IsSubConceptOfOperation_BehaviorDescriptor();
      case 12:
        return new Concept_GetAllSuperConcepts_BehaviorDescriptor();
      case 14:
        return new Concept_GetHierarchy_BehaviorDescriptor();
      case 124:
        return new SNodeCreator_BehaviorDescriptor();
      case 18:
        return new Concept_NewInstance_BehaviorDescriptor();
      case 11:
        return new Concept_GetAllSubConcepts_BehaviorDescriptor();
      case 10:
        return new Concept_FindInstances_BehaviorDescriptor();
      case 47:
        return new Model_NodesIncludingImportedOperation_BehaviorDescriptor();
      case 97:
        return new PoundExpression_BehaviorDescriptor();
      case 37:
        return new LinkRefQualifier_BehaviorDescriptor();
      case 135:
        return new _LinkAccessT_BehaviorDescriptor();
      case 83:
        return new Node_IsAttributeOperation_BehaviorDescriptor();
      case 134:
        return new StaticConceptMethodCall_BehaviorDescriptor();
      case 42:
        return new Model_AddRootOperation_BehaviorDescriptor();
      case 45:
        return new Model_GetLongNameOperation_BehaviorDescriptor();
      case 33:
        return new LinkList_RemoveAllChildrenOperation_BehaviorDescriptor();
      case 103:
        return new Property_RemoveOperation_BehaviorDescriptor();
      case 54:
        return new NodeRefExpression_BehaviorDescriptor();
      case 131:
        return new SearchScopeType_BehaviorDescriptor();
      case 78:
        return new Node_GetReferentSearchScopeOperation_BehaviorDescriptor();
      case 132:
        return new SearchScope_ContainsOperation_BehaviorDescriptor();
      case 36:
        return new LinkRefExpression_BehaviorDescriptor();
      case 22:
        return new EqualsStructurallyExpression_BehaviorDescriptor();
      case 58:
        return new Node_DetachOperation_BehaviorDescriptor();
      case 114:
        return new SEnumMemberType_BehaviorDescriptor();
      case 21:
        return new EnumMember_ValueOperation_BehaviorDescriptor();
      case 20:
        return new EnumMember_NameOperation_BehaviorDescriptor();
      case 115:
        return new SEnumOperationInvocation_BehaviorDescriptor();
      case 116:
        return new SEnum_MemberForNameOperation_BehaviorDescriptor();
      case 117:
        return new SEnum_MemberForValueOperation_BehaviorDescriptor();
      case 118:
        return new SEnum_MemberOperation_BehaviorDescriptor();
      case 119:
        return new SEnum_MembersOperation_BehaviorDescriptor();
      case 96:
        return new OperationParm_StopConceptList_BehaviorDescriptor();
      case 5:
        return new ConceptProperty_SetOperation_BehaviorDescriptor();
      case 121:
        return new SLinkImplicitSelect_BehaviorDescriptor();
      case 77:
        return new Node_GetReferencesOperation_BehaviorDescriptor();
      case 130:
        return new SReferenceType_BehaviorDescriptor();
      case 110:
        return new Reference_GetTargetOperation_BehaviorDescriptor();
      case 107:
        return new Reference_GetLinkDeclarationOperation_BehaviorDescriptor();
      case 109:
        return new Reference_GetRoleOperation_BehaviorDescriptor();
      case 65:
        return new Node_GetContainingLinkOperation_BehaviorDescriptor();
      case 66:
        return new Node_GetContainingRoleOperation_BehaviorDescriptor();
      case 76:
        return new Node_GetReferenceOperation_BehaviorDescriptor();
      case 93:
        return new OperationParm_LinkQualifier_BehaviorDescriptor();
      case 108:
        return new Reference_GetResolveInfo_BehaviorDescriptor();
      case 2:
        return new CheckedModuleReference_BehaviorDescriptor();
      case 95:
        return new OperationParm_SameMetaLevel_BehaviorDescriptor();
      case 3:
        return new ConceptFqNameRefExpression_BehaviorDescriptor();
      case 23:
        return new IfInstanceOfStatement_BehaviorDescriptor();
      case 25:
        return new IfInstanceOfVariable_BehaviorDescriptor();
      case 24:
        return new IfInstanceOfVarReference_BehaviorDescriptor();
      case 34:
        return new LinkNameRefExpression_BehaviorDescriptor();
      case 99:
        return new PropertyNameRefExpression_BehaviorDescriptor();
      case 1:
        return new AttributeAccess_BehaviorDescriptor();
      case 52:
        return new NodeAttributeQualifier_BehaviorDescriptor();
      case 27:
        return new LinkAttributeQualifier_BehaviorDescriptor();
      case 0:
        return new AllAttributeQualifier_BehaviorDescriptor();
      case 98:
        return new PropertyAttributeQualifier_BehaviorDescriptor();
      case 35:
        return new LinkQualifier_BehaviorDescriptor();
      case 100:
        return new PropertyQualifier_BehaviorDescriptor();
      case 4:
        return new ConceptPropertyNameRefExpression_BehaviorDescriptor();
      case 46:
        return new Model_GetModule_BehaviorDescriptor();
      case 51:
        return new ModuleReferenceExpression_BehaviorDescriptor();
      case 26:
        return new LanguageReferenceExpression_BehaviorDescriptor();
      case 105:
        return new ReadConceptReferenceExpression_BehaviorDescriptor();
      case 41:
        return new ModelReferenceExpression_BehaviorDescriptor();
      case 9:
        return new ConceptSwitchStatementCase_BehaviorDescriptor();
      case 8:
        return new ConceptSwitchStatement_BehaviorDescriptor();
      case 53:
        return new NodePointerExpression_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }
}
