package jetbrains.mps.lang.editor.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;

public class CellModel_Custom_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_8637_0(editorContext, node);
  }

  public EditorCell createInspectedCell(EditorContext editorContext, SNode node) {
    return this.createCollection_8637_1(editorContext, node);
  }

  private EditorCell createCollection_8637_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_8637_0");
    Styles_StyleSheet.getBorderedCollection(editorCell).apply(editorCell);
    editorCell.addEditorCell(this.createComponent_8637_0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_8637_2(editorContext, node));
    editorCell.addEditorCell(this.createComponent_8637_1(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_8637_1(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_8637_1");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createComponent_8637_2(editorContext, node));
    editorCell.addEditorCell(this.createConstant_8637_3(editorContext, node));
    editorCell.addEditorCell(this.createConstant_8637_0(editorContext, node));
    editorCell.addEditorCell(this.createCollection_8637_3(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_8637_2(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_8637_2");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_8637_1(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_8637_0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_8637_3(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_8637_3");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.DRAW_BORDER, true);
    }
    editorCell.setGridLayout(true);
    editorCell.addEditorCell(this.createCollection_8637_2(editorContext, node));
    return editorCell;
  }

  private EditorCell createComponent_8637_0(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new _OpenTag(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    return editorCell;
  }

  private EditorCell createComponent_8637_1(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new _CloseTag(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    return editorCell;
  }

  private EditorCell createComponent_8637_2(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new Style_Component(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    return editorCell;
  }

  private EditorCell createConstant_8637_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "Custom cell:");
    editorCell.setCellId("Constant_8637_0");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_8637_1(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "cell provider");
    editorCell.setCellId("Constant_8637_1");
    Styles_StyleSheet.getProperty(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_8637_2(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "custom cell");
    editorCell.setCellId("Constant_8637_2");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_8637_3(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_8637_3");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createRefNode_8637_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("cellProvider");
    provider.setNoTargetText("<no cellProvider>");
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
