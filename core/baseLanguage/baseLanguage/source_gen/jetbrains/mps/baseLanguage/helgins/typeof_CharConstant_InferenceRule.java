package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_CharConstant_InferenceRule implements InferenceRule_Runtime {

  public typeof_CharConstant_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck) {
    {
      SNode _nodeToCheck_1029348928467 = nodeToCheck;
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.baseLanguage.helgins@5_0", "1215615991114", true), new QuotationClass_72().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.baseLanguage.helgins@5_0", "1215615991111");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.CharConstant";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
