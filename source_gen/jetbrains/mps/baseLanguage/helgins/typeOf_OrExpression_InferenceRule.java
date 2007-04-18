package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS  */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.helgins.structure.ApplicableNodeCondition;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelUID;
import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_OrExpression_InferenceRule implements InferenceRule_Runtime {

  public  typeOf_OrExpression_InferenceRule() {
  }

  public void applyRule(SNode argument) {
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(argument, "leftExpression", true)), new QuotationClass_37().createNode(), SLinkOperations.getTarget(argument, "leftExpression", true));
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(argument, "rightExpression", true)), new QuotationClass_38().createNode(), SLinkOperations.getTarget(argument, "rightExpression", true));
    TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_39().createNode(), argument);
  }
  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.OrExpression";
  }
  public ApplicableNodeCondition getNodeCondition() {
    SModel model = SModelRepository.getInstance().getModelDescriptor(SModelUID.fromString("jetbrains.mps.baseLanguage.helgins")).getSModel();
    return (ApplicableNodeCondition)BaseAdapter.fromNode(model.getNodeById("1176901219562"));
  }
  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }
  public boolean overrides() {
    return false;
  }
}
