package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.scope.Scope;
import jetbrains.mps.smodel.SNode;

public class BuildJavaPlugin_BehaviorDescriptor extends BuildPlugin_BehaviorDescriptor {
  public BuildJavaPlugin_BehaviorDescriptor() {
  }

  public Scope virtual_getLayoutScope_1224588814561807654(SNode thisNode, SNode kind) {
    return BuildJavaPlugin_Behavior.virtual_getLayoutScope_1224588814561807654(thisNode, kind);
  }

  public Scope virtual_getProjectStructureScope_3734116213129936182(SNode thisNode, SNode kind) {
    return BuildJavaPlugin_Behavior.virtual_getProjectStructureScope_3734116213129936182(thisNode, kind);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.build.structure.BuildJavaPlugin";
  }
}
