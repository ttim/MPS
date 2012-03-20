package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.build.util.Context;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class BuildLayout_NamedContainer_Behavior {
  public static void init(SNode thisNode) {
  }

  public static void virtual_appendName_1368030936106665465(SNode thisNode, SNode parent, StringBuilder sb) {
    if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.build.structure.BuildLayout_Container")) {
      sb.append("/");
    }
    sb.append(BuildString_Behavior.call_getText_4380385936562005550(SLinkOperations.getTarget(thisNode, "containerName", true), null));
  }

  public static String virtual_getChildrenOutputDir_WithMacro_4701820937132344011(SNode thisNode, Context context) {
    SNode nlayout = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.build.structure.BuildNamedLayout", true, false);
    return context.getTempPath(thisNode, SPropertyOperations.getString(thisNode, "name"), ((nlayout != null) ?
      SPropertyOperations.getString(nlayout, "name") :
      "default"
    ));
  }

  public static String call_getOutputPath_WithMacro_280273048052535414(SNode thisNode, Context context) {
    if ((SNodeOperations.getParent(thisNode) != null) && SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.build.structure.BuildLayout_Container")) {
      String parentChildrenTargetDir = BuildLayout_Container_Behavior.call_getChildrenOutputDir_WithMacro_4701820937132344011(SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.build.structure.BuildLayout_Container"), context);
      return parentChildrenTargetDir + "/" + BuildString_Behavior.call_getText_4380385936562005550(SLinkOperations.getTarget(thisNode, "containerName", true), context.getMacros(thisNode));
    }
    return null;
  }
}
