package jetbrains.mps.lang.core.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;

public class SuppressErrorsAnnotation_BehaviorDescriptor extends NodeAttribute_BehaviorDescriptor implements ISuppressErrors_BehaviorDescriptor {
  public SuppressErrorsAnnotation_BehaviorDescriptor() {
  }

  public boolean virtual_suppress_3393165121846091591(SNode thisNode, SNode child) {
    return ISuppressErrors_Behavior.virtual_suppress_3393165121846091591(thisNode, child);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.lang.core.structure.SuppressErrorsAnnotation";
  }
}
