package jetbrains.mps.execution.commands.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class CommandBuilderExpression_Behavior {
  private static Class[] PARAMETERS_856705193941282164 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isLegalAsStatement_1239211900844(SNode thisNode) {
    return true;
  }

  public static String virtual_getVariableExpectedName_1213877519781(SNode thisNode) {
    return "process";
  }

  public static boolean call_isLegalAsStatement_856705193941282164(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.commands.structure.CommandBuilderExpression"), "virtual_isLegalAsStatement_1239211900844", PARAMETERS_856705193941282164);
  }

  public static boolean callSuper_isLegalAsStatement_856705193941282164(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.commands.structure.CommandBuilderExpression"), callerConceptFqName, "virtual_isLegalAsStatement_1239211900844", PARAMETERS_856705193941282164);
  }
}
