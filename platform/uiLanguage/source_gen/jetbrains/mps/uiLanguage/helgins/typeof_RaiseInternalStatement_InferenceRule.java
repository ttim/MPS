package jetbrains.mps.uiLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_RaiseInternalStatement_InferenceRule implements InferenceRule_Runtime {

  public typeof_RaiseInternalStatement_InferenceRule() {
  }

  public void applyRule(final SNode statement) {
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequationStrong(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(statement, "argument", true), "jetbrains.mps.uiLanguage.helgins", "1209655701497", true), SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.getAncestor(statement, "jetbrains.mps.uiLanguage.structure.EventDeclaration", false, false), "parameter", true), "type", true), SLinkOperations.getTarget(statement, "argument", true), null, "jetbrains.mps.uiLanguage.helgins", "1209655719223", true, 0);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.uiLanguage.structure.RaiseInternalStatement";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
