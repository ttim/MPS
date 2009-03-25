package jetbrains.mps.lang.editor.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.editor.behavior.CellMenuDescriptor_Behavior;

public class CellMenuUtil {

  private CellMenuUtil() {
  }

  public static SNode getEditedFeature(SNode node) {
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.editor.structure.CellMenuPart_Abstract")) {
      return getEditedFeature(SNodeOperations.getParent(node));
    }
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.editor.structure.CellMenuDescriptor")) {
      return CellMenuDescriptor_Behavior.call_getEditedFeature_1220342015727(node);
    }
    return null;
  }

}
