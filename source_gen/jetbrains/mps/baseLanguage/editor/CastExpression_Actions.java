package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Apr 6, 2006 7:48:11 PM */


import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;

public class CastExpression_Actions {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction("DELETE", new CastExpression_Actions_DELETE(node));
  }
}
