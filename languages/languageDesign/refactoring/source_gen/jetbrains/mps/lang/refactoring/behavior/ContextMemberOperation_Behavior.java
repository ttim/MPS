package jetbrains.mps.lang.refactoring.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ContextMemberOperation_Behavior {
  private static Class[] PARAMETERS_7012097027058652452 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode call_createType_7012097027058652452(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.refactoring.structure.ContextMemberOperation"), "virtual_createType_7012097027058652452", PARAMETERS_7012097027058652452, new Object[]{});
  }

  public static SNode callSuper_createType_7012097027058652452(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.refactoring.structure.ContextMemberOperation"), callerConceptFqName, "virtual_createType_7012097027058652452", PARAMETERS_7012097027058652452, new Object[]{});
  }
}
