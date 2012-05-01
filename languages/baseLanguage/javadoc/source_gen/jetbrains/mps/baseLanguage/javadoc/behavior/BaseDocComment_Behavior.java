package jetbrains.mps.baseLanguage.javadoc.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class BaseDocComment_Behavior {
  private static Class[] PARAMETERS_8465538089690623795 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isTagSectionEmpty_8465538089690623795(SNode thisNode) {
    return ListSequence.fromList(SLinkOperations.getTargets(thisNode, "author", true)).isEmpty() && (SLinkOperations.getTarget(thisNode, "deprecated", true) == null) && ListSequence.fromList(SLinkOperations.getTargets(thisNode, "since", true)).isEmpty() && ListSequence.fromList(SLinkOperations.getTargets(thisNode, "version", true)).isEmpty() && ListSequence.fromList(SLinkOperations.getTargets(thisNode, "see", true)).isEmpty();
  }

  public static boolean call_isTagSectionEmpty_8465538089690623795(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.javadoc.structure.BaseDocComment"), "virtual_isTagSectionEmpty_8465538089690623795", PARAMETERS_8465538089690623795);
  }

  public static boolean callSuper_isTagSectionEmpty_8465538089690623795(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.javadoc.structure.BaseDocComment"), callerConceptFqName, "virtual_isTagSectionEmpty_8465538089690623795", PARAMETERS_8465538089690623795);
  }
}
