package jetbrains.mps.lang.traceable.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class UnitConcept_Behavior {
  private static Class[] PARAMETERS_5067982036267369911 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String call_getUnitName_5067982036267369911(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.traceable.structure.UnitConcept"), "virtual_getUnitName_5067982036267369911", PARAMETERS_5067982036267369911, new Object[]{});
  }

  public static String callSuper_getUnitName_5067982036267369911(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.traceable.structure.UnitConcept"), callerConceptFqName, "virtual_getUnitName_5067982036267369911", PARAMETERS_5067982036267369911, new Object[]{});
  }
}
