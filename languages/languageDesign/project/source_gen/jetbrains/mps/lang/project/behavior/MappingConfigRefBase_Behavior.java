package jetbrains.mps.lang.project.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class MappingConfigRefBase_Behavior {
  private static Class[] PARAMETERS_2721285250110257005 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isComplete_2721285250110257005(SNode thisNode) {
    return true;
  }

  public static boolean call_isComplete_2721285250110257005(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.project.structure.MappingConfigRefBase"), "virtual_isComplete_2721285250110257005", PARAMETERS_2721285250110257005, new Object[]{});
  }

  public static boolean callSuper_isComplete_2721285250110257005(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.project.structure.MappingConfigRefBase"), callerConceptFqName, "virtual_isComplete_2721285250110257005", PARAMETERS_2721285250110257005, new Object[]{});
  }
}
