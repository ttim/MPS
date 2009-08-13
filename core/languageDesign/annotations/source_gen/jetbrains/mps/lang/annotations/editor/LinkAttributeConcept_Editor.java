package jetbrains.mps.lang.annotations.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;

public class LinkAttributeConcept_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_2506_0(editorContext, node);
  }

  private EditorCell createCollection_2506_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_2506_0");
    editorCell.addEditorCell(this.createConstant_2506_0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_2506_1(editorContext, node));
    editorCell.addEditorCell(this.createConstant_2506_2(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_2506_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "$(");
    editorCell.setCellId("Constant_2506_0");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_2506_1(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<reference cell>");
    editorCell.setCellId("Constant_2506_1");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_2506_2(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ")$");
    editorCell.setCellId("Constant_2506_2");
    editorCell.setDefaultText("");
    return editorCell;
  }

}
