package jetbrains.mps.baseLanguage.classifiers.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.classifiers.behavior.ThisClassifierExpresson_Behavior;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.baseLanguage.classifiers.behavior.IClassifier_Behavior;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_ThisClassifierExpresson_InferenceRule implements InferenceRule_Runtime {

  public typeof_ThisClassifierExpresson_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck) {
    SNode classifier = ThisClassifierExpresson_Behavior.call_getClassifier_1213877512819(nodeToCheck);
    if (classifier != null) {
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(nodeToCheck, "jetbrains.mps.baseLanguage.classifiers.helgins", "1205753197519", true), IClassifier_Behavior.call_createType_1213877527970(classifier), nodeToCheck, null, "jetbrains.mps.baseLanguage.classifiers.helgins", "1205753196184");
    } else
    {
      {
        BaseIntentionProvider intentionProvider = null;
        TypeChecker.getInstance().reportTypeError(nodeToCheck, "this classifier expression isn't applicable in this place", "jetbrains.mps.baseLanguage.classifiers.helgins", "1205753211126", intentionProvider);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.classifiers.structure.ThisClassifierExpresson";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
