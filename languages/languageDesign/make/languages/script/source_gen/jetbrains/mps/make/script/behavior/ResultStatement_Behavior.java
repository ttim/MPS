package jetbrains.mps.make.script.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ResultStatement_Behavior {
  private static Class[] PARAMETERS_2974008768272238697 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isGuardClauseStatement_1237547327995(SNode thisNode) {
    return true;
  }

  public static boolean call_isGuardClauseStatement_2974008768272238697(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.make.script.structure.ResultStatement"), "virtual_isGuardClauseStatement_1237547327995", PARAMETERS_2974008768272238697, new Object[]{});
  }

  public static boolean callSuper_isGuardClauseStatement_2974008768272238697(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.make.script.structure.ResultStatement"), callerConceptFqName, "virtual_isGuardClauseStatement_1237547327995", PARAMETERS_2974008768272238697, new Object[]{});
  }
}
