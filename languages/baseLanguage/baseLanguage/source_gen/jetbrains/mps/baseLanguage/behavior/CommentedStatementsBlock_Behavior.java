package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.Set;

public class CommentedStatementsBlock_Behavior {
  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getLocalVariableElements_1238805763253(SNode thisNode) {
    return SLinkOperations.getTargets(thisNode, "statement", true);
  }

  public static void virtual_collectUncaughtMethodThrowables_5412515780383134223(SNode thisNode, Set<SNode> throwables, boolean ignoreMayBeThrowables) {
    // do nothing 
  }
}
