package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS 30.11.2006 15:55:54 */

import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;

public class NotExpression_Parens_Actions {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction("DELETE", new NotExpression_Parens_Actions_DELETE(node));
  }
}
