package jetbrains.mps.gwt.client.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class Attr_Behavior {
  private static Class[] PARAMETERS_3852159904898525999 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String call_getXmlAttr_3852159904898525999(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.gwt.client.structure.Attr"), "virtual_getXmlAttr_3852159904898525999", PARAMETERS_3852159904898525999);
  }

  public static String callSuper_getXmlAttr_3852159904898525999(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.gwt.client.structure.Attr"), callerConceptFqName, "virtual_getXmlAttr_3852159904898525999", PARAMETERS_3852159904898525999);
  }
}
