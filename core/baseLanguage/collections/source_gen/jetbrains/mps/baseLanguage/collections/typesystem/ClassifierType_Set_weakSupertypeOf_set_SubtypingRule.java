package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;

public class ClassifierType_Set_weakSupertypeOf_set_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {

  /* package */_Patterns.Pattern_5 myMatchingPattern;

  public ClassifierType_Set_weakSupertypeOf_set_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode set, TypeCheckingContext typeCheckingContext) {
    return new _Quotations.QuotationClass_87().createNode(this.myMatchingPattern.PatternVar6, typeCheckingContext);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.SetType";
  }

  public boolean isApplicable(SNode argument) {
    this.myMatchingPattern = new _Patterns.Pattern_5();
    return this.myMatchingPattern.match(argument);
  }

  public boolean isWeak() {
    return true;
  }

}
