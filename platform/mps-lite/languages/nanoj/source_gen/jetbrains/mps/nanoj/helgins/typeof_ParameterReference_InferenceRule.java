package jetbrains.mps.nanoj.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_ParameterReference_InferenceRule implements InferenceRule_Runtime {

  public  typeof_ParameterReference_InferenceRule() {
  }

  public void applyRule(final SNode argument) {
    TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(argument, "jetbrains.mps.nanoj.helgins", "1197383209218", true), TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(argument, "parameter", false), "jetbrains.mps.nanoj.helgins", "1197383209220", true), argument, null, "jetbrains.mps.nanoj.helgins", "1197383209217");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.nanoj.structure.ParameterReference";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
