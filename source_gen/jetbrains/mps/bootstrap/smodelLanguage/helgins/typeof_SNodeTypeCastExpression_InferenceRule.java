package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_SNodeTypeCastExpression_InferenceRule implements InferenceRule_Runtime {

  public  typeof_SNodeTypeCastExpression_InferenceRule() {
  }

  public void applyRule(final SNode argument) {
    final SNode LeftType_typevar_1186061665928 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable(false);
    TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getEquationManager().getRepresentator(LeftType_typevar_1186061665928), TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(argument, "leftExpression", true)), SLinkOperations.getTarget(argument, "leftExpression", true), null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186061673586");
    TypeChecker.getInstance().getRuntimeSupport().whenConcrete(TypeChecker.getInstance().getEquationManager().getRepresentator(LeftType_typevar_1186061665928), new Runnable() {

      public void run() {
        if(TypeChecker.getInstance().getSubtypingManager().isSubtype(TypeChecker.getInstance().getEquationManager().getRepresentator(LeftType_typevar_1186061665928), new QuotationClass_1().createNode(), false, false)) {
          TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_().createNode(SLinkOperations.getTarget(argument, "concept", false)), argument, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186061696726");
        } else
        {
          TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_2().createNode(SLinkOperations.getTarget(argument, "concept", false)), argument, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186061696740");
        }
      }

    }, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186061660362");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
