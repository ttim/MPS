package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.helgins.runtime.HUtil;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_Concept_NewInstance_InferenceRule implements InferenceRule_Runtime {

  public  typeOf_Concept_NewInstance_InferenceRule() {
  }

  public void applyRule(SNode argument) {
    if(SLinkOperations.getTarget(argument, "prototypeNode", true) != null) {
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().checkedTypeOf(SLinkOperations.getTarget(argument, "prototypeNode", true), "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1181950215213"), new QuotationClass_68().createNode(), SLinkOperations.getTarget(argument, "prototypeNode", true), null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1181950211367");
    }
    SNode leftExpression = SLinkOperations.getTarget(SNodeOperations.getParent(argument, null, false, false), "leftExpression", true);
    SNode leftConceptType = TypeChecker.getInstance().getRuntimeSupport().coerce(TypeChecker.getInstance().getRuntimeSupport().checkedTypeOf(leftExpression, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1181950306645"), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptType"), false);
    if(leftConceptType != null) {
      TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_69().createNode(SLinkOperations.getTarget(leftConceptType, "conceptDeclaraton", false)), argument, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1181950359570");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.Concept_NewInstance";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
