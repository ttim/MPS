package jetbrains.mps.buildScript.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class BuildString_Behavior {
  public static void init(SNode thisNode) {
  }

  public static String call_getName_4380385936562005550(SNode thisNode) {
    StringBuilder sb = new StringBuilder();
    for (SNode n : ListSequence.fromList(SLinkOperations.getTargets(thisNode, "parts", true))) {
      sb.append(BuildStringPart_Behavior.call_getText_4380385936562037054(n));
    }
    return sb.toString();
  }
}
