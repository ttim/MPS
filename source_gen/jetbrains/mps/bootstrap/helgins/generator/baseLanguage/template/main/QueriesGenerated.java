package jetbrains.mps.bootstrap.helgins.generator.baseLanguage.template.main;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.AttributesRolesUtil;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.baseLanguage.structure.ClassConcept;
import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration;
import jetbrains.mps.baseLanguage.structure.StatementList;
import jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.bootstrap.helgins.structure.ReferenceAntiquotation_AnnotationLink;

public class QueriesGenerated {

  public static boolean baseMappingRule_Condition_1175150707078(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode type = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(node, "body", true));
    return !(TypeChecker.getInstance().getSubtypingManager().isSubtype(type, new QuotationClass_().createNode()));
  }
  public static boolean baseMappingRule_Condition_1175150546879(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode type = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(node, "body", true));
    return TypeChecker.getInstance().getSubtypingManager().isSubtype(type, new QuotationClass_1().createNode());
  }
  public static boolean baseMappingRule_Condition_1174662794354(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "nodeToCheck", true) != null;
  }
  public static boolean baseMappingRule_Condition_1174661049584(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "leftExpression", true), "jetbrains.mps.bootstrap.helgins.structure.TypeOfExpression");
  }
  public static boolean baseMappingRule_Condition_1174661198791(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "rightExpression", true), "jetbrains.mps.bootstrap.helgins.structure.TypeOfExpression");
  }
  public static boolean baseMappingRule_Condition_1175004525975(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "modelToCreate", true) != null;
  }
  public static String propertyMacro_GetPropertyValue_1174586557380(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return "parameter_" + node.getId();
  }
  public static String propertyMacro_GetPropertyValue_1174411533255(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return generator.getGeneratorSessionContext().createUniqueName("QuotationClass_");
  }
  public static String propertyMacro_GetPropertyValue_1174589744208(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return "quotedNode_" + node.getId();
  }
  public static String propertyMacro_GetPropertyValue_1174589744239(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return node.getConceptFqName();
  }
  public static String propertyMacro_GetPropertyValue_1174589744253(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return node.getProperty("propertyName");
  }
  public static String propertyMacro_GetPropertyValue_1174589744261(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return node.getProperty("propertyValue");
  }
  public static String propertyMacro_GetPropertyValue_1174589744316(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return node.getProperty("role");
  }
  public static String propertyMacro_GetPropertyValue_1174589744325(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return node.getProperty("targetModel");
  }
  public static String propertyMacro_GetPropertyValue_1174589744333(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return node.getProperty("targetInfo");
  }
  public static String propertyMacro_GetPropertyValue_1174589744341(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return node.getProperty("isExternalInfo");
  }
  public static String propertyMacro_GetPropertyValue_1174598230942(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return AttributesRolesUtil.getLinkRoleFromLinkAttributeRole(node.getRole_());
  }
  public static String propertyMacro_GetPropertyValue_1174596303319(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return node.getRole_();
  }
  public static String propertyMacro_GetPropertyValue_1174596368606(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return node.getRole_();
  }
  public static String propertyMacro_GetPropertyValue_1174596122815(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return node.getRole_();
  }
  public static String propertyMacro_GetPropertyValue_1174644028587(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode applicableNode = SLinkOperations.getTarget(node, "applicableNode", true);
    SNode conceptDecl = SLinkOperations.getTarget(applicableNode, "concept", false);
    return SNodeOperations.getModel(conceptDecl).toString() + "." + SPropertyOperations.getString(conceptDecl, "name");
  }
  public static String propertyMacro_GetPropertyValue_1174644237197(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode applicableNode = SLinkOperations.getTarget(node, "applicableNode", true);
    SNode patternExpr = SLinkOperations.getTarget(applicableNode, "pattern", true);
    SNode conceptDecl = SNodeOperations.getConceptDeclaration(SLinkOperations.getTarget(patternExpr, "patternNode", true));
    return SNodeOperations.getModel(conceptDecl).toString() + "." + SPropertyOperations.getString(conceptDecl, "name");
  }
  public static String propertyMacro_GetPropertyValue_1174647504808(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.getModel(node).toString();
  }
  public static String propertyMacro_GetPropertyValue_1174647592321(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode applicableNode = SLinkOperations.getTarget(node, "applicableNode", true);
    return applicableNode.getId();
  }
  public static String propertyMacro_GetPropertyValue_1175162990835(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(node, "jetbrains.mps.bootstrap.helgins.structure.SupertypingRule") + "";
  }
  public static String propertyMacro_GetPropertyValue_1174643589864(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode ruleConcept = SNodeOperations.getConceptDeclaration(node);
    return SPropertyOperations.getString(node, "name") + "_" + ruleConcept;
  }
  public static String propertyMacro_GetPropertyValue_1174666030638(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getBoolean(node, "nullable") + "";
  }
  public static String propertyMacro_GetPropertyValue_1174666025058(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "name") + "_typevar_" + node.getId();
  }
  public static String propertyMacro_GetPropertyValue_1174916988756(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getBoolean(node, "result") + "";
  }
  public static SNode referenceMacro_GetReferent_1174599415255(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode quotation = SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.helgins.structure.Quotation", false, false);
    SNode antiquotation = node;
    if(antiquotation == null) {
      return null;
    }
    return generator.findNodeBuilderForSource(SLinkOperations.getTarget(antiquotation, "expression", true), "parametersFromExpressions").getTargetNode();
  }
  public static SNode referenceMacro_GetReferent_1174596315030(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode parentTargetNode = generator.findNodeBuilderForSource(SNodeOperations.getParent(node, null, false, false), "quotationClass").getTargetNode();
    ClassConcept quotationClass = (ClassConcept)BaseAdapter.fromNode(parentTargetNode);
    InstanceMethodDeclaration methodDecl = quotationClass.getMethods().get(0);
    StatementList statementList = methodDecl.getBody();
    LocalVariableDeclarationStatement lvs = (LocalVariableDeclarationStatement)statementList.getStatements().get(0);
    return BaseAdapter.fromAdapter(lvs.getLocalVariableDeclaration());
  }
  public static SNode referenceMacro_GetReferent_1174596303285(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode parentTargetNode = generator.findNodeBuilderForSource(SNodeOperations.getParent(node, null, false, false), "nodeCreatorForQuotedNode").getTargetNode();
    StatementList statementList = (StatementList)BaseAdapter.fromNode(parentTargetNode);
    LocalVariableDeclarationStatement lvs = (LocalVariableDeclarationStatement)statementList.getStatements().get(0);
    return BaseAdapter.fromAdapter(lvs.getLocalVariableDeclaration());
  }
  public static SNode referenceMacro_GetReferent_1174596345825(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode quotation = SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.helgins.structure.Quotation", false, false);
    SNode antiquotation = null;
    for(SNode child : SNodeOperations.getChildren(node)) {
      if(SNodeOperations.isInstanceOf(child, "jetbrains.mps.bootstrap.helgins.structure.Antiquotation")) {
        antiquotation = child;
        break;
      }
    }
    if(antiquotation == null) {
      return null;
    }
    return generator.findNodeBuilderForSource(SLinkOperations.getTarget(antiquotation, "expression", true), "parametersFromExpressions").getTargetNode();
  }
  public static SNode referenceMacro_GetReferent_1174596368572(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode parentTargetNode = generator.findNodeBuilderForSource(SNodeOperations.getParent(node, null, false, false), "nodeCreatorForQuotedNode").getTargetNode();
    StatementList statementList = (StatementList)BaseAdapter.fromNode(parentTargetNode);
    LocalVariableDeclarationStatement lvs = (LocalVariableDeclarationStatement)statementList.getStatements().get(0);
    return BaseAdapter.fromAdapter(lvs.getLocalVariableDeclaration());
  }
  public static SNode referenceMacro_GetReferent_1174596384506(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode parentTargetNode = generator.findNodeBuilderForSource(SNodeOperations.getParent(node, null, false, false), "quotationClass").getTargetNode();
    ClassConcept quotationClass = (ClassConcept)BaseAdapter.fromNode(parentTargetNode);
    InstanceMethodDeclaration methodDecl = quotationClass.getMethods().get(0);
    StatementList statementList = methodDecl.getBody();
    LocalVariableDeclarationStatement lvs = (LocalVariableDeclarationStatement)statementList.getStatements().get(0);
    return BaseAdapter.fromAdapter(lvs.getLocalVariableDeclaration());
  }
  public static SNode referenceMacro_GetReferent_1174596011567(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode quotation = SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.helgins.structure.Quotation", false, false);
    SNode antiquotation = null;
    for(SNode child : SNodeOperations.getChildren(node)) {
      if(SNodeOperations.isInstanceOf(child, "jetbrains.mps.bootstrap.helgins.structure.ListAntiquotation")) {
        antiquotation = child;
        break;
      }
    }
    if(antiquotation == null) {
      return null;
    }
    return generator.findNodeBuilderForSource(SLinkOperations.getTarget(antiquotation, "expression", true), "parametersFromExpressions").getTargetNode();
  }
  public static SNode referenceMacro_GetReferent_1174596122781(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode parentTargetNode = generator.findNodeBuilderForSource(SNodeOperations.getParent(node, null, false, false), "nodeCreatorForQuotedNode").getTargetNode();
    StatementList statementList = (StatementList)BaseAdapter.fromNode(parentTargetNode);
    LocalVariableDeclarationStatement lvs = (LocalVariableDeclarationStatement)statementList.getStatements().get(0);
    return BaseAdapter.fromAdapter(lvs.getLocalVariableDeclaration());
  }
  public static SNode referenceMacro_GetReferent_1175002013260(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return generator.findNodeBuilderForSource(SLinkOperations.getTarget(SLinkOperations.getTarget(node, "applicableNode", true), "pattern", true), "patternClass").getTargetNode();
  }
  public static SNode referenceMacro_GetReferent_1174998489630(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return generator.findNodeBuilderForSource(SLinkOperations.getTarget(SLinkOperations.getTarget(node, "applicableNode", true), "pattern", true), "patternClass").getTargetNode().getChild("constructor");
  }
  public static SNode referenceMacro_GetReferent_1175002064909(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode clt;
    if(SNodeOperations.isInstanceOf(node, "jetbrains.mps.bootstrap.helgins.structure.InferenceRule")) {
      return SLinkOperations.getTarget(new QuotationClass_2().createNode(generator.getTargetModel()), "classifier", false);
    }
    if(SNodeOperations.isInstanceOf(node, "jetbrains.mps.bootstrap.helgins.structure.AbstractSubtypingRule")) {
      return SLinkOperations.getTarget(new QuotationClass_3().createNode(generator.getTargetModel()), "classifier", false);
    }
    return SLinkOperations.getTarget(new QuotationClass_4().createNode(generator.getTargetModel()), "classifier", false);
  }
  public static SNode referenceMacro_GetReferent_1175149443385(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode clt;
    return SLinkOperations.getTarget(new QuotationClass_5().createNode(), "classifier", false);
  }
  public static SNode referenceMacro_GetReferent_1174655195413(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode rule = SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.helgins.structure.AbstractRule", false, false);
    SNode method = generator.findNodeBuilderForSource(rule, "mainMethodForRule").getTargetNode();
    InstanceMethodDeclaration method_ = (InstanceMethodDeclaration)BaseAdapter.fromNode(method);
    return method_.getParameters().get(0).getNode();
  }
  public static SNode referenceMacro_GetReferent_1174666452984(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode statement = generator.findNodeBuilderForSource(SLinkOperations.getTarget(node, "typeVarDeclaration", false), "typeVarDeclaration").getTargetNode();
    return SLinkOperations.getTarget(statement, "localVariableDeclaration", true);
  }
  public static SNode referenceMacro_GetReferent_1174916691301(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return generator.findNodeBuilderForSource(SLinkOperations.getTarget(node, "pattern", true), "patternClass").getTargetNode().getChild("constructor");
  }
  public static SNode referenceMacro_GetReferent_1174999318513(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode rule = SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.helgins.structure.AbstractRule", false, false);
    return generator.findNodeBuilderForSource(rule, "applicableNodePatternField").getTargetNode();
  }
  public static SNode referenceMacro_GetReferent_1174997611702(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return generator.findNodeBuilderForSource(SLinkOperations.getTarget(node, "patternVarDecl", false), "patternVarField").getTargetNode();
  }
  public static SNode referenceMacro_GetReferent_1174999849168(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode rule = SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.helgins.structure.AbstractRule", false, false);
    return generator.findNodeBuilderForSource(rule, "applicableNodePatternField").getTargetNode();
  }
  public static SNode referenceMacro_GetReferent_1174999849185(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return generator.findNodeBuilderForSource(SLinkOperations.getTarget(node, "patternVarDecl", false), "patternVarField").getTargetNode();
  }
  public static SNode referenceMacro_GetReferent_1174999907201(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode rule = SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.helgins.structure.AbstractRule", false, false);
    return generator.findNodeBuilderForSource(rule, "applicableNodePatternField").getTargetNode();
  }
  public static SNode referenceMacro_GetReferent_1174999907218(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return generator.findNodeBuilderForSource(SLinkOperations.getTarget(node, "patternVarDecl", false), "patternVarField").getTargetNode();
  }
  public static SNode referenceMacro_GetReferent_1175005366860(SNode node, SNode templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return generator.findNodeBuilderForSource(SLinkOperations.getTarget(node, "modelToCreate", true), "parametersFromExpressions").getTargetNode();
  }
  public static boolean ifMacro_Condition_1174589744219(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return false;
  }
  public static boolean ifMacro_Condition_1174589744227(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return false;
  }
  public static boolean ifMacro_Condition_1174596315076(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.getParent(node, null, false, false) == SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.helgins.structure.Quotation", false, false);
  }
  public static boolean ifMacro_Condition_1174596303326(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.getParent(node, null, false, false) != SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.helgins.structure.Quotation", false, false);
  }
  public static boolean ifMacro_Condition_1174589744447(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    List<SNode> children = SNodeOperations.getChildren(node);
    for(SNode child : children) {
      if(SNodeOperations.isInstanceOf(child, "jetbrains.mps.bootstrap.helgins.structure.Antiquotation") || SNodeOperations.isInstanceOf(child, "jetbrains.mps.bootstrap.helgins.structure.ListAntiquotation")) {
        return false;
      }
    }
    return true;
  }
  public static boolean ifMacro_Condition_1174596368613(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.getParent(node, null, false, false) != SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.helgins.structure.Quotation", false, false);
  }
  public static boolean ifMacro_Condition_1174596384552(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.getParent(node, null, false, false) == SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.helgins.structure.Quotation", false, false);
  }
  public static boolean ifMacro_Condition_1174596404090(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    List<SNode> children = SNodeOperations.getChildren(node);
    for(SNode child : children) {
      if(SNodeOperations.isInstanceOf(child, "jetbrains.mps.bootstrap.helgins.structure.Antiquotation")) {
        return true;
      }
    }
    return false;
  }
  public static boolean ifMacro_Condition_1174596122822(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.getParent(node, null, false, false) != SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.helgins.structure.Quotation", false, false);
  }
  public static boolean ifMacro_Condition_1174595833965(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    List<SNode> children = SNodeOperations.getChildren(node);
    for(SNode child : children) {
      if(SNodeOperations.isInstanceOf(child, "jetbrains.mps.bootstrap.helgins.structure.ListAntiquotation")) {
        return true;
      }
    }
    return false;
  }
  public static boolean ifMacro_Condition_1174998351525(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "applicableNode", true), "jetbrains.mps.bootstrap.helgins.structure.PatternCondition");
  }
  public static boolean ifMacro_Condition_1174643945663(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "applicableNode", true), "jetbrains.mps.bootstrap.helgins.structure.ConceptReference");
  }
  public static boolean ifMacro_Condition_1174643948635(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "applicableNode", true), "jetbrains.mps.bootstrap.helgins.structure.PatternCondition");
  }
  public static boolean ifMacro_Condition_1174648501543(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "applicableNode", true), "jetbrains.mps.bootstrap.helgins.structure.ConceptReference");
  }
  public static boolean ifMacro_Condition_1174648541218(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "applicableNode", true), "jetbrains.mps.bootstrap.helgins.structure.PatternCondition");
  }
  public static boolean ifMacro_Condition_1175162630666(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(node, "jetbrains.mps.bootstrap.helgins.structure.AbstractSubtypingRule");
  }
  public static boolean ifMacro_Condition_1175149440226(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(node, "jetbrains.mps.bootstrap.helgins.structure.AbstractSubtypingRule");
  }
  public static List sourceNodesQuery_1174585963726(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    List<SNode> result = new ArrayList();
    if(SLinkOperations.getTarget(node, "modelToCreate", true) != null) {
      result.add(SLinkOperations.getTarget(node, "modelToCreate", true));
    }
    for(SNode child : SNodeOperations.getDescendants(node, null)) {
      if(SNodeOperations.isInstanceOf(child, "jetbrains.mps.bootstrap.helgins.structure.AbstractAntiquotation")) {
        result.add(SLinkOperations.getTarget(child, "expression", true));
      }
    }
    return result;
  }
  public static List sourceNodesQuery_1174589744268(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SModel model = generator.getTargetModel();
    List<SNode> result = new ArrayList();
    for(String property : node.getPropertyNames()) {
      SNode propertyNode = BaseConcept.newInstance(model).getNode();
      propertyNode.setProperty("propertyName", property);
      propertyNode.setProperty("propertyValue", node.getProperty(property));
      result.add(propertyNode);
    }
    return result;
  }
  public static List sourceNodesQuery_1174589744348(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SModel model = generator.getTargetModel();
    List<SNode> result = new ArrayList();
    for(SReference reference : node.getReferences()) {
      if(ReferenceAntiquotation_AnnotationLink.getReferenceAntiquotation((BaseConcept)((BaseConcept)SNodeOperations.getAdapter(node)), reference.getRole()) != null) {
        continue;
      }
      SNode referenceNode = BaseConcept.newInstance(model).getNode();
      referenceNode.setProperty("targetModel", reference.getTargetModelUID().toString());
      referenceNode.setProperty("role", reference.getRole());
      boolean isExternalInfo = false;
      String targetInfo = "";
      String extResolveInfo = reference.getExtResolveInfo();
      if(extResolveInfo != null) {
        targetInfo = extResolveInfo;
        isExternalInfo = true;
      } else 
      {
        targetInfo = reference.getTargetNodeId();
      }
      referenceNode.setProperty("targetInfo", targetInfo);
      referenceNode.setProperty("isExternalInfo", isExternalInfo + "");
      result.add(referenceNode);
    }
    return result;
  }
  public static List sourceNodesQuery_1174597452640(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    List<SNode> result = new ArrayList();
    for(String refRole : node.getReferenceRoles()) {
      BaseAdapter attribute = ReferenceAntiquotation_AnnotationLink.getReferenceAntiquotation((BaseConcept)((BaseConcept)SNodeOperations.getAdapter(node)), refRole);
      if(attribute != null) {
        result.add(attribute.getNode());
      }
    }
    return result;
  }
  public static List sourceNodesQuery_1174589744440(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    List<SNode> result = new ArrayList<SNode>();
    for(SNode child : SNodeOperations.getChildren(node)) {
      if(!(SNodeOperations.isInstanceOf(child, "jetbrains.mps.bootstrap.helgins.structure.AbstractAntiquotation"))) {
        result.add(child);
      }
    }
    return result;
  }
  public static List sourceNodesQuery_1174587654636(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    List<SNode> result = new ArrayList();
    if(SLinkOperations.getTarget(node, "modelToCreate", true) != null) {
      result.add(SLinkOperations.getTarget(node, "modelToCreate", true));
    }
    for(SNode child : SNodeOperations.getDescendants(node, null)) {
      if(SNodeOperations.isInstanceOf(child, "jetbrains.mps.bootstrap.helgins.structure.AbstractAntiquotation")) {
        result.add(SLinkOperations.getTarget(child, "expression", true));
      }
    }
    return result;
  }
  public static List sourceNodesQuery_1174916595463(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTargets(node, "judgement", true);
  }
  public static SNode sourceNodeQuery_1174578748617(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "quotedNode", true);
  }
  public static SNode sourceNodeQuery_1175004575860(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.helgins.structure.Quotation", false, false);
  }
  public static SNode sourceNodeQuery_1174587743784(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return node;
  }
  public static SNode sourceNodeQuery_1174654997817(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1174657742834(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "term", true);
  }
  public static SNode sourceNodeQuery_1174659246360(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1174659256692(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "rightExpression", true);
  }
  public static SNode sourceNodeQuery_1174661816168(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode toe = SLinkOperations.getTarget(node, "leftExpression", true);
    return SLinkOperations.getTarget(toe, "term", true);
  }
  public static SNode sourceNodeQuery_1174661930271(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode toe = SLinkOperations.getTarget(node, "rightExpression", true);
    return SLinkOperations.getTarget(toe, "term", true);
  }
  public static SNode sourceNodeQuery_1174662846575(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "nodeToCheck", true);
  }
  public static SNode sourceNodeQuery_1174663601249(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1174663601257(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "rightExpression", true);
  }
  public static SNode sourceNodeQuery_1174663674476(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1174663674484(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "rightExpression", true);
  }
  public static SNode sourceNodeQuery_1174663713984(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1174663713992(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "rightExpression", true);
  }
  public static SNode sourceNodeQuery_1174917063458(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "nodeToMatch", true);
  }
  public static SNode sourceNodeQuery_1175149651851(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1175149818478(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1175154733812(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "nodeToCheck", true);
  }
}
