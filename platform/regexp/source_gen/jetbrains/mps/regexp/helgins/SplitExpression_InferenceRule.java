package jetbrains.mps.regexp.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeCheckingContext;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class SplitExpression_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public SplitExpression_InferenceRule() {
  }

  public void applyRule(final SNode se, final TypeCheckingContext typeCheckingContext) {
    {
      SNode _nodeToCheck_1029348928467 = se;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(se, "expr", true), "r:00000000-0000-4000-0000-011c89590517(jetbrains.mps.regexp.helgins)", "1178179183643", true), new QuotationClass_4().createNode(), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590517(jetbrains.mps.regexp.helgins)", "1178179183642", false, 0, intentionProvider);
    }
    TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_5().createNode(), se, "r:00000000-0000-4000-0000-011c89590517(jetbrains.mps.regexp.helgins)", "1178179183649");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.regexp.structure.SplitExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
