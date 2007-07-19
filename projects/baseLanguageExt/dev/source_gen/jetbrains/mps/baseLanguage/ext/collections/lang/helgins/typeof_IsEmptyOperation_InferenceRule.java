package jetbrains.mps.baseLanguage.ext.collections.lang.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.helgins.inference.TypeChecker;

public class typeof_IsEmptyOperation_InferenceRule implements InferenceRule_Runtime {

  public  typeof_IsEmptyOperation_InferenceRule() {
  }

  public void applyRule(SNode argument) {
    SNode parent = SNodeOperations.getParent(argument, null, false, false);
    do {
      SNode matchedNode_1178725705148 = parent;
      {
        boolean matches_1178725705150 = false;
        matches_1178725705150 = SModelUtil_new.isAssignableConcept(parent.getConceptFqName(), "jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceOperationExpression");
        if(matches_1178725705150) {
          TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_12().createNode(), argument);
          break;
        }
      }
      TypeChecker.getInstance().reportTypeError(argument, "not expected here");
    } while(false);
  }
  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.ext.collections.lang.structure.IsEmptyOperation";
  }
  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }
  public boolean overrides() {
    return false;
  }
}
