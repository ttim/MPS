package jetbrains.mps.build.distrib.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.BaseConcept_BehaviorDescriptor;
import jetbrains.mps.lang.core.behavior.INamedConcept_BehaviorDescriptor;
import jetbrains.mps.build.packaging.behavior.IVariableHolder_BehaviorDescriptor;
import jetbrains.mps.build.packaging.behavior.IMacroHolder_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.build.packaging.behavior.IMacroHolder_Behavior;

public class DistribConfiguration_BehaviorDescriptor extends BaseConcept_BehaviorDescriptor implements INamedConcept_BehaviorDescriptor, IVariableHolder_BehaviorDescriptor, IMacroHolder_BehaviorDescriptor {
  public DistribConfiguration_BehaviorDescriptor() {
  }

  public String virtual_evaluateMacro_1234975967990(SNode thisNode, String macroName) {
    return DistribConfiguration_Behavior.virtual_evaluateMacro_1234975967990(thisNode, macroName);
  }

  public String virtual_getPath_1234976932856(SNode thisNode) {
    return DistribConfiguration_Behavior.virtual_getPath_1234976932856(thisNode);
  }

  public List<SNode> virtual_getAllVariable_1234864693585(SNode thisNode) {
    return DistribConfiguration_Behavior.virtual_getAllVariable_1234864693585(thisNode);
  }

  public String virtual_getFqName_1213877404258(SNode thisNode) {
    return INamedConcept_Behavior.virtual_getFqName_1213877404258(thisNode);
  }

  public List<String> virtual_getAllMacroNames_1234975567387(SNode thisNode, boolean addBasedir) {
    return IMacroHolder_Behavior.virtual_getAllMacroNames_1234975567387(thisNode, addBasedir);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.build.distrib.structure.DistribConfiguration";
  }
}
