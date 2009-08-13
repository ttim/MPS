package jetbrains.mps.xml.deprecated.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;

public class PublicId_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_7240_0(editorContext, node);
  }

  private EditorCell createCollection_7240_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_7240_0");
    editorCell.addEditorCell(this.createConstant_7240_0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_7240_1(editorContext, node));
    editorCell.addEditorCell(this.createProperty_7240_0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_7240_2(editorContext, node));
    editorCell.addEditorCell(this.createConstant_7240_4(editorContext, node));
    editorCell.addEditorCell(this.createConstant_7240_3(editorContext, node));
    editorCell.addEditorCell(this.createProperty_7240_1(editorContext, node));
    editorCell.addEditorCell(this.createConstant_7240_5(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_7240_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "PUBLIC");
    editorCell.setCellId("Constant_7240_0");
    XMLDeprecatedStyles_StyleSheet.getElement(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_7240_1(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "\"");
    editorCell.setCellId("Constant_7240_1");
    XMLDeprecatedStyles_StyleSheet.getAttributeValue(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_7240_2(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "\"");
    editorCell.setCellId("Constant_7240_2");
    XMLDeprecatedStyles_StyleSheet.getAttributeValue(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_7240_3(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "\"");
    editorCell.setCellId("Constant_7240_3");
    XMLDeprecatedStyles_StyleSheet.getAttributeValue(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_7240_4(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, " ");
    editorCell.setCellId("Constant_7240_4");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_7240_5(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "\"");
    editorCell.setCellId("Constant_7240_5");
    XMLDeprecatedStyles_StyleSheet.getAttributeValue(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createProperty_7240_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("publicID");
    provider.setNoTargetText("<no publicID>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_publicID");
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

  private EditorCell createProperty_7240_1(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("systemID");
    provider.setNoTargetText("<no systemID>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_systemID");
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

}
