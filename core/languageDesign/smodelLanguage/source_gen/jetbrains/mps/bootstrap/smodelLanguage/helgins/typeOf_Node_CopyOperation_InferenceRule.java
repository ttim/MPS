package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_Node_CopyOperation_InferenceRule implements InferenceRule_Runtime {

  public typeOf_Node_CopyOperation_InferenceRule() {
  }

  public void applyRule(final SNode node) {
    RulesUtil.checkAppliedCorrectly_generic(node);
    final SNode Concept_typevar_1205967749950 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
    RulesUtil.equate_inputNodeConcept(node, TypeChecker.getInstance().getEquationManager().getRepresentator(Concept_typevar_1205967749950));
    {
      final SNode C = TypeChecker.getInstance().getEquationManager().getRepresentator(Concept_typevar_1205967749950);
      TypeChecker.getInstance().getRuntimeSupport().whenConcrete(C, new Runnable() {

        public void run() {
          SNode inputNodeConcept = TypeChecker.getInstance().getEquationManager().getRepresentator(C);
          {
            SNode _nodeToCheck_1029348928467 = node;
            BaseIntentionProvider intentionProvider = null;
            TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(node, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1205967749966", true), new QuotationClass_66().createNode(inputNodeConcept), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1205967749964", intentionProvider);
          }
        }

      }, "jetbrains.mps.bootstrap.smodelLanguage.helgins@3_0", "1220882338498");
    }
    {
      SNode _nodeToCheck_1029348928467 = node;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(node, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186057865109", true), new QuotationClass_42().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186057869956", false, 0, intentionProvider);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_CopyOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
