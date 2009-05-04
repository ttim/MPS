package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.ComparisonRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModelUtil_new;

public class map_type_comparableWith_Map_ComparisonRule extends ComparisonRule_Runtime {

  /* package */_Patterns.Pattern_13 myMatchingPattern2;

  public map_type_comparableWith_Map_ComparisonRule() {
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
    this.myMatchingPattern2 = new _Patterns.Pattern_13();
    return this.myMatchingPattern2.match(node);
  }

  public String getApplicableConceptFQName1() {
    return "jetbrains.mps.baseLanguage.collections.structure.MapType";
  }

  public String getApplicableConceptFQName2() {
    return "jetbrains.mps.baseLanguage.structure.ClassifierType";
  }

}
