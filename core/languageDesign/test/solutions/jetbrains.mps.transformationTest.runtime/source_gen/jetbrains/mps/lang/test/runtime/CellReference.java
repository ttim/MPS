package jetbrains.mps.lang.test.runtime;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;

public class CellReference {

  private SNode myNode;
  private String myId;

  public CellReference(SNode node, String id) {
    this.myNode = node;
    this.myId = id;
  }

  public SNode getNode() {
    return this.myNode;
  }

  public String getID() {
    return this.myId;
  }

  public String toString() {
    final Wrappers._T<String> result = new Wrappers._T<String>();
    ModelAccess.instance().runReadAction(new Runnable() {

      public void run() {
        result.value = "node = " + CellReference.this.myNode.getId() + ", id = " + CellReference.this.myId;
      }

    });
    return result.value;
  }

}
