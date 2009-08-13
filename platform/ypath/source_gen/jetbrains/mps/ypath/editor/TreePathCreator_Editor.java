package jetbrains.mps.ypath.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;

public class TreePathCreator_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_6851_0(editorContext, node);
  }

  private EditorCell createCollection_6851_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_6851_0");
    editorCell.addEditorCell(this.createComponent_6851_0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_6851_0(editorContext, node, "("));
    editorCell.addEditorCell(this.createRefNode_6851_0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_6851_1(editorContext, node, ","));
    editorCell.addEditorCell(this.createRefNode_6851_1(editorContext, node));
    editorCell.addEditorCell(this.createConstant_6851_2(editorContext, node, ")"));
    return editorCell;
  }

  private EditorCell createComponent_6851_0(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new TreePath_component(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    return editorCell;
  }

  private EditorCell createConstant_6851_0(EditorContext editorContext, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, text);
    editorCell.setCellId("Constant_6851_0");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_6851_1(EditorContext editorContext, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, text);
    editorCell.setCellId("Constant_6851_1");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_6851_2(EditorContext editorContext, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, text);
    editorCell.setCellId("Constant_6851_2");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createRefNode_6851_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("parentBlock");
    provider.setNoTargetText("<no parentBlock>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createRefNode_6851_1(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("childrenBlock");
    provider.setNoTargetText("<no childrenBlock>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

}
