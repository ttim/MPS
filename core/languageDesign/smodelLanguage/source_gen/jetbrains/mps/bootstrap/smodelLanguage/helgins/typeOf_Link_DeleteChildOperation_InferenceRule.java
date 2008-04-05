package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_Link_DeleteChildOperation_InferenceRule implements InferenceRule_Runtime {

  public  typeOf_Link_DeleteChildOperation_InferenceRule() {
  }

  public void applyRule(final SNode op) {
    RulesUtil.checkAppliedTo_LinkAccess_aggregation(op);
    final SNode Concept_typevar_1206099630117 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable(false);
    RulesUtil.equate_inputNodeConcept(op, TypeChecker.getInstance().getEquationManager().getRepresentator(Concept_typevar_1206099630117));
    {
      final SNode C = TypeChecker.getInstance().getEquationManager().getRepresentator(Concept_typevar_1206099630117);
      TypeChecker.getInstance().getRuntimeSupport().whenConcrete(C, new Runnable() {

        public void run() {
          TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(op, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1205528931094", true), new QuotationClass_74().createNode(TypeChecker.getInstance().getEquationManager().getRepresentator(C)), op, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1205528931092");
        }

      }, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1205528931049");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.Link_DeleteChildOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
