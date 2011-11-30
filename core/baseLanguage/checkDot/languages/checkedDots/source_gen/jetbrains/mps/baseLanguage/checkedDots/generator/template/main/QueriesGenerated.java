package jetbrains.mps.baseLanguage.checkedDots.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.baseLanguage.behavior.IVariableReference_Behavior;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.baseLanguage.checkedDots.behavior.CheckedDotExpression_Behavior;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.baseLanguage.behavior.Classifier_Behavior;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class QueriesGenerated {
  public static boolean baseMappingRule_Condition_2319519288049917875(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    SNode checkedDot = SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.baseLanguage.checkedDots.structure.CheckedDotExpression", false, false);
    return checkedDot != null && SLinkOperations.getTarget(checkedDot, "operation", true) != null && SLinkOperations.getTarget(checkedDot, "operation", true).isAncestorOf(_context.getNode());
  }

  public static boolean baseMappingRule_Condition_3905905920761714586(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    SNode checkedDot = SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.baseLanguage.checkedDots.structure.CheckedDotExpression", false, false);
    return checkedDot != null && SLinkOperations.getTarget(checkedDot, "operation", true) != null && SLinkOperations.getTarget(checkedDot, "operation", true).isAncestorOf(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_4549711462050029098(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.createUniqueName("check", _context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_3391577739833458953(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(IVariableReference_Behavior.call_getVariable_1023687332192481693(_context.getNode()), "name");
  }

  public static Object referenceMacro_GetReferent_5665267283159127972(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SLinkOperations.getTarget(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", false);
  }

  public static Object referenceMacro_GetReferent_2319519288049960746(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "baseMethodDeclaration", false);
  }

  public static boolean ifMacro_Condition_53796356308815904(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(SNodeOperations.isInstanceOf(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "operation", true)), "jetbrains.mps.baseLanguage.structure.VoidType"));
  }

  public static boolean ifMacro_Condition_3674434577577159998(final IOperationContext operationContext, final IfMacroContext _context) {
    return CheckedDotExpression_Behavior.call_hasLocalContextInside_3674434577577159922(_context.getNode());
  }

  public static boolean ifMacro_Condition_3674434577577160639(final IOperationContext operationContext, final IfMacroContext _context) {
    return CheckedDotExpression_Behavior.call_hasLocalContextInside_3674434577577159922(_context.getNode());
  }

  public static SNode sourceNodeQuery_53796356308815896(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "operation", true);
  }

  public static SNode sourceNodeQuery_53796356308817189(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "operation", true);
  }

  public static SNode sourceNodeQuery_53796356308780436(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "operation", true));
  }

  public static SNode sourceNodeQuery_5227621747122194587(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "operation", true));
  }

  public static SNode sourceNodeQuery_7907427828436736378(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "operand", true));
  }

  public static SNode sourceNodeQuery_1392486827343609139(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TypeChecker.getInstance().getTypeOf(_context.getNode());
  }

  public static SNode sourceNodeQuery_2319519288049976964(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Classifier_Behavior.call_getThisType_3305065273710880775(SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.baseLanguage.structure.Classifier", false, false));
  }

  public static SNode sourceNodeQuery_7907427828436735258(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "operand", true);
  }

  public static SNode sourceNodeQuery_3391577739833596065(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_3674434577577160632(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return new QueriesGenerated.QuotationClass_x583g4_a0a0s().createNode();
  }

  public static Iterable sourceNodesQuery_3391577739833431906(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SNodeOperations.getDescendants(SLinkOperations.getTarget(_context.getNode(), "operation", true), "jetbrains.mps.baseLanguage.structure.IVariableReference", false, new String[]{});
  }

  public static Iterable sourceNodesQuery_5837079428841717746(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    SNode operation = SLinkOperations.getTarget(_context.getNode(), "operation", true);
    SNode declaration;
    if (SNodeOperations.isInstanceOf(operation, "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation")) {
      declaration = SLinkOperations.getTarget(SNodeOperations.cast(operation, "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"), "baseMethodDeclaration", false);
    } else {
      return Sequence.fromIterable(Collections.<SNode>emptyList());
    }
    return SLinkOperations.getTargets(declaration, "throwsItem", true);
  }

  public static Iterable sourceNodesQuery_3391577739833596041(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SNodeOperations.getDescendants(SLinkOperations.getTarget(_context.getNode(), "operation", true), "jetbrains.mps.baseLanguage.structure.IVariableReference", false, new String[]{});
  }

  public static Iterable sourceNodesQuery_4741735385321357379(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "actualArgument", true);
  }

  public static class QuotationClass_x583g4_a0a0s {
    public QuotationClass_x583g4_a0a0s() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ThisExpression", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
