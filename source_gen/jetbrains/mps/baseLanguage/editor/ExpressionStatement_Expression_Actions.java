package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Sep 25, 2006 5:23:11 PM */

import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;

public class ExpressionStatement_Expression_Actions {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction("DELETE", new ExpressionStatement_Expression_Actions_DELETE(node));
  }
}
