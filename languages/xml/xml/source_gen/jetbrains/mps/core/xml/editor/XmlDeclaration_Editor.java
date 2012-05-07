package jetbrains.mps.core.xml.editor;

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
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.core.xml.behavior.XmlPart_Behavior;

public class XmlDeclaration_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_axvdb8_a(editorContext, node);
  }

  private EditorCell createAlternation_axvdb8_a0(EditorContext editorContext, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = XmlDeclaration_Editor.renderingCondition_axvdb8_a0a(node, editorContext, editorContext.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createConstant_axvdb8_a0a(editorContext, node);
    } else {
      editorCell = this.createConstant_axvdb8_a0a_0(editorContext, node);
    }
    return editorCell;
  }

  private EditorCell createAlternation_axvdb8_c0(EditorContext editorContext, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = XmlDeclaration_Editor.renderingCondition_axvdb8_a2a(node, editorContext, editorContext.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createConstant_axvdb8_a2a(editorContext, node);
    } else {
      editorCell = this.createConstant_axvdb8_a2a_0(editorContext, node);
    }
    return editorCell;
  }

  private EditorCell createCollection_axvdb8_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_axvdb8_a");
    editorCell.addEditorCell(this.createAlternation_axvdb8_a0(editorContext, node));
    editorCell.addEditorCell(this.createCollection_axvdb8_b0(editorContext, node));
    editorCell.addEditorCell(this.createAlternation_axvdb8_c0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_axvdb8_b0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_axvdb8_b0");
    editorCell.addEditorCell(this.createConstant_axvdb8_a1a(editorContext, node));
    editorCell.addEditorCell(this.createCollection_axvdb8_b1a(editorContext, node));
    editorCell.addEditorCell(this.createCollection_axvdb8_c1a(editorContext, node));
    editorCell.addEditorCell(this.createCollection_axvdb8_d1a(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_axvdb8_b1a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_axvdb8_b1a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_axvdb8_a1b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_axvdb8_b1b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_axvdb8_c1b0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_axvdb8_d1b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_axvdb8_e1b0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_axvdb8_c1a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_axvdb8_c1a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_axvdb8_a2b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_axvdb8_b2b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_axvdb8_c2b0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_axvdb8_d2b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_axvdb8_e2b0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_axvdb8_d1a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_axvdb8_d1a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_axvdb8_a3b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_axvdb8_b3b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_axvdb8_c3b0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_axvdb8_d3b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_axvdb8_e3b0(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_a0a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<?");
    editorCell.setCellId("Constant_axvdb8_a0a");
    XmlSS_StyleSheet.getXmlTagPunctuation(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.MATCHING_LABEL, "openTag");
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_a0a_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<?");
    editorCell.setCellId("Constant_axvdb8_a0a_0");
    XmlSS_StyleSheet.getXmlTagPunctuation(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
      style.set(StyleAttributes.MATCHING_LABEL, "openTag");
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_a1a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "xml");
    editorCell.setCellId("Constant_axvdb8_a1a");
    XmlSS_StyleSheet.getXmlTagName(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_a1b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "version");
    editorCell.setCellId("Constant_axvdb8_a1b0");
    XmlSS_StyleSheet.getXmlAttributeName(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_b1b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "=");
    editorCell.setCellId("Constant_axvdb8_b1b0");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_c1b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "\"");
    editorCell.setCellId("Constant_axvdb8_c1b0");
    XmlSS_StyleSheet.getXmlAttributeValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_e1b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "\"");
    editorCell.setCellId("Constant_axvdb8_e1b0");
    XmlSS_StyleSheet.getXmlAttributeValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_a2b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "encoding");
    editorCell.setCellId("Constant_axvdb8_a2b0");
    XmlSS_StyleSheet.getXmlAttributeName(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_b2b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "=");
    editorCell.setCellId("Constant_axvdb8_b2b0");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_c2b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "\"");
    editorCell.setCellId("Constant_axvdb8_c2b0");
    XmlSS_StyleSheet.getXmlAttributeValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_e2b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "\"");
    editorCell.setCellId("Constant_axvdb8_e2b0");
    XmlSS_StyleSheet.getXmlAttributeValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_a3b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "standalone");
    editorCell.setCellId("Constant_axvdb8_a3b0");
    XmlSS_StyleSheet.getXmlAttributeName(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_b3b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "=");
    editorCell.setCellId("Constant_axvdb8_b3b0");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_c3b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "\"");
    editorCell.setCellId("Constant_axvdb8_c3b0");
    XmlSS_StyleSheet.getXmlAttributeValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_e3b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "\"");
    editorCell.setCellId("Constant_axvdb8_e3b0");
    XmlSS_StyleSheet.getXmlAttributeValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_a2a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "?>");
    editorCell.setCellId("Constant_axvdb8_a2a");
    XmlSS_StyleSheet.getXmlTagPunctuation(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.MATCHING_LABEL, "openTag");
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_axvdb8_a2a_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "?>");
    editorCell.setCellId("Constant_axvdb8_a2a_0");
    XmlSS_StyleSheet.getXmlTagPunctuation(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
      style.set(StyleAttributes.MATCHING_LABEL, "openTag");
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createProperty_axvdb8_d1b0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("version");
    provider.setNoTargetText("<no version>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_version");
    XmlSS_StyleSheet.getXmlAttributeValue(editorCell).apply(editorCell);
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

  private EditorCell createProperty_axvdb8_d2b0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("encoding");
    provider.setNoTargetText("default");
    provider.setAllowsEmptyTarget(true);
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_encoding");
    XmlSS_StyleSheet.getXmlAttributeValue(editorCell).apply(editorCell);
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

  private EditorCell createProperty_axvdb8_d3b0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("standalone");
    provider.setNoTargetText("default");
    provider.setAllowsEmptyTarget(true);
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_standalone");
    XmlSS_StyleSheet.getXmlAttributeValue(editorCell).apply(editorCell);
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

  private static boolean renderingCondition_axvdb8_a0a(SNode node, EditorContext editorContext, IScope scope) {
    return XmlPart_Behavior.call_isFirstPositionAllowed_2133624044437631446(node);
  }

  private static boolean renderingCondition_axvdb8_a2a(SNode node, EditorContext editorContext, IScope scope) {
    return XmlPart_Behavior.call_isLastPositionAllowed_2133624044437631519(node);
  }
}
