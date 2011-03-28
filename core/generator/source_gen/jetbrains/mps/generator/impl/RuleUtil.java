package jetbrains.mps.generator.impl;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class RuleUtil {
  public static final String concept_AbstractMacro = "jetbrains.mps.lang.generator.structure.AbstractMacro";
  public static final String concept_ITemplateCall = "jetbrains.mps.lang.generator.structure.ITemplateCall";
  public static final String concept_NodeMacro = "jetbrains.mps.lang.generator.structure.NodeMacro";
  public static final String concept_IfMacro = "jetbrains.mps.lang.generator.structure.IfMacro";
  public static final String concept_SourceSubstituteMacro = "jetbrains.mps.lang.generator.structure.SourceSubstituteMacro";
  public static final String concept_CopySrcNodeMacro = "jetbrains.mps.lang.generator.structure.CopySrcNodeMacro";
  public static final String concept_CopySrcListMacro = "jetbrains.mps.lang.generator.structure.CopySrcListMacro";
  public static final String concept_IncludeMacro = "jetbrains.mps.lang.generator.structure.IncludeMacro";
  public static final String concept_LoopMacro = "jetbrains.mps.lang.generator.structure.LoopMacro";
  public static final String concept_LabelMacro = "jetbrains.mps.lang.generator.structure.LabelMacro";
  public static final String concept_InsertMacro = "jetbrains.mps.lang.generator.structure.InsertMacro";
  public static final String concept_WeaveMacro = "jetbrains.mps.lang.generator.structure.WeaveMacro";
  public static final String concept_MapSrcNodeMacro = "jetbrains.mps.lang.generator.structure.MapSrcNodeMacro";
  public static final String concept_MapSrcListMacro = "jetbrains.mps.lang.generator.structure.MapSrcListMacro";
  public static final String concept_SwitchMacro = "jetbrains.mps.lang.generator.structure.SwitchMacro";
  public static final String concept_TemplateCallMacro = "jetbrains.mps.lang.generator.structure.TemplateCallMacro";
  public static final String concept_PropertyMacro = "jetbrains.mps.lang.generator.structure.PropertyMacro";
  public static final String concept_ReferenceMacro = "jetbrains.mps.lang.generator.structure.ReferenceMacro";
  public static final String concept_BaseMappingRule = "jetbrains.mps.lang.generator.structure.BaseMappingRule";
  public static final String concept_Reduction_MappingRule = "jetbrains.mps.lang.generator.structure.Reduction_MappingRule";
  public static final String concept_Root_MappingRule = "jetbrains.mps.lang.generator.structure.Root_MappingRule";
  public static final String concept_Weaving_MappingRule = "jetbrains.mps.lang.generator.structure.Weaving_MappingRule";
  public static final String concept_TemplateSwitch = "jetbrains.mps.lang.generator.structure.TemplateSwitch";
  public static final String concept_PatternReduction_MappingRule = "jetbrains.mps.lang.generator.structure.PatternReduction_MappingRule";
  public static final String concept_CreateRootRule = "jetbrains.mps.lang.generator.structure.CreateRootRule";
  public static final String concept_DropRootRule = "jetbrains.mps.lang.generator.structure.DropRootRule";
  public static final String concept_MappingScriptReference = "jetbrains.mps.lang.generator.structure.MappingScriptReference";
  public static final String concept_TemplateDeclarationReference = "jetbrains.mps.lang.generator.structure.TemplateDeclarationReference";
  public static final String concept_TemplateDeclaration = "jetbrains.mps.lang.generator.structure.TemplateDeclaration";
  public static final String concept_WeaveEach_RuleConsequence = "jetbrains.mps.lang.generator.structure.WeaveEach_RuleConsequence";
  public static final String concept_MappingConfiguration = "jetbrains.mps.lang.generator.structure.MappingConfiguration";
  public static final String concept_TemplateArgumentPatternRef = "jetbrains.mps.lang.generator.structure.TemplateArgumentPatternRef";
  public static final String concept_TemplateArgumentQueryExpression = "jetbrains.mps.lang.generator.structure.TemplateArgumentQueryExpression";
  public static final String concept_TemplateArgumentParameterExpression = "jetbrains.mps.lang.generator.structure.TemplateArgumentParameterExpression";
  public static final String link_MappingConfiguration_preMappingScript = "preMappingScript";
  public static final String link_TemplateSwitch_modifiedSwitch = "modifiedSwitch";

  public RuleUtil() {
  }

  private static String getMappingLabelName(SNode mappingLabelDeclaration) {
    if (mappingLabelDeclaration == null) {
      return null;
    }
    String result = SPropertyOperations.getString(mappingLabelDeclaration, "name");
    return (result.length() == 0 ?
      null :
      result
    );
  }

  public static String getCreateRootRuleLabel(SNode rule) {
    return getMappingLabelName(SLinkOperations.getTarget(rule, "label", false));
  }

  public static String getTemplateFragmentLabel(SNode templateFragment) {
    return getMappingLabelName(SLinkOperations.getTarget(templateFragment, "labelDeclaration", false));
  }

  public static String getNodeMacroLabel(SNode nodeMacro) {
    return getMappingLabelName(SLinkOperations.getTarget(nodeMacro, "mappingLabel", false));
  }

  public static String getPatternReductionRuleLabel(SNode patternRule) {
    return getMappingLabelName(SLinkOperations.getTarget(patternRule, "labelDeclaration", false));
  }

  public static String getBaseRuleLabel(SNode rule) {
    return getMappingLabelName(SLinkOperations.getTarget(rule, "labelDeclaration", false));
  }

  public static SNode getBaseRuleApplicableConcept(SNode rule) {
    return SLinkOperations.getTarget(rule, "applicableConcept", false);
  }

  public static boolean getBaseRuleApplyToConceptInheritors(SNode rule) {
    return SPropertyOperations.getBoolean(rule, "applyToConceptInheritors");
  }

  public static SNode getBaseRuleCondition(SNode rule) {
    return SLinkOperations.getTarget(rule, "conditionFunction", true);
  }

  public static SNode getCreateRootRuleCondition(SNode rule) {
    return SLinkOperations.getTarget(rule, "conditionFunction", true);
  }

  public static SNode getCreateRootRuleTemplateNode(SNode rule) {
    return SLinkOperations.getTarget(rule, "templateNode", false);
  }

  public static SNode getReductionRuleConsequence(SNode reductionRule) {
    return SLinkOperations.getTarget(reductionRule, "ruleConsequence", true);
  }

  public static SNode getDropRuleCondition(SNode rule) {
    return SLinkOperations.getTarget(rule, "conditionFunction", true);
  }

  public static SNode getDropRuleApplicableConcept(SNode rule) {
    return SLinkOperations.getTarget(rule, "applicableConcept", false);
  }

  public static SNode getRootRuleTemplateNode(SNode rule) {
    return SLinkOperations.getTarget(rule, "template", false);
  }

  public static boolean getRootRuleKeepSourceRoot(SNode rule) {
    return SPropertyOperations.hasValue(rule, "keepSourceRoot", "true", null);
  }

  public static SNode getSwitchModifiedSwitch(SNode switchNode) {
    return SLinkOperations.getTarget(switchNode, "modifiedSwitch", false);
  }

  public static SNode getSwitchDefaultConsequence(SNode switchNode) {
    return SLinkOperations.getTarget(switchNode, "defaultConsequence", true);
  }

  public static SNode getSwitch_NullInputMessage(SNode switch_) {
    return SLinkOperations.getTarget(switch_, "nullInputMessage", true);
  }

  public static SNode getPatternReductionRuleConsequence(SNode reductionRule) {
    return SLinkOperations.getTarget(reductionRule, "ruleConsequence", true);
  }

  public static SNode getMapSrc_PostMapperFunction(SNode node) {
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.generator.structure.MapSrcNodeMacro")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.MapSrcNodeMacro"), "postMapperFunction", true);
    } else if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.generator.structure.MapSrcListMacro")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.MapSrcListMacro"), "postMapperFunction", true);
    }
    return null;
  }

  public static SNode getMapSrc_MapperFunction(SNode node) {
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.generator.structure.MapSrcNodeMacro")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.MapSrcNodeMacro"), "mapperFunction", true);
    } else if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.generator.structure.MapSrcListMacro")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.MapSrcListMacro"), "mapperFunction", true);
    }
    return null;
  }

  public static SNode getPatternReductionRulePatternNode(SNode reductionRule) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(reductionRule, "pattern", true), "patternNode", true);
  }

  public static String[] getTemplateDeclarationParameterNames(SNode templateDeclaration) {
    List<SNode> params = SLinkOperations.getTargets(templateDeclaration, "parameter", true);
    String[] result = new String[ListSequence.fromList(params).count()];
    for (int i = 0; i < result.length; i++) {
      SNode param = ListSequence.fromList(params).getElement(i);
      if (param == null) {
        return null;
      }
      result[i] = SPropertyOperations.getString(param, "name");
      if (result[i] == null) {
        return null;
      }
    }
    return result;
  }

  public static SNode getIfMacro_ConditionFunction(SNode macro) {
    return SLinkOperations.getTarget(macro, "conditionFunction", true);
  }

  public static SNode getIfMacro_AlternativeConsequence(SNode macro) {
    return SLinkOperations.getTarget(macro, "alternativeConsequence", true);
  }

  public static SNode getReferenceMacro_GetReferent(SNode macro) {
    return SLinkOperations.getTarget(macro, "referentFunction", true);
  }

  public static SNode getPropertyMacro_ValueFunction(SNode macro) {
    return SLinkOperations.getTarget(macro, "propertyValueFunction", true);
  }

  public static SNode getTemplateFragment_ContextNodeQuery(SNode tf) {
    return SLinkOperations.getTarget(tf, "contextNodeQuery", true);
  }

  public static SNode getMappingScriptReference_Script(SNode ref) {
    return SLinkOperations.getTarget(ref, "mappingScript", false);
  }

  public static SNode getSwitchMacro_TemplateSwitch(SNode macro) {
    return SLinkOperations.getTarget(macro, "templateSwitch", false);
  }

  public static SNode getIncludeMacro_Template(SNode macro) {
    return SLinkOperations.getTarget(macro, "includeTemplate", false);
  }

  public static SNode getCallMacro_Template(SNode macro) {
    return SLinkOperations.getTarget(macro, "template", false);
  }

  public static SNode getWeaving_ContextNodeQuery(SNode rule) {
    return SLinkOperations.getTarget(rule, "contextNodeQuery", true);
  }

  public static SNode getWeaving_Consequence(SNode rule) {
    return SLinkOperations.getTarget(rule, "ruleConsequence", true);
  }

  public static SNode getTemplateFragmentByAnnotatedNode(SNode node) {
    return AttributeOperations.getAttribute(node, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.generator.structure.TemplateFragment")));
  }

  public static SNode getTemplateDeclarationReference_Template(SNode ref) {
    return SLinkOperations.getTarget(ref, "template", false);
  }

  public static SNode getWeaveEach_Template(SNode weaveEach) {
    return SLinkOperations.getTarget(weaveEach, "template", false);
  }

  public static SNode getWeaveEach_SourceNodesQuery(SNode weaveEach) {
    return SLinkOperations.getTarget(weaveEach, "sourceNodesQuery", true);
  }

  public static boolean getMappingConfiguration_TopPrio(SNode mapping) {
    return SPropertyOperations.getBoolean(mapping, "topPriorityGroup");
  }

  public static SNode getTemplateDeclaration_ContentNode(SNode decl) {
    return SLinkOperations.getTarget(decl, "contentNode", true);
  }

  public static SNode getSourceNodesQuery(SNode node) {
    if (node == null) {
      return null;
    }
    String conceptFqName = node.getConceptFqName();
    if (conceptFqName.equals("jetbrains.mps.lang.generator.structure.LoopMacro")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.LoopMacro"), "sourceNodesQuery", true);
    } else if (conceptFqName.equals("jetbrains.mps.lang.generator.structure.CopySrcListMacro")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.CopySrcListMacro"), "sourceNodesQuery", true);
    } else if (conceptFqName.equals("jetbrains.mps.lang.generator.structure.MapSrcListMacro")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.MapSrcListMacro"), "sourceNodesQuery", true);
    } else if (conceptFqName.equals("jetbrains.mps.lang.generator.structure.WeaveMacro")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.WeaveMacro"), "nodesToWeaveQuery", true);
    }
    return null;
  }

  public static SNode getWeaveMacro_Consequence(SNode weaveMacro) {
    return SLinkOperations.getTarget(weaveMacro, "ruleConsequence", true);
  }

  public static SNode getSourceNodeQuery(SNode node) {
    if (node == null) {
      return null;
    }
    String conceptFqName = node.getConceptFqName();
    if (conceptFqName.equals("jetbrains.mps.lang.generator.structure.CopySrcNodeMacro")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.CopySrcNodeMacro"), "sourceNodeQuery", true);
    } else if (conceptFqName.equals("jetbrains.mps.lang.generator.structure.MapSrcNodeMacro")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.MapSrcNodeMacro"), "sourceNodeQuery", true);
    } else if (conceptFqName.equals("jetbrains.mps.lang.generator.structure.SwitchMacro")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.SwitchMacro"), "sourceNodeQuery", true);
    } else if (conceptFqName.equals("jetbrains.mps.lang.generator.structure.IncludeMacro")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.IncludeMacro"), "sourceNodeQuery", true);
    } else if (conceptFqName.equals("jetbrains.mps.lang.generator.structure.TemplateCallMacro")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.TemplateCallMacro"), "sourceNodeQuery", true);
    }
    return null;
  }

  public static List<SNode> getTemplateCall_Arguments(SNode macro) {
    return SLinkOperations.getTargets(macro, "actualArgument", true);

  }

  public static SNode getTemplateCall_Template(SNode macro) {
    return SLinkOperations.getTarget(macro, "template", false);
  }

  public static Object evaluateBaseLanguageExpression(SNode expr) {
    if (SNodeOperations.isInstanceOf(expr, "jetbrains.mps.baseLanguage.structure.BooleanConstant")) {
      return SPropertyOperations.getBoolean(SNodeOperations.cast(expr, "jetbrains.mps.baseLanguage.structure.BooleanConstant"), "value");
    } else if (SNodeOperations.isInstanceOf(expr, "jetbrains.mps.baseLanguage.structure.IntegerConstant")) {
      return SPropertyOperations.getInteger(SNodeOperations.cast(expr, "jetbrains.mps.baseLanguage.structure.IntegerConstant"), "value");
    } else if (SNodeOperations.isInstanceOf(expr, "jetbrains.mps.baseLanguage.structure.StringLiteral")) {
      return SPropertyOperations.getString(SNodeOperations.cast(expr, "jetbrains.mps.baseLanguage.structure.StringLiteral"), "value");
    } else if (SNodeOperations.isInstanceOf(expr, "jetbrains.mps.baseLanguage.structure.NullLiteral")) {
      return null;
    }
    throw new IllegalArgumentException();
  }

  public static SNode getTemplateArgumentQueryExpression_Query(SNode expr) {
    return SLinkOperations.getTarget(expr, "query", true);
  }

  public static SNode getTemplateArgumentParameterExpression_Parameter(SNode expr) {
    return SLinkOperations.getTarget(expr, "parameter", false);
  }

  public static boolean getMappingScript_IsPreProcess(SNode script) {
    return SPropertyOperations.hasValue(script, "scriptKind", "pre_processing", "post_processing");
  }

  public static boolean getMappingScript_ModifiesModel(SNode script) {
    return SPropertyOperations.getBoolean(script, "modifiesModel");
  }

  public static SNode getMappingScript_CodeBlock(SNode script) {
    return SLinkOperations.getTarget(script, "codeBlock", true);
  }

  public static SNode getInsertMacro_Query(SNode macro) {
    return SLinkOperations.getTarget(macro, "createNodeQuery", true);
  }

  public static SNode getMappingConfiguration_IsApplicable(SNode mapping) {
    return SLinkOperations.getTarget(mapping, "condition", true);
  }
}
