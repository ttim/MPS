package jetbrains.mps.lang.plugin.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class AbstractEditorTab_Behavior {

  public static void init(SNode thisNode) {
  }

  public static String call_getGeneratedName_1213877534648(SNode thisNode) {
    return NameUtil.toValidIdentifier(SPropertyOperations.getString(thisNode, "name")) + "_Tab";
  }

  public static String call_getGeneratedClassFQName_1213877534658(SNode thisNode) {
    return SNodeOperations.getModel(thisNode).getLongName() + "." + AbstractEditorTab_Behavior.call_getGeneratedName_1213877534648(thisNode);
  }

}
