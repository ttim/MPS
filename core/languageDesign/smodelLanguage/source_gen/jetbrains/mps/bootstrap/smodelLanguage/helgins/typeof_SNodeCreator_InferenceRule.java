package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_SNodeCreator_InferenceRule implements InferenceRule_Runtime {

  public typeof_SNodeCreator_InferenceRule() {
  }

  public void applyRule(final SNode creator) {
    SNode createdType = SLinkOperations.getTarget(creator, "createdType", true);
    if (createdType != null) {
      if (SLinkOperations.getTarget(createdType, "concept", false) == null) {
        {
          BaseIntentionProvider intentionProvider = null;
          TypeChecker.getInstance().reportTypeError(createdType, "concrete node type is expected", "jetbrains.mps.bootstrap.smodelLanguage.helgins@9_0", "1219261917301", intentionProvider);
        }
        return;
      }
      if (SLinkOperations.getTarget(creator, "prototypeNode", true) != null) {
        {
          SNode _nodeToCheck_1029348928467 = creator;
          BaseIntentionProvider intentionProvider = null;
          TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(creator, "prototypeNode", true), "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186061742845", true), new QuotationClass_54().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1181945011354", false, 0, intentionProvider);
        }
      }
      {
        SNode _nodeToCheck_1029348928467 = creator;
        BaseIntentionProvider intentionProvider = null;
        TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(creator, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1203712073963", true), createdType, _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1203712073961", intentionProvider);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeCreator";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
