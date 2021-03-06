package jetbrains.mps.lang.typesystem.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.behavior.IConceptAspect_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class NonTypesystemRule_Behavior {
  private static Class[] PARAMETERS_590757823759247531 = {SNode.class, SNode.class};

  public static void init(SNode thisNode) {
  }

  public static void virtual_setBaseConcept_6261424444345963020(SNode thisNode, SNode baseConcept) {
    IConceptAspect_Behavior.callSuper_setBaseConcept_6261424444345963020(thisNode, "jetbrains.mps.lang.typesystem.structure.NonTypesystemRule", baseConcept);
    SPropertyOperations.set(thisNode, "name", "check_" + SPropertyOperations.getString(baseConcept, "name"));
  }

  public static void call_setBaseConcept_590757823759247531(SNode thisNode, SNode baseConcept) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.typesystem.structure.NonTypesystemRule"), "virtual_setBaseConcept_6261424444345963020", PARAMETERS_590757823759247531, new Object[]{baseConcept});
  }

  public static void callSuper_setBaseConcept_590757823759247531(SNode thisNode, String callerConceptFqName, SNode baseConcept) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.typesystem.structure.NonTypesystemRule"), callerConceptFqName, "virtual_setBaseConcept_6261424444345963020", PARAMETERS_590757823759247531, new Object[]{baseConcept});
  }
}
