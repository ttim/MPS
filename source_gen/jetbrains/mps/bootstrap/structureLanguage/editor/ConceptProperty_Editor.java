package jetbrains.mps.bootstrap.structureLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Error;
import java.awt.Color;

public class ConceptProperty_Editor extends DefaultNodeEditor {

  private static void setupErrorCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1105728957754");
    editorCell.setDrawBorder(false);
  }

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createErrorCell(context, node);
  }
  public EditorCell createErrorCell(EditorContext context, SNode node) {
    EditorCell_Error editorCell = EditorCell_Error.create(context, node, "<choose property>");
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(true);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1105728957754");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
}
