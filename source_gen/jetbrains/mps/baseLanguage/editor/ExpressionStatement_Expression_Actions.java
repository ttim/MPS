package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Jul 5, 2006 1:58:55 PM */


import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;

public class ExpressionStatement_Expression_Actions {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction("DELETE", new ExpressionStatement_Expression_Actions_DELETE(node));
  }
}
