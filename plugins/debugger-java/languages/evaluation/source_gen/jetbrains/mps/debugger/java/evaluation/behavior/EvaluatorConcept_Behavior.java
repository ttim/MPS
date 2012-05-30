package jetbrains.mps.debugger.java.evaluation.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.project.IModule;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.internal.collections.runtime.ILeftCombinator;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class EvaluatorConcept_Behavior {
  private static Class[] PARAMETERS_5211667636169798157 = {SNode.class};
  private static Class[] PARAMETERS_5211667636169798161 = {SNode.class};
  private static Class[] PARAMETERS_5211667636169798165 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getThrowableTypes_6204026822016975623(SNode thisNode) {
    return new ArrayList<SNode>();
  }

  public static SNode virtual_getBody_1239354440022(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "evaluatedStatements", true);
  }

  public static SNode virtual_getExpectedRetType_1239354342632(SNode thisNode) {
    return new EvaluatorConcept_Behavior.QuotationClass_29c8r0_a0a0d().createNode();
  }

  public static String virtual_getEvaluatorPresentation_9172312269976647295(SNode thisNode) {
    // todo better presentation 
    List<SNode> statements = SLinkOperations.getTargets(SLinkOperations.getTarget(thisNode, "evaluatedStatements", true), "statement", true);
    if (ListSequence.fromList(statements).isEmpty()) {
      return "empty statement";
    }

    SNode lastStatement = ListSequence.fromList(statements).last();
    String suffix = ((ListSequence.fromList(statements).count() > 1 ?
      "..." :
      ""
    ));

    if (SNodeOperations.isInstanceOf(lastStatement, "jetbrains.mps.baseLanguage.structure.ExpressionStatement")) {
      return EvaluatorConcept_Behavior.call_getPresentation_9172312269976661829(thisNode, SLinkOperations.getTarget(SNodeOperations.cast(lastStatement, "jetbrains.mps.baseLanguage.structure.ExpressionStatement"), "expression", true)) + suffix;
    }

    return ((String) BehaviorManager.getInstance().invoke(Object.class, lastStatement, "virtual_getPresentation_1213877396640", new Class[]{SNode.class})) + suffix;
  }

  public static String call_getPresentation_9172312269976661829(SNode thisNode, @Nullable SNode expression) {
    if (expression == null) {
      return "????";
    }

    if (SNodeOperations.isInstanceOf(expression, "jetbrains.mps.lang.core.structure.INamedConcept")) {
      return SPropertyOperations.getString(SNodeOperations.cast(expression, "jetbrains.mps.lang.core.structure.INamedConcept"), "name");
    }

    if (SNodeOperations.isInstanceOf(expression, "jetbrains.mps.baseLanguage.structure.DotExpression")) {
      return EvaluatorConcept_Behavior.call_getPresentation_9172312269976661829(thisNode, SLinkOperations.getTarget(SNodeOperations.cast(expression, "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true)) + "." + EvaluatorConcept_Behavior.call_getOperationPresentation_9172312269976661942(thisNode, SLinkOperations.getTarget(SNodeOperations.cast(expression, "jetbrains.mps.baseLanguage.structure.DotExpression"), "operation", true));
    }

    if (SNodeOperations.isInstanceOf(expression, "jetbrains.mps.baseLanguage.structure.BinaryOperation")) {
      return EvaluatorConcept_Behavior.call_getPresentation_9172312269976661829(thisNode, SLinkOperations.getTarget(SNodeOperations.cast(expression, "jetbrains.mps.baseLanguage.structure.BinaryOperation"), "leftExpression", true)) + SConceptPropertyOperations.getString(SNodeOperations.cast(expression, "jetbrains.mps.baseLanguage.structure.BinaryOperation"), "alias") + EvaluatorConcept_Behavior.call_getPresentation_9172312269976661829(thisNode, SLinkOperations.getTarget(SNodeOperations.cast(expression, "jetbrains.mps.baseLanguage.structure.BinaryOperation"), "rightExpression", true));
    }

    if (SNodeOperations.isInstanceOf(expression, "jetbrains.mps.baseLanguage.structure.StringLiteral")) {
      return "\"" + SPropertyOperations.getString(SNodeOperations.cast(expression, "jetbrains.mps.baseLanguage.structure.StringLiteral"), "value") + "\"";
    }

    if (SNodeOperations.isInstanceOf(expression, "jetbrains.mps.baseLanguage.structure.GenericNewExpression")) {
      return "new " + ((String) BehaviorManager.getInstance().invoke(Object.class, SLinkOperations.getTarget(SNodeOperations.cast(expression, "jetbrains.mps.baseLanguage.structure.GenericNewExpression"), "creator", true), "virtual_getPresentation_1213877396640", new Class[]{SNode.class}));
    }

    if (SConceptPropertyOperations.getBoolean(expression, "constant")) {
      return ((Object) BehaviorManager.getInstance().invoke(Object.class, expression, "virtual_getCompileTimeConstantValue_1238860310638", new Class[]{SNode.class, IModule.class}, SNodeOperations.getModel(thisNode).getModelDescriptor().getModule())) + "";
    }

    return BaseConcept_Behavior.call_getPresentation_1213877396640(expression);
  }

  public static String call_getOperationPresentation_9172312269976661942(final SNode thisNode, @Nullable SNode operation) {
    if (operation == null) {
      return "????";
    }
    if (StringUtils.isNotEmpty(SConceptPropertyOperations.getString(operation, "alias"))) {
      return SConceptPropertyOperations.getString(operation, "alias");
    }
    if (SNodeOperations.isInstanceOf(operation, "jetbrains.mps.baseLanguage.structure.IMethodCall")) {
      return SPropertyOperations.getString(SLinkOperations.getTarget(SNodeOperations.cast(operation, "jetbrains.mps.baseLanguage.structure.IMethodCall"), "baseMethodDeclaration", false), "name") + "(" + ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(operation, "jetbrains.mps.baseLanguage.structure.IMethodCall"), "actualArgument", true)).foldLeft("", new ILeftCombinator<SNode, String>() {
        public String combine(String s, SNode it) {
          return ((StringUtils.isEmpty(s) ?
            "" :
            s + ","
          )) + EvaluatorConcept_Behavior.call_getPresentation_9172312269976661829(thisNode, it);
        }
      }) + ")";
    }
    return ((String) BehaviorManager.getInstance().invoke(Object.class, operation, "virtual_getPresentation_1213877396640", new Class[]{SNode.class}));
  }

  public static List<SNode> call_getThrowableTypes_5211667636169798157(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.debugger.java.evaluation.structure.EvaluatorConcept"), "virtual_getThrowableTypes_6204026822016975623", PARAMETERS_5211667636169798157);
  }

  public static SNode call_getBody_5211667636169798161(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.debugger.java.evaluation.structure.EvaluatorConcept"), "virtual_getBody_1239354440022", PARAMETERS_5211667636169798161);
  }

  public static SNode call_getExpectedRetType_5211667636169798165(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.debugger.java.evaluation.structure.EvaluatorConcept"), "virtual_getExpectedRetType_1239354342632", PARAMETERS_5211667636169798165);
  }

  public static List<SNode> callSuper_getThrowableTypes_5211667636169798157(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.debugger.java.evaluation.structure.EvaluatorConcept"), callerConceptFqName, "virtual_getThrowableTypes_6204026822016975623", PARAMETERS_5211667636169798157);
  }

  public static SNode callSuper_getBody_5211667636169798161(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.debugger.java.evaluation.structure.EvaluatorConcept"), callerConceptFqName, "virtual_getBody_1239354440022", PARAMETERS_5211667636169798161);
  }

  public static SNode callSuper_getExpectedRetType_5211667636169798165(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.debugger.java.evaluation.structure.EvaluatorConcept"), callerConceptFqName, "virtual_getExpectedRetType_1239354342632", PARAMETERS_5211667636169798165);
  }

  public static class QuotationClass_29c8r0_a0a0d {
    public QuotationClass_29c8r0_a0a0d() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
