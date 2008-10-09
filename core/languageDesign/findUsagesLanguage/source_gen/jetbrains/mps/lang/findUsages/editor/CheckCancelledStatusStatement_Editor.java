package jetbrains.mps.lang.findUsages.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;

public class CheckCancelledStatusStatement_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createConstant1207141899185(context, node, "check cancelled status;");
  }

  public EditorCell createConstant1207141899185(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12071418991851207141899185(editorCell, node, context);
    setupLabel_Constant_1207141899185_1207141899185(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }


  private static void setupBasic_Constant_12071418991851207141899185(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1207141899185");
  }

  private static void setupLabel_Constant_1207141899185_1207141899185(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

}
