package jetbrains.mps.logging.refactoring.generator.baseLanguage.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.core.constraints.INamedConcept_Behavior;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import java.util.List;
import jetbrains.mps.logging.refactoring.constraints.ArgumentType_Behavior;

public class QueriesGenerated {

  public static boolean baseMappingRule_Condition_1189763520881(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode parent = SNodeOperations.getParent(node, null, false, false);
    if(SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.AssignmentExpression")) {
      return !(SLinkOperations.getTarget(parent, "lValue", true) == node);
    }
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SLinkOperations.getTarget(node, "argument", false), "argumentType", true), "jetbrains.mps.logging.refactoring.structure.StringArgumentType");
  }

  public static boolean baseMappingRule_Condition_1190731843928(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode parent = SNodeOperations.getParent(node, null, false, false);
    if(SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.AssignmentExpression")) {
      return !(SLinkOperations.getTarget(parent, "lValue", true) == node);
    }
    return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SLinkOperations.getTarget(node, "argument", false), "argumentType", true), "jetbrains.mps.logging.refactoring.structure.StringArgumentType"));
  }

  public static boolean baseMappingRule_Condition_1189763354452(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "lValue", true), "jetbrains.mps.logging.refactoring.structure.RequiredAdditionalArgumentReference");
  }

  public static boolean baseMappingRule_Condition_1190640880222(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "argumentType", true), "jetbrains.mps.logging.refactoring.structure.StringArgumentType");
  }

  public static boolean baseMappingRule_Condition_1190640903767(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "argumentType", true), "jetbrains.mps.logging.refactoring.structure.SModelArgumentType");
  }

  public static boolean baseMappingRule_Condition_1190640919750(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "argumentType", true), "jetbrains.mps.logging.refactoring.structure.SNodeArgumentType");
  }

  public static boolean baseMappingRule_Condition_1190640941391(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "argumentType", true), "jetbrains.mps.logging.refactoring.structure.SNodeOrModelArgumentType");
  }

  public static Object propertyMacro_GetPropertyValue_1189698210116(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "name");
  }

  public static Object propertyMacro_GetPropertyValue_1189776889452(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "name");
  }

  public static Object propertyMacro_GetPropertyValue_1189698215259(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "name");
  }

  public static Object propertyMacro_GetPropertyValue_1189776896095(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "name");
  }

  public static Object propertyMacro_GetPropertyValue_1189697560065(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "name");
  }

  public static Object propertyMacro_GetPropertyValue_1190733623863(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(SLinkOperations.getTarget(node, "lValue", true), "argument", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1190733601350(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(node, "argument", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1190641329907(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "presentation");
  }

  public static Object propertyMacro_GetPropertyValue_1190641312367(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "name");
  }

  public static Object propertyMacro_GetPropertyValue_1190720237098(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "presentation");
  }

  public static Object propertyMacro_GetPropertyValue_1190720237106(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "name");
  }

  public static Object propertyMacro_GetPropertyValue_1190721658937(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "presentation");
  }

  public static Object propertyMacro_GetPropertyValue_1190721658945(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "name");
  }

  public static Object propertyMacro_GetPropertyValue_1190721767911(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return INamedConcept_Behavior.call_getFqName_1184686272576(SLinkOperations.getTarget(SLinkOperations.getTarget(node, "argumentType", true), "nodeConcept", false));
  }

  public static Object propertyMacro_GetPropertyValue_1190721877127(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "presentation");
  }

  public static Object propertyMacro_GetPropertyValue_1190721877135(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(node, "name");
  }

  public static Object propertyMacro_GetPropertyValue_1190733777020(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(node, "argument", false), "name");
  }

  public static SNode referenceMacro_GetReferent_1189764427569(SNode node, SNode templateNode, SNode outputNode, SModel sourceModel, ITemplateGenerator generator) {
    SNode conceptFunction = SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.ConceptFunction", false, false);
    SNode method = (SNode)generator.findOutputNodeByInputNodeAndMappingName(SLinkOperations.getTarget(conceptFunction, "body", true), "methodBody").getParent().getParent().getParent();
    return ListOperations.getElement(SLinkOperations.getTargets(method, "parameter", true), 1);
  }

  public static SNode referenceMacro_GetReferent_1189764645520(SNode node, SNode templateNode, SNode outputNode, SModel sourceModel, ITemplateGenerator generator) {
    SNode conceptFunction = SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.ConceptFunction", false, false);
    SNode method = (SNode)generator.findOutputNodeByInputNodeAndMappingName(SLinkOperations.getTarget(conceptFunction, "body", true), "methodBody").getParent().getParent().getParent();
    return ListOperations.getElement(SLinkOperations.getTargets(method, "parameter", true), 1);
  }

  public static SNode referenceMacro_GetReferent_1190733777030(SNode node, SNode templateNode, SNode outputNode, SModel sourceModel, ITemplateGenerator generator) {
    SNode conceptFunction = SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.ConceptFunction", false, false);
    SNode method = (SNode)generator.findOutputNodeByInputNodeAndMappingName(SLinkOperations.getTarget(conceptFunction, "body", true), "methodBody").getParent().getParent().getParent();
    return ListOperations.getElement(SLinkOperations.getTargets(method, "parameter", true), 1);
  }

  public static boolean ifMacro_Condition_1190725064806(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return (SLinkOperations.getTarget(node, "isApplicableClause", true) != null);
  }

  public static boolean ifMacro_Condition_1190725026904(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return (SLinkOperations.getTarget(node, "isApplicableClause", true) == null);
  }

  public static boolean ifMacro_Condition_1190724959339(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return (SLinkOperations.getTarget(node, "doRefactorClause", true) != null);
  }

  public static boolean ifMacro_Condition_1190724916731(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return (SLinkOperations.getTarget(node, "updateModelClause", true) != null);
  }

  public static boolean ifMacro_Condition_1190642651793(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return true;
  }

  public static List sourceNodesQuery_1189698183859(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTargets(node, "arguments", true);
  }

  public static List sourceNodesQuery_1189698208144(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTargets(node, "internalArguments", true);
  }

  public static List sourceNodesQuery_1190640631445(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTargets(node, "arguments", true);
  }

  public static SNode sourceNodeQuery_1190725081382(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(node, "isApplicableClause", true), "body", true);
  }

  public static SNode sourceNodeQuery_1190724963405(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(node, "doRefactorClause", true), "body", true);
  }

  public static SNode sourceNodeQuery_1190724923720(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(node, "updateModelClause", true), "body", true);
  }

  public static SNode sourceNodeQuery_1190731677089(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "rValue", true);
  }

  public static SNode sourceNodeQuery_1190733777006(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return ArgumentType_Behavior.call_convertIntoType_1190731931503(SLinkOperations.getTarget(SLinkOperations.getTarget(node, "argument", false), "argumentType", true));
  }

}
