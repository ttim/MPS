package jetbrains.mps.build.workflow.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.structure.BehaviorDescriptor;
import jetbrains.mps.smodel.structure.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class BwfJavaDependency_Behavior {
  private static Class[] PARAMETERS_6647099934207246778 = {SNode.class};
  private static Class[] PARAMETERS_6647099934207248130 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_getSignature_6647099934207246778(SNode thisNode) {
    return null;
  }

  public static SNode virtual_clone_6647099934207248130(SNode thisNode) {
    return null;
  }

  public static String call_getSignature_6647099934207246778(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.workflow.structure.BwfJavaDependency"), "virtual_getSignature_6647099934207246778", PARAMETERS_6647099934207246778);
  }

  public static SNode call_clone_6647099934207248130(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.workflow.structure.BwfJavaDependency"), "virtual_clone_6647099934207248130", PARAMETERS_6647099934207248130);
  }

  public static String callSuper_getSignature_6647099934207246778(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.workflow.structure.BwfJavaDependency"), callerConceptFqName, "virtual_getSignature_6647099934207246778", PARAMETERS_6647099934207246778);
  }

  public static SNode callSuper_clone_6647099934207248130(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.workflow.structure.BwfJavaDependency"), callerConceptFqName, "virtual_clone_6647099934207248130", PARAMETERS_6647099934207248130);
  }
}
