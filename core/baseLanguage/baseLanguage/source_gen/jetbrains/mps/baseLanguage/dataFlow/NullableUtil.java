package jetbrains.mps.baseLanguage.dataFlow;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class NullableUtil {
  public NullableUtil() {
  }

  public static List<SNode> getOrConditions(SNode ifStatement) {
    List<SNode> result = new ArrayList<SNode>();
    getOrExpressions(SLinkOperations.getTarget(ifStatement, "condition", true), result);
    return result;
  }

  public static void getOrExpressions(SNode expression, List<SNode> result) {
    if (SNodeOperations.isInstanceOf(expression, "jetbrains.mps.baseLanguage.structure.AndExpression")) {
      return;
    }
    if (SNodeOperations.isInstanceOf(expression, "jetbrains.mps.baseLanguage.structure.OrExpression")) {
      SNode or = SNodeOperations.cast(expression, "jetbrains.mps.baseLanguage.structure.OrExpression");
      getOrExpressions(SLinkOperations.getTarget(or, "leftExpression", true), result);
      getOrExpressions(SLinkOperations.getTarget(or, "rightExpression", true), result);
    }
    ListSequence.fromList(result).addElement(expression);
  }

  public static SNode getOtherThanNull(SNode equals) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(equals, "leftExpression", true), "jetbrains.mps.baseLanguage.structure.NullLiteral")) {
      return SLinkOperations.getTarget(equals, "rightExpression", true);
    }
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(equals, "rightExpression", true), "jetbrains.mps.baseLanguage.structure.NullLiteral")) {
      return SLinkOperations.getTarget(equals, "leftExpression", true);
    }
    return null;
  }
}
