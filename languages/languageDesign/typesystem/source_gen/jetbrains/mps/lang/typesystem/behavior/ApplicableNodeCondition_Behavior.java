package jetbrains.mps.lang.typesystem.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ApplicableNodeCondition_Behavior {
  private static Class[] PARAMETERS_1213877307633 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode call_getApplicableConcept_1213877307633(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.typesystem.structure.ApplicableNodeCondition"), "virtual_getApplicableConcept_1213877307633", PARAMETERS_1213877307633, new Object[]{});
  }

  public static SNode callSuper_getApplicableConcept_1213877307633(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.typesystem.structure.ApplicableNodeCondition"), callerConceptFqName, "virtual_getApplicableConcept_1213877307633", PARAMETERS_1213877307633, new Object[]{});
  }
}
