package jetbrains.mps.lang.typesystem.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;

public class Node_TypeOperation_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createConstant_4604_0(editorContext, node);
  }

  public EditorCell createInspectedCell(EditorContext editorContext, SNode node) {
    return this.createComponent_4604_0(editorContext, node);
  }

  private EditorCell createComponent_4604_0(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new _NotInRules_Component(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    return editorCell;
  }

  private EditorCell createConstant_4604_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "type");
    editorCell.setCellId("Constant_4604_0");
    editorCell.setDefaultText("");
    return editorCell;
  }
}
