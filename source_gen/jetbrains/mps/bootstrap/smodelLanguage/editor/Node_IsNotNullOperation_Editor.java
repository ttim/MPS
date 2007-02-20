package jetbrains.mps.bootstrap.smodelLanguage.editor;

/*Generated by MPS  */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import java.awt.Color;

public class Node_IsNotNullOperation_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createConstantCell(context, node, "isNotNull");
  }
  public EditorCell createConstantCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(true);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1172008340176");
    editorCell.setLayoutConstraint("");
    editorCell.putUserObject(EditorCell.ATTRACTS_FOCUS_POLICY, EditorCell.ATTRACTS_FOCUS);
    return editorCell;
  }
}
