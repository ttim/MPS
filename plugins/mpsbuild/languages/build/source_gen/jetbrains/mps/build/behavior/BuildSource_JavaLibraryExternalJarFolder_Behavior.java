package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.VisibleArtifacts;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class BuildSource_JavaLibraryExternalJarFolder_Behavior {
  public static void init(SNode thisNode) {
  }

  public static Iterable<SNode> virtual_getDependencyTargets_841011766566205095(SNode thisNode, VisibleArtifacts artifacts) {

    SNode artifact = BuildSource_JavaExternalJarFolderRef_Behavior.call_getDependencyTarget_5610619299014531753(SLinkOperations.getTarget(thisNode, "extFolder", true), artifacts);
    if (artifact != null) {
      return SLinkOperations.getTargets(artifact, "children", true);
    }
    return null;
  }
}
