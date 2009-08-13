package jetbrains.mps.nanoj.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Error;

public class NanoStatement_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createError_4401_0(context, node);
  }

  private EditorCell createError_4401_0(EditorContext context, SNode node) {
    EditorCell_Error editorCell = new EditorCell_Error(context, node, "<abstract statement>");
    editorCell.setCellId("Error_4401_0");
    return editorCell;
  }

}
