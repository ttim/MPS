package jetbrains.mps.lang.core.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class INamedConcept_Behavior {
  private static Class[] PARAMETERS_1213877404258 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_getFqName_1213877404258(SNode thisNode) {
    String longName = SNodeOperations.getModel(thisNode).getLongName();
    if (longName.equals("")) {
      return SPropertyOperations.getString(thisNode, "name");
    }
    return longName + "." + SPropertyOperations.getString(thisNode, "name");
  }

  public static String call_getFqName_1213877404258(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.INamedConcept"), "virtual_getFqName_1213877404258", PARAMETERS_1213877404258, new Object[]{});
  }

  public static String callSuper_getFqName_1213877404258(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.INamedConcept"), callerConceptFqName, "virtual_getFqName_1213877404258", PARAMETERS_1213877404258, new Object[]{});
  }
}
