package jetbrains.mps.langBeta.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;

public class AlphaConcept_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createConstant_5790_0(context, node, "alpha concept");
  }

  public EditorCell createConstant_5790_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_5790_0(editorCell, node, context);
    setupLabel_Constant_5790_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }


  private static void setupBasic_Constant_5790_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_5790_0");
  }

  private static void setupLabel_Constant_5790_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

}
