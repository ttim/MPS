package jetbrains.mps.lang.smodel.typesystem;

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

public class typeof_Concept_IsSubConceptOfOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_Concept_IsSubConceptOfOperation_InferenceRule() {
  }

  public void applyRule(final SNode op, final TypeCheckingContext typeCheckingContext) {
    SNode conceptArg = SLinkOperations.getTarget(op, "conceptArgument", true);
    if (SNodeOperations.isInstanceOf(conceptArg, "jetbrains.mps.lang.smodel.structure.PoundExpression")) {
      // concept expected 
      {
        SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(SNodeOperations.cast(conceptArg, "jetbrains.mps.lang.smodel.structure.PoundExpression"), "expression", true);
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1206661693384", 0, intentionProvider);
        _info_12389875345.setInequationGroup("default");
        typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1206661693386", false), (SNode) new typeof_Concept_IsSubConceptOfOperation_InferenceRule.QuotationClass_35z7h3_a0a1a1a0().createNode(typeCheckingContext), false, _info_12389875345);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.smodel.structure.Concept_IsSubConceptOfOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_35z7h3_a0a1a1a0 {
    public QuotationClass_35z7h3_a0a1a1a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_35z7h3_a0a1a1a0 = null;
      {
        quotedNode_35z7h3_a0a1a1a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_35z7h3_a0a1a1a0 = quotedNode_35z7h3_a0a1a1a0;
        result = quotedNode1_35z7h3_a0a1a1a0;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_35z7h3_a0a1a1a0 = null;
      {
        quotedNode_35z7h3_a0a1a1a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_35z7h3_a0a1a1a0 = quotedNode_35z7h3_a0a1a1a0;
        result = quotedNode1_35z7h3_a0a1a1a0;
      }
      return result;
    }
  }
}
