package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS 16.05.2006 16:59:00 */


import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;

public class BinaryOperation_Symbol_Actions {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction("DELETE", new BinaryOperation_Symbol_Actions_DELETE(node));
  }
}
