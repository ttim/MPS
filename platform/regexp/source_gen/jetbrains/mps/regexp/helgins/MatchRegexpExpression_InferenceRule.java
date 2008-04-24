package jetbrains.mps.regexp.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class MatchRegexpExpression_InferenceRule implements InferenceRule_Runtime {

  public MatchRegexpExpression_InferenceRule() {
  }

  public void applyRule(final SNode matchRegexpExpression) {
    TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_7().createNode(), matchRegexpExpression, "jetbrains.mps.regexp.helgins", "1179358945232");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.regexp.structure.MatchRegexpExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
