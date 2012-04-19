package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.BaseConcept_BehaviorDescriptor;
import jetbrains.mps.lang.traceable.behavior.ScopeConcept_BehaviorDescriptor;
import jetbrains.mps.lang.core.behavior.ScopeProvider_BehaviorDescriptor;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.lang.core.behavior.ScopeProvider_Behavior;

public class CatchClause_BehaviorDescriptor extends BaseConcept_BehaviorDescriptor implements ScopeConcept_BehaviorDescriptor, ScopeProvider_BehaviorDescriptor {
  public CatchClause_BehaviorDescriptor() {
  }

  public List<SNode> virtual_getScopeVariables_5067982036267369894(SNode thisNode) {
    return CatchClause_Behavior.virtual_getScopeVariables_5067982036267369894(thisNode);
  }

  public Scope virtual_getScope_7722139651431880752(SNode thisNode, SNode kind, String role, int index) {
    return ScopeProvider_Behavior.virtual_getScope_7722139651431880752(thisNode, kind, role, index);
  }

  public Scope virtual_getScope_3734116213129936182(SNode thisNode, SNode kind, SNode child) {
    return CatchClause_Behavior.virtual_getScope_3734116213129936182(thisNode, kind, child);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.baseLanguage.structure.CatchClause";
  }
}
