package jetbrains.mps.lang.typesystem.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class LinkPatternVariableReference_Behavior {
  private static Class[] PARAMETERS_1225210740874 = {SNode.class, Object.class};

  public static void init(SNode thisNode) {
  }

  public static void virtual_abxcdef_1225210740874(SNode thisNode, @Deprecated Object o) {
  }

  public static void call_abxcdef_1225210740874(SNode thisNode, @Deprecated Object o) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.typesystem.structure.LinkPatternVariableReference"), "virtual_abxcdef_1225210740874", PARAMETERS_1225210740874, new Object[]{o});
  }

  public static void callSuper_abxcdef_1225210740874(SNode thisNode, String callerConceptFqName, @Deprecated Object o) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.typesystem.structure.LinkPatternVariableReference"), callerConceptFqName, "virtual_abxcdef_1225210740874", PARAMETERS_1225210740874, new Object[]{o});
  }
}
