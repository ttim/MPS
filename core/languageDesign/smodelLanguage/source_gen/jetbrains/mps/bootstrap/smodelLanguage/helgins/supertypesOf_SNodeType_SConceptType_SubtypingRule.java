package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.SubtypingRule_Runtime;
import jetbrains.mps.bootstrap.helgins.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNode;

public class supertypesOf_SNodeType_SConceptType_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {

  /* package */Pattern_2 myMatchingPattern;

  public  supertypesOf_SNodeType_SConceptType_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode node) {
    return new QuotationClass_60().createNode();
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType";
  }

  public boolean isApplicable(SNode argument) {
    this.myMatchingPattern = new Pattern_2();
    return this.myMatchingPattern.match(argument);
  }

  public boolean isWeak() {
    return false;
  }

}
