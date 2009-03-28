package jetbrains.mps.lang.smodel.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.lang.smodel.typesystem._Patterns;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.typesystem._Quotations;

public class supertypesOf_ClassifierTypeSNode_SNodeType_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {

  /* package */_Patterns.Pattern_0 myMatchingPattern;

  public supertypesOf_ClassifierTypeSNode_SNodeType_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode type) {
    return new _Quotations.QuotationClass_67().createNode();
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ClassifierType";
  }

  public boolean isApplicable(SNode argument) {
    this.myMatchingPattern = new _Patterns.Pattern_0();
    return this.myMatchingPattern.match(argument);
  }

  public boolean isWeak() {
    return true;
  }

}
