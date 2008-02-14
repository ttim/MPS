package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_DotExpression_InferenceRule implements InferenceRule_Runtime {

  public  typeof_DotExpression_InferenceRule() {
  }

  public void applyRule(final SNode dotExpression) {
    TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(dotExpression, "jetbrains.mps.baseLanguage.helgins", "1197028434327", true), TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(dotExpression, "operation", true), "jetbrains.mps.baseLanguage.helgins", "1197028440830", false), dotExpression, null, "jetbrains.mps.baseLanguage.helgins", "1197028438070");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.DotExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
