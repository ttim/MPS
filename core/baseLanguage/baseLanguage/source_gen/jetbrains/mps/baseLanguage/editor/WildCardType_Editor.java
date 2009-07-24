package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;

public class WildCardType_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_9976_0(context, node);
  }

  public EditorCell createCollection_9976_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_9976_0(editorCell, node, context);
    editorCell.addEditorCell(this.createConstant_9976_0(context, node, "?"));
    return editorCell;
  }

  public EditorCell createConstant_9976_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_9976_0(editorCell, node, context);
    setupLabel_Constant_9976_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }


  private static void setupBasic_Collection_9976_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_9976_0");
  }

  private static void setupBasic_Constant_9976_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_9976_0");
  }

  private static void setupLabel_Constant_9976_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

}
