package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS  */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.helgins.structure.ApplicableNodeCondition;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelUID;
import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_SLinkAccess_InferenceRule implements InferenceRule_Runtime {

  public  typeof_SLinkAccess_InferenceRule() {
  }

  public void applyRule(SNode argument) {
    Object concept = RulesFunctions.fun_get_NodeConceptFromLeftExpression(argument);
    if(!(!((concept == null)))) {
      TypeChecker.getInstance().reportTypeError(argument, "couldn't define node concept from left expression");
    }
    TypeChecker.getInstance().getRuntimeSupport().givetype((SNode)Queries.CustomExpression_typeof_SLinkAccess(argument, concept), argument);
  }
  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess";
  }
  public ApplicableNodeCondition getNodeCondition() {
    SModel model = SModelRepository.getInstance().getModelDescriptor(SModelUID.fromString("jetbrains.mps.bootstrap.smodelLanguage.helgins")).getSModel();
    return (ApplicableNodeCondition)BaseAdapter.fromNode(model.getNodeById("1178287490192"));
  }
  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }
  public boolean overrides() {
    return false;
  }
}
