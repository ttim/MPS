package jetbrains.mps.buildScript.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.buildScript.util.Context;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class BuildFolderMacro_Behavior {
  public static void init(SNode thisNode) {
  }

  public static String call_evaluate_4959435991187146982(SNode thisNode, Context context) {
    String key = "usedMacro";
    Set<String> usedMacro = context.<Set<String>>get(key);
    if (usedMacro == null) {
      usedMacro = SetSequence.fromSet(new HashSet<String>());
      context.put(key, usedMacro);
    }
    if (SetSequence.fromSet(usedMacro).contains(SPropertyOperations.getString(thisNode, "name"))) {
      // cycle 
      return null;
    }
    SetSequence.fromSet(usedMacro).addElement(SPropertyOperations.getString(thisNode, "name"));

    return BuildSourcePath_Behavior.call_getLocalPath_5481553824944787364(SLinkOperations.getTarget(thisNode, "defaultPath", true), context);
  }
}
