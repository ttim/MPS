package jetbrains.mps.buildScript.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.buildScript.util.Context;
import jetbrains.mps.buildScript.util.UnpackHelper;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class BuildLayout_Folder_Behavior {
  public static void init(SNode thisNode) {
  }

  public static String virtual_getChildrenOutputDir_WithMacro_4701820937132344011(SNode thisNode, Context context) {
    return BuildLayout_NamedContainer_Behavior.call_getOutputPath_WithMacro_280273048052535414(thisNode, context);
  }

  public static void virtual_unpack_7128123785277710736(SNode thisNode, UnpackHelper helper) {
    SNode parent = helper.parent(thisNode);
    String parentLocation = helper.contentLocations().get(parent);
    helper.locations().put(thisNode, parentLocation + "/" + helper.toString(SLinkOperations.getTarget(thisNode, "containerName", true)));
  }
}
