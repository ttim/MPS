package jetbrains.mps.bootstrap.smodelLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.nodeEditor.EditorCell_Constant;

public class Node_IsNotNullOperation_Editor extends DefaultNodeEditor {

  private static void setupBasic_ConstantCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1172008340176");
    editorCell.setDrawBorder(false);
    editorCell.putUserObject(EditorCell.ATTRACTS_FOCUS_POLICY, EditorCell.ATTRACTS_FOCUS);
  }

  private static void setupLabel_ConstantCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
    editorCell.setEditable(true);
  }


  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createConstantCell(context, node, "isNotNull");
  }

  public EditorCell createConstantCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    Node_IsNotNullOperation_Editor.setupBasic_ConstantCell(editorCell, node, context);
    Node_IsNotNullOperation_Editor.setupLabel_ConstantCell(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

}
