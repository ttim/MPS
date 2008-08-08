package jetbrains.mps.bootstrap.helgins.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_ConceptReference_InferenceRule implements InferenceRule_Runtime {

  public typeOf_ConceptReference_InferenceRule() {
  }

  public void applyRule(final SNode cr) {
    SNode conceptReference = cr;
    {
      SNode _nodeToCheck_1029348928467 = cr;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(conceptReference, "jetbrains.mps.bootstrap.helgins.helgins", "1201876231886", true), new QuotationClass_0().createNode(SLinkOperations.getTarget(conceptReference, "concept", false)), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.helgins.helgins", "1201876231884", intentionProvider);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.helgins.structure.ConceptReference";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
