package jetbrains.mps.buildScript.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class BuildTextStringPart_Behavior {
  public static void init(SNode thisNode) {
  }

  public static String virtual_getText_4380385936562037054(SNode thisNode) {
    return SPropertyOperations.getString(thisNode, "text");
  }
}
