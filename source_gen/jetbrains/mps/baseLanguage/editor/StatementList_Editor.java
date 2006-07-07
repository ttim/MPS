package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Jul 7, 2006 6:27:44 PM */


import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import jetbrains.mps.nodeEditor.CellLayout_Vertical;
import java.awt.Color;
import jetbrains.mps.nodeEditor.EditorCell_Basic;

public class StatementList_Editor extends DefaultNodeEditor {

  public AbstractCellListHandler myStatementListHandler;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createStatementList(context, node);
  }
  public EditorCell createStatementList(EditorContext context, SNode node) {
    if(this.myStatementListHandler == null) {
      this.myStatementListHandler = new StatementList_Editor_StatementListHandler(node, "statement", context);
    }
    EditorCell_Collection editorCell = this.myStatementListHandler.createCells(context, new CellLayout_Vertical());
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.addKeyMap(new StatementList_KeyMap());
    editorCell.putUserObject(EditorCell.ROLE, this.myStatementListHandler.getElementRole());
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
}
