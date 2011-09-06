package jetbrains.mps.baseLanguage.javadoc.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.javadoc.editor.NodeCaretPair;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.structure.BehaviorDescriptor;
import jetbrains.mps.smodel.structure.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class InlineTagCommentLinePart_Behavior {
  private static Class[] PARAMETERS_3633133276124360200 = {SNode.class, Boolean.TYPE};

  public static void init(SNode thisNode) {
  }

  public static NodeCaretPair virtual_smartDelete_9042833497008205283(SNode thisNode, boolean isBegining) {
    int index = SNodeOperations.getIndexInParent(thisNode);
    SNode line = SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.baseLanguage.javadoc.structure.CommentLine");
    SNodeOperations.deleteNode(thisNode);
    NodeCaretPair pair = CommentLine_Behavior.call_tryMergeToRight_439148907936414403(line, index - 1);
    if (pair == null) {
      return new NodeCaretPair(ListSequence.fromList(SLinkOperations.getTargets(line, "part", true)).getElement(index), 0);
    } else {
      return pair;
    }
  }

  public static NodeCaretPair call_smartDelete_3633133276124360200(SNode thisNode, boolean isBegining) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (NodeCaretPair) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.javadoc.structure.InlineTagCommentLinePart"), "virtual_smartDelete_9042833497008205283", PARAMETERS_3633133276124360200, isBegining);
  }

  public static NodeCaretPair callSuper_smartDelete_3633133276124360200(SNode thisNode, String callerConceptFqName, boolean isBegining) {
    return (NodeCaretPair) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.javadoc.structure.InlineTagCommentLinePart"), callerConceptFqName, "virtual_smartDelete_9042833497008205283", PARAMETERS_3633133276124360200, isBegining);
  }
}
