package jetbrains.mps.baseLanguage.ext.collections.lang.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_MapElement_InferenceRule implements InferenceRule_Runtime {

  public  typeof_MapElement_InferenceRule() {
  }

  public void applyRule(final SNode argument) {
    final SNode keyType_typevar_1198083488673 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable(false);
    final SNode valueType_typevar_1198083495346 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable(false);
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(argument, "map", true), "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1198083507709", true), new QuotationClass_54().createNode(TypeChecker.getInstance().getEquationManager().getRepresentator(keyType_typevar_1198083488673), TypeChecker.getInstance().getEquationManager().getRepresentator(valueType_typevar_1198083495346)), SLinkOperations.getTarget(argument, "map", true), null, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1198083568591");
    TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(argument, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1198083609561", true), TypeChecker.getInstance().getEquationManager().getRepresentator(keyType_typevar_1198083488673), argument, null, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1198083621785");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.ext.collections.lang.structure.MapElement";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
