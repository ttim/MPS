package jetbrains.mps.xml.deprecated.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;

public class DocumentTypeDeclaration_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_6391_0(editorContext, node);
  }

  private EditorCell createCollection_6391_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_6391_0");
    editorCell.addEditorCell(this.createCollection_6391_1(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_6391_1(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_6391_1");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_6391_0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_6391_1(editorContext, node));
    editorCell.addEditorCell(this.createProperty_6391_0(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_6391_0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_6391_2(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_6391_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<!");
    editorCell.setCellId("Constant_6391_0");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_6391_1(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "DOCTYPE");
    editorCell.setCellId("Constant_6391_1");
    XMLDeprecatedStyles_StyleSheet.getElement(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_6391_2(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ">");
    editorCell.setCellId("Constant_6391_2");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createProperty_6391_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("name");
    provider.setNoTargetText("<no name>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_name");
    XMLDeprecatedStyles_StyleSheet.getAttributeValue(editorCell).apply(editorCell);
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

  private EditorCell createRefNode_6391_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("externalID");
    provider.setNoTargetText("<no externalID>");
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
