package jetbrains.mps.core.xml.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class XmlProlog_Behavior {
  public static void init(SNode thisNode) {
  }

  public static boolean call_isInValidPosition_2133624044437891376(SNode thisNode, SNode element) {
    SNode declaration = ListSequence.fromList(SLinkOperations.getTargets(thisNode, "elements", true)).findFirst(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SConceptPropertyOperations.getBoolean(it, "isFirst");
      }
    });
    if (declaration == null) {
      return true;
    }
    return !(ListSequence.fromList(SNodeOperations.getPrevSiblings(declaration, false)).contains(element));
  }
}
