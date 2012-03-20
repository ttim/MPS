package jetbrains.mps.build.workflow.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.INamedConcept_BehaviorDescriptor;
import jetbrains.mps.lang.core.behavior.ScopeProvider_BehaviorDescriptor;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.core.behavior.ScopeProvider_Behavior;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;

public class BwfTask_BehaviorDescriptor extends BwfProjectPart_BehaviorDescriptor implements INamedConcept_BehaviorDescriptor, ScopeProvider_BehaviorDescriptor {
  public BwfTask_BehaviorDescriptor() {
  }

  public Scope virtual_getScope_7722139651431880752(SNode thisNode, SNode kind, String role, int index) {
    return ScopeProvider_Behavior.virtual_getScope_7722139651431880752(thisNode, kind, role, index);
  }

  public String virtual_getFqName_1213877404258(SNode thisNode) {
    return INamedConcept_Behavior.virtual_getFqName_1213877404258(thisNode);
  }

  public Scope virtual_getScope_3734116213129936182(SNode thisNode, SNode kind, SNode child) {
    return BwfTask_Behavior.virtual_getScope_3734116213129936182(thisNode, kind, child);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.build.workflow.structure.BwfTask";
  }
}
