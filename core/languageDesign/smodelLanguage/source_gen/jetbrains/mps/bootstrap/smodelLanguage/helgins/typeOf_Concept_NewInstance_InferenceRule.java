package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.behavior.SNodeOperation_Behavior;
import jetbrains.mps.patterns.IMatchingPattern;
import jetbrains.mps.bootstrap.helgins.runtime.HUtil;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_Concept_NewInstance_InferenceRule implements InferenceRule_Runtime {

  public typeOf_Concept_NewInstance_InferenceRule() {
  }

  public void applyRule(final SNode node) {
    if (SLinkOperations.getTarget(node, "prototypeNode", true) != null) {
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(node, "prototypeNode", true), "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186061176339", true), new QuotationClass_57().createNode(), SLinkOperations.getTarget(node, "prototypeNode", true), null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1181950211367", false, 0);
    }
    SNode leftExpression = SNodeOperation_Behavior.call_getLeftExpression_1213877508894(node);
    {
      final SNode LeftType = TypeChecker.getInstance().getRuntimeSupport().typeOf(leftExpression, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1207688101928", false);
      TypeChecker.getInstance().getRuntimeSupport().whenConcrete(LeftType, new Runnable() {

        public void run() {
          {
            IMatchingPattern pattern_ = HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptType");
            SNode coercedNode_ = TypeChecker.getInstance().getRuntimeSupport().coerce(TypeChecker.getInstance().getEquationManager().getRepresentator(LeftType), pattern_);
            if (coercedNode_ != null) {
              TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(node, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1207688101919", true), new QuotationClass_96().createNode(SLinkOperations.getTarget(coercedNode_, "conceptDeclaraton", false)), node, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1207688101917");
            }
          }
        }

      }, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1207688101911");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.Concept_NewInstance";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
