package jetbrains.mps.lang.checkedName.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;

public class PropertyRefType_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createConstant_hq6ii_a(editorContext, node);
  }

  private EditorCell createConstant_hq6ii_a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "propRef");
    editorCell.setCellId("Constant_hq6ii_a");
    editorCell.setDefaultText("");
    return editorCell;
  }
}
