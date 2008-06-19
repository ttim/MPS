package jetbrains.mps.baseLanguage.ext.collections.lang.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_ToListOperation_InferenceRule implements InferenceRule_Runtime {

  public typeof_ToListOperation_InferenceRule() {
  }

  public void applyRule(final SNode op) {
    SNode input = RulesFunctions_Collections.getInput(op);
    final SNode elementType_typevar_1184850887615 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(input, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1184850938813", true), new QuotationClass_11().createNode(TypeChecker.getInstance().getEquationManager().getRepresentator(elementType_typevar_1184850887615)), input, null, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1184850943303", false, 0);
    TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(op, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1184850970648", true), new QuotationClass_12().createNode(TypeChecker.getInstance().getEquationManager().getRepresentator(elementType_typevar_1184850887615)), op, null, "jetbrains.mps.baseLanguage.ext.collections.lang.helgins", "1184850973959");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.ext.collections.lang.structure.ToListOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
