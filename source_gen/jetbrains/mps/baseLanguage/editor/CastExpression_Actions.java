package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Apr 5, 2006 2:16:43 PM */


import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;

public class CastExpression_Actions {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction("DELETE", new CastExpression_Actions_DELETE(node));
  }
}
