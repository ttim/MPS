package jetbrains.mps.baseLanguage.ext.collections.lang.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.baseLanguage.ext.collections.lang.helgins.QuotationClass_27;
import jetbrains.mps.bootstrap.helgins.structure.ApplicableNodeCondition;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelUID;
import jetbrains.mps.smodel.BaseAdapter;

public class typeof_IsNotEmptyOperation_InferenceRule implements InferenceRule_Runtime {

  public  typeof_IsNotEmptyOperation_InferenceRule() {
  }

  public void applyRule(SNode argument) {
    do {
      SNode matchedNode_1178725705667 = SNodeOperations.getParent(argument, null, false, false);
      {
        boolean matches_1178725705671 = false;
        matches_1178725705671 = SModelUtil_new.isAssignableConcept(SNodeOperations.getParent(argument, null, false, false).getConceptFqName(), "jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceOperationExpression");
        if(matches_1178725705671) {
          TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_27().createNode(), argument);
          break;
        }
      }
      TypeChecker.getInstance().reportTypeError(argument, "not expected here");
    } while(false);
  }
  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.ext.collections.lang.structure.IsNotEmptyOperation";
  }
  public ApplicableNodeCondition getNodeCondition() {
    SModel model = SModelRepository.getInstance().getModelDescriptor(SModelUID.fromString("jetbrains.mps.baseLanguage.ext.collections.lang.helgins")).getSModel();
    return (ApplicableNodeCondition)BaseAdapter.fromNode(model.getNodeById("1178725704747"));
  }
  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }
  public boolean overrides() {
    return false;
  }
}
