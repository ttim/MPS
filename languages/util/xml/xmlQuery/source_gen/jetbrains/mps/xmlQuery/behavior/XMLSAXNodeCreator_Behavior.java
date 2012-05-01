package jetbrains.mps.xmlQuery.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class XMLSAXNodeCreator_Behavior {
  private static Class[] PARAMETERS_2268737274628969541 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getExpectedReturnType_1213877374441(SNode thisNode) {
    SNode rule = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.xmlQuery.structure.XMLSAXNodeRule", false, false);
    return XMLSAXNodeRule_Behavior.call_getType_2286463592495414413(rule);
  }

  public static SNode call_getExpectedReturnType_2268737274628969541(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlQuery.structure.XMLSAXNodeCreator"), "virtual_getExpectedReturnType_1213877374441", PARAMETERS_2268737274628969541);
  }

  public static SNode callSuper_getExpectedReturnType_2268737274628969541(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlQuery.structure.XMLSAXNodeCreator"), callerConceptFqName, "virtual_getExpectedReturnType_1213877374441", PARAMETERS_2268737274628969541);
  }
}
