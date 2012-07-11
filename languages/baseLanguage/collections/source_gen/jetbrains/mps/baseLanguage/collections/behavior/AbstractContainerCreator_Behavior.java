package jetbrains.mps.baseLanguage.collections.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class AbstractContainerCreator_Behavior {
  private static Class[] PARAMETERS_1237722437229 = {SNode.class};
  private static Class[] PARAMETERS_2261417478150191157 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_canHaveParameter_2261417478150191157(SNode thisNode) {
    return true;
  }

  public static SNode call_createType_1237722437229(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.collections.structure.AbstractContainerCreator"), "virtual_createType_1237722437229", PARAMETERS_1237722437229, new Object[]{});
  }

  public static boolean call_canHaveParameter_2261417478150191157(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.collections.structure.AbstractContainerCreator"), "virtual_canHaveParameter_2261417478150191157", PARAMETERS_2261417478150191157, new Object[]{});
  }

  public static SNode callSuper_createType_1237722437229(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.collections.structure.AbstractContainerCreator"), callerConceptFqName, "virtual_createType_1237722437229", PARAMETERS_1237722437229, new Object[]{});
  }

  public static boolean callSuper_canHaveParameter_2261417478150191157(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.collections.structure.AbstractContainerCreator"), callerConceptFqName, "virtual_canHaveParameter_2261417478150191157", PARAMETERS_2261417478150191157, new Object[]{});
  }
}
