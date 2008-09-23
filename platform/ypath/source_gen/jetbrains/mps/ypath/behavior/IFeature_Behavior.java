package jetbrains.mps.ypath.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class IFeature_Behavior {

  public static void init(SNode thisNode) {
  }

  public static String call_getFullName_1213877499608(SNode thisNode) {
    return "Feature_" + SPropertyOperations.getString(thisNode, "name");
  }

  public static SNode call_getTargetType_1213877499617(SNode thisNode) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.getAncestor(thisNode, "jetbrains.mps.ypath.structure.TreePath", false, false), "treePathType", true), "nodeType", true);
  }

  public static void call_setOpposite_1213877499629(SNode thisNode, SNode newOpposite, boolean mutual) {
    if (IFeature_Behavior.call_hasMutualOpposite_1213877499741(thisNode)) {
      IFeature_Behavior.call_removeOpposite_1213877499679(thisNode);
    }
    IFeature_Behavior.call_removePartialOpposites_1213877499703(thisNode);
    IFeature_Behavior.call_removeOpposite_1213877499679(newOpposite);
    if (mutual) {
      IFeature_Behavior.call_removePartialOpposites_1213877499703(newOpposite);
    }
    SLinkOperations.setTarget(thisNode, "opposite", newOpposite, false);
    if (mutual) {
      SLinkOperations.setTarget(SLinkOperations.getTarget(thisNode, "opposite", false), "opposite", thisNode, false);
    }
  }

  public static void call_removeOpposite_1213877499679(SNode thisNode) {
    if (IFeature_Behavior.call_hasMutualOpposite_1213877499741(thisNode)) {
      SLinkOperations.setTarget(SLinkOperations.getTarget(thisNode, "opposite", false), "opposite", null, false);
    }
    SLinkOperations.setTarget(thisNode, "opposite", null, false);
  }

  public static void call_removePartialOpposites_1213877499703(SNode thisNode) {
    final SNode thisNodeLoc = thisNode;
    for(SNode foo : ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.getParent(thisNode), "features", true)).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return it != thisNodeLoc && SLinkOperations.getTarget(it, "opposite", false) == thisNodeLoc;
      }

    })) {
      SLinkOperations.setTarget(foo, "opposite", null, false);
    }
  }

  public static boolean call_hasMutualOpposite_1213877499741(SNode thisNode) {
    return (SLinkOperations.getTarget(thisNode, "opposite", false) != null) && SLinkOperations.getTarget(SLinkOperations.getTarget(thisNode, "opposite", false), "opposite", false) == thisNode;
  }

  public static boolean call_hasPartialOpposites_1213877499758(SNode thisNode) {
    if ((SLinkOperations.getTarget(thisNode, "opposite", false) != null)) {
      return false;
    }
    final SNode thisNodeLoc = thisNode;
    return ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.getParent(thisNode), "features", true)).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return it != thisNodeLoc && SLinkOperations.getTarget(it, "opposite", false) == thisNodeLoc;
      }

    }).isNotEmpty();
  }

  public static Iterable<SNode> call_getPartialOpposites_1213877499798(SNode thisNode) {
    if ((SLinkOperations.getTarget(thisNode, "opposite", false) != null)) {
      return ListSequence.<SNode>fromArray();
    }
    final SNode thisNodeLoc = thisNode;
    return ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.getParent(thisNode), "features", true)).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return it != thisNodeLoc && SLinkOperations.getTarget(it, "opposite", false) == thisNodeLoc;
      }

    });
  }

}
