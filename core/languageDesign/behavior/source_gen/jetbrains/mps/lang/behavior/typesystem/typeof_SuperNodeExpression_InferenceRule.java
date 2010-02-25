package jetbrains.mps.lang.behavior.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class typeof_SuperNodeExpression_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_SuperNodeExpression_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck, final TypeCheckingContext typeCheckingContext) {
    SNode behaviour = SNodeOperations.getAncestor(nodeToCheck, "jetbrains.mps.lang.behavior.structure.ConceptBehavior", true, false);
    SNode concept = SLinkOperations.getTarget(behaviour, "concept", false);
    SNode result;
    if (SNodeOperations.isInstanceOf(concept, "jetbrains.mps.lang.structure.structure.ConceptDeclaration")) {
      SNode cd = ((SNode) concept);
      result = SLinkOperations.getTarget(cd, "extends", false);
    } else {
      SNode icd = ((SNode) concept);
      result = SLinkOperations.getTarget(ListSequence.fromList(SLinkOperations.getTargets(icd, "extends", true)).first(), "intfc", false);
    }
    {
      SNode _nodeToCheck_1029348928467 = nodeToCheck;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:f7f8a091-d98d-402d-85c4-5f05cb2b8c61(jetbrains.mps.lang.behavior.typesystem)", "1225195239813", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:f7f8a091-d98d-402d-85c4-5f05cb2b8c61(jetbrains.mps.lang.behavior.typesystem)", "1225195239815", true), (SNode) new typeof_SuperNodeExpression_InferenceRule.QuotationClass_8307_l523emnesjbu().createNode(result, typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.behavior.structure.SuperNodeExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_8307_l523emnesjbu {
    public QuotationClass_8307_l523emnesjbu() {
    }

    public SNode createNode(Object parameter_8307_l523emnesj70, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8307_l523emnesj6y = null;
      {
        quotedNode_8307_l523emnesj6y = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8307_l523emnesj6y = quotedNode_8307_l523emnesj6y;
        quotedNode1_8307_l523emnesj6y.setReferent("concept", (SNode) parameter_8307_l523emnesj70);
        result = quotedNode1_8307_l523emnesj6y;
      }
      return result;
    }

    public SNode createNode(Object parameter_8307_l523emnesj70) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8307_l523emnesj6y = null;
      {
        quotedNode_8307_l523emnesj6y = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8307_l523emnesj6y = quotedNode_8307_l523emnesj6y;
        quotedNode1_8307_l523emnesj6y.setReferent("concept", (SNode) parameter_8307_l523emnesj70);
        result = quotedNode1_8307_l523emnesj6y;
      }
      return result;
    }
  }
}
