package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS 12.10.2006 0:05:55 */

import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;

public class BinaryOperation_Symbol_Actions {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction("DELETE", new BinaryOperation_Symbol_Actions_DELETE(node));
  }
}
