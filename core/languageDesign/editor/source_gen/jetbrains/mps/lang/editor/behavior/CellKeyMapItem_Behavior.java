package jetbrains.mps.lang.editor.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.editor.behavior.CellKeyMapKeystroke_Behavior;

public class CellKeyMapItem_Behavior {

  public static void init(SNode thisNode) {
  }

  public static String call_getKeyStroke_1213877335427(SNode thisNode) {
    SNode first = ListSequence.fromList(SLinkOperations.getTargets(thisNode, "keystroke", true)).first();
    String result = "";
    if (first == null) {
      return result;
    }
    return CellKeyMapKeystroke_Behavior.call_getKeyStroke_1213877273475(first);
  }

}
