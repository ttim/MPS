package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.baseLanguage.behavior.Classifier_Behavior;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import java.util.Map;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;

public class typeof_LocalInstanceMethodCall_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_LocalInstanceMethodCall_InferenceRule() {
  }

  public void applyRule(final SNode methodCall, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    if (SLinkOperations.getTarget(methodCall, "baseMethodDeclaration", false) == null) {
      return;
    }
    // --- 
    SNode methodDeclaration = SLinkOperations.getTarget(methodCall, "baseMethodDeclaration", false);
    final SNode methodClassifier = SNodeOperations.getAncestor(methodDeclaration, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    SNode currentClassifier = SNodeOperations.getAncestor(methodCall, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    while (currentClassifier != null && !(ListSequence.fromList(Classifier_Behavior.call_getVisibleMembers_1213877306257(currentClassifier, methodCall, IClassifiersSearchScope.INSTANCE_METHOD)).contains(methodDeclaration))) {
      currentClassifier = SNodeOperations.getAncestor(currentClassifier, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    }
    SNode constructedType = new typeof_LocalInstanceMethodCall_InferenceRule.QuotationClass_h4n2qb_a0a6a0().createNode(currentClassifier, typeCheckingContext);
    for (SNode tvd : SLinkOperations.getTargets(currentClassifier, "typeVariableDeclaration", true)) {
      SNode tvr = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.TypeVariableReference", null);
      SLinkOperations.setTarget(tvr, "typeVariableDeclaration", tvd, false);
      ListSequence.fromList(SLinkOperations.getTargets(constructedType, "parameter", true)).addElement(tvr);
    }
    Map<SNode, List<SNode>> mmap = MapSequence.fromMap(new HashMap<SNode, List<SNode>>());
    RulesFunctions_BaseLanguage.inference_equateParametersAndReturnType(typeCheckingContext, methodCall, SLinkOperations.getTarget(SLinkOperations.getTarget(methodCall, "baseMethodDeclaration", false), "returnType", true), mmap);
    RulesFunctions_BaseLanguage.inference_matchConcreteTypesWithMethodTypeVariables(typeCheckingContext, methodCall, mmap);
    RulesFunctions_BaseLanguage.inference_matchConcreteTypesWithTypeVariables(typeCheckingContext, methodClassifier, constructedType, mmap);
    RulesFunctions_BaseLanguage.inference_equateMatchingTypeVariables(typeCheckingContext, mmap);
    if (currentClassifier == null) {
      currentClassifier = SNodeOperations.getAncestor(methodCall, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    }
    {
      SNode _nodeToCheck_1029348928467 = methodCall;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1126608406759381109", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) new typeof_LocalInstanceMethodCall_InferenceRule.QuotationClass_h4n2qb_a0a41a0_0().createNode(currentClassifier, typeCheckingContext), (SNode) new typeof_LocalInstanceMethodCall_InferenceRule.QuotationClass_h4n2qb_a0a41a0().createNode(methodClassifier, typeCheckingContext), false, _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public boolean overrides() {
    return true;
  }

  public static class QuotationClass_h4n2qb_a0a6a0 {
    public QuotationClass_h4n2qb_a0a6a0() {
    }

    public SNode createNode(Object parameter_3, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("classifier", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("classifier", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_h4n2qb_a0a41a0 {
    public QuotationClass_h4n2qb_a0a41a0() {
    }

    public SNode createNode(Object parameter_3, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("classifier", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("classifier", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_h4n2qb_a0a41a0_0 {
    public QuotationClass_h4n2qb_a0a41a0_0() {
    }

    public SNode createNode(Object parameter_3, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("classifier", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("classifier", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
