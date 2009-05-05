package jetbrains.mps.baseLanguage.classifiers.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.baseLanguage.classifiers.behavior.SuperClassifierExpresson_Behavior;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.baseLanguage.classifiers.behavior.IClassifier_Behavior;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_SuperClassifierExpresson_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeof_SuperClassifierExpresson_InferenceRule() {
  }

  public void applyRule(final SNode expresson, final TypeCheckingContext typeCheckingContext) {
    SNode classifier = SuperClassifierExpresson_Behavior.call_getClassifier_1217434044387(expresson);
    if (classifier != null) {
      {
        SNode _nodeToCheck_1029348928467 = expresson;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createEquation((SNode)typeCheckingContext.typeOf(expresson, "r:00000000-0000-4000-0000-011c89590371(jetbrains.mps.baseLanguage.classifiers.typesystem)", "1217434001451", true), (SNode)IClassifier_Behavior.call_createSuperType_1217433657148(classifier), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590371(jetbrains.mps.baseLanguage.classifiers.typesystem)", "1217434001449", intentionProvider);
      }
    } else
    {
      {
        BaseIntentionProvider intentionProvider = null;
        IErrorTarget errorTarget = new NodeErrorTarget();
        typeCheckingContext.reportTypeError(expresson, "super classifier expression isn't applicable in this place", "r:00000000-0000-4000-0000-011c89590371(jetbrains.mps.baseLanguage.classifiers.typesystem)", "1217434001462", intentionProvider, errorTarget);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.classifiers.structure.SuperClassifierExpresson";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
