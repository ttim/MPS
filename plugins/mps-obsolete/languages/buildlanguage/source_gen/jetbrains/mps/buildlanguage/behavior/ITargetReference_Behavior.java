package jetbrains.mps.buildlanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ITargetReference_Behavior {
  private static Class[] PARAMETERS_1230222765831 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String call_getProjectFileName_1230222765831(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildlanguage.structure.ITargetReference"), "virtual_getProjectFileName_1230222765831", PARAMETERS_1230222765831, new Object[]{});
  }

  public static String callSuper_getProjectFileName_1230222765831(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildlanguage.structure.ITargetReference"), callerConceptFqName, "virtual_getProjectFileName_1230222765831", PARAMETERS_1230222765831, new Object[]{});
  }
}
