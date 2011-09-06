package jetbrains.mps.baseLanguage.regexp.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.structure.BehaviorDescriptor;
import jetbrains.mps.smodel.structure.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class MatchVariableReferenceReplacement_Behavior {
  private static Class[] PARAMETERS_3796137614137539495 = {SNode.class, SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_toString_3796137614137538905(SNode thisNode, SNode search) {
    List<SNode> vars = new ArrayList<SNode>();
    Regexp_Behavior.call_getString_1222432436326(search, vars);
    return "$" + (ListSequence.fromList(vars).indexOf(SLinkOperations.getTarget(thisNode, "match", false)) + 1);
  }

  public static String call_toString_3796137614137539495(SNode thisNode, SNode search) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.MatchVariableReferenceReplacement"), "virtual_toString_3796137614137538905", PARAMETERS_3796137614137539495, search);
  }

  public static String callSuper_toString_3796137614137539495(SNode thisNode, String callerConceptFqName, SNode search) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.MatchVariableReferenceReplacement"), callerConceptFqName, "virtual_toString_3796137614137538905", PARAMETERS_3796137614137539495, search);
  }
}
