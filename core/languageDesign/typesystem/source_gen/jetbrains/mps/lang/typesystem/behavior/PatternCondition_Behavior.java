package jetbrains.mps.lang.typesystem.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class PatternCondition_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getApplicableConcept_1213877307633(SNode thisNode) {
    return SNodeOperations.getConceptDeclaration(SLinkOperations.getTarget(SLinkOperations.getTarget(thisNode, "pattern", true), "patternNode", true));
  }
}
