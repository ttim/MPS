package jetbrains.mps.lang.typesystem.behavior;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.behavior.AbstractLoopStatement_BehaviorDescriptor;
import java.util.List;
import jetbrains.mps.smodel.SNode;

public class MultipleForeachLoop_BehaviorDescriptor extends AbstractLoopStatement_BehaviorDescriptor {
  public MultipleForeachLoop_BehaviorDescriptor() {
  }

  public List<SNode> virtual_getOrderedParts_1955452033143960289(SNode thisNode) {
    return MultipleForeachLoop_Behavior.virtual_getOrderedParts_1955452033143960289(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.lang.typesystem.structure.MultipleForeachLoop";
  }
}
