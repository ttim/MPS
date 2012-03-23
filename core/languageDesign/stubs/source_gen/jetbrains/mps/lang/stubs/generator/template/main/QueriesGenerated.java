package jetbrains.mps.lang.stubs.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.classifiers.behavior.ThisClassifierExpression_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.stubs.behavior.AbstractModelCreator_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.lang.stubs.behavior.LibraryStubDescriptor_Behavior;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;

public class QueriesGenerated {
  public static boolean baseMappingRule_Condition_5516999836374766741(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(ThisClassifierExpression_Behavior.call_getClassifier_1213877512819(_context.getNode()), "jetbrains.mps.lang.stubs.structure.StubsCreatorDeclaration");
  }

  public static boolean baseMappingRule_Condition_2856649189863832596(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "export", true) != null);
  }

  public static Object propertyMacro_GetPropertyValue_3798212845297807980(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return AbstractModelCreator_Behavior.call_getGeneratedName_5553449326502826657(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_562112407431589663(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "languageId");
  }

  public static Object propertyMacro_GetPropertyValue_8178231612784878176(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SModelDescriptor model = _context.getOriginalInputModel().getModelDescriptor();
    return Language.getLanguageForLanguageAspect(model).getModuleReference().getModuleId().toString();
  }

  public static Object propertyMacro_GetPropertyValue_5553449326502993530(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return AbstractModelCreator_Behavior.call_getGeneratedName_5553449326502826657(_context.getNode());
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

  public static Object propertyMacro_GetPropertyValue_2856649189863739908(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SNodeOperations.cast(SLinkOperations.getTarget(_context.getNode(), "export", true), "jetbrains.mps.lang.core.structure.ExportScopeNamespace"), "namespace");
  }

  public static Object propertyMacro_GetPropertyValue_2856649189863698958(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return LibraryStubDescriptor_Behavior.call_getGeneratedName_2856649189863832611(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_5516999836374471953(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SLinkOperations.getTarget(_context.getNode(), "declaration", false), "map_StubCreator");
  }

  public static Object referenceMacro_GetReferent_5516999836374789389(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SNodeOperations.cast(ThisClassifierExpression_Behavior.call_getClassifier_1213877512819(_context.getNode()), "jetbrains.mps.lang.stubs.structure.StubsCreatorDeclaration"), "map_StubCreator");
  }

  public static Object referenceMacro_GetReferent_4009335194403290562(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SLinkOperations.getTarget(_context.getNode(), "member", false), "map_ClassifierMethod");
  }

  public static Object referenceMacro_GetReferent_8307046163197876896(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return "updateModel";
  }

  public static Object referenceMacro_GetReferent_2856649189863698970(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return AbstractModelCreator_Behavior.call_getGeneratedName_5553449326502826657(SLinkOperations.getTarget(_context.getNode(), "creator", false));
  }

  public static boolean ifMacro_Condition_4009335194403392534(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "rootDescriptorsBlock", true) != null);
  }

  public static boolean ifMacro_Condition_625258459142302897(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "initBlock", true) != null);
  }

  public static boolean ifMacro_Condition_2856649189863739816(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "export", true), "jetbrains.mps.lang.core.structure.ExportScopeModule");
  }

  public static boolean ifMacro_Condition_2856649189863739829(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "export", true), "jetbrains.mps.lang.core.structure.ExportScopePublic");
  }

  public static boolean ifMacro_Condition_2856649189863739872(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "export", true), "jetbrains.mps.lang.core.structure.ExportScopeNamespace");
  }

  public static SNode sourceNodeQuery_3798212845297904679(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "updateModelBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_4577087497091827773(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "modelDescriptorsBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_4577087497091827887(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "rootDescriptorsBlock", true), "body", true);
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

  public static Iterable sourceNodesQuery_664395348088057442(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "field", true);
  }

  public static Iterable sourceNodesQuery_562112407431544948(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "settings", true), "importedLanguage", true);
  }

  public static Iterable sourceNodesQuery_5516999836374945739(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "method", true);
  }

  public static Iterable sourceNodesQuery_4009335194403290554(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "actualArgument", true);
  }
}
