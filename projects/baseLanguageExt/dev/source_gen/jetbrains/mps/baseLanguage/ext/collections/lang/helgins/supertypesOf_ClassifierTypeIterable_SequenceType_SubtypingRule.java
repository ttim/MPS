package jetbrains.mps.baseLanguage.ext.collections.lang.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.SubtypingRule_Runtime;
import jetbrains.mps.bootstrap.helgins.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNode;

public class supertypesOf_ClassifierTypeIterable_SequenceType_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {

  /* package */Pattern_1 myMatchingPattern;

  public  supertypesOf_ClassifierTypeIterable_SequenceType_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode type) {
    return new QuotationClass_39().createNode(this.myMatchingPattern.PatternVar1);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ClassifierType";
  }

  public boolean isApplicable(SNode argument) {
    this.myMatchingPattern = new Pattern_1();
    return this.myMatchingPattern.match(argument);
  }

  public boolean isWeak() {
    return true;
  }

}
