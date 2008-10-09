package jetbrains.mps.lang.findUsages.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeCheckingContext;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_NewExecuteFinderExpression_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeof_NewExecuteFinderExpression_InferenceRule() {
  }

  public void applyRule(final SNode executeFinderExpression, final TypeCheckingContext typeCheckingContext) {
    {
      SNode _nodeToCheck_1029348928467 = executeFinderExpression;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(executeFinderExpression, "r:00000000-0000-4000-0000-011c8959035a(jetbrains.mps.lang.findUsages.helgins)", "1206450509047", true), new QuotationClass_3().createNode(), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959035a(jetbrains.mps.lang.findUsages.helgins)", "1206450517331", intentionProvider);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.findUsages.structure.ExecuteFinderExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
