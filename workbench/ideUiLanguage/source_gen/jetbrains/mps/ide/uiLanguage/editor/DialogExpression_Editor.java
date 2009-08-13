package jetbrains.mps.ide.uiLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;

public class DialogExpression_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createConstant_6324_0(editorContext, node);
  }

  private EditorCell createConstant_6324_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "dialog");
    editorCell.setCellId("Constant_6324_0");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

}
