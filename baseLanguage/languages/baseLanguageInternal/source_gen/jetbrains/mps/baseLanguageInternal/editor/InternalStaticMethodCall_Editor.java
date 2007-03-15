package jetbrains.mps.baseLanguageInternal.editor;

/*Generated by MPS  */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import java.awt.Color;
import jetbrains.mps.baseLanguage.editor.BaseMethodCall_actualArgumentList;
import jetbrains.mps.nodeEditor.EditorCell_Constant;

public class InternalStaticMethodCall_Editor extends DefaultNodeEditor {

  public AbstractCellProvider myBaseMethodCall_actualArgumentList;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createRowCell(context, node);
  }
  public EditorCell createRowCell(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell(context, node, "."));
    editorCell.addEditorCell(this.createBaseMethodCall_actualArgumentListCell(context, node));
    editorCell.putUserObject(EditorCell.CELL_ID, "1173990744300");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createBaseMethodCall_actualArgumentListCell(EditorContext context, SNode node) {
    if(this.myBaseMethodCall_actualArgumentList == null) {
      this.myBaseMethodCall_actualArgumentList = new BaseMethodCall_actualArgumentList(node);
    }
    EditorCell componentCell = this.myBaseMethodCall_actualArgumentList.createEditorCell(context);
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.addEditorCell(componentCell);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1173992027127");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1173990746615");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
}
