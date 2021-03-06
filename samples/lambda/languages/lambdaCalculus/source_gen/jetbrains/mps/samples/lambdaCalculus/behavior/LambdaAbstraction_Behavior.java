package jetbrains.mps.samples.lambdaCalculus.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class LambdaAbstraction_Behavior {
  private static Class[] PARAMETERS_8981808925914844638 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode call_getInnerBody_5066394162984540354(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(thisNode, "body", true), "jetbrains.mps.samples.lambdaCalculus.structure.LambdaAbstraction")) {
      return LambdaAbstraction_Behavior.call_getInnerBody_5066394162984540354(SNodeOperations.cast(SLinkOperations.getTarget(thisNode, "body", true), "jetbrains.mps.samples.lambdaCalculus.structure.LambdaAbstraction"));
    }
    return SLinkOperations.getTarget(thisNode, "body", true);
  }

  public static List<SNode> call_getAllVariables_5066394162984559815(SNode thisNode) {
    List<SNode> result = new ArrayList<SNode>();
    // Is it OK to create lists recursively? 
    ListSequence.fromList(result).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "variable", true)));
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(thisNode, "body", true), "jetbrains.mps.samples.lambdaCalculus.structure.LambdaAbstraction")) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(LambdaAbstraction_Behavior.call_getAllVariables_5066394162984559815(SNodeOperations.cast(SLinkOperations.getTarget(thisNode, "body", true), "jetbrains.mps.samples.lambdaCalculus.structure.LambdaAbstraction"))));
    }
    return result;
  }

  public static List<SNode> virtual_getVariables_8981808925914841576(SNode thisNode) {
    return SLinkOperations.getTargets(thisNode, "variable", true);
  }

  public static List<SNode> call_getVariables_8981808925914844638(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.samples.lambdaCalculus.structure.LambdaAbstraction"), "virtual_getVariables_8981808925914841576", PARAMETERS_8981808925914844638, new Object[]{});
  }

  public static List<SNode> callSuper_getVariables_8981808925914844638(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.samples.lambdaCalculus.structure.LambdaAbstraction"), callerConceptFqName, "virtual_getVariables_8981808925914841576", PARAMETERS_8981808925914844638, new Object[]{});
  }
}
