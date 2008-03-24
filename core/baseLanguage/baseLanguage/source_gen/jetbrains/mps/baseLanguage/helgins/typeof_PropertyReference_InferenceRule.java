package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.baseLanguage.constraints.IOperation_Behavior;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_PropertyReference_InferenceRule implements InferenceRule_Runtime {

  public  typeof_PropertyReference_InferenceRule() {
  }

  public void applyRule(final SNode propertyReference) {
    SNode property = SLinkOperations.getTarget(propertyReference, "property", false);
    if ((property != null)) {
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(propertyReference, "jetbrains.mps.baseLanguage.helgins", "1201468020092", true), TypeChecker.getInstance().getRuntimeSupport().typeOf(property, "jetbrains.mps.baseLanguage.helgins", "1201468039491", true), propertyReference, null, "jetbrains.mps.baseLanguage.helgins", "1201468036877");
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequationStrong(TypeChecker.getInstance().getRuntimeSupport().typeOf(IOperation_Behavior.call_getOperand_1197028596169(propertyReference), "jetbrains.mps.baseLanguage.helgins", "1201468086552", true), new QuotationClass_79().createNode(SNodeOperations.getAncestor(property, "jetbrains.mps.baseLanguage.structure.Classifier", false, false)), IOperation_Behavior.call_getOperand_1197028596169(propertyReference), null, "jetbrains.mps.baseLanguage.helgins", "1201468086542", false);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.PropertyReference";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
