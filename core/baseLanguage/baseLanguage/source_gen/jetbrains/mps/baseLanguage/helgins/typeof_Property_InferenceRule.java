package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_Property_InferenceRule implements InferenceRule_Runtime {

  public  typeof_Property_InferenceRule() {
  }

  public void applyRule(final SNode property) {
    TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(property, "jetbrains.mps.baseLanguage.helgins", "1201468307043", true), SLinkOperations.getTarget(property, "type", true), property, null, "jetbrains.mps.baseLanguage.helgins", "1201468313014");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.Property";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
