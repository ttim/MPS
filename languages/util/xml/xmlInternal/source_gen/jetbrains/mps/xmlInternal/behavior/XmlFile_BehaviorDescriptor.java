package jetbrains.mps.xmlInternal.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.BaseConcept_BehaviorDescriptor;
import jetbrains.mps.lang.core.behavior.INamedConcept_BehaviorDescriptor;
import jetbrains.mps.xml.behavior.XmlRoot_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;

public class XmlFile_BehaviorDescriptor extends BaseConcept_BehaviorDescriptor implements INamedConcept_BehaviorDescriptor, XmlRoot_BehaviorDescriptor {
  public XmlFile_BehaviorDescriptor() {
  }

  public SNode virtual_getSchema_1213877420378(SNode thisNode, IScope scope) {
    return XmlFile_Behavior.virtual_getSchema_1213877420378(thisNode, scope);
  }

  public String virtual_getFqName_1213877404258(SNode thisNode) {
    return INamedConcept_Behavior.virtual_getFqName_1213877404258(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.xmlInternal.structure.XmlFile";
  }
}
