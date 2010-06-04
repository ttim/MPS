package jetbrains.mps.samples.lambdaCalculus.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class LetRef_Behavior {
  public static void init(SNode thisNode) {
  }

  public static List<SNode> call_getAllReferences_926857988255581402(SNode thisNode) {
    List<SNode> result = new ArrayList<SNode>();
    SNode node = thisNode;
    while (SNodeOperations.getParent(node) != null && !(SNodeOperations.isInstanceOf(node, "jetbrains.mps.samples.lambdaCalculus.structure.MultipleExpression"))) {
      node = SNodeOperations.getParent(node);
    }
    for (SNode letRef : SNodeOperations.getDescendants(node, "jetbrains.mps.samples.lambdaCalculus.structure.LetRef", false, new String[]{})) {
      if (SLinkOperations.getTarget(letRef, "variable", false) == SLinkOperations.getTarget(thisNode, "variable", false)) {
        ListSequence.fromList(result).addElement(letRef);
      }
    }
    return result;
  }
}
