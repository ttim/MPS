package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_IfStatement_InferenceRule implements InferenceRule_Runtime {

  public typeOf_IfStatement_InferenceRule() {
  }

  public void applyRule(final SNode ifStatement) {
    {
      SNode _nodeToCheck_1029348928467 = ifStatement;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(ifStatement, "condition", true), "jetbrains.mps.baseLanguage.helgins", "1176898833121", true), new QuotationClass_27().createNode(), _nodeToCheck_1029348928467, "condition should be boolean", "jetbrains.mps.baseLanguage.helgins", "1176898861472", false, 0, intentionProvider);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.IfStatement";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
