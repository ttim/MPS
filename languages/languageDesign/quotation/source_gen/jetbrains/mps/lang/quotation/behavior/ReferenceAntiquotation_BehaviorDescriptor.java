package jetbrains.mps.lang.quotation.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.LinkAttribute_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.scope.Scope;

public class ReferenceAntiquotation_BehaviorDescriptor extends LinkAttribute_BehaviorDescriptor implements AbstractAntiquotation_BehaviorDescriptor {
  public ReferenceAntiquotation_BehaviorDescriptor() {
  }

  public int virtual_getMetaLevelChange_201537367881074474(SNode thisNode) {
    return AbstractAntiquotation_Behavior.virtual_getMetaLevelChange_201537367881074474(thisNode);
  }

  public Scope virtual_getScope_7722139651431880752(SNode thisNode, SNode kind, String role, int index) {
    return AbstractAntiquotation_Behavior.virtual_getScope_7722139651431880752(thisNode, kind, role, index);
  }

  public Scope virtual_getScope_3734116213129936182(SNode thisNode, SNode kind, SNode child) {
    return AbstractAntiquotation_Behavior.virtual_getScope_3734116213129936182(thisNode, kind, child);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.lang.quotation.structure.ReferenceAntiquotation";
  }
}
