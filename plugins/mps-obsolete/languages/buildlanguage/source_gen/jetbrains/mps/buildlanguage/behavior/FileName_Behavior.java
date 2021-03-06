package jetbrains.mps.buildlanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import java.io.File;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class FileName_Behavior {
  public static void init(SNode thisNode) {
    SLinkOperations.setTarget(thisNode, "value", SConceptOperations.createNewNode("jetbrains.mps.buildlanguage.structure.StringLiteral", null), true);
  }

  public static String virtual_toString_1213877472569(SNode thisNode) {
    if ((SLinkOperations.getTarget(thisNode, "value", true) == null)) {
      return "";
    }
    return PropertyValueExpression_Behavior.call_toString_1213877472569(SLinkOperations.getTarget(thisNode, "value", true));
  }

  public static boolean call_exists_1213877511925(SNode thisNode) {
    String filename = PropertyValueExpression_Behavior.call_getActualValue_1213877472572(thisNode);
    File f = new File(filename);
    if (f.exists()) {
      return true;
    }
    SNode root = SNodeOperations.getContainingRoot(thisNode);
    if (SNodeOperations.isInstanceOf(root, "jetbrains.mps.buildlanguage.structure.Project")) {
      SNode project = SNodeOperations.cast(root, "jetbrains.mps.buildlanguage.structure.Project");
      if ((SLinkOperations.getTarget(project, "basedir", true) == null)) {
        return false;
      }
      f = new File(PropertyValueExpression_Behavior.call_toString_1213877472569(SLinkOperations.getTarget(project, "basedir", true)), filename);
      return f.exists();
    }
    return true;
  }

  public static String virtual_getActualValue_1213877472572(SNode thisNode) {
    return PropertyValueExpression_Behavior.call_getActualValue_1213877472572(SLinkOperations.getTarget(thisNode, "value", true));
  }
}
