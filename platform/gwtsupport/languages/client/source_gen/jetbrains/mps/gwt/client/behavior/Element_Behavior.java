package jetbrains.mps.gwt.client.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class Element_Behavior {
  private static Class[] PARAMETERS_3852159904898386595 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String call_getXmlElement_3852159904898386595(SNode thisNode) {
    return (String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.gwt.client.structure.Element"), "virtual_getXmlElement_3852159904898386595", PARAMETERS_3852159904898386595);
  }

  public static String callSuper_getXmlElement_3852159904898386595(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.gwt.client.structure.Element"), callerConceptFqName, "virtual_getXmlElement_3852159904898386595", PARAMETERS_3852159904898386595);
  }
}
