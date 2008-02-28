package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_IntegerLiteral_InferenceRule implements InferenceRule_Runtime {

  public  typeOf_IntegerLiteral_InferenceRule() {
  }

  public void applyRule(final SNode integerLiteral) {
    TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_46().createNode(), integerLiteral, "jetbrains.mps.baseLanguage.helgins", "1176907711684");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.IntegerLiteral";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
