package jetbrains.mps.nanoj.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cells.EditorCell_Indent;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;

public class NanoClass_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_6536_0(context, node);
  }

  private EditorCell createCollection_6536_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    editorCell.setCellId("Collection_6536_0");
    editorCell.addEditorCell(this.createCollection_6536_1(context, node));
    editorCell.addEditorCell(this.createCollection_6536_2(context, node));
    editorCell.addEditorCell(this.createCollection_6536_3(context, node));
    return editorCell;
  }

  private EditorCell createCollection_6536_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setCellId("Collection_6536_1");
    editorCell.addEditorCell(this.createConstant_6536_0(context, node, "class"));
    editorCell.addEditorCell(this.createConstant_6536_1(context, node, "{"));
    return editorCell;
  }

  private EditorCell createCollection_6536_2(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setCellId("Collection_6536_2");
    editorCell.addEditorCell(this.createIndentCell6536_0(context, node));
    editorCell.addEditorCell(this.createRefNode_6536_0(context, node));
    return editorCell;
  }

  private EditorCell createCollection_6536_3(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setCellId("Collection_6536_3");
    editorCell.addEditorCell(this.createConstant_6536_2(context, node, "}"));
    return editorCell;
  }

  private EditorCell createConstant_6536_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_6536_0");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_6536_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_6536_1");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_6536_2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_6536_2");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createIndentCell6536_0(EditorContext context, SNode node) {
    EditorCell_Indent result = new EditorCell_Indent(context, node);
    return result;
  }

  private EditorCell createRefNode_6536_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("statement");
    provider.setNoTargetText("<no statement>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

}
