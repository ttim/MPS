package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.VisibleArtifacts;

public class BuildSource_JavaDependencyLibrary_BehaviorDescriptor extends BuildSource_JavaDependency_BehaviorDescriptor implements BuildExternalDependency_BehaviorDescriptor {
  public BuildSource_JavaDependencyLibrary_BehaviorDescriptor() {
  }

  public Iterable<SNode> virtual_getDependencyTargets_841011766566205095(SNode thisNode, VisibleArtifacts artifacts) {
    return BuildSource_JavaDependencyLibrary_Behavior.virtual_getDependencyTargets_841011766566205095(thisNode, artifacts);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.build.structure.BuildSource_JavaDependencyLibrary";
  }
}
