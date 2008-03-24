package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_OrExpression_InferenceRule implements InferenceRule_Runtime {

  public  typeOf_OrExpression_InferenceRule() {
  }

  public void applyRule(final SNode orExpr) {
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(orExpr, "leftExpression", true), "jetbrains.mps.baseLanguage.helgins", "1176901341532", true), new QuotationClass_39().createNode(), SLinkOperations.getTarget(orExpr, "leftExpression", true), null, "jetbrains.mps.baseLanguage.helgins", "1176901360178", false);
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(orExpr, "rightExpression", true), "jetbrains.mps.baseLanguage.helgins", "1176901371535", true), new QuotationClass_40().createNode(), SLinkOperations.getTarget(orExpr, "rightExpression", true), null, "jetbrains.mps.baseLanguage.helgins", "1176901371532", false);
    TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_41().createNode(), orExpr, "jetbrains.mps.baseLanguage.helgins", "1176901392839");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.OrExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
