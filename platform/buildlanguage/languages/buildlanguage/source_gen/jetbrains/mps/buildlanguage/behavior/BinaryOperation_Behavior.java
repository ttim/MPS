package jetbrains.mps.buildlanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class BinaryOperation_Behavior {
  private static Class[] PARAMETERS_1213877398951 = {SNode.class, SNode.class, SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getType_1213877398951(SNode thisNode, SNode s1, SNode s2) {
    return s1;
  }

  public static SNode call_getType_1213877398951(SNode thisNode, SNode s1, SNode s2) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildlanguage.structure.BinaryOperation"), "virtual_getType_1213877398951", PARAMETERS_1213877398951, s1, s2);
  }

  public static SNode callSuper_getType_1213877398951(SNode thisNode, String callerConceptFqName, SNode s1, SNode s2) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildlanguage.structure.BinaryOperation"), callerConceptFqName, "virtual_getType_1213877398951", PARAMETERS_1213877398951, s1, s2);
  }
}
