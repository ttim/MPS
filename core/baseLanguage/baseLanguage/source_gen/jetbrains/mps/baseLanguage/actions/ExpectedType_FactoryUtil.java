package jetbrains.mps.baseLanguage.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.constraints.TypeDerivable_Behavior;
import jetbrains.mps.patterns.util.MatchingUtil;

public class ExpectedType_FactoryUtil {

  public static boolean canComputeCastType(SNode castExpression) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(castExpression, null, false, false), "jetbrains.mps.baseLanguage.structure.TypeDerivable");
  }

  public static SNode createExpectedType(SNode contextNode) {
    SNode castType = null;
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(contextNode, null, false, false), "jetbrains.mps.baseLanguage.structure.TypeDerivable")) {
      castType = TypeDerivable_Behavior.call_deriveType_1201184092299(SNodeOperations.getParent(contextNode, null, false, false), contextNode);
    }
    return castType;
  }

  public static SNode getOriginalExpression(SNode enclosingNode, SNode copiedExpression) {
    SNode originalExpression = null;
    for(SNode child : SNodeOperations.getChildren(enclosingNode)) {
      if (MatchingUtil.matchNodes(copiedExpression, child)) {
        originalExpression = child;
      }
    }
    return originalExpression;
  }

}
