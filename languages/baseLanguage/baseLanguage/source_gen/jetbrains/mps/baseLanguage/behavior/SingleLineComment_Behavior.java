package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Set;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class SingleLineComment_Behavior {
  public static void init(SNode thisNode) {
  }

  public static void virtual_collectUncaughtMethodThrowables_5412515780383134223(SNode thisNode, Set<SNode> throwables, boolean ignoreMayBeThrowables) {
    // doing nothing 
  }

  public static Scope virtual_getScope_3734116213129936182(SNode thisNode, SNode kind, SNode child) {
    if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration")) {
      if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.baseLanguage.structure.StatementList")) {
        // <node> 
        return Scope.getScope(SNodeOperations.getParent(thisNode), ListSequence.fromList(SNodeOperations.getChildren(SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.baseLanguage.structure.StatementList"))).last(), kind);
      } else {
        return null;
      }
    }

    return null;
  }
}
