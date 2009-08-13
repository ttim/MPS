package jetbrains.mps.ide.uiLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;

public class DisposeDialogStatement_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_0836_0(context, node);
  }

  private EditorCell createCollection_0836_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setCellId("Collection_0836_0");
    editorCell.addEditorCell(this.createConstant_0836_0(context, node, "disposeDialog"));
    editorCell.addEditorCell(this.createConstant_0836_1(context, node, ";"));
    return editorCell;
  }

  private EditorCell createConstant_0836_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_0836_0");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_0836_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_0836_1");
    BaseLanguageStyle_StyleSheet.getSemicolon(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

}
