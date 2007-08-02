package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_Link_SetTargetOperation_InferenceRule implements InferenceRule_Runtime {

  public  typeOf_Link_SetTargetOperation_InferenceRule() {
  }

  public void applyRule(final SNode argument) {
    if(RulesUtil.checkAppliedCorrectly_generic(argument)) {
      SNode parameter = SLinkOperations.getTarget(argument, "parameter", true);
      if((parameter != null)) {
        SNode parmType = TypeChecker.getInstance().getRuntimeSupport().checkedTypeOf(parameter, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178287492128");
        if(!((parmType != null))) {
          TypeChecker.getInstance().reportTypeError(parameter, "no type", "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178287492130");
        }
        SNode expectedType = RulesUtil.get_inputNodeType(argument);
        if(!(TypeChecker.getInstance().getSubtypingManager().isSubtype(parmType, expectedType))) {
          TypeChecker.getInstance().reportTypeError(parameter, "incompatible type\nexpected: " + expectedType + "\nwas: " + parmType, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178287492141");
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
