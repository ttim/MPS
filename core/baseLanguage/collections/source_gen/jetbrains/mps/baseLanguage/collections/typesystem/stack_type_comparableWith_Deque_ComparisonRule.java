package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.ComparisonRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModelUtil_new;

public class stack_type_comparableWith_Deque_ComparisonRule extends ComparisonRule_Runtime {
  /*package*/ _Patterns.Pattern_18 myMatchingPattern2;

  public stack_type_comparableWith_Deque_ComparisonRule() {
  }

  public boolean areComparable(SNode node1, SNode node2) {
    return true;
  }

  public boolean isWeak() {
    return true;
  }

  public boolean isApplicable1(SNode node) {
    return SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableConceptFQName1());
  }

  public boolean isApplicable2(SNode node) {
    this.myMatchingPattern2 = new _Patterns.Pattern_18();
    return this.myMatchingPattern2.match(node);
  }

  public String getApplicableConceptFQName1() {
    return "jetbrains.mps.baseLanguage.collections.structure.StackType";
  }

  public String getApplicableConceptFQName2() {
    return "jetbrains.mps.baseLanguage.structure.ClassifierType";
  }
}
