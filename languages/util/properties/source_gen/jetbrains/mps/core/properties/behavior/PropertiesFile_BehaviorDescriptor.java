package jetbrains.mps.core.properties.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.BaseConcept_BehaviorDescriptor;
import jetbrains.mps.lang.core.behavior.INamedConcept_BehaviorDescriptor;
import jetbrains.mps.lang.traceable.behavior.UnitConcept_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;

public class PropertiesFile_BehaviorDescriptor extends BaseConcept_BehaviorDescriptor implements INamedConcept_BehaviorDescriptor, UnitConcept_BehaviorDescriptor {
  public PropertiesFile_BehaviorDescriptor() {
  }

  public String virtual_getUnitName_5067982036267369911(SNode thisNode) {
    return PropertiesFile_Behavior.virtual_getUnitName_5067982036267369911(thisNode);
  }

  public String virtual_getFqName_1213877404258(SNode thisNode) {
    return INamedConcept_Behavior.virtual_getFqName_1213877404258(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.core.properties.structure.PropertiesFile";
  }
}
