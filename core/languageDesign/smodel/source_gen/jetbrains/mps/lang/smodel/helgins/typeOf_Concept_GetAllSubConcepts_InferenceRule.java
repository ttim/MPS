package jetbrains.mps.lang.smodel.helgins;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.lang.smodel.behavior.SNodeOperation_Behavior;
import jetbrains.mps.lang.pattern.IMatchingPattern;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_Concept_GetAllSubConcepts_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeOf_Concept_GetAllSubConcepts_InferenceRule() {
  }

  public void applyRule(final SNode node, final TypeCheckingContext typeCheckingContext) {
    if (SLinkOperations.getTarget(node, "scope", true) != null) {
      {
        SNode _nodeToCheck_1029348928467 = node;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createLessThanInequation(typeCheckingContext.typeOf(SLinkOperations.getTarget(node, "scope", true), "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.helgins)", "1207683977998", true), new QuotationClass_87().createNode(), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.helgins)", "1207683977996", false, 0, intentionProvider);
      }
    }
    if (SLinkOperations.getTarget(node, "smodel", true) != null) {
      {
        SNode _nodeToCheck_1029348928467 = node;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createLessThanInequation(typeCheckingContext.typeOf(SLinkOperations.getTarget(node, "smodel", true), "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.helgins)", "1207683989240", true), new QuotationClass_88().createNode(), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.helgins)", "1207683989238", false, 0, intentionProvider);
      }
    }
    SNode leftExpression = SNodeOperation_Behavior.call_getLeftExpression_1213877508894(node);
    {
      final SNode LeftType = typeCheckingContext.typeOf(leftExpression, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.helgins)", "1207683978022", false);
      typeCheckingContext.whenConcrete(LeftType, new Runnable() {

        public void run() {
          {
            IMatchingPattern pattern_1 = HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.lang.smodel.structure.SConceptType");
            SNode coercedNode_1 = TypeChecker.getInstance().getRuntimeSupport().coerce(typeCheckingContext.getEquationManager().getRepresentator(LeftType), pattern_1);
            if (coercedNode_1 != null) {
              {
                SNode _nodeToCheck_1029348928467 = node;
                BaseIntentionProvider intentionProvider = null;
                typeCheckingContext.createEquation(typeCheckingContext.typeOf(node, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.helgins)", "1207685633873", true), new QuotationClass_89().createNode(SLinkOperations.getTarget(coercedNode_1, "conceptDeclaraton", false)), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.helgins)", "1207685633871", intentionProvider);
              }
            }
          }
        }

      }, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.helgins)", "1207683978011");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.smodel.structure.Concept_GetAllSubConcepts";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
