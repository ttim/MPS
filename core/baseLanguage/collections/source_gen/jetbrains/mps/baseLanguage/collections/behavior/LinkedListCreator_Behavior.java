package jetbrains.mps.baseLanguage.collections.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class LinkedListCreator_Behavior {

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_createType_1237722437229(SNode thisNode) {
    return new _Quotations.QuotationClass_11().createNode(SLinkOperations.getTarget(thisNode, "elementType", true));
  }

}
