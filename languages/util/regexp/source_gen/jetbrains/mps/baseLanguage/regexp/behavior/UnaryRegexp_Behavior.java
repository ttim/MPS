package jetbrains.mps.baseLanguage.regexp.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class UnaryRegexp_Behavior {
  private static Class[] PARAMETERS_1222867684394 = {SNode.class, List.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_getString_1222432436326(SNode thisNode, List<SNode> vars) {
    String s = Regexp_Behavior.call_getString_1222432436326(SLinkOperations.getTarget(thisNode, "regexp", true), vars);
    return ((UnaryRegexp_Behavior.call_inParentheses_1353467374623956744(thisNode) ?
      Regexp_Behavior.call_par_1222433790846(thisNode, s) :
      s
    )) + SConceptPropertyOperations.getString(thisNode, "alias");
  }

  public static boolean call_inParentheses_1353467374623956744(SNode thisNode) {
    return (SLinkOperations.getTarget(thisNode, "regexp", true) != null ?
      Regexp_Behavior.call_needParentheses_1353467374623880338(SLinkOperations.getTarget(thisNode, "regexp", true)) :
      true
    );
  }

  public static String call_getString_1222867684394(SNode thisNode, List<SNode> vars) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.UnaryRegexp"), "virtual_getString_1222432436326", PARAMETERS_1222867684394, new Object[]{vars});
  }

  public static String callSuper_getString_1222867684394(SNode thisNode, String callerConceptFqName, List<SNode> vars) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.UnaryRegexp"), callerConceptFqName, "virtual_getString_1222432436326", PARAMETERS_1222867684394, new Object[]{vars});
  }
}
