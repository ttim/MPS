package jetbrains.mps.lang.generator.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class Reduction_MappingRule_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getTemplateType_1213877498511(SNode thisNode) {
    return RuleConsequence_Behavior.call_getTemplateType_7933327286924651185(SLinkOperations.getTarget(thisNode, "ruleConsequence", true));
  }
}
