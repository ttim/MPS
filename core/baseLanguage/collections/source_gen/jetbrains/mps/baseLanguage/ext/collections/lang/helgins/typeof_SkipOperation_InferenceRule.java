package jetbrains.mps.baseLanguage.ext.collections.lang.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_SkipOperation_InferenceRule implements InferenceRule_Runtime {

  public typeof_SkipOperation_InferenceRule() {
  }

  public void applyRule(final SNode op) {
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(op, "elementsToSkip", true), "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1184847100456", true), new QuotationClass_6().createNode(), SLinkOperations.getTarget(op, "elementsToSkip", true), null, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1184847107857", false, 0);
    RulesFunctions_Collections.setInputSequenceType(op, op);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.ext.collections.lang.structure.SkipOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
