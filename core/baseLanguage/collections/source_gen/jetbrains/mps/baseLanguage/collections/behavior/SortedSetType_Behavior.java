package jetbrains.mps.baseLanguage.collections.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class SortedSetType_Behavior {

  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getAbstractCreators_1226945293888(SNode thisNode) {
    List<SNode> result = new ArrayList<SNode>();
    ListSequence.fromList(result).addElement(new _Quotations.QuotationClass_14().createNode(SLinkOperations.getTarget(thisNode, "elementType", true)));
    return result;
  }

  public static SNode virtual_getClassExpression_1213877337357(SNode thisNode) {
    return new _Quotations.QuotationClass_15().createNode();
  }

}
