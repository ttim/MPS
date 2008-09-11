package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
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
      {
        SNode _nodeToCheck_1029348928467 = node;
        BaseIntentionProvider intentionProvider = null;
        TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(node, "prototypeNode", true), "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186061176339", true), new QuotationClass_53().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1181950211367", false, 0, intentionProvider);
      }
    }
    SNode leftExpression = SNodeOperation_Behavior.call_getLeftExpression_1213877508894(node);
    {
      final SNode LeftType = TypeChecker.getInstance().getRuntimeSupport().typeOf(leftExpression, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1207688101928", false);
      TypeChecker.getInstance().getRuntimeSupport().whenConcrete(LeftType, new Runnable() {

        public void run() {
          {
            IMatchingPattern pattern_0 = HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptType");
            SNode coercedNode_0 = TypeChecker.getInstance().getRuntimeSupport().coerce(TypeChecker.getInstance().getEquationManager().getRepresentator(LeftType), pattern_0);
            if (coercedNode_0 != null) {
              {
                SNode _nodeToCheck_1029348928467 = node;
                BaseIntentionProvider intentionProvider = null;
                TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(node, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1207688101919", true), new QuotationClass_90().createNode(SLinkOperations.getTarget(coercedNode_0, "conceptDeclaraton", false)), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1207688101917", intentionProvider);
              }
            }
          }
        }

      }, "jetbrains.mps.bootstrap.smodelLanguage.helgins@3_0", "1221163285671");
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
