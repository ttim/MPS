package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class BreakStatement_Behavior {

  public static void init(SNode thisNode) {
  }

  public static SNode call_getLoop_1213877377001(SNode thisNode) {
    SNode loopOrSwitch = BreakStatement_Behavior.call_getLoopOrSwitch_1213877377041(thisNode);
    if (SNodeOperations.isInstanceOf(loopOrSwitch, "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement")) {
      return SNodeOperations.cast(loopOrSwitch, "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement");
    }
    return null;
  }

  public static SNode call_getSwitch_1213877377021(SNode thisNode) {
    SNode loopOrSwitch = BreakStatement_Behavior.call_getLoopOrSwitch_1213877377041(thisNode);
    if (SNodeOperations.isInstanceOf(loopOrSwitch, "jetbrains.mps.baseLanguage.structure.SwitchStatement")) {
      return SNodeOperations.cast(loopOrSwitch, "jetbrains.mps.baseLanguage.structure.SwitchStatement");
    }
    return null;
  }

  public static SNode call_getLoopOrSwitch_1213877377041(SNode thisNode) {
    for(SNode item : SNodeOperations.getAncestors(thisNode, null, false)) {
      if (SNodeOperations.isInstanceOf(item, "jetbrains.mps.baseLanguage.structure.SwitchStatement") && SPropertyOperations.getString(thisNode, "label") == null) {
        return item;
      }
      if (SNodeOperations.isInstanceOf(item, "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement")) {
        SNode loop = SNodeOperations.cast(item, "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement");
        if (SPropertyOperations.getString(thisNode, "label") == null) {
          if (SPropertyOperations.getString(loop, "label") == null) {
            return loop;
          }
        } else
        {
          if (SPropertyOperations.getString(thisNode, "label").equals(SPropertyOperations.getString(loop, "label"))) {
            return loop;
          }
        }
      }
    }
    return null;
  }

  public static boolean virtual_isGuardClauseStatement_1237547327995(SNode thisNode) {
    return true;
  }

}
