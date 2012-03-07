package jetbrains.mps.buildScript.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.buildScript.util.VisibleArtifacts;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;

public class BuildLayout_Import_Behavior {
  public static void init(SNode thisNode) {
  }

  public static Iterable<SNode> virtual_getDependencyTargets_841011766566205095(SNode thisNode, VisibleArtifacts artifacts) {
    SNode target = SNodeOperations.as(artifacts.toOriginalNode(SLinkOperations.getTarget(thisNode, "target", false)), "jetbrains.mps.buildScript.structure.BuildLayout_NamedContainer");
    if (target != null && artifacts.contains(target)) {
      return Sequence.<SNode>singleton(target);
    }
    return null;
  }
}
