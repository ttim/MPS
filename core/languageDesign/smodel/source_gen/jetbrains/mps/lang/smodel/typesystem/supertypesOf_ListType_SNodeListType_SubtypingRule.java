package jetbrains.mps.lang.smodel.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNode;

public class supertypesOf_ListType_SNodeListType_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {

  /* package */_Patterns.Pattern_3 myMatchingPattern;

  public supertypesOf_ListType_SNodeListType_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode subtype) {
    return new _Quotations.QuotationClass_84().createNode(this.myMatchingPattern.PatternVar0);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.ListType";
  }

  public boolean isApplicable(SNode argument) {
    this.myMatchingPattern = new _Patterns.Pattern_3();
    return this.myMatchingPattern.match(argument);
  }

  public boolean isWeak() {
    return false;
  }

}
