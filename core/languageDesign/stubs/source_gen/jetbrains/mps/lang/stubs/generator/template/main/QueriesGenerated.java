package jetbrains.mps.lang.stubs.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.classifiers.behavior.ThisClassifierExpression_Behavior;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.stubs.behavior.StubsCreatorDeclaration_Behavior;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;

public class QueriesGenerated {
  public static boolean baseMappingRule_Condition_5516999836374766741(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(ThisClassifierExpression_Behavior.call_getClassifier_1213877512819(_context.getNode()), "jetbrains.mps.lang.stubs.structure.StubsCreatorDeclaration");
  }

  public static Object propertyMacro_GetPropertyValue_3798212845297807980(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return StubsCreatorDeclaration_Behavior.call_getGeneratedName_5307115338409984553(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_4009335194403290562(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SLinkOperations.getTarget(_context.getNode(), "member", false), "map_ClassifierMethod");
  }

  public static Object referenceMacro_GetReferent_5516999836374471953(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SLinkOperations.getTarget(_context.getNode(), "creatorDeclaration", false), "map_StubCreator");
  }

  public static Object referenceMacro_GetReferent_5516999836374789389(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SNodeOperations.cast(ThisClassifierExpression_Behavior.call_getClassifier_1213877512819(_context.getNode()), "jetbrains.mps.lang.stubs.structure.StubsCreatorDeclaration"), "map_StubCreator");
  }

  public static boolean ifMacro_Condition_4009335194403392534(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "rootDescriptorsBlock", true) != null);
  }

  public static SNode sourceNodeQuery_3798212845297904679(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "updateModelBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_3798212845297904695(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "modelDescriptorsBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_3798212845297904714(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "rootDescriptorsBlock", true), "body", true);
  }

  public static Iterable sourceNodesQuery_4009335194403290554(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "actualArgument", true);
  }

  public static Iterable sourceNodesQuery_5516999836374945739(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "methodDeclaration", true);
  }
}
