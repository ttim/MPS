package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class BuildMacro_Behavior {
  private static Class[] PARAMETERS_6547494638219688113 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isPublic_6547494638219688113(SNode thisNode) {
    return false;
  }

  public static boolean call_isPublic_6547494638219688113(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildMacro"), "virtual_isPublic_6547494638219688113", PARAMETERS_6547494638219688113, new Object[]{});
  }

  public static boolean callSuper_isPublic_6547494638219688113(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildMacro"), callerConceptFqName, "virtual_isPublic_6547494638219688113", PARAMETERS_6547494638219688113, new Object[]{});
  }
}
