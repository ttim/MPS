package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class VariableArityType_Behavior {

  public static void init(SNode thisNode) {
  }

  public static String virtual_getPresentation_1213877396640(SNode thisNode) {
    return BaseConcept_Behavior.call_getPresentation_1213877396640(SLinkOperations.getTarget(thisNode, "componentType", true)) + "...";
  }

}
