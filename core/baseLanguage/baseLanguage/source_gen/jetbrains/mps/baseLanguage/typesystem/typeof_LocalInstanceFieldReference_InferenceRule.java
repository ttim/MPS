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
import jetbrains.mps.errors.BaseQuickFixProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import java.util.Map;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class typeof_LocalInstanceFieldReference_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_LocalInstanceFieldReference_InferenceRule() {
  }

  public void applyRule(final SNode fieldReference, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    final SNode fieldDeclaration = SLinkOperations.getTarget(fieldReference, "variableDeclaration", false);
    if ((fieldDeclaration == null)) {
      return;
    }
    final SNode InstanceType_typevar_2233570453276392932 = typeCheckingContext.createNewRuntimeTypesVariable();
    SNode currentClassifier = SNodeOperations.getAncestor(fieldReference, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    while (currentClassifier != null && !(ListSequence.fromList(Classifier_Behavior.call_getVisibleMembers_1213877306257(currentClassifier, fieldReference, IClassifiersSearchScope.INSTANCE_FIELD)).contains(fieldDeclaration))) {
      currentClassifier = SNodeOperations.getAncestor(currentClassifier, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    }
    SNode constructedType = new typeof_LocalInstanceFieldReference_InferenceRule.QuotationClass_4vmy70_a0a5a0().createNode(currentClassifier, currentClassifier, typeCheckingContext);
    for (SNode tvd : SLinkOperations.getTargets(currentClassifier, "typeVariableDeclaration", true)) {
      SNode tvr = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.TypeVariableReference", null);
      SLinkOperations.setTarget(tvr, "typeVariableDeclaration", tvd, false);
      ListSequence.fromList(SLinkOperations.getTargets(constructedType, "parameter", true)).addElement(tvr);
    }

    {
      SNode _nodeToCheck_1029348928467 = fieldReference;
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "2233570453276392933", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) constructedType, (SNode) typeCheckingContext.getRepresentative(InstanceType_typevar_2233570453276392932), _info_12389875345);
    }
    final SNode fieldClassifier = SNodeOperations.getAncestor(fieldDeclaration, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    {
      SNode _nodeToCheck_1029348928467 = fieldReference;
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "2233570453276392949", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequationStrong((SNode) typeCheckingContext.getRepresentative(InstanceType_typevar_2233570453276392932), (SNode) new typeof_LocalInstanceFieldReference_InferenceRule.QuotationClass_4vmy70_a0a01a0().createNode(fieldClassifier, fieldClassifier, typeCheckingContext), true, _info_12389875345);
    }
    Map<SNode, List<SNode>> mmap = MapSequence.fromMap(new HashMap<SNode, List<SNode>>());
    SNode matchedType = RulesFunctions_BaseLanguage.inference_matchTypeWithTypeVariables(typeCheckingContext, SLinkOperations.getTarget(fieldDeclaration, "type", true), mmap);
    {
      SNode _nodeToCheck_1029348928467 = fieldReference;
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "2233570453276392975", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "2233570453276392977", true), (SNode) matchedType, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = null;
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "2233570453276392981", 0, intentionProvider);
      _info_12389875345.setInequationGroup("priority_4_1759628044690732301");
      _info_12389875345.addInequationGroupBefore("priority_3_1759628044690732300");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(fieldReference, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "2233570453276392986", true), (SNode) new typeof_LocalInstanceFieldReference_InferenceRule.QuotationClass_4vmy70_a0a41a0().createNode(typeCheckingContext), false, _info_12389875345);
    }
    RulesFunctions_BaseLanguage.inference_matchConcreteTypesWithTypeVariables(typeCheckingContext, fieldClassifier, typeCheckingContext.getRepresentative(InstanceType_typevar_2233570453276392932), mmap);
    RulesFunctions_BaseLanguage.inference_equateMatchingTypeVariables(typeCheckingContext, mmap);
    RulesFunctions_BaseLanguage.inference_setConcreteUpperBorders(typeCheckingContext, mmap);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference";
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

  public static class QuotationClass_4vmy70_a0a5a0 {
    public QuotationClass_4vmy70_a0a5a0() {
    }

    public SNode createNode(Object parameter_3, Object parameter_4, final TypeCheckingContext typeCheckingContext) {
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

    public SNode createNode(Object parameter_3, Object parameter_4) {
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

  public static class QuotationClass_4vmy70_a0a01a0 {
    public QuotationClass_4vmy70_a0a01a0() {
    }

    public SNode createNode(Object parameter_3, Object parameter_4, final TypeCheckingContext typeCheckingContext) {
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

    public SNode createNode(Object parameter_3, Object parameter_4) {
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

  public static class QuotationClass_4vmy70_a0a41a0 {
    public QuotationClass_4vmy70_a0a41a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
