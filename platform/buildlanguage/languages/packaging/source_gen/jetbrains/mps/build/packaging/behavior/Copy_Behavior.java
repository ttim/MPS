package jetbrains.mps.build.packaging.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.EqualUtil;

public class Copy_Behavior {

  public static void init(SNode thisNode) {
    SPropertyOperations.set(thisNode, "file", "" + (false));
    SPropertyOperations.set(thisNode, "name", "");
    SPropertyOperations.set(thisNode, "excludes", "");
    SLinkOperations.setTarget(thisNode, "sourcePath", SConceptOperations.createNewNode("jetbrains.mps.build.packaging.structure.Path", null), true);
  }

  public static String virtual_getPath_1213877333777(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.build.packaging.structure.ICompositeComponent")) {
      return ICompositeComponent_Behavior.call_getChildrenTargetDir_1213877279370(((SNode)SNodeOperations.getParent(thisNode)));
    }
    return "";
  }

  public static String call_getExcludes_1213877251358(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.build.packaging.structure.ICompositeComponent")) {
      return ((SPropertyOperations.getString(thisNode, "excludes") != null) && (!(SPropertyOperations.getString(thisNode, "excludes").equals(""))) ?
        (SPropertyOperations.getString(thisNode, "excludes") + ", ") :
        ""
      ) + Copy_Behavior.call_getExcludes_1213877251358(((SNode)SNodeOperations.getParent(thisNode)));
    }
    return ((SPropertyOperations.getString(thisNode, "excludes") != null) ?
      (SPropertyOperations.getString(thisNode, "excludes")) :
      ""
    );
  }

  public static String call_getIncludes_1213877251415(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.build.packaging.structure.ICompositeComponent")) {
      return ((SPropertyOperations.getString(thisNode, "includes") != null) && (!(SPropertyOperations.getString(thisNode, "includes").equals(""))) ?
        (SPropertyOperations.getString(thisNode, "includes") + ", ") :
        ""
      ) + Copy_Behavior.call_getIncludes_1213877251415(((SNode)SNodeOperations.getParent(thisNode)));
    }
    return ((SPropertyOperations.getString(thisNode, "includes") != null) ?
      (SPropertyOperations.getString(thisNode, "includes")) :
      ""
    );
  }

  public static boolean virtual_equals_1213877333900(SNode thisNode, SNode snode) {
    if (!(SNodeOperations.isInstanceOf(snode, NameUtil.nodeFQName(SNodeOperations.getConceptDeclaration(thisNode))))) {
      return false;
    }
    return EqualUtil.equalsIgnoreCase(Path_Behavior.call_getName_1221141245424(SLinkOperations.getTarget(thisNode, "sourcePath", true)), Path_Behavior.call_getName_1221141245424(SLinkOperations.getTarget(snode, "sourcePath", true)));
  }

}
