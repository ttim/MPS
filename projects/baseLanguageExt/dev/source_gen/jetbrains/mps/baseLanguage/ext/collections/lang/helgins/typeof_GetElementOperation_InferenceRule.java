package jetbrains.mps.baseLanguage.ext.collections.lang.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_GetElementOperation_InferenceRule implements InferenceRule_Runtime {

  public  typeof_GetElementOperation_InferenceRule() {
  }

  public void applyRule(final SNode argument) {
    RulesFunctions_Collections.setInputElementType(argument, argument);
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(argument, "argument", true), "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1184856462630", true), new QuotationClass_24().createNode(), SLinkOperations.getTarget(argument, "argument", true), null, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1184856469305");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.ext.collections.lang.structure.GetElementOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
