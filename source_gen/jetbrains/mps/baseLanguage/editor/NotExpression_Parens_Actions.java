package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Nov 20, 2006 12:14:57 PM */

import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;

public class NotExpression_Parens_Actions {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction("DELETE", new NotExpression_Parens_Actions_DELETE(node));
  }
}
