package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.structureLanguage.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_Node_GetAdapterOperation_InferenceRule implements InferenceRule_Runtime {

  public typeOf_Node_GetAdapterOperation_InferenceRule() {
  }

  public void applyRule(final SNode node) {
    RulesUtil.checkAppliedCorrectly_generic(node);
    final SNode Concept_typevar_1205967245422 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
    RulesUtil.equate_inputNodeConcept(node, TypeChecker.getInstance().getEquationManager().getRepresentator(Concept_typevar_1205967245422));
    {
      final SNode C = TypeChecker.getInstance().getEquationManager().getRepresentator(Concept_typevar_1205967245422);
      TypeChecker.getInstance().getRuntimeSupport().whenConcrete(C, new Runnable() {

        public void run() {
          SNode inputNodeConcept = TypeChecker.getInstance().getEquationManager().getRepresentator(C);
          TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(node, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1203710468988", true), AbstractConceptDeclaration_Behavior.call_getAdapterType_1213877394418(inputNodeConcept), node, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1203710468986");
        }

      }, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186057669142");
    }
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(node, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186057680866", true), new QuotationClass_47().createNode(), node, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186057690603", false, 500);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAdapterOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
