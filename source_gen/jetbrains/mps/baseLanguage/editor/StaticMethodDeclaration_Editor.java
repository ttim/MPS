package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS*/


import jetbrains.mps.nodeEditor.SemanticNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.semanticModel.SemanticNode;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.EditorCell_Error;
import jetbrains.mps.nodeEditor.ModelAccessor;
import jetbrains.mps.nodeEditor.PropertyAccessor;
import jetbrains.mps.nodeEditor.EditorCell_Property;

public class StaticMethodDeclaration_Editor extends SemanticNodeEditor {

  private AbstractCellProvider my_BaseMethodParmListEditor;

  public void setSemanticNode(SemanticNode node) {
    super.setSemanticNode(node);
    my_BaseMethodParmListEditor = new _BaseMethodParmListEditor(node);
  }
  public EditorCell createEditorCell(EditorContext editorContext, SemanticNode node) {
    return this.createMethodBox(editorContext, node);
  }
  public EditorCell createMethodBox(EditorContext editorContext, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setSelectable(true);
    editorCell.setGridLayout(false);
    MethodDeclaration_NodeBoxActions.setCellActions(editorCell, node);
    editorCell.addEditorCell(this.createHeaderRow(editorContext, node));
    editorCell.addEditorCell(this.createBodyArea(editorContext, node));
    editorCell.addEditorCell(this.createConstantCell3(editorContext, node, "}"));
    return editorCell;
  }
  public EditorCell createHeaderRow(EditorContext editorContext, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setSelectable(true);
    editorCell.setGridLayout(false);
    editorCell.addEditorCell(this.createConstantCell(editorContext, node, "static"));
    editorCell.addEditorCell(this.createReturnType(editorContext, node));
    editorCell.addEditorCell(this.createMethodName(editorContext, node));
    editorCell.addEditorCell(this.createConstantCell1(editorContext, node, "("));
    editorCell.addEditorCell(this.create_BaseMethodParmListEditorCell(editorContext, node));
    editorCell.addEditorCell(this.createConstantCell2(editorContext, node, ")"));
    return editorCell;
  }
  public EditorCell createConstantCell(EditorContext editorContext, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(editorContext, node, text, false);
    return editorCell;
  }
  public EditorCell createReturnType(EditorContext editorContext, SemanticNode node) {
    SemanticNode returnType = node.getReferent("returnType", (SemanticNode)null);
    EditorCell editorCell = null;
    if(returnType != null) {
      editorCell = this.nodeCell(editorContext, returnType);
      MethodDeclaration_ReturnTypeCellActions.setCellActions(editorCell, node);
    } else {
      editorCell = EditorCell_Error.create(editorContext, node, null);
      MethodDeclaration_ReturnTypeCellActions.setCellActions(editorCell, node);
}
    return editorCell;
  }
  public EditorCell createMethodName(EditorContext editorContext, SemanticNode node) {
    ModelAccessor modelAccessor = new PropertyAccessor(node, "name", true, false);
    EditorCell_Property editorCell = EditorCell_Property.create(editorContext, modelAccessor, node);
    editorCell.setDefaultText("<no name>");
    return editorCell;
  }
  public EditorCell createConstantCell1(EditorContext editorContext, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(editorContext, node, text, false);
    editorCell.setSelectable(false);
    return editorCell;
  }
  public EditorCell create_BaseMethodParmListEditorCell(EditorContext editorContext, SemanticNode node) {
    EditorCell editorCell = my_BaseMethodParmListEditor.createEditorCell(editorContext);
    return editorCell;
  }
  public EditorCell createConstantCell2(EditorContext editorContext, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(editorContext, node, text, false);
    editorCell.setSelectable(false);
    return editorCell;
  }
  public EditorCell createBodyArea(EditorContext editorContext, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setSelectable(false);
    editorCell.setGridLayout(false);
    editorCell.addEditorCell(this.createIndentCell(editorContext, node, "  "));
    editorCell.addEditorCell(this.createBodyCell(editorContext, node));
    return editorCell;
  }
  public EditorCell createIndentCell(EditorContext editorContext, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(editorContext, node, text, false);
    return editorCell;
  }
  public EditorCell createBodyCell(EditorContext editorContext, SemanticNode node) {
    SemanticNode body = node.getReferent("body", (SemanticNode)null);
    EditorCell editorCell = null;
    if(body != null) {
      editorCell = this.nodeCell(editorContext, body);
    } else {
      editorCell = EditorCell_Error.create(editorContext, node, null);
}
    return editorCell;
  }
  public EditorCell createConstantCell3(EditorContext editorContext, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(editorContext, node, text, false);
    editorCell.setSelectable(false);
    return editorCell;
  }
}
