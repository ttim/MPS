package jetbrains.mps.ui.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class UIObjectReference_Behavior {
  private static Class[] PARAMETERS_3262277503800965875 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getDeclaration_3262277503800831941(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "declaration", false);
  }

  public static SNode call_getDeclaration_3262277503800965875(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.ui.structure.UIObjectReference"), "virtual_getDeclaration_3262277503800831941", PARAMETERS_3262277503800965875, new Object[]{});
  }

  public static SNode callSuper_getDeclaration_3262277503800965875(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.ui.structure.UIObjectReference"), callerConceptFqName, "virtual_getDeclaration_3262277503800831941", PARAMETERS_3262277503800965875, new Object[]{});
  }
}
