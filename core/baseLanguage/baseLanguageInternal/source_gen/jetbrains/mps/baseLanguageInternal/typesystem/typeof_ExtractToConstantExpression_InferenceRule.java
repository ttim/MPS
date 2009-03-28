package jetbrains.mps.baseLanguageInternal.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_ExtractToConstantExpression_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeof_ExtractToConstantExpression_InferenceRule() {
  }

  public void applyRule(final SNode expression, final TypeCheckingContext typeCheckingContext) {
    {
      SNode _nodeToCheck_1029348928467 = expression;
      BaseIntentionProvider intentionProvider = null;
      typeCheckingContext.createEquation(typeCheckingContext.typeOf(expression, "r:00000000-0000-4000-0000-011c895903ab(jetbrains.mps.baseLanguageInternal.typesystem)", "1238253420219", true), typeCheckingContext.typeOf(SLinkOperations.getTarget(expression, "expression", true), "r:00000000-0000-4000-0000-011c895903ab(jetbrains.mps.baseLanguageInternal.typesystem)", "1238253425212", true), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895903ab(jetbrains.mps.baseLanguageInternal.typesystem)", "1238253423488", intentionProvider);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguageInternal.structure.ExtractToConstantExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
