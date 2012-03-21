package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.UnpackHelper;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class BuildLayout_Copy_Behavior {
  public static void init(SNode thisNode) {
  }

  public static void virtual_unpack_7128123785277710736(SNode thisNode, UnpackHelper helper) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(thisNode, "fileset", true), "jetbrains.mps.build.structure.BuildInputSingleFile")) {
      SNode parent = helper.parent(thisNode);
      String parentLocation = helper.contentLocations().get(parent);
      SNode path = SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(thisNode, "fileset", true), "jetbrains.mps.build.structure.BuildInputSingleFile"), "path", true);
      if (path != null) {
        String lastSegment = BuildSourcePath_Behavior.call_getLastSegment_1368030936106771141(path, null);
        if (lastSegment != null) {
          String fileLocation = parentLocation + "/" + lastSegment;
          helper.locations().put(thisNode, fileLocation);
        }
      }
    }
  }

  public static boolean virtual_isFile_1368030936106753986(SNode thisNode) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(thisNode, "fileset", true), "jetbrains.mps.build.structure.BuildInputSingleFile");
  }

  public static void virtual_appendName_1368030936106665465(SNode thisNode, SNode parent, StringBuilder sb) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(thisNode, "fileset", true), "jetbrains.mps.build.structure.BuildInputSingleFile")) {
      SNode path = SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(thisNode, "fileset", true), "jetbrains.mps.build.structure.BuildInputSingleFile"), "path", true);
      if (path != null) {
        String lastSegment = BuildSourcePath_Behavior.call_getLastSegment_1368030936106771141(path, null);
        if (lastSegment != null) {
          if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.build.structure.BuildLayout_Node")) {
            sb.append("/");
          }
          sb.append(lastSegment);
        }
      }
      return;
    }
    BuildLayout_PathElement_Behavior.callSuper_appendName_1368030936106665465(thisNode, "jetbrains.mps.build.structure.BuildLayout_Copy", parent, sb);
  }
}
