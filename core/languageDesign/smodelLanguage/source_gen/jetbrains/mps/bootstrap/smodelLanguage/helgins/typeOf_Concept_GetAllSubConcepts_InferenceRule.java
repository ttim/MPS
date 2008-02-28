package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.constraints.SNodeOperation_Behavior;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_Concept_GetAllSubConcepts_InferenceRule implements InferenceRule_Runtime {

  public  typeOf_Concept_GetAllSubConcepts_InferenceRule() {
  }

  public void applyRule(final SNode node) {
    SNode leftExpression = SNodeOperation_Behavior.call_getLeftExpression_1200920411564(node);
    final SNode C_typevar_1186061759037 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable(false);
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequationStrong(TypeChecker.getInstance().getRuntimeSupport().typeOf(leftExpression, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186061764227", true), new QuotationClass_68().createNode(TypeChecker.getInstance().getEquationManager().getRepresentator(C_typevar_1186061759037)), leftExpression, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186061769012");
    TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(node, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1203711474227", true), new QuotationClass_69().createNode(TypeChecker.getInstance().getEquationManager().getRepresentator(C_typevar_1186061759037)), node, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1203711474225");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.Concept_GetAllSubConcepts";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
