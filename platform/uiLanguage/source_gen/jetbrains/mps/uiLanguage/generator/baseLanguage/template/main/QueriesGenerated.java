package jetbrains.mps.uiLanguage.generator.baseLanguage.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.classifiers.constraints.ThisClassifierExpresson_Behavior;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.uiLanguage.constraints.ComponentDeclaration_Behavior;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.uiLanguage.constraints.BindExpression_Behavior;
import jetbrains.mps.uiLanguage.constraints.BeanDeclaration_Behavior;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.uiLanguage.constraints.Scroller_Behavior;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.uiLanguage.constraints.IComponentInstance_Behavior;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;

import java.util.List;

import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.SequenceOperations;

public class QueriesGenerated {

  public static boolean baseMappingRule_Condition_1202732186792(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "value", true), "jetbrains.mps.uiLanguage.structure.BindExpression"));
  }

  public static boolean baseMappingRule_Condition_1203086836455(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "value", true), "jetbrains.mps.uiLanguage.structure.BindExpression"));
  }

  public static boolean baseMappingRule_Condition_1203521594846(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "creator", true), "jetbrains.mps.uiLanguage.structure.ComponentCreator");
  }

  public static boolean baseMappingRule_Condition_1205754252254(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(ThisClassifierExpresson_Behavior.call_getClassifier_1205753961441(_context.getNode()), "jetbrains.mps.uiLanguage.structure.ComponentDeclaration");
  }

  public static boolean baseMappingRule_Condition_1207755858791(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(ThisClassifierExpresson_Behavior.call_getClassifier_1205753961441(_context.getNode()), "jetbrains.mps.uiLanguage.structure.BeanDeclaration");
  }

  public static boolean baseMappingRule_Condition_1207756277502(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "lValue", true), "jetbrains.mps.baseLanguage.structure.DotExpression"))) {
      return false;
    }
    SNode opExpr = SLinkOperations.getTarget(_context.getNode(), "lValue", true);
    if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(opExpr, "operation", true), "jetbrains.mps.uiLanguage.structure.AttributeReferenceOperation"))) {
      return false;
    }
    return true;
  }

  public static boolean baseMappingRule_Condition_1207756353114(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "operation", true), "jetbrains.mps.uiLanguage.structure.AttributeReferenceOperation");
  }

  public static boolean baseMappingRule_Condition_1207756353125(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "operation", true), "jetbrains.mps.baseLanguage.classifiers.structure.DefaultClassifierMethodCallOperation");
  }

  public static boolean baseMappingRule_Condition_1207757173231(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "creator", true), "jetbrains.mps.uiLanguage.structure.BeanCreator");
  }

  public static Object propertyMacro_GetPropertyValue_1202393917712(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ComponentDeclaration_Behavior.call_getComponentClassName_1202394358859(ComponentDeclaration_Behavior.call_getExtendedComponent_1202392526494(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1202395130383(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ComponentDeclaration_Behavior.call_getComponentClassName_1202394358859(SLinkOperations.getTarget(_context.getNode(), "componentDeclaration", false));
  }

  public static Object propertyMacro_GetPropertyValue_1202395179495(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ComponentDeclaration_Behavior.call_getComponentClassName_1202394358859(SLinkOperations.getTarget(_context.getNode(), "componentDeclaration", false));
  }

  public static Object propertyMacro_GetPropertyValue_1202395198473(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ComponentDeclaration_Behavior.call_getComponentClassName_1202394358859(SLinkOperations.getTarget(_context.getNode(), "componentDeclaration", false));
  }

  public static Object propertyMacro_GetPropertyValue_1202395335440(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getGenerator().getGeneratorSessionContext().createUniqueName("createComponent");
  }

  public static Object propertyMacro_GetPropertyValue_1202395524841(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.getSetterName(SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "attribute", false), "name"));
  }

  public static Object propertyMacro_GetPropertyValue_1202395953748(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1202400509563(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ComponentDeclaration_Behavior.call_getComponentClassName_1202394358859(SLinkOperations.getTarget(_context.getNode(), "componentDeclaration", false));
  }

  public static Object propertyMacro_GetPropertyValue_1202400527073(final IOperationContext operationContext, final PropertyMacroContext _context) {
    String baseName;
    if (SPropertyOperations.getString(_context.getNode(), "name") != null) {
      baseName = "my" + NameUtil.capitalize(SPropertyOperations.getString(_context.getNode(), "name"));
    } else {
      baseName = "myComponent";
    }
    return _context.getGenerator().getGeneratorSessionContext().createUniqueName(baseName);
  }

  public static Object propertyMacro_GetPropertyValue_1202466134243(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "my" + NameUtil.capitalize(SPropertyOperations.getString(_context.getNode(), "name"));
  }

  public static Object propertyMacro_GetPropertyValue_1202466216057(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.getGetterName(SPropertyOperations.getString(_context.getNode(), "name"));
  }

  public static Object propertyMacro_GetPropertyValue_1202466231005(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.getSetterName(SPropertyOperations.getString(_context.getNode(), "name"));
  }

  public static Object propertyMacro_GetPropertyValue_1202467071658(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1202731581547(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "attribute", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1202732923427(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode expression = SLinkOperations.getTarget(_context.getNode(), "value", true);
    return BindExpression_Behavior.call_getPathExpression_1202732446780(expression);
  }

  public static Object propertyMacro_GetPropertyValue_1202746727709(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode operationExpression = SLinkOperations.getTarget(_context.getNode(), "lValue", true);
    SNode referenceOperation = SLinkOperations.getTarget(operationExpression, "operation", true);
    return NameUtil.getSetterName(SPropertyOperations.getString(SLinkOperations.getTarget(referenceOperation, "member", false), "name"));
  }

  public static Object propertyMacro_GetPropertyValue_1202748125960(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.getGetterName(SPropertyOperations.getString(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "operation", true), "member", false), "name"));
  }

  public static Object propertyMacro_GetPropertyValue_1202813431540(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode call = SLinkOperations.getTarget(_context.getNode(), "operation", true);
    return SPropertyOperations.getString(SLinkOperations.getTarget(call, "member", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1203087655378(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode expression = SLinkOperations.getTarget(_context.getNode(), "value", true);
    return BindExpression_Behavior.call_getPathExpression_1202732446780(expression);
  }

  public static Object propertyMacro_GetPropertyValue_1203521175722(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ComponentDeclaration_Behavior.call_getComponentClassName_1202394358859(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "creator", true), "componentDeclaration", false));
  }

  public static Object propertyMacro_GetPropertyValue_1203598354568(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ComponentDeclaration_Behavior.call_getComponentClassName_1202394358859(SLinkOperations.getTarget(_context.getNode(), "component", false));
  }

  public static Object propertyMacro_GetPropertyValue_1207755974306(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BeanDeclaration_Behavior.call_getGeneratedName_1207755414961(SLinkOperations.getTarget(_context.getNode(), "bean", false));
  }

  public static Object propertyMacro_GetPropertyValue_1207756876763(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.getGetterName(SPropertyOperations.getString(_context.getNode(), "name"));
  }

  public static Object propertyMacro_GetPropertyValue_1207756897827(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1207756897872(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.getSetterName(SPropertyOperations.getString(_context.getNode(), "name"));
  }

  public static Object propertyMacro_GetPropertyValue_1207757201595(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BeanDeclaration_Behavior.call_getGeneratedName_1207755414961(SNodeOperations.getAncestor(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "creator", true), "constructor", false), "jetbrains.mps.uiLanguage.structure.BeanDeclaration", false, false));
  }

  public static Object propertyMacro_GetPropertyValue_1207757515192(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1207757536328(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1207757555791(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1207757745935(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object referenceMacro_GetReferent_1202395785142(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "componentFactory");
  }

  public static Object referenceMacro_GetReferent_1202400661315(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "componentField");
  }

  public static Object referenceMacro_GetReferent_1202732045058(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode instance = SNodeOperations.getParent(_context.getNode(), null, false, false);
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(instance, "componentField");
  }

  public static Object referenceMacro_GetReferent_1202747104243(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(SLinkOperations.getTarget(_context.getNode(), "component", false), "componentField");
  }

  public static Object referenceMacro_GetReferent_1203087977763(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode instance = SNodeOperations.getParent(_context.getNode(), null, false, false);
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(instance, "componentField");
  }

  public static Object referenceMacro_GetReferent_1203090308966(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(Scroller_Behavior.call_getWrappedComponent_1203090088392(_context.getNode()), "componentFactory");
  }

  public static boolean ifMacro_Condition_1202740360197(final IOperationContext operationContext, final IfMacroContext _context) {
    return IComponentInstance_Behavior.call_getLayoutConstraint_1203090353020(_context.getNode()) != null;
  }

  public static boolean ifMacro_Condition_1202828721940(final IOperationContext operationContext, final IfMacroContext _context) {
    return "_Dialog".equals(SPropertyOperations.getString(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "root", true), "componentDeclaration", false), "name"));
  }

  public static boolean ifMacro_Condition_1202828766724(final IOperationContext operationContext, final IfMacroContext _context) {
    return "_Dialog".equals(SPropertyOperations.getString(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "root", true), "componentDeclaration", false), "name"));
  }

  public static boolean ifMacro_Condition_1203087505903(final IOperationContext operationContext, final IfMacroContext _context) {
    return ComponentDeclaration_Behavior.call_getConstructor_1203080456035(_context.getNode()) != null;
  }

  public static boolean ifMacro_Condition_1203090388611(final IOperationContext operationContext, final IfMacroContext _context) {
    return IComponentInstance_Behavior.call_getLayoutConstraint_1203090353020(_context.getNode()) != null;
  }

  public static boolean ifMacro_Condition_1203675479827(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "onChange", true) != null;
  }

  public static boolean ifMacro_Condition_1204896367155(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "initializer", true) != null;
  }

  public static boolean ifMacro_Condition_1207756897847(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "onChange", true) != null;
  }

  public static SNode sourceNodeQuery_1202395527079(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "value", true);
  }

  public static SNode sourceNodeQuery_1202466119287(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1202466197938(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1202466206951(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1202466934239(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1202732499988(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    SNode expression = SLinkOperations.getTarget(_context.getNode(), "value", true);
    return BindExpression_Behavior.call_getSourceObject_1202732428354(expression);
  }

  public static SNode sourceNodeQuery_1202740361998(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(IComponentInstance_Behavior.call_getLayoutConstraint_1203090353020(_context.getNode()), "constraint", true);
  }

  public static SNode sourceNodeQuery_1202744829093(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "handler", true);
  }

  public static SNode sourceNodeQuery_1202746716683(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "rValue", true);
  }

  public static SNode sourceNodeQuery_1202746788601(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "lValue", true), "operand", true);
  }

  public static SNode sourceNodeQuery_1202748123035(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "operand", true);
  }

  public static SNode sourceNodeQuery_1202749002563(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_1202813349306(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "operand", true);
  }

  public static SNode sourceNodeQuery_1203087281362(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "value", true);
  }

  public static SNode sourceNodeQuery_1203087505894(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(ComponentDeclaration_Behavior.call_getConstructor_1203080456035(_context.getNode()), "body", true);
  }

  public static SNode sourceNodeQuery_1203087655359(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    SNode expression = SLinkOperations.getTarget(_context.getNode(), "value", true);
    return BindExpression_Behavior.call_getSourceObject_1202732428354(expression);
  }

  public static SNode sourceNodeQuery_1203090390583(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(IComponentInstance_Behavior.call_getLayoutConstraint_1203090353020(_context.getNode()), "constraint", true);
  }

  public static SNode sourceNodeQuery_1203675466452(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "onChange", true);
  }

  public static SNode sourceNodeQuery_1204896369237(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "initializer", true);
  }

  public static SNode sourceNodeQuery_1207756876743(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1207756897807(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1207756897840(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "onChange", true);
  }

  public static SNode sourceNodeQuery_1207756897858(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1207757732474(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1207757762084(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "initializer", true);
  }

  public static List sourceNodesQuery_1202395104349(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SNodeOperations.getDescendants(SLinkOperations.getTarget(_context.getNode(), "root", true), "jetbrains.mps.uiLanguage.structure.ComponentInstance", false);
  }

  public static List sourceNodesQuery_1202395385084(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "content", true);
  }

  public static List sourceNodesQuery_1202395840258(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "root", true), "content", true);
  }

  public static List sourceNodesQuery_1202400443878(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SNodeOperations.getDescendants(SLinkOperations.getTarget(_context.getNode(), "root", true), "jetbrains.mps.uiLanguage.structure.ComponentInstance", false);
  }

  public static List sourceNodesQuery_1202466096481(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ComponentDeclaration_Behavior.call_getDeclaredAttributes_1202465971016(_context.getNode());
  }

  public static List sourceNodesQuery_1202466178697(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ComponentDeclaration_Behavior.call_getDeclaredAttributes_1202465971016(_context.getNode());
  }

  public static List sourceNodesQuery_1202466187116(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ComponentDeclaration_Behavior.call_getDeclaredAttributes_1202465971016(_context.getNode());
  }

  public static List sourceNodesQuery_1202478250130(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SequenceOperations.toList(SequenceOperations.where(SNodeOperations.getDescendants(_context.getNode(), "jetbrains.mps.uiLanguage.structure.AttributeValue", true), new zPredicate(null, null)));
  }

  public static List sourceNodesQuery_1202749000153(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ComponentDeclaration_Behavior.call_getDeclaredMethods_1202749020955(_context.getNode());
  }

  public static List sourceNodesQuery_1203087598722(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SequenceOperations.toList(SequenceOperations.where(SNodeOperations.getDescendants(_context.getNode(), "jetbrains.mps.uiLanguage.structure.ListElements", true), new zPredicate1(null, null)));
  }

  public static List sourceNodesQuery_1207756399572(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    SNode call = SLinkOperations.getTarget(_context.getNode(), "operation", true);
    return SLinkOperations.getTargets(call, "actualArgument", true);
  }

  public static List sourceNodesQuery_1207756876756(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "attribute", true);
  }

  public static List sourceNodesQuery_1207756897865(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "attribute", true);
  }

  public static List sourceNodesQuery_1207757055477(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "constructor", true);
  }

  public static List sourceNodesQuery_1207757149085(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "attribute", true);
  }

  public static List sourceNodesQuery_1207759431551(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "method", true);
  }

}
