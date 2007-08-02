package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_LinkList_InsertChildFirstOperation_InferenceRule implements InferenceRule_Runtime {

  public  typeOf_LinkList_InsertChildFirstOperation_InferenceRule() {
  }

  public void applyRule(final SNode argument) {
    RulesUtil.checkAppliedTo_LinkListAccess_aggregation(argument);
    if(RulesUtil.checkAppliedTo_LinkListAccess_aggregation(argument)) {
      SNode parameter = SLinkOperations.getTarget(argument, "parameter", true);
      if((parameter != null)) {
        SNode expectedType = RulesUtil.get_inputNodeType(argument);
        SNode parmType = TypeChecker.getInstance().getRuntimeSupport().typeOf(parameter);
        TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(parmType, expectedType, argument, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186061883539");
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.LinkList_InsertChildFirstOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
