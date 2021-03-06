package jetbrains.mps.ui.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ContainerCompartment_Behavior {
  private static Class[] PARAMETERS_8923564134258348484 = {SNode.class};
  private static Class[] PARAMETERS_8923564134258348492 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getContext_8923564134258345451(SNode thisNode) {
    return SNodeOperations.getAncestor(thisNode, "jetbrains.mps.ui.structure.UIObjectStatement", false, false);
  }

  public static SNode virtual_getContainer_8923564134258257521(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "container", false);
  }

  public static SNode call_getContext_8923564134258348484(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.ui.structure.ContainerCompartment"), "virtual_getContext_8923564134258345451", PARAMETERS_8923564134258348484, new Object[]{});
  }

  public static SNode call_getContainer_8923564134258348492(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.ui.structure.ContainerCompartment"), "virtual_getContainer_8923564134258257521", PARAMETERS_8923564134258348492, new Object[]{});
  }

  public static SNode callSuper_getContext_8923564134258348484(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.ui.structure.ContainerCompartment"), callerConceptFqName, "virtual_getContext_8923564134258345451", PARAMETERS_8923564134258348484, new Object[]{});
  }

  public static SNode callSuper_getContainer_8923564134258348492(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.ui.structure.ContainerCompartment"), callerConceptFqName, "virtual_getContainer_8923564134258257521", PARAMETERS_8923564134258348492, new Object[]{});
  }
}
