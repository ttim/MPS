package jetbrains.mps.build.mps.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class BuildMps_IdeaPluginContent_Behavior {
  private static Class[] PARAMETERS_6547494638219603457 = {SNode.class, Object.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_exports_6547494638219603457(SNode thisNode, Object object) {
    return false;
  }

  public static boolean call_exports_6547494638219603457(SNode thisNode, Object object) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginContent"), "virtual_exports_6547494638219603457", PARAMETERS_6547494638219603457, new Object[]{object});
  }

  public static boolean callSuper_exports_6547494638219603457(SNode thisNode, String callerConceptFqName, Object object) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginContent"), callerConceptFqName, "virtual_exports_6547494638219603457", PARAMETERS_6547494638219603457, new Object[]{object});
  }
}
