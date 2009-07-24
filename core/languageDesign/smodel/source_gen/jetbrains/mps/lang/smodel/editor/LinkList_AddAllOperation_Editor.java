package jetbrains.mps.lang.smodel.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;

public class LinkList_AddAllOperation_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider myReplaceableAlias_Comp2492_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_2492_0(context, node);
  }

  public EditorCell createCollection_2492_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_2492_0(editorCell, node, context);
    editorCell.addEditorCell(this.createComponent_2492_0(context, node));
    editorCell.addEditorCell(this.createConstant_2492_0(context, node, "("));
    editorCell.addEditorCell(this.createRefNode_2492_1(context, node));
    editorCell.addEditorCell(this.createConstant_2492_1(context, node, ")"));
    return editorCell;
  }

  public EditorCell createComponent_2492_0(EditorContext context, SNode node) {
    if (this.myReplaceableAlias_Comp2492_0 == null) {
      this.myReplaceableAlias_Comp2492_0 = new ReplaceableAlias_Comp(node);
    }
    EditorCell editorCell = this.myReplaceableAlias_Comp2492_0.createEditorCell(context);
    setupBasic_Component_2492_0(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createConstant_2492_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_2492_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_2492_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_2492_1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNode_2492_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_2492_0(editorCell, node, context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_2492_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("childNodes");
    provider.setNoTargetText("<no childNodes>");
    EditorCell cellWithRole = this.createRefNode_2492_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_2492_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_2492_0");
  }

  private static void setupBasic_RefNode_2492_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Component_2492_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Constant_2492_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_2492_0");
    BaseLanguageStyle_StyleSheet.getLeftParenAfterName(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_2492_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_2492_1");
    BaseLanguageStyle_StyleSheet.getRightParen(editorCell).apply(editorCell);
  }

}
