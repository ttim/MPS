package smodelLanguage.samples;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;

public class ListOfNodes {

  public void newList(SNode e1, SNode e2) {
    List<SNode> list = ListOperations.createList(new SNode[]{e1,e2});
  }
}
