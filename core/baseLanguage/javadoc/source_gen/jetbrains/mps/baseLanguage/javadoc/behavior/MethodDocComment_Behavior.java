package jetbrains.mps.baseLanguage.javadoc.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class MethodDocComment_Behavior {
  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isTagSectionEmpty_8465538089690623795(SNode thisNode) {
    return BaseDocComment_Behavior.callSuper_isTagSectionEmpty_8465538089690623795(thisNode, "jetbrains.mps.baseLanguage.javadoc.structure.MethodDocComment") && ListSequence.fromList(SLinkOperations.getTargets(thisNode, "param", true)).isEmpty();
  }
}
