package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.EquationManager;
import jetbrains.mps.smodel.SModelUtil_new;

public class char_extends_int_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {

  public char_extends_int_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode charType, EquationManager equationManager) {
    return new _Quotations.QuotationClass_47().createNode();
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.CharType";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean isWeak() {
    return false;
  }

}
