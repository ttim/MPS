package jetbrains.mps.build.packaging.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.io.File;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class Path_Behavior {
  private static Class[] PARAMETERS_1221141245424 = {SNode.class};

  public static void init(SNode thisNode) {
    SNode ref = SConceptOperations.createNewNode("jetbrains.mps.build.packaging.structure.MacroReference", null);
    SLinkOperations.setTarget(thisNode, "macro", ref, true);
  }

  public static String call_getFullPathWithoutMacro_1226511495568(SNode thisNode) {
    if ((SLinkOperations.getTarget(thisNode, "compositePathComponent", true) == null) || ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(thisNode, "compositePathComponent", true), "pathComponent", true)).count() == 0) {
      return "";
    }
    StringBuffer sb = new StringBuffer();
    for(SNode component : Sequence.fromIterable(SLinkOperations.getTargets(SLinkOperations.getTarget(thisNode, "compositePathComponent", true), "pathComponent", true))) {
      sb.append(SPropertyOperations.getString(component, "path"));
      sb.append(File.separator);
    }
    return sb.toString();
  }

  public static String virtual_getName_1221141245424(SNode thisNode) {
    if ((SLinkOperations.getTarget(thisNode, "compositePathComponent", true) == null) || ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(thisNode, "compositePathComponent", true), "pathComponent", true)).count() == 0) {
      return "";
    }
    return SPropertyOperations.getString(ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(thisNode, "compositePathComponent", true), "pathComponent", true)).last(), "path");
  }

  public static String call_getName_1221141245424(SNode thisNode) {
    return (String)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_getName_1221141245424", PARAMETERS_1221141245424);
  }

  public static String callSuper_getName_1221141245424(SNode thisNode, String callerConceptFqName) {
    return (String)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_getName_1221141245424", PARAMETERS_1221141245424);
  }

}
