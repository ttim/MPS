package jetbrains.mps.buildScript.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.INamedConcept_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;

public abstract class BuildLayout_NamedContainer_BehaviorDescriptor extends BuildLayout_AbstractContainer_BehaviorDescriptor implements INamedConcept_BehaviorDescriptor {
  public BuildLayout_NamedContainer_BehaviorDescriptor() {
  }

  public String virtual_getFqName_1213877404258(SNode thisNode) {
    return INamedConcept_Behavior.virtual_getFqName_1213877404258(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.buildScript.structure.BuildLayout_NamedContainer";
  }
}
