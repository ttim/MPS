package jetbrains.mps.bootstrap.helgins.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_ListVarDeclaration_InferenceRule implements InferenceRule_Runtime {

  public typeof_ListVarDeclaration_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck) {
    {
      SNode _nodeToCheck_1029348928467 = nodeToCheck;
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.bootstrap.helgins.helgins", "1203432694651", true), new QuotationClass_21().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.helgins.helgins@5_0", "1215688284861");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.helgins.structure.ListVarDeclaration";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
