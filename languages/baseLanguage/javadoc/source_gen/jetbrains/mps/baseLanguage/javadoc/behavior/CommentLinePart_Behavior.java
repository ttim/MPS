package jetbrains.mps.baseLanguage.javadoc.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.javadoc.editor.NodeCaretPair;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class CommentLinePart_Behavior {
  private static Class[] PARAMETERS_9042833497008205283 = {SNode.class, Boolean.TYPE};

  public static void init(SNode thisNode) {
  }

  public static NodeCaretPair virtual_smartDelete_9042833497008205283(SNode thisNode, boolean isBeginning) {
    SNodeOperations.deleteNode(thisNode);
    return null;
  }

  public static NodeCaretPair call_smartDelete_9042833497008205283(SNode thisNode, boolean isBeginning) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (NodeCaretPair) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.javadoc.structure.CommentLinePart"), "virtual_smartDelete_9042833497008205283", PARAMETERS_9042833497008205283, isBeginning);
  }

  public static NodeCaretPair callSuper_smartDelete_9042833497008205283(SNode thisNode, String callerConceptFqName, boolean isBeginning) {
    return (NodeCaretPair) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.javadoc.structure.CommentLinePart"), callerConceptFqName, "virtual_smartDelete_9042833497008205283", PARAMETERS_9042833497008205283, isBeginning);
  }
}
