package jetbrains.mps.buildScript.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.buildScript.util.Context;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class BuildLayout_Behavior {
  public static void init(SNode thisNode) {
  }

  public static String virtual_getChildrenOutputDir_WithMacro_4701820937132344011(SNode thisNode, Context context) {
    return "${build.layout}";
  }

  public static String virtual_getAssembleSubTaskId_4701820937132344052(SNode thisNode) {
    return null;
  }

  public static String virtual_getPrepareSubTaskId_4701820937132344041(SNode thisNode) {
    return null;
  }

  public static void virtual_appendName_1368030936106665465(SNode thisNode, SNode parent, StringBuilder sb) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.buildScript.structure.BuildProject")) {
      sb.append(SPropertyOperations.getString(SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.buildScript.structure.BuildProject"), "name"));
      sb.append(".");
    }
    sb.append("default");
  }
}
