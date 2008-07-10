package jetbrains.mps.bootstrap.helgins.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_ComparisonRule_InferenceRule implements InferenceRule_Runtime {

  public typeof_ComparisonRule_InferenceRule() {
  }

  public void applyRule(final SNode comparisonRule) {
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(comparisonRule, "body", true);
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.bootstrap.helgins.helgins", "1188915257236", true), new QuotationClass_16().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.helgins.helgins@5_0", "1215688284099", false, 0);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.helgins.structure.ComparisonRule";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
