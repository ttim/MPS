package jetbrains.mps.lang.typesystem.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;

public class MultipleForeachLoopVariable_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_6386_f0hy8xt0(editorContext, node);
  }

  private EditorCell createCollection_6386_f0hy8xt0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_6386_f0hy8xt0");
    editorCell.addEditorCell(this.createRefNode_6386_f0hy8zwk(editorContext, node));
    editorCell.addEditorCell(this.createConstant_6386_f0hy92gn(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_6386_f0hy99o9(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_6386_f0hy92gn(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ":");
    editorCell.setCellId("Constant_6386_f0hy92gn");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createRefNode_6386_f0hy8zwk(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("variable");
    provider.setNoTargetText("<no variable>");
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

  private EditorCell createRefNode_6386_f0hy99o9(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("iterable");
    provider.setNoTargetText("<no iterable>");
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
