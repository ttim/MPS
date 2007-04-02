package jetbrains.mps.bootstrap.helgins.helgins;

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

public class typeOf_PatternCondition_InferenceRule implements InferenceRule_Runtime {

  public  typeOf_PatternCondition_InferenceRule() {
  }

  public void applyRule(SNode argument) {
    SNode paternCondition = argument;
    TypeChecker.getInstance().getRuntimeSupport().givetype(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(paternCondition, "pattern", true)), paternCondition);
  }
  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.helgins.structure.PatternCondition";
  }
  public ApplicableNodeCondition getNodeCondition() {
    SModel model = SModelRepository.getInstance().getModelDescriptor(SModelUID.fromString("jetbrains.mps.bootstrap.helgins.helgins")).getSModel();
    return (ApplicableNodeCondition)BaseAdapter.fromNode(model.getNodeById("1175521878360"));
  }
  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }
}
