package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.Context;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class BuildLayout_EchoProperties_Behavior {
  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isValidPart_9184644532456897464(SNode thisNode, String propertyValue) {
    return !(propertyValue.contains("$") || propertyValue.contains("/") || propertyValue.contains("\\"));
  }

  public static String call_getOutputPath_WithMacro_202934866059116697(SNode thisNode, Context context) {
    if ((SNodeOperations.getParent(thisNode) != null) && SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.build.structure.BuildLayout_Container")) {
      String parentChildrenTargetDir = BuildLayout_Container_Behavior.call_getChildrenOutputDir_WithMacro_4701820937132344011(SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.build.structure.BuildLayout_Container"), context);
      return parentChildrenTargetDir + "/" + BuildString_Behavior.call_getText_4380385936562005550(SLinkOperations.getTarget(thisNode, "fileName", true), context.getMacros(thisNode));
    }
    return null;
  }
}
