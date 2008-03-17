package jetbrains.mps.bootstrap.helgins.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_WhenConcreteVariableDeclaration_InferenceRule implements InferenceRule_Runtime {

  public  typeof_WhenConcreteVariableDeclaration_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck) {
    TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(nodeToCheck, "jetbrains.mps.bootstrap.helgins.helgins", "1205768025013", true), TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(SNodeOperations.getParent(nodeToCheck, null, false, false), "argument", true), "jetbrains.mps.bootstrap.helgins.helgins", "1205768025018", false), nodeToCheck, null, "jetbrains.mps.bootstrap.helgins.helgins", "1205768025011");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.helgins.structure.WhenConcreteVariableDeclaration";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
