package jetbrains.mps.lang.typesystem.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class ApplicableNodeCondition_Behavior {
  private static Class[] PARAMETERS_1213877307633 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode call_getApplicableConcept_1213877307633(SNode thisNode) {
    return (SNode)BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.typesystem.structure.ApplicableNodeCondition"), "virtual_getApplicableConcept_1213877307633", PARAMETERS_1213877307633);
  }

  public static SNode callSuper_getApplicableConcept_1213877307633(SNode thisNode, String callerConceptFqName) {
    return (SNode)BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.typesystem.structure.ApplicableNodeCondition"), callerConceptFqName, "virtual_getApplicableConcept_1213877307633", PARAMETERS_1213877307633);
  }
}
