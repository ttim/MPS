package jetbrains.mps.build.mps.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.structure.BehaviorDescriptor;
import jetbrains.mps.smodel.structure.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class BuildMps_AbstractModule_Behavior {
  private static Class[] PARAMETERS_8369506495128693730 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isCompact_8369506495128693730(SNode thisNode) {
    return SPropertyOperations.getBoolean(thisNode, "compact");
  }

  public static String call_getModuleReference_4643216374596368935(SNode thisNode) {
    return SPropertyOperations.getString(thisNode, "uuid") + "(" + SPropertyOperations.getString(thisNode, "name") + ")";
  }

  public static boolean call_isCompact_8369506495128693730(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.mps.structure.BuildMps_AbstractModule"), "virtual_isCompact_8369506495128693730", PARAMETERS_8369506495128693730);
  }

  public static boolean callSuper_isCompact_8369506495128693730(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.mps.structure.BuildMps_AbstractModule"), callerConceptFqName, "virtual_isCompact_8369506495128693730", PARAMETERS_8369506495128693730);
  }
}
