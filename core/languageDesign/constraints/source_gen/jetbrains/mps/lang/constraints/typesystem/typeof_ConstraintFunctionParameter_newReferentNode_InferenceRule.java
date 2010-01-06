package jetbrains.mps.lang.constraints.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class typeof_ConstraintFunctionParameter_newReferentNode_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_ConstraintFunctionParameter_newReferentNode_InferenceRule() {
  }

  public void applyRule(final SNode node, final TypeCheckingContext typeCheckingContext) {
    SNode targetConcept = SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.getAncestor(node, "jetbrains.mps.lang.constraints.structure.NodeReferentConstraint", false, false), "applicableLink", false), "target", false);
    if ((targetConcept == null)) {
      {
        SNode _nodeToCheck_1029348928467 = node;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590309(jetbrains.mps.lang.constraints.typesystem)", "1208198552377", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590309(jetbrains.mps.lang.constraints.typesystem)", "1208198552379", true), (SNode) new typeof_ConstraintFunctionParameter_newReferentNode_InferenceRule.QuotationClass_5098_0().createNode(typeCheckingContext), _info_12389875345);
      }
    } else {
      {
        SNode _nodeToCheck_1029348928467 = node;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590309(jetbrains.mps.lang.constraints.typesystem)", "1208198556678", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590309(jetbrains.mps.lang.constraints.typesystem)", "1208198556680", true), (SNode) new typeof_ConstraintFunctionParameter_newReferentNode_InferenceRule.QuotationClass_5098_1().createNode(targetConcept, typeCheckingContext), _info_12389875345);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.constraints.structure.ConstraintFunctionParameter_newReferentNode";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_5098_0 {
    public QuotationClass_5098_0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6 = null;
      {
        quotedNode_6 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6 = quotedNode_6;
        result = quotedNode1_6;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6 = null;
      {
        quotedNode_6 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6 = quotedNode_6;
        result = quotedNode1_6;
      }
      return result;
    }
  }

  public static class QuotationClass_5098_1 {
    public QuotationClass_5098_1() {
    }

    public SNode createNode(Object parameter_5098_0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7 = null;
      {
        quotedNode_7 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7 = quotedNode_7;
        quotedNode1_7.setReferent("concept", (SNode) parameter_5098_0);
        result = quotedNode1_7;
      }
      return result;
    }

    public SNode createNode(Object parameter_5098_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7 = null;
      {
        quotedNode_7 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7 = quotedNode_7;
        quotedNode1_7.setReferent("concept", (SNode) parameter_5098_0);
        result = quotedNode1_7;
      }
      return result;
    }
  }
}
