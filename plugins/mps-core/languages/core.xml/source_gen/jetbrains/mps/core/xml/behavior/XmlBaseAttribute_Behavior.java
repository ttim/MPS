package jetbrains.mps.core.xml.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class XmlBaseAttribute_Behavior {
  private static Class[] PARAMETERS_3080189811177259788 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isMultiline_3080189811177259788(SNode thisNode) {
    return false;
  }

  public static boolean call_isMultiline_3080189811177259788(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.core.xml.structure.XmlBaseAttribute"), "virtual_isMultiline_3080189811177259788", PARAMETERS_3080189811177259788, new Object[]{});
  }

  public static boolean callSuper_isMultiline_3080189811177259788(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.core.xml.structure.XmlBaseAttribute"), callerConceptFqName, "virtual_isMultiline_3080189811177259788", PARAMETERS_3080189811177259788, new Object[]{});
  }
}
