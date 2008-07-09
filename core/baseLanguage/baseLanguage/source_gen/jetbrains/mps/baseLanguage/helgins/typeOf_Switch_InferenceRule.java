package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_Switch_InferenceRule implements InferenceRule_Runtime {

  public typeOf_Switch_InferenceRule() {
  }

  public void applyRule(final SNode switchStatement) {
    SNode switchSt = switchStatement;
    for(SNode switchCase : SLinkOperations.getTargets(switchSt, "case", true)) {
      {
        SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(switchCase, "expression", true);
        TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.baseLanguage.helgins@5_0", "1215615984869", true), TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(switchSt, "expression", true), "jetbrains.mps.baseLanguage.helgins@5_0", "1215615984874", true), _nodeToCheck_1029348928467, null, "jetbrains.mps.baseLanguage.helgins@5_0", "1215615984867", false, 0);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.SwitchStatement";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
