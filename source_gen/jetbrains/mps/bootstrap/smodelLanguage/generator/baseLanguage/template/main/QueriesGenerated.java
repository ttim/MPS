package jetbrains.mps.bootstrap.smodelLanguage.generator.baseLanguage.template.main;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.baseLanguage.util.QueriesUtil;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.bootstrap.smodelLanguage.SModelLanguageUtil;
import jetbrains.mps.bootstrap.smodelLanguage.SNodeOperation;
import jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Concept;
import jetbrains.mps.smodel.SModelUtil;
import jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.bootstrap.smodelLanguage.SPropertyAccess;
import jetbrains.mps.bootstrap.smodelLanguage.SConceptPropertyAccess;
import jetbrains.mps.bootstrap.smodelLanguage.SModelLanguageTypesUtil;
import java.util.List;

public class QueriesGenerated {

  public static boolean baseMappingRule_Condition_1168911272662(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "creator", true), "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListCreator");
  }
  public static boolean baseMappingRule_Condition_1168983652971(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    // todo: remove this condition when all elements are 
    // generated in a new way
    boolean b = false;
    SNode op = SLinkOperations.getTarget(node, "nodeOperation", true);
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptPropertyAccess");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetNewChildOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Link_DeleteChildOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkListAccess");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.LinkList_AddNewChildOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.LinkList_AddChildOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.LinkList_InsertChildFirstOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.LinkList_GetCountOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Model_CreateNewNodeOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Model_CreateNewRootNodeOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetParentOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAdapterOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsInstanceOfOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetNextSiblingOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetPrevSiblingOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetNextSiblingsOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetPrevSiblingsOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAllSiblingsOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_InsertNewNextSiblingOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_InsertNewPrevSiblingOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_InsertNextSiblingOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_InsertPrevSiblingOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ReplaceWithNewOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ReplaceWithAnotherOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_DeleteOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_CopyOperation");
    b = b || SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsRoleOperation");
    b = b || (SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess") && QueriesUtil.isPropertyAccess_simple(op));
    b = b || (SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess") && QueriesUtil.isPropertyAccess_enum_notNullDefaultValue(op));
    b = b || (SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess") && QueriesUtil.isPropertyAccess_enum_nullDefaultValue(op));
    b = b || (SNodeOperations.isInstanceOf(op, "jetbrains.mps.bootstrap.smodelLanguage.structure.Property_SetOperation") && QueriesUtil.isProperty_set_stringValue(node, generator));
    return b;
  }
  public static boolean baseMappingRule_Condition_1168976445524(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return QueriesUtil.isPropertyAccess_simple(node);
  }
  public static boolean baseMappingRule_Condition_1168976854559(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return QueriesUtil.isPropertyAccess_enum_notNullDefaultValue(node);
  }
  public static boolean baseMappingRule_Condition_1168977178297(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return QueriesUtil.isPropertyAccess_enum_nullDefaultValue(node);
  }
  public static boolean baseMappingRule_Condition_1168977521292(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(node, "enumMember", false), "internalValue") != null;
  }
  public static boolean baseMappingRule_Condition_1168977610522(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(node, "enumMember", false), "internalValue") == null;
  }
  public static boolean baseMappingRule_Condition_1168978381110(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return QueriesUtil.isProperty_set_stringValue(SNodeOperations.getParent(node, null, false, false), generator);
  }
  public static boolean baseMappingRule_Condition_1168978822549(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return QueriesUtil.isProperty_set_notStringValue(node, generator);
  }
  public static boolean baseMappingRule_Condition_1168979017065(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "nodeOperation", true), "jetbrains.mps.bootstrap.smodelLanguage.structure.Property_HasValue_Simple");
  }
  public static boolean baseMappingRule_Condition_1168979597371(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return QueriesUtil.isProperty_hasValueEnum_notNullDefaultValue(node, generator);
  }
  public static boolean baseMappingRule_Condition_1168979716443(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return QueriesUtil.isProperty_hasValueEnum_nullDefaultValue(node, generator);
  }
  public static boolean baseMappingRule_Condition_1168967899174(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return QueriesUtil.opGetParent_reduceDefault(node);
  }
  public static boolean baseMappingRule_Condition_1169087003242(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return QueriesUtil.opGetParent_reduceWhereConceptInList(node);
  }
  public static boolean baseMappingRule_Condition_1169074670328(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    Object parm = SModelLanguageUtil.findNodeOperationParameter((SNodeOperation)node, OperationParm_Concept.class);
    return parm != null;
  }
  public static boolean baseMappingRule_Condition_1169074949355(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    Object parm = SModelLanguageUtil.findNodeOperationParameter((SNodeOperation)node, OperationParm_Concept.class);
    return parm == null;
  }
  public static String propertyMacro_GetPropertyValue_1170457795969(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(node, "property", false), "name");
  }
  public static String propertyMacro_GetPropertyValue_1168981884180(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(node, "enumMember", false), "internalValue");
  }
  public static String propertyMacro_GetPropertyValue_1168986363721(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode link = SLinkOperations.getTarget(node, "link", false);
    return SModelUtil.getGenuineLinkRole((LinkDeclaration)link);
  }
  public static String propertyMacro_GetPropertyValue_1168986509277(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode link = SLinkOperations.getTarget(node, "link", false);
    link = SModelUtil.getGenuineLinkDeclaration((LinkDeclaration)link);
    if(SPropertyOperations.hasValue(link, "metaClass", "aggregation", null)) {
      return "true";
    }
    return "false";
  }
  public static String propertyMacro_GetPropertyValue_1169054268385(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode genuineLink = QueriesUtil.linkOpExpression_genuineLink(SNodeOperations.getParent(node, null, false, false));
    return SPropertyOperations.getString(genuineLink, "role");
  }
  public static String propertyMacro_GetPropertyValue_1169054430478(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode parmConcept = SLinkOperations.getTarget(node, "concept", false);
    if(parmConcept == null) {
      parmConcept = SModelLanguageUtil.getLinkTargetConceptForLinkOperation((SNodeOperation)node);
    }
    return NameUtil.nodeFQName(parmConcept);
  }
  public static String propertyMacro_GetPropertyValue_1169056926467(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode link = SLinkOperations.getTarget(node, "link", false);
    return SModelUtil.getGenuineLinkRole((LinkDeclaration)link);
  }
  public static String propertyMacro_GetPropertyValue_1169057010209(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode link = SLinkOperations.getTarget(node, "link", false);
    link = SModelUtil.getGenuineLinkDeclaration((LinkDeclaration)link);
    if(SPropertyOperations.hasValue(link, "metaClass", "aggregation", null)) {
      return "true";
    }
    return "false";
  }
  public static String propertyMacro_GetPropertyValue_1169057619361(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode genuineLink = QueriesUtil.linkListOpExpression_genuineLink(SNodeOperations.getParent(node, null, false, false));
    return SPropertyOperations.getString(genuineLink, "role");
  }
  public static String propertyMacro_GetPropertyValue_1169057685014(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode parmConcept = SLinkOperations.getTarget(node, "concept", false);
    if(parmConcept == null) {
      parmConcept = SModelLanguageUtil.getLinkTargetConceptForLinkOperation((SNodeOperation)node);
    }
    return NameUtil.nodeFQName(parmConcept);
  }
  public static String propertyMacro_GetPropertyValue_1170438409571(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return NameUtil.nodeFQName(SLinkOperations.getTarget(node, "concept", false));
  }
  public static String propertyMacro_GetPropertyValue_1170443135014(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return NameUtil.nodeFQName(SLinkOperations.getTarget(node, "concept", false));
  }
  public static String propertyMacro_GetPropertyValue_1170443738936(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return NameUtil.nodeFQName(SLinkOperations.getTarget(node, "concept", false));
  }
  public static String propertyMacro_GetPropertyValue_1169058210501(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode genuineLink = QueriesUtil.linkListOpExpression_genuineLink(SNodeOperations.getParent(node, null, false, false));
    return SPropertyOperations.getString(genuineLink, "role");
  }
  public static String propertyMacro_GetPropertyValue_1169058658826(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode genuineLink = QueriesUtil.linkListOpExpression_genuineLink(SNodeOperations.getParent(node, null, false, false));
    return SPropertyOperations.getString(genuineLink, "role");
  }
  public static String propertyMacro_GetPropertyValue_1169056436910(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode genuineLink = QueriesUtil.linkOpExpression_genuineLink(SNodeOperations.getParent(node, null, false, false));
    return SPropertyOperations.getString(genuineLink, "role");
  }
  public static String propertyMacro_GetPropertyValue_1169055820374(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode genuineLink = QueriesUtil.linkOpExpression_genuineLink(SNodeOperations.getParent(node, null, false, false));
    return SPropertyOperations.getString(genuineLink, "role");
  }
  public static String propertyMacro_GetPropertyValue_1169055966769(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode genuineLink = QueriesUtil.linkOpExpression_genuineLink(SNodeOperations.getParent(node, null, false, false));
    if(SPropertyOperations.hasValue(genuineLink, "metaClass", "aggregation", null)) {
      return "true";
    }
    return "false";
  }
  public static String propertyMacro_GetPropertyValue_1170443309771(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return NameUtil.nodeFQName(SLinkOperations.getTarget(node, "concept", false));
  }
  public static String propertyMacro_GetPropertyValue_1169070256927(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode parmConcept = SLinkOperations.getTarget(node, "concept", false);
    return NameUtil.nodeFQName(parmConcept);
  }
  public static String propertyMacro_GetPropertyValue_1170444074663(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return NameUtil.nodeFQName(SLinkOperations.getTarget(node, "conceptOfParent", false));
  }
  public static String propertyMacro_GetPropertyValue_1170444136064(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SModelUtil.getGenuineLinkRole((LinkDeclaration)SLinkOperations.getTarget(node, "linkInParent", false));
  }
  public static String propertyMacro_GetPropertyValue_1169069895463(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode genuineLink = QueriesUtil.linkListOpExpression_genuineLink(SNodeOperations.getParent(node, null, false, false));
    return SPropertyOperations.getString(genuineLink, "role");
  }
  public static String propertyMacro_GetPropertyValue_1170442611639(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return "" + _QueriesUtil.operationHasParm_Inclusion(node);
  }
  public static String propertyMacro_GetPropertyValue_1170442795984(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return "" + _QueriesUtil.operationHasParm_Inclusion(node);
  }
  public static String propertyMacro_GetPropertyValue_1170443045607(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return "" + _QueriesUtil.operationHasParm_Inclusion(node);
  }
  public static String propertyMacro_GetPropertyValue_1170461331284(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(node, "property", false), "name");
  }
  public static String propertyMacro_GetPropertyValue_1170461506307(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return _QueriesUtil.get_SPropertyAccess_enum_defaultValue(node);
  }
  public static String propertyMacro_GetPropertyValue_1170462640580(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(node, "property", false), "name");
  }
  public static String propertyMacro_GetPropertyValue_1168294031937(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return NameUtil.nodeFQName(node);
  }
  public static String propertyMacro_GetPropertyValue_1169070814788(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode parmConcept = SLinkOperations.getTarget(node, "concept", false);
    return NameUtil.nodeFQName(parmConcept);
  }
  public static String propertyMacro_GetPropertyValue_1168985327635(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(node, "conceptProperty", false), "name");
  }
  public static SNode referenceMacro_GetReferent_1170457360268(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return _QueriesUtil.get_SPropertyAccess_simple_getterMethod((SPropertyAccess)node, scope);
  }
  public static SNode referenceMacro_GetReferent_1170461142999(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return _QueriesUtil.get_SPropertyAccess_enum_getterMethod((SPropertyAccess)node, scope);
  }
  public static SNode referenceMacro_GetReferent_1170462607714(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return _QueriesUtil.get_SPropertyAccess_enum_getterMethod((SPropertyAccess)node, scope);
  }
  public static SNode referenceMacro_GetReferent_1168984233974(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return _QueriesUtil.get_SConceptPropertyAccess_GetMethod((SConceptPropertyAccess)node, scope);
  }
  public static SNode referenceMacro_GetReferent_1170386916206(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode noe = SNodeOperations.getParent(node, null, false, false);
    return SModelLanguageTypesUtil.tryObtain_snode_adapterClass(SLinkOperations.getTarget(noe, "leftExpression", true), generator.getTypeChecker());
  }
  public static List sourceNodesQuery_1168293467222(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode op = SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "nodeOperation", true);
    return (List<SNode>)_QueriesUtil.getNodeOperation_ConceptList_concepts((SNodeOperation)(op));
  }
  public static SNode sourceNodeQuery_1170466610811(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    // <expr>.<property-access>.<operation>
    // <operation> : our input node
    // <expt> : expression to copy
    SNode noe1 = SNodeOperations.getParent(node, null, false, false);
    SNode noe2 = SLinkOperations.getTarget(noe1, "leftExpression", true);
    return SLinkOperations.getTarget(noe2, "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170457758878(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1168986247382(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1169051323267(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    // <expr-to-copy> . link-access . set-new-child-op
    SNode lexpr1 = SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
    return SLinkOperations.getTarget(lexpr1, "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1169056862270(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1169057396154(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    // <expr-to-copy> . linklist-access . add-new-child-op
    SNode lexpr1 = SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
    return SLinkOperations.getTarget(lexpr1, "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1169071189829(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170438306732(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170443112989(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170443724880(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1169058187694(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    // <expr-to-copy> . linklist-access . add-child-op
    SNode lexpr1 = SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
    return SLinkOperations.getTarget(lexpr1, "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1169058238859(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "parameter", true);
  }
  public static SNode sourceNodeQuery_1169058619143(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    // <expr-to-copy> . linklist-access . insert-child-first-op
    SNode lexpr1 = SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
    return SLinkOperations.getTarget(lexpr1, "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1169058688355(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "parameter", true);
  }
  public static SNode sourceNodeQuery_1169056377509(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    // <expr-to-copy> . link-access . delete-op
    SNode lexpr1 = SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
    return SLinkOperations.getTarget(lexpr1, "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170443842431(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170443854081(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "parameter", true);
  }
  public static SNode sourceNodeQuery_1170443922573(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1169055764567(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    // <expr-to-copy> . link-access . set-target-op
    SNode lexpr1 = SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
    return SLinkOperations.getTarget(lexpr1, "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1169055881310(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "parameter", true);
  }
  public static SNode sourceNodeQuery_1170443264981(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170443385726(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170443410595(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "parameter", true);
  }
  public static SNode sourceNodeQuery_1170443508758(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170443521299(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "parameter", true);
  }
  public static SNode sourceNodeQuery_1169070207215(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170436841750(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170438565150(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170438667880(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170443980567(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170444043092(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1169069851562(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    // <expr-to-copy> . linklist-access . count-op
    SNode lexpr1 = SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
    return SLinkOperations.getTarget(lexpr1, "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170441968236(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170442775025(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170443028820(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170461311540(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170462621492(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1168292579606(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1169070779095(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1168983597964(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "nodeOperation", true);
  }
  public static SNode sourceNodeQuery_1168985092391(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1170386866118(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(node, null, false, false), "leftExpression", true);
  }
}
