package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.UnpackHelper;

public class BuildProjectDependency_BehaviorDescriptor extends BuildDependency_BehaviorDescriptor implements BuildLayout_PathElement_BehaviorDescriptor {
  public BuildProjectDependency_BehaviorDescriptor() {
  }

  public void virtual_unpack_7128123785277710736(SNode thisNode, UnpackHelper helper) {
    BuildProjectDependency_Behavior.virtual_unpack_7128123785277710736(thisNode, helper);
  }

  public void virtual_appendName_1368030936106665465(SNode thisNode, SNode parent, StringBuilder sb) {
    BuildProjectDependency_Behavior.virtual_appendName_1368030936106665465(thisNode, parent, sb);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.build.structure.BuildProjectDependency";
  }
}
