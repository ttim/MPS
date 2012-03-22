package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.scopes.runtime.SimpleScope;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class Closure_Behavior {
  public static void init(SNode thisNode) {
  }

  public static List<SNode> call_getVariablesReferencedInClosure_1223989736803(SNode thisNode) {
    List<SNode> referencedInClosures = new ArrayList<SNode>();
    for (SNode varRef : SNodeOperations.getDescendants(thisNode, "jetbrains.mps.baseLanguage.structure.VariableReference", false, new String[]{})) {
      SNode closure = SNodeOperations.getAncestor(SLinkOperations.getTarget(varRef, "variableDeclaration", false), "jetbrains.mps.baseLanguage.structure.Closure", false, false);
      if ((closure == null) || closure != SNodeOperations.getParent(thisNode)) {
        ListSequence.fromList(referencedInClosures).addElement(SLinkOperations.getTarget(varRef, "variableDeclaration", false));
      }
    }
    return referencedInClosures;
  }

  public static Scope virtual_getScope_3734116213129936182(SNode thisNode, SNode kind, SNode child) {
    final Wrappers._T<SNode> _child = new Wrappers._T<SNode>(child);
    if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.baseLanguage.structure.ClosureParameter")) {
      while (SNodeOperations.getParent(_child.value) != thisNode) {
        _child.value = SNodeOperations.getParent(_child.value);
      }
      return new SimpleScope(ListSequence.fromList(SNodeOperations.getChildren(thisNode)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.ClosureParameter") && it != _child.value;
        }
      }));
    }
    return null;
  }
}
