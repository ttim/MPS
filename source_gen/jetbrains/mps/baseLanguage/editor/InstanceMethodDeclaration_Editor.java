package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS*/


import jetbrains.mps.nodeEditor.SemanticNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.semanticModel.SemanticNode;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.nodeEditor.CellAction_DeleteNode;
import jetbrains.mps.nodeEditor.EditorCell_Error;
import jetbrains.mps.nodeEditor.CellAction_Empty;
import jetbrains.mps.nodeEditor.ModelAccessor;
import jetbrains.mps.nodeEditor.PropertyAccessor;
import jetbrains.mps.nodeEditor.EditorCell_Property;
import jetbrains.mps.nodeEditor.CellAction_DeleteProperty;
import jetbrains.mps.nodeEditor.EditorCell_Constant;

public class InstanceMethodDeclaration_Editor extends SemanticNodeEditor {

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
    InstanceMethodDeclaration_NodeBoxActions.setCellActions(editorCell, node);
    editorCell.addEditorCell(this.createHeaderRow(editorContext, node));
    editorCell.addEditorCell(this.createBodyArea(editorContext, node));
    editorCell.addEditorCell(this.createConstantCell2(editorContext, node, "}"));
    return editorCell;
  }
  public EditorCell createHeaderRow(EditorContext editorContext, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setSelectable(true);
    editorCell.setGridLayout(false);
    editorCell.addEditorCell(this.createReturnType(editorContext, node));
    editorCell.addEditorCell(this.createMethodName(editorContext, node));
    editorCell.addEditorCell(this.createConstantCell(editorContext, node, "("));
    editorCell.addEditorCell(this.create_BaseMethodParmListEditorCell(editorContext, node));
    editorCell.addEditorCell(this.createConstantCell1(editorContext, node, ")"));
    return editorCell;
  }
  public EditorCell createReturnType(EditorContext editorContext, SemanticNode node) {
    SemanticNode returnType = node.getReferent("returnType", (SemanticNode)null);
    EditorCell editorCell = null;
    if(returnType != null) {
      editorCell = editorContext.createNodeCell(returnType);
      editorCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteNode(returnType));
      InstanceMethodDeclaration_ReturnTypeCellActions.setCellActions(editorCell, node);
    } else {
      editorCell = EditorCell_Error.create(editorContext, node, "<no return type>");
      editorCell.setAction(EditorCellAction.DELETE, new CellAction_Empty());
      InstanceMethodDeclaration_ReturnTypeCellActions.setCellActions(editorCell, node);
    }
    return editorCell;
  }
  public EditorCell createMethodName(EditorContext editorContext, SemanticNode node) {
    ModelAccessor modelAccessor = new PropertyAccessor(node, "name", true, false);
    EditorCell_Property editorCell = EditorCell_Property.create(editorContext, modelAccessor, node);
    editorCell.setDefaultText("<no name>");
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteProperty(node, "name"));
    return editorCell;
  }
  public EditorCell createConstantCell(EditorContext editorContext, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(editorContext, node, text, false);
    editorCell.setSelectable(false);
    return editorCell;
  }
  public EditorCell create_BaseMethodParmListEditorCell(EditorContext editorContext, SemanticNode node) {
    EditorCell editorCell = my_BaseMethodParmListEditor.createEditorCell(editorContext);
    return editorCell;
  }
  public EditorCell createConstantCell1(EditorContext editorContext, SemanticNode node, String text) {
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
      editorCell = editorContext.createNodeCell(body);
      editorCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteNode(body));
    } else {
      editorCell = EditorCell_Error.create(editorContext, node, null);
      editorCell.setAction(EditorCellAction.DELETE, new CellAction_Empty());
    }
    return editorCell;
  }
  public EditorCell createConstantCell2(EditorContext editorContext, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(editorContext, node, text, false);
    editorCell.setSelectable(false);
    return editorCell;
  }
}
