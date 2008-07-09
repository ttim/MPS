package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_OrExpression_InferenceRule implements InferenceRule_Runtime {

  public typeOf_OrExpression_InferenceRule() {
  }

  public void applyRule(final SNode orExpr) {
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(orExpr, "leftExpression", true);
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.baseLanguage.helgins@5_0", "1215615987457", true), new QuotationClass_34().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.baseLanguage.helgins@5_0", "1215615987454", false, 0);
    }
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(orExpr, "rightExpression", true);
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.baseLanguage.helgins@5_0", "1215615987463", true), new QuotationClass_35().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.baseLanguage.helgins@5_0", "1215615987460", false, 0);
    }
    TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_36().createNode(), orExpr, "jetbrains.mps.baseLanguage.helgins", "1176901392839");
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
