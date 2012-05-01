package jetbrains.mps.baseLanguage.regexp.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.ArrayList;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class MatchParensRegexp_Behavior {
  private static Class[] PARAMETERS_1222435297321 = {SNode.class, List.class};
  private static Class[] PARAMETERS_4204903511793602684 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_getString_1222432436326(SNode thisNode, List<SNode> vars) {
    ListSequence.fromList(vars).addElement(thisNode);
    return "(" + Regexp_Behavior.call_getString_1222432436326(SLinkOperations.getTarget(thisNode, "regexp", true), vars) + ")";
  }

  public static int call_getIndex_1223361984345(SNode thisNode) {
    SNode parens = thisNode;
    List<SNode> parensList = new ArrayList<SNode>();
    Regexp_Behavior.call_getString_1222432436326(Regexp_Behavior.call_getTopLevelRegexp_1223362823237(thisNode), parensList);
    return 1 + ListSequence.fromList(parensList).indexOf(parens);
  }

  public static SNode virtual_getValue_1224857430232(SNode thisNode) {
    throw new UnsupportedOperationException();
  }

  public static String call_getString_1222435297321(SNode thisNode, List<SNode> vars) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.MatchParensRegexp"), "virtual_getString_1222432436326", PARAMETERS_1222435297321, vars);
  }

  public static SNode call_getValue_4204903511793602684(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.MatchParensRegexp"), "virtual_getValue_1224857430232", PARAMETERS_4204903511793602684);
  }

  public static String callSuper_getString_1222435297321(SNode thisNode, String callerConceptFqName, List<SNode> vars) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.MatchParensRegexp"), callerConceptFqName, "virtual_getString_1222432436326", PARAMETERS_1222435297321, vars);
  }

  public static SNode callSuper_getValue_4204903511793602684(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.MatchParensRegexp"), callerConceptFqName, "virtual_getValue_1224857430232", PARAMETERS_4204903511793602684);
  }
}
