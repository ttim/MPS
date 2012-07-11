package jetbrains.mps.baseLanguage.regexp.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class OrRegexp_Behavior {
  private static Class[] PARAMETERS_1222434354398 = {SNode.class, List.class};
  private static Class[] PARAMETERS_1353467374623956023 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_getString_1222432436326(SNode thisNode, List<SNode> vars) {
    String s = Regexp_Behavior.call_getString_1222432436326(SLinkOperations.getTarget(thisNode, "left", true), vars) + "|" + Regexp_Behavior.call_getString_1222432436326(SLinkOperations.getTarget(thisNode, "right", true), vars);
    return (OrRegexp_Behavior.call_inParentheses_1353467374623956858(thisNode) ?
      Regexp_Behavior.call_par_1222433790846(thisNode, s) :
      s
    );
  }

  public static boolean virtual_needParentheses_1353467374623880338(SNode thisNode) {
    return true;
  }

  public static boolean call_inParentheses_1353467374623956858(SNode thisNode) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.baseLanguage.regexp.structure.SeqRegexp");
  }

  public static String call_getString_1222434354398(SNode thisNode, List<SNode> vars) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.OrRegexp"), "virtual_getString_1222432436326", PARAMETERS_1222434354398, new Object[]{vars});
  }

  public static boolean call_needParentheses_1353467374623956023(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.OrRegexp"), "virtual_needParentheses_1353467374623880338", PARAMETERS_1353467374623956023, new Object[]{});
  }

  public static String callSuper_getString_1222434354398(SNode thisNode, String callerConceptFqName, List<SNode> vars) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.OrRegexp"), callerConceptFqName, "virtual_getString_1222432436326", PARAMETERS_1222434354398, new Object[]{vars});
  }

  public static boolean callSuper_needParentheses_1353467374623956023(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.OrRegexp"), callerConceptFqName, "virtual_needParentheses_1353467374623880338", PARAMETERS_1353467374623956023, new Object[]{});
  }
}
