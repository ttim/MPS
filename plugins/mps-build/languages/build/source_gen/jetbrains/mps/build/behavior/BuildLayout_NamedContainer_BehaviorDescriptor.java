package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.INamedConcept_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.Context;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;

public abstract class BuildLayout_NamedContainer_BehaviorDescriptor extends BuildLayout_AbstractContainer_BehaviorDescriptor implements INamedConcept_BehaviorDescriptor, BuildSource_SingleFolder_BehaviorDescriptor, BuildStringContainer_BehaviorDescriptor {
  public BuildLayout_NamedContainer_BehaviorDescriptor() {
  }

  public boolean virtual_isValidPart_9184644532456897464(SNode thisNode, String propertyValue, String role) {
    return BuildLayout_NamedContainer_Behavior.virtual_isValidPart_9184644532456897464(thisNode, propertyValue, role);
  }

  public String virtual_getApproximateName_5610619299014531547(SNode thisNode) {
    return BuildLayout_NamedContainer_Behavior.virtual_getApproximateName_5610619299014531547(thisNode);
  }

  public void virtual_appendName_1368030936106665465(SNode thisNode, SNode parent, StringBuilder sb) {
    BuildLayout_NamedContainer_Behavior.virtual_appendName_1368030936106665465(thisNode, parent, sb);
  }

  public String virtual_getChildrenOutputDir_WithMacro_4701820937132344011(SNode thisNode, Context context) {
    return BuildLayout_NamedContainer_Behavior.virtual_getChildrenOutputDir_WithMacro_4701820937132344011(thisNode, context);
  }

  public String virtual_getFqName_1213877404258(SNode thisNode) {
    return INamedConcept_Behavior.virtual_getFqName_1213877404258(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.build.structure.BuildLayout_NamedContainer";
  }
}
