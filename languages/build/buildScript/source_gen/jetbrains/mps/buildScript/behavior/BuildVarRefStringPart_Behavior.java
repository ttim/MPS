package jetbrains.mps.buildScript.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class BuildVarRefStringPart_Behavior {
  public static void init(SNode thisNode) {
  }

  public static String virtual_getText_4380385936562037054(SNode thisNode) {
    String macroName = SPropertyOperations.getString(SLinkOperations.getTarget(thisNode, "macro", false), "name");
    if (SNodeOperations.getAncestor(SLinkOperations.getTarget(thisNode, "macro", false), "jetbrains.mps.buildScript.structure.BuildProject", false, false) != SNodeOperations.getAncestor(thisNode, "jetbrains.mps.buildScript.structure.BuildProject", false, false)) {
      macroName = SPropertyOperations.getString(SNodeOperations.getAncestor(SLinkOperations.getTarget(thisNode, "macro", false), "jetbrains.mps.buildScript.structure.BuildProject", false, false), "name") + ".var." + macroName;
    }
    return "${" + macroName + "}";
  }
}
