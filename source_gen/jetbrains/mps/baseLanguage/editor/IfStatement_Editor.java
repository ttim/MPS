package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS*/


import jetbrains.mps.nodeEditor.SemanticNodeEditor;
import jetbrains.mps.semanticModel.SemanticNode;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.EditorCell_Error;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.baseLanguage.IfStatement;

public class IfStatement_Editor extends SemanticNodeEditor {
  public static String MATCHING_TEXT = "if";

  public void setSemanticNode(SemanticNode node) {
    super.setSemanticNode(node);
  }
  public EditorCell createEditorCell(EditorContext editorContext, SemanticNode node) {
    return this.createStatementBox(editorContext, node);
  }
  public EditorCell createStatementBox(EditorContext editorContext, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setGridLayout(false);
    IfStatement_NodeBoxActions.setCellActions(editorCell, node);
    editorCell.addEditorCell(this.createHeaderRow(editorContext, node));
    editorCell.addEditorCell(this.createIfTrueBox(editorContext, node));
    if(this.handleConditionalQuery_1075379536707(node)) {
      editorCell.addEditorCell(this.createIfFalseBranch(editorContext, node));
    }
    if(this.handleConditionalQuery_1075379580458(node)) {
      editorCell.addEditorCell(this.createConstantCell3(editorContext, node, "}"));
    }
    return editorCell;
  }
  public EditorCell createHeaderRow(EditorContext editorContext, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setGridLayout(false);
    editorCell.addEditorCell(this.createConstantCell(editorContext, node, "if ("));
    editorCell.addEditorCell(this.createConditionCell(editorContext, node));
    editorCell.addEditorCell(this.createConstantCell1(editorContext, node, ") {"));
    return editorCell;
  }
  public EditorCell createConstantCell(EditorContext editorContext, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(editorContext, node, text, false);
    return editorCell;
  }
  public EditorCell createConditionCell(EditorContext editorContext, SemanticNode node) {
    SemanticNode condition = node.getReferent("condition", (SemanticNode)null);
    EditorCell editorCell = null;
    if(condition != null) {
      editorCell = this.nodeCell(editorContext, condition);
      IfStatement_ConditionCellActions.setCellActions(editorCell, node);
    } else {
      editorCell = EditorCell_Error.create(editorContext, node, null);
      IfStatement_ConditionCellActions.setCellActions(editorCell, node);
      _DefErrorActions.setCellActions(editorCell, node);
}
    return editorCell;
  }
  public EditorCell createConstantCell1(EditorContext editorContext, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(editorContext, node, text, false);
    return editorCell;
  }
  public EditorCell createIfTrueBox(EditorContext editorContext, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setGridLayout(false);
    editorCell.addEditorCell(this.createIndentCell(editorContext, node, "  "));
    editorCell.addEditorCell(this.createIfTrueCell(editorContext, node));
    return editorCell;
  }
  public EditorCell createIndentCell(EditorContext editorContext, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(editorContext, node, text, false);
    return editorCell;
  }
  public EditorCell createIfTrueCell(EditorContext editorContext, SemanticNode node) {
    SemanticNode ifTrue = node.getReferent("ifTrue", (SemanticNode)null);
    EditorCell editorCell = null;
    if(ifTrue != null) {
      editorCell = this.nodeCell(editorContext, ifTrue);
    } else {
      editorCell = EditorCell_Error.create(editorContext, node, null);
}
    return editorCell;
  }
  public EditorCell createIfFalseBranch(EditorContext editorContext, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setSelectable(false);
    editorCell.setGridLayout(false);
    editorCell.addEditorCell(this.createConstantCell2(editorContext, node, "} else"));
    editorCell.addEditorCell(this.createIfFalseStatementCell(editorContext, node));
    return editorCell;
  }
  public EditorCell createConstantCell2(EditorContext editorContext, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(editorContext, node, text, false);
    return editorCell;
  }
  public EditorCell createIfFalseStatementCell(EditorContext editorContext, SemanticNode node) {
    SemanticNode ifFalseStatement = node.getReferent("ifFalseStatement", (SemanticNode)null);
    EditorCell editorCell = null;
    if(ifFalseStatement != null) {
      editorCell = this.nodeCell(editorContext, ifFalseStatement);
      IfStatement_ElseStatementActions.setCellActions(editorCell, node);
    } else {
      editorCell = EditorCell_Constant.create(editorContext, node, "", true);
      ((EditorCell_Label)editorCell).setEditable(true);
      IfStatement_ElseStatementActions.setCellActions(editorCell, node);
}
    return editorCell;
  }
  public EditorCell createConstantCell3(EditorContext editorContext, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(editorContext, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setEditable(false);
    IfStatement_IfClosingBracketActions.setCellActions(editorCell, node);
    return editorCell;
  }
  public boolean handleConditionalQuery_1075379536707(SemanticNode node) {
    IfStatement ifStatement = (IfStatement)node;
    return ifStatement.getIfFalseStatement() != null;
  }
  public boolean handleConditionalQuery_1075379580458(SemanticNode node) {
    IfStatement ifStatement = (IfStatement)node;
    return ifStatement.getIfFalseStatement() == null;
  }
}
