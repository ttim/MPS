package jetbrains.mps.bootstrap.structureLanguage.editor;

/*Generated by MPS*/


import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.semanticModel.SemanticNode;
import jetbrains.mps.nodeEditor.EditorCell_Error;
import java.awt.Color;

public class ConceptLink_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SemanticNode node) {
    return this.createErrorCell(context, node);
  }
  public EditorCell createErrorCell(EditorContext context, SemanticNode node) {
    EditorCell_Error editorCell = EditorCell_Error.create(context, node, "<choose link>");
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setEditable(true);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    ConceptLink_ConceptLinks_Menu.setCellActions(editorCell, node);
    return editorCell;
  }
}
