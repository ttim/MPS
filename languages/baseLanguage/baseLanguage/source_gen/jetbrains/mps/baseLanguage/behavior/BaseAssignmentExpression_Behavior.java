package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class BaseAssignmentExpression_Behavior {
  private static Class[] PARAMETERS_1215696236033 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isReadAsignment_1215696236033(SNode thisNode) {
    return true;
  }

  public static boolean virtual_isLegalAsStatement_1239211900844(SNode thisNode) {
    return true;
  }

  public static boolean call_isReadAsignment_1215696236033(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.BaseAssignmentExpression"), "virtual_isReadAsignment_1215696236033", PARAMETERS_1215696236033);
  }

  public static boolean callSuper_isReadAsignment_1215696236033(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.BaseAssignmentExpression"), callerConceptFqName, "virtual_isReadAsignment_1215696236033", PARAMETERS_1215696236033);
  }
}
