package jetbrains.mps.buildScript.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.ScopeProvider_BehaviorDescriptor;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.smodel.SNode;

public class BuildProjectDependency_BehaviorDescriptor extends BuildDependency_BehaviorDescriptor implements ScopeProvider_BehaviorDescriptor {
  public BuildProjectDependency_BehaviorDescriptor() {
  }

  public Scope virtual_getScope_7722139651431880752(SNode thisNode, SNode kind, String role, int index) {
    return BuildProjectDependency_Behavior.virtual_getScope_7722139651431880752(thisNode, kind, role, index);
  }

  public Scope virtual_getScope_3734116213129936182(SNode thisNode, SNode kind, SNode child) {
    return BuildProjectDependency_Behavior.virtual_getScope_3734116213129936182(thisNode, kind, child);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.buildScript.structure.BuildProjectDependency";
  }
}
