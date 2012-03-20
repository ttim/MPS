package jetbrains.mps.core.xml.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.core.xml.behavior.XmlValuePart_Behavior;

public class XmlCharRefValue_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_urzn0w_a(editorContext, node);
  }

  private EditorCell createAlternation_urzn0w_a0(EditorContext editorContext, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = XmlCharRefValue_Editor.renderingCondition_urzn0w_a0a(node, editorContext, editorContext.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createConstant_urzn0w_a0a(editorContext, node);
    } else {
      editorCell = this.createConstant_urzn0w_a0a_0(editorContext, node);
    }
    return editorCell;
  }

  private EditorCell createAlternation_urzn0w_c0(EditorContext editorContext, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = XmlCharRefValue_Editor.renderingCondition_urzn0w_a2a(node, editorContext, editorContext.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createConstant_urzn0w_a2a(editorContext, node);
    } else {
      editorCell = this.createConstant_urzn0w_a2a_0(editorContext, node);
    }
    return editorCell;
  }

  private EditorCell createCollection_urzn0w_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_urzn0w_a");
    editorCell.addEditorCell(this.createAlternation_urzn0w_a0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_urzn0w_b0(editorContext, node));
    editorCell.addEditorCell(this.createAlternation_urzn0w_c0(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_urzn0w_a0a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "&#");
    editorCell.setCellId("Constant_urzn0w_a0a");
    XmlSS_StyleSheet.getXmlAttrCharRefValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
    delete_XmlEntityRefValueDelete.setCellActions(editorCell, node, editorContext);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_urzn0w_a0a_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "&#");
    editorCell.setCellId("Constant_urzn0w_a0a_0");
    XmlSS_StyleSheet.getXmlAttrCharRefValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    }
    delete_XmlEntityRefValueDelete.setCellActions(editorCell, node, editorContext);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_urzn0w_a2a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ";");
    editorCell.setCellId("Constant_urzn0w_a2a");
    XmlSS_StyleSheet.getXmlAttrCharRefValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    }
    delete_XmlEntityRefValueDelete.setCellActions(editorCell, node, editorContext);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_urzn0w_a2a_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ";");
    editorCell.setCellId("Constant_urzn0w_a2a_0");
    XmlSS_StyleSheet.getXmlAttrCharRefValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
    delete_XmlEntityRefValueDelete.setCellActions(editorCell, node, editorContext);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createProperty_urzn0w_b0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("charCode");
    provider.setNoTargetText("<no charCode>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_charCode");
    XmlSS_StyleSheet.getXmlAttrCharRefValue(editorCell).apply(editorCell);
    delete_XmlEntityRefValueDelete.setCellActions(editorCell, node, editorContext);
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

  private static boolean renderingCondition_urzn0w_a0a(SNode node, EditorContext editorContext, IScope scope) {
    // see MPS-15260 
    return XmlValuePart_Behavior.call_isFirstPositionAllowed_3080189811177340436(node);
  }

  private static boolean renderingCondition_urzn0w_a2a(SNode node, EditorContext editorContext, IScope scope) {
    // see MPS-15260 
    return XmlValuePart_Behavior.call_isLastPositionAllowed_3080189811177340441(node);
  }
}
