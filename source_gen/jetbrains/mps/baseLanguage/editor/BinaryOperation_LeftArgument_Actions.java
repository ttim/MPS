package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Nov 20, 2006 7:19:45 PM */

import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;

public class BinaryOperation_LeftArgument_Actions {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction("DELETE", new BinaryOperation_LeftArgument_Actions_DELETE(node));
  }
}
