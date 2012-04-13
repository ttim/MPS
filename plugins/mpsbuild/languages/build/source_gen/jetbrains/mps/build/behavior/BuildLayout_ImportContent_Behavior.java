package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.VisibleArtifacts;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class BuildLayout_ImportContent_Behavior {
  public static void init(SNode thisNode) {
  }

  public static Iterable<SNode> virtual_getDependencyTargets_841011766566205095(SNode thisNode, VisibleArtifacts artifacts) {
    if (SNodeOperations.getContainingRoot(thisNode) == SNodeOperations.getContainingRoot(SLinkOperations.getTarget(thisNode, "target", false))) {
      return null;
    }

    SNode target = SNodeOperations.as(artifacts.toOriginalNode(SLinkOperations.getTarget(thisNode, "target", false)), "jetbrains.mps.build.structure.BuildLayout_Node");
    if (SNodeOperations.isInstanceOf(target, "jetbrains.mps.build.structure.BuildLayout_Container") && artifacts.contains(target)) {
      artifacts.needsFetch(SNodeOperations.getAncestorWhereConceptInList(thisNode, new String[]{"jetbrains.mps.build.structure.BuildLayout", "jetbrains.mps.build.structure.BuildNamedLayout"}, false, false));
      return SLinkOperations.getTargets(SNodeOperations.cast(target, "jetbrains.mps.build.structure.BuildLayout_Container"), "children", true);
    }
    return null;
  }
}
