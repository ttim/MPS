package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_Node_InsertNextSiblingOperation_InferenceRule implements InferenceRule_Runtime {

  public  typeof_Node_InsertNextSiblingOperation_InferenceRule() {
  }

  public void applyRule(final SNode argument) {
    RulesUtil.checkAppliedCorrectly_generic(argument);
    SNode parameter = SLinkOperations.getTarget(argument, "parameter", true);
    if(!((parameter == null))) {
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequationStrong(TypeChecker.getInstance().getRuntimeSupport().typeOf(parameter), new QuotationClass_15().createNode(), parameter, "incompatible type: snode expected", "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186057239246");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_InsertNextSiblingOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
