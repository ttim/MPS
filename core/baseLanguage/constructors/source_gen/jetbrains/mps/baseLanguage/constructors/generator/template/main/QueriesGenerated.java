package jetbrains.mps.baseLanguage.constructors.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.baseLanguage.behavior.Type_Behavior;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;

public class QueriesGenerated {
  public static boolean baseMappingRule_Condition_4563030478605919789(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "customConstructor", false), "arguments", true), "jetbrains.mps.baseLanguage.constructors.structure.ListArgumentsClause");
  }

  public static boolean baseMappingRule_Condition_7738355964682569232(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "customConstructor", false), "arguments", true), "jetbrains.mps.baseLanguage.constructors.structure.ListArgumentsClause"));
  }

  public static Object propertyMacro_GetPropertyValue_3361165003578773248(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_3361165003578605393(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_606143069297663192(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return INamedConcept_Behavior.call_getFqName_1213877404258(SNodeOperations.cast(SNodeOperations.getParent(SLinkOperations.getTarget(_context.getNode(), "customConstructor", false)), "jetbrains.mps.baseLanguage.constructors.structure.CustomConstructorContainer"));
  }

  public static Object propertyMacro_GetPropertyValue_606143069297663234(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "customConstructor", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_4739047193854099886(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_4563030478605372023(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_7738355964682458480(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return INamedConcept_Behavior.call_getFqName_1213877404258(SNodeOperations.cast(SNodeOperations.getParent(SLinkOperations.getTarget(_context.getNode(), "customConstructor", false)), "jetbrains.mps.baseLanguage.constructors.structure.CustomConstructorContainer"));
  }

  public static Object propertyMacro_GetPropertyValue_7738355964682458492(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "customConstructor", false), "name");
  }

  public static Object referenceMacro_GetReferent_4563030478605788432(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "parameter", false), "name");
  }

  public static boolean ifMacro_Condition_4563030478605217770(final IOperationContext operationContext, final IfMacroContext _context) {
    return true;
  }

  public static boolean ifMacro_Condition_7451562887563468786(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(TypeChecker.getInstance().getTypeOf(_context.getNode()), "jetbrains.mps.baseLanguage.structure.PrimitiveType");
  }

  public static SNode sourceNodeQuery_4563030478604331518(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_4739047193854690302(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "list", true);
  }

  public static SNode sourceNodeQuery_3361165003578773217(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "returnType", true);
  }

  public static SNode sourceNodeQuery_3361165003578773233(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_4563030478604064810(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "arguments", true);
  }

  public static SNode sourceNodeQuery_7451562887563468798(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.baseLanguage.constructors.structure.CustomConstructorUsage"), "customConstructor", false), "arguments", true), "jetbrains.mps.baseLanguage.constructors.structure.ListArgumentsClause"), "list", true), "type", true);
  }

  public static SNode sourceNodeQuery_7451562887563468815(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TypeChecker.getInstance().getRuntimeSupport().coerce_(SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.baseLanguage.constructors.structure.CustomConstructorUsage"), "customConstructor", false), "arguments", true), "jetbrains.mps.baseLanguage.constructors.structure.ListArgumentsClause"), "list", true), "type", true), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.PrimitiveType"), true);
  }

  public static SNode sourceNodeQuery_7451562887563468835(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_7451562887563468852(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "customConstructor", false), "arguments", true), "jetbrains.mps.baseLanguage.constructors.structure.ListArgumentsClause"), "list", true), "type", true));
  }

  public static SNode sourceNodeQuery_4563030478604494220(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(SLinkOperations.getTarget(_context.getNode(), "type", true));
  }

  public static SNode sourceNodeQuery_4563030478605372033(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_7738355964682834056(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static Iterable sourceNodesQuery_4563030478605194153(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static Iterable sourceNodesQuery_3361165003578749619(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "constructors", true);
  }

  public static Iterable sourceNodesQuery_7451562887563468840(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "element", true);
  }

  public static Iterable sourceNodesQuery_7738355964682834053(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "element", true);
  }
}
