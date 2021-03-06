package jetbrains.mps.lang.stubs.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.classifiers.behavior.ThisClassifierExpression_Behavior;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.stubs.behavior.ModelManagerDeclaration_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.lang.stubs.behavior.LibraryStubDescriptor_Behavior;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;

public class QueriesGenerated {
  public static boolean baseMappingRule_Condition_5516999836374766741(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(ThisClassifierExpression_Behavior.call_getClassifier_1213877512819(_context.getNode()), "jetbrains.mps.lang.stubs.structure.ModelManagerDeclaration");
  }

  public static Object propertyMacro_GetPropertyValue_5553449326502993530(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ModelManagerDeclaration_Behavior.call_getGeneratedName_4063774604867753792(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_2974122604715183878(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "moduleName");
  }

  public static Object propertyMacro_GetPropertyValue_2974122604715183881(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "moduleId");
  }

  public static Object propertyMacro_GetPropertyValue_2974122604715183884(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return Language.getLanguageFor(_context.getOriginalInputModel().getModelDescriptor()).getModuleReference().getModuleId().toString();
  }

  public static Object propertyMacro_GetPropertyValue_2974122604715183887(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return LibraryStubDescriptor_Behavior.call_getGeneratedClassFQName_5437642622779198671(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_2974122604715183923(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return LibraryStubDescriptor_Behavior.call_getGeneratedClassName_2974122604715185986(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_5516999836374789389(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SNodeOperations.cast(ThisClassifierExpression_Behavior.call_getClassifier_1213877512819(_context.getNode()), "jetbrains.mps.lang.stubs.structure.ModelManagerDeclaration"), "map_ModelManager");
  }

  public static Object referenceMacro_GetReferent_4009335194403290562(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SLinkOperations.getTarget(_context.getNode(), "member", false), "map_ClassifierMethod");
  }

  public static boolean ifMacro_Condition_4063774604867754051(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "createBlock", true) != null);
  }

  public static boolean ifMacro_Condition_4063774604867754093(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "createBlock", true) != null);
  }

  public static boolean ifMacro_Condition_625258459142302897(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "initBlock", true) != null);
  }

  public static SNode sourceNodeQuery_4063774604867754030(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "descriptorsFunc", true), "body", true);
  }

  public static SNode sourceNodeQuery_4063774604867754067(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "createBlock", true), "canCreateFunc", true), "body", true);
  }

  public static SNode sourceNodeQuery_4063774604867763636(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "createBlock", true), "createFunc", true), "body", true);
  }

  public static SNode sourceNodeQuery_625258459142302913(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "initBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_2974122604715183891(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "rootsBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_972176972348246341(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "langName", true);
  }

  public static Iterable sourceNodesQuery_4009335194403290554(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "actualArgument", true);
  }

  public static Iterable sourceNodesQuery_1707183255733253502(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "field", true);
  }

  public static Iterable sourceNodesQuery_1707183255733255524(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "method", true);
  }
}
