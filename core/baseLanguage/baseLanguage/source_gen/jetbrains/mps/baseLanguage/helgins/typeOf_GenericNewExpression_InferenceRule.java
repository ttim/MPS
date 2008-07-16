package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_GenericNewExpression_InferenceRule implements InferenceRule_Runtime {

  public typeOf_GenericNewExpression_InferenceRule() {
  }

  public void applyRule(final SNode genericNE) {
    {
      SNode _nodeToCheck_1029348928467 = genericNE;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.baseLanguage.helgins", "1197929386566", true), TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(genericNE, "creator", true), "jetbrains.mps.baseLanguage.helgins", "1176896993400", true), _nodeToCheck_1029348928467, null, "jetbrains.mps.baseLanguage.helgins", "1197929386564", intentionProvider);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.GenericNewExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
