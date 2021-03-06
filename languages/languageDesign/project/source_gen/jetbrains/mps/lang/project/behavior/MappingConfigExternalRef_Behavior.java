package jetbrains.mps.lang.project.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class MappingConfigExternalRef_Behavior {
  private static Class[] PARAMETERS_2721285250110400531 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isComplete_2721285250110257005(SNode thisNode) {
    return (SLinkOperations.getTarget(thisNode, "generator", true) != null) && MappingConfigRefBase_Behavior.call_isComplete_2721285250110257005(SLinkOperations.getTarget(thisNode, "innerRef", true));
  }

  public static boolean call_isComplete_2721285250110400531(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.project.structure.MappingConfigExternalRef"), "virtual_isComplete_2721285250110257005", PARAMETERS_2721285250110400531, new Object[]{});
  }

  public static boolean callSuper_isComplete_2721285250110400531(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.project.structure.MappingConfigExternalRef"), callerConceptFqName, "virtual_isComplete_2721285250110257005", PARAMETERS_2721285250110400531, new Object[]{});
  }
}
