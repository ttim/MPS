package jetbrains.mps.lang.plugin.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class PluginDependency_Behavior {
  private static Class[] PARAMETERS_5864553086652219131 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String call_getPluginId_5864553086652219131(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.plugin.structure.PluginDependency"), "virtual_getPluginId_5864553086652219131", PARAMETERS_5864553086652219131);
  }

  public static String callSuper_getPluginId_5864553086652219131(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.plugin.structure.PluginDependency"), callerConceptFqName, "virtual_getPluginId_5864553086652219131", PARAMETERS_5864553086652219131);
  }
}
