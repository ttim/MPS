package jetbrains.mps.nanoj.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_ParensExpression_InferenceRule implements InferenceRule_Runtime {

  public  typeof_ParensExpression_InferenceRule() {
  }

  public void applyRule(final SNode argument) {
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.nanoj.structure.ParensExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
