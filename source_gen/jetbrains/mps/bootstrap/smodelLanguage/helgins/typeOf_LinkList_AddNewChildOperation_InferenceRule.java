package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_LinkList_AddNewChildOperation_InferenceRule implements InferenceRule_Runtime {

  public  typeOf_LinkList_AddNewChildOperation_InferenceRule() {
  }

  public void applyRule(SNode argument) {
    SNode resultConcept = null;
    if(RulesUtil.checkAppliedTo_LinkListAccess_aggregation(argument)) {
      SNode expectedConcept = RulesUtil.get_inputNodeConcept(argument);
      SNode parameterConcept = SLinkOperations.getTarget(argument, "concept", false);
      if(parameterConcept == null) {
        resultConcept = expectedConcept;
      } else
      {
        resultConcept = parameterConcept;
        RulesUtil.checkAssignableConcept(parameterConcept, expectedConcept, argument, "incompatible parameter concept");
      }
    }
    TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_47().createNode(resultConcept), argument, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178287492000");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.LinkList_AddNewChildOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
