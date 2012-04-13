package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.VisibleArtifacts;
import jetbrains.mps.build.util.JavaExportUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class BuildSource_JavaDependencyLibrary_Behavior {
  public static void init(SNode thisNode) {
  }

  public static Iterable<SNode> virtual_getDependencyTargets_841011766566205095(SNode thisNode, VisibleArtifacts artifacts) {
    return JavaExportUtil.requireLibrary(artifacts, SLinkOperations.getTarget(thisNode, "library", false), SNodeOperations.getParent(thisNode));
  }
}
