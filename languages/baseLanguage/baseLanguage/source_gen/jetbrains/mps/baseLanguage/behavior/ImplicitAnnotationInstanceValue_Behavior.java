package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.scope.EmptyScope;

public class ImplicitAnnotationInstanceValue_Behavior {
  public static void init(SNode thisNode) {
  }

  public static Scope virtual_getScope_3734116213129936182(SNode thisNode, SNode kind, SNode child) {
    Scope original = Scope.getScope(Scope.parent(thisNode), thisNode, kind);
    if (original != null && (int) ListSequence.fromList(original.getAvailableElements(null)).count() == 1) {
      return original;
    } else {
      return new EmptyScope();
    }
  }
}
