package jetbrains.mps.baseLanguage.ext.collections.lang.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_PageOperation_InferenceRule implements InferenceRule_Runtime {

  public  typeof_PageOperation_InferenceRule() {
  }

  public void applyRule(final SNode argument) {
    RulesFunctions_Collections.setInputSequenceType(argument, argument);
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(argument, "fromElement", true), "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1184784251266", true), new QuotationClass_8().createNode(), SLinkOperations.getTarget(argument, "fromElement", true), null, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1184784238570");
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(argument, "toElement", true), "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1184784257962", true), new QuotationClass_9().createNode(), SLinkOperations.getTarget(argument, "toElement", true), null, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1184784267337");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.ext.collections.lang.structure.PageOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
