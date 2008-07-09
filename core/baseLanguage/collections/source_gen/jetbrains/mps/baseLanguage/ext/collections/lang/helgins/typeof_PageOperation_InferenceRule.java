package jetbrains.mps.baseLanguage.ext.collections.lang.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_PageOperation_InferenceRule implements InferenceRule_Runtime {

  public typeof_PageOperation_InferenceRule() {
  }

  public void applyRule(final SNode op) {
    RulesFunctions_Collections.setInputSequenceType(op, op);
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(op, "fromElement", true);
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins@5_0", "1215607387239", true), new QuotationClass_8().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins@5_0", "1215607387236", false, 0);
    }
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(op, "toElement", true);
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins@5_0", "1215607387245", true), new QuotationClass_9().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins@5_0", "1215607387242", false, 0);
    }
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
