package jetbrains.mps.samples.formulaLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Error;

public class Constant_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createError_2040_0(context, node);
  }

  private EditorCell createError_2040_0(EditorContext context, SNode node) {
    EditorCell_Error editorCell = new EditorCell_Error(context, node, "?constant?");
    editorCell.setCellId("Error_2040_0");
    return editorCell;
  }

}
