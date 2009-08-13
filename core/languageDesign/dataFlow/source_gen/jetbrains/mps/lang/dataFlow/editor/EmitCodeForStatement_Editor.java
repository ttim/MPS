package jetbrains.mps.lang.dataFlow.editor;

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

public class EmitCodeForStatement_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_4758_0(context, node);
  }

  private EditorCell createCollection_4758_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    editorCell.setCellId("Collection_4758_0");
    editorCell.addEditorCell(this.createConstant_4758_0(context, node, "code"));
    editorCell.addEditorCell(this.createConstant_4758_1(context, node, "for"));
    editorCell.addEditorCell(this.createRefNode_4758_0(context, node));
    return editorCell;
  }

  private EditorCell createConstant_4758_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_4758_0");
    DataFlow_StyleSheet.getInstruction(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4758_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_4758_1");
    DataFlow_StyleSheet.getInstruction(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createRefNode_4758_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("codeFor");
    provider.setNoTargetText("<no codeFor>");
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
