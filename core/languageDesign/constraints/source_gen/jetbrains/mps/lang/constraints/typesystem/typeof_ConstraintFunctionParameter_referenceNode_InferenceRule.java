package jetbrains.mps.lang.constraints.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.constraints.behavior.NodeReferentConstraint_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.constraints.behavior.NodeDefaultSearchScope_Behavior;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class typeof_ConstraintFunctionParameter_referenceNode_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_ConstraintFunctionParameter_referenceNode_InferenceRule() {
  }

  public void applyRule(final SNode node, final TypeCheckingContext typeCheckingContext) {
    SNode applicableConcept = NodeReferentConstraint_Behavior.call_getApplicableConcept_1213877399322(SNodeOperations.getAncestor(node, "jetbrains.mps.lang.constraints.structure.NodeReferentConstraint", false, false));
    if ((applicableConcept == null)) {
      applicableConcept = NodeDefaultSearchScope_Behavior.call_getReferentConcept_1213877261403(SNodeOperations.getAncestor(node, "jetbrains.mps.lang.constraints.structure.NodeDefaultSearchScope", false, false));
    }
    if ((applicableConcept == null)) {
      {
        SNode _nodeToCheck_1029348928467 = node;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590309(jetbrains.mps.lang.constraints.typesystem)", "1212097655290", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590309(jetbrains.mps.lang.constraints.typesystem)", "1212097655292", true), (SNode) new typeof_ConstraintFunctionParameter_referenceNode_InferenceRule.QuotationClass_7290_l523emnet0dp().createNode(typeCheckingContext), _info_12389875345);
      }
    } else {
      {
        SNode _nodeToCheck_1029348928467 = node;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590309(jetbrains.mps.lang.constraints.typesystem)", "1212097660325", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590309(jetbrains.mps.lang.constraints.typesystem)", "1212097660327", true), (SNode) new typeof_ConstraintFunctionParameter_referenceNode_InferenceRule.QuotationClass_7290_l523emnet0f8().createNode(applicableConcept, typeCheckingContext), _info_12389875345);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.constraints.structure.ConstraintFunctionParameter_referenceNode";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_7290_l523emnet0dp {
    public QuotationClass_7290_l523emnet0dp() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7290_l523emneszvr = null;
      {
        quotedNode_7290_l523emneszvr = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7290_l523emneszvr = quotedNode_7290_l523emneszvr;
        result = quotedNode1_7290_l523emneszvr;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7290_l523emneszvr = null;
      {
        quotedNode_7290_l523emneszvr = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7290_l523emneszvr = quotedNode_7290_l523emneszvr;
        result = quotedNode1_7290_l523emneszvr;
      }
      return result;
    }
  }

  public static class QuotationClass_7290_l523emnet0f8 {
    public QuotationClass_7290_l523emnet0f8() {
    }

    public SNode createNode(Object parameter_7290_l523emneszvz, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7290_l523emneszvx = null;
      {
        quotedNode_7290_l523emneszvx = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7290_l523emneszvx = quotedNode_7290_l523emneszvx;
        quotedNode1_7290_l523emneszvx.setReferent("concept", (SNode) parameter_7290_l523emneszvz);
        result = quotedNode1_7290_l523emneszvx;
      }
      return result;
    }

    public SNode createNode(Object parameter_7290_l523emneszvz) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7290_l523emneszvx = null;
      {
        quotedNode_7290_l523emneszvx = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7290_l523emneszvx = quotedNode_7290_l523emneszvx;
        quotedNode1_7290_l523emneszvx.setReferent("concept", (SNode) parameter_7290_l523emneszvz);
        result = quotedNode1_7290_l523emneszvx;
      }
      return result;
    }
  }
}
