package jetbrains.mps.lang.editor.editor;

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

public class CellModel_JComponent_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createConstant_3375_0(context, node, "$swing component$");
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection_3375_0(context, node);
  }

  private EditorCell createCollection_3375_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    editorCell.setCellId("Collection_3375_0");
    editorCell.addEditorCell(this.createCollection_3375_1(context, node));
    return editorCell;
  }

  private EditorCell createCollection_3375_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setCellId("Collection_3375_1");
    editorCell.addEditorCell(this.createConstant_3375_1(context, node, "component provider:"));
    editorCell.addEditorCell(this.createRefNode_3375_0(context, node));
    return editorCell;
  }

  private EditorCell createConstant_3375_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_3375_0");
    Styles_StyleSheet.getRootCellModelStyle(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_3375_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_3375_1");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createRefNode_3375_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("componentProvider");
    provider.setNoTargetText("<no componentProvider>");
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
