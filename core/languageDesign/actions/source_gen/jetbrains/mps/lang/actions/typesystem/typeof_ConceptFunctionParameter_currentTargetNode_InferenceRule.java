package jetbrains.mps.lang.actions.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class typeof_ConceptFunctionParameter_currentTargetNode_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_ConceptFunctionParameter_currentTargetNode_InferenceRule() {
  }

  public void applyRule(final SNode node, final TypeCheckingContext typeCheckingContext) {
    SNode builder = SNodeOperations.getAncestor(node, "jetbrains.mps.lang.actions.structure.NodeSubstituteActionsBuilder", false, false);
    {
      SNode _nodeToCheck_1029348928467 = node;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902a6(jetbrains.mps.lang.actions.typesystem)", "1223982503146", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902a6(jetbrains.mps.lang.actions.typesystem)", "1223982503151", true), (SNode) new typeof_ConceptFunctionParameter_currentTargetNode_InferenceRule.QuotationClass_9kq3v1_a0a1a0().createNode(SLinkOperations.getTarget(builder, "applicableConcept", false), typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_currentTargetNode";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_9kq3v1_a0a1a0 {
    public QuotationClass_9kq3v1_a0a1a0() {
    }

    public SNode createNode(Object parameter_9kq3v1_a0a0a1a0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_9kq3v1_a0a1a0 = null;
      {
        quotedNode_9kq3v1_a0a1a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_9kq3v1_a0a1a0 = quotedNode_9kq3v1_a0a1a0;
        quotedNode1_9kq3v1_a0a1a0.setReferent("concept", (SNode) parameter_9kq3v1_a0a0a1a0);
        result = quotedNode1_9kq3v1_a0a1a0;
      }
      return result;
    }

    public SNode createNode(Object parameter_9kq3v1_a0a0a1a0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_9kq3v1_a0a1a0 = null;
      {
        quotedNode_9kq3v1_a0a1a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_9kq3v1_a0a1a0 = quotedNode_9kq3v1_a0a1a0;
        quotedNode1_9kq3v1_a0a1a0.setReferent("concept", (SNode) parameter_9kq3v1_a0a0a1a0);
        result = quotedNode1_9kq3v1_a0a1a0;
      }
      return result;
    }
  }
}
