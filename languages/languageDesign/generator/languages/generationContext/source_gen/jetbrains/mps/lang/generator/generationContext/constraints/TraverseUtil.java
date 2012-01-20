package jetbrains.mps.lang.generator.generationContext.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class TraverseUtil {
  public TraverseUtil() {
  }

  public static SNode parent(SNode n) {
    if (SNodeOperations.isAttribute(n)) {
      if (SNodeOperations.isInstanceOf(n, "jetbrains.mps.lang.core.structure.NodeAttribute")) {
        SNode next = SNodeOperations.getPrevSibling(n);
        while (next != null) {
          if (SNodeOperations.isInstanceOf(next, "jetbrains.mps.lang.core.structure.NodeAttribute")) {
            return next;
          }
          next = SNodeOperations.getPrevSibling(next);
        }
        n = SNodeOperations.getParent(n);
        return (n == null ?
          null :
          SNodeOperations.getParent(n)
        );
      }
      return SNodeOperations.getParent(n);
    }
    SNode lastAttr = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(n, "jetbrains.mps.lang.core.structure.BaseConcept"), "smodelAttribute", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.lang.core.structure.NodeAttribute");
      }
    }).last();
    if ((lastAttr != null)) {
      return lastAttr;
    }

    return SNodeOperations.getParent(n);
  }
}
