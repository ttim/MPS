package jetbrains.mps.build.distrib.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.packaging.behavior.Path_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class PathCommantLinePart_Behavior {

  public static void init(SNode thisNode) {
  }

  public static String virtual_getText_1231864533228(SNode thisNode) {
    String fullPath = Path_Behavior.call_getFullPathWithoutMacro_1226511495568(SLinkOperations.getTarget(thisNode, "path", true));
    if ((SLinkOperations.getTarget(SLinkOperations.getTarget(thisNode, "path", true), "macro", true) != null)) {
      fullPath = "${" + SPropertyOperations.getString(SLinkOperations.getTarget(SLinkOperations.getTarget(thisNode, "path", true), "macro", true), "name") + "}/" + fullPath.replace("\\", "/");
    }
    return fullPath;
  }

}
