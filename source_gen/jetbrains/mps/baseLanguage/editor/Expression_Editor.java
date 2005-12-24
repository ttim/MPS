package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Dec 24, 2005 1:49:04 AM */


import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorCell_Error;
import java.awt.Color;

public class Expression_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createErrorCell(context, node);
  }
  public EditorCell createErrorCell(EditorContext context, SNode node) {
    EditorCell_Error editorCell = EditorCell_Error.create(context, node, "<expression>");
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(true);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    Expression_NodeBoxActions.setCellActions(editorCell, node, context);
    editorCell.addKeyMap(new _Expression_KeyMap());
    editorCell.putUserObject(EditorCell.CELL_ID, "1075376431437");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
}
