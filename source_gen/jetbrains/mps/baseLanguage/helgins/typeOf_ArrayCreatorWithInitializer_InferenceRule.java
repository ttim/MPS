package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_ArrayCreatorWithInitializer_InferenceRule implements InferenceRule_Runtime {

  public  typeOf_ArrayCreatorWithInitializer_InferenceRule() {
  }

  public void applyRule(SNode argument) {
    for(SNode value : SLinkOperations.getTargets(argument, "initValue", true)) {
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(value), SLinkOperations.getTarget(argument, "componentType", true), value, null, "jetbrains.mps.baseLanguage.helgins", "1175600269225");
    }
    TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_9().createNode(SNodeOperations.copyNode(SLinkOperations.getTarget(argument, "componentType", true), TypeChecker.getInstance().getRuntimeTypesModel())), argument, "jetbrains.mps.baseLanguage.helgins", "1175600306141");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ArrayCreatorWithInitializer";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
