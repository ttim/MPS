package jetbrains.mps.lang.plugin.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class TabbedEditorDeclaration_Behavior {

  public static void init(SNode thisNode) {
  }

  public static String call_getGeneratedName_1213877237161(SNode thisNode) {
    return NameUtil.toValidIdentifier(SPropertyOperations.getString(thisNode, "name")) + "_TabbedEditor";
  }

  public static String call_getGeneratedClassFQName_1213877237171(SNode thisNode) {
    return SNodeOperations.getModel(thisNode).getLongName() + "." + TabbedEditorDeclaration_Behavior.call_getGeneratedName_1213877237161(thisNode);
  }

}
