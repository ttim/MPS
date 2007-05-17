package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.SubtypingRule_Runtime;
import jetbrains.mps.bootstrap.helgins.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.baseLanguage.helgins.Pattern_3;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.helgins.QuotationClass_66;
import jetbrains.mps.bootstrap.helgins.structure.ApplicableNodeCondition;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelUID;
import jetbrains.mps.smodel.BaseAdapter;

public class double_unboxing_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {

  /* package */Pattern_3 myMatchingPattern;

  public  double_unboxing_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode type) {
    return new QuotationClass_66().createNode();
  }
  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ClassifierType";
  }
  public ApplicableNodeCondition getNodeCondition() {
    SModel model = SModelRepository.getInstance().getModelDescriptor(SModelUID.fromString("jetbrains.mps.baseLanguage.helgins")).getSModel();
    return (ApplicableNodeCondition)BaseAdapter.fromNode(model.getNodeById("1177076650871"));
  }
  public boolean isApplicable(SNode argument) {
    this.myMatchingPattern = new Pattern_3();
    return this.myMatchingPattern.match(argument);
  }
  public boolean isSupertyping() {
    return false;
  }
  public boolean isWeak() {
    return true;
  }
}
