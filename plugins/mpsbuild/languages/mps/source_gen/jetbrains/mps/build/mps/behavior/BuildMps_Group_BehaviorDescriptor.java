package jetbrains.mps.build.mps.behavior;

/*Generated by MPS */

import jetbrains.mps.build.behavior.BuildProjectPart_BehaviorDescriptor;
import jetbrains.mps.lang.core.behavior.INamedConcept_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;

public class BuildMps_Group_BehaviorDescriptor extends BuildProjectPart_BehaviorDescriptor implements INamedConcept_BehaviorDescriptor {
  public BuildMps_Group_BehaviorDescriptor() {
  }

  public String virtual_getFqName_1213877404258(SNode thisNode) {
    return INamedConcept_Behavior.virtual_getFqName_1213877404258(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.build.mps.structure.BuildMps_Group";
  }
}
