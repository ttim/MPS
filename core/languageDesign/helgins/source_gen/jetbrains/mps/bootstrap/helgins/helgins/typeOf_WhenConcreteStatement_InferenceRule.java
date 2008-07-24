package jetbrains.mps.bootstrap.helgins.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_WhenConcreteStatement_InferenceRule implements InferenceRule_Runtime {

  public typeOf_WhenConcreteStatement_InferenceRule() {
  }

  public void applyRule(final SNode whenConcreteStatement) {
    {
      SNode _nodeToCheck_1029348928467 = whenConcreteStatement;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(whenConcreteStatement, "argument", true), "jetbrains.mps.bootstrap.helgins.helgins", "1185805519376", true), new QuotationClass_13().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.helgins.helgins", "1185805532321", false, 0, intentionProvider);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.helgins.structure.WhenConcreteStatement";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
