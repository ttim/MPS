package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class LocalVariableDeclarationStatement_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getLocalVariableDeclaration_1238803857389(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "localVariableDeclaration", true);
  }
}
