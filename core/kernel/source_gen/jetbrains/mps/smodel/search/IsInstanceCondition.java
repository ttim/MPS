package jetbrains.mps.smodel.search;

/*Generated by MPS */

import jetbrains.mps.util.Condition;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.NameUtil;

public class IsInstanceCondition implements Condition<SNode> {
  private String myConceptFqName;

  public IsInstanceCondition(SNode node) {
    this(NameUtil.nodeFQName(node));
  }

  public IsInstanceCondition(String fqName) {
    myConceptFqName = fqName;
  }

  public String getConceptFqName() {
    return myConceptFqName;
  }

  public boolean met(SNode node) {
    return node.isInstanceOfConcept(myConceptFqName);
  }
}
