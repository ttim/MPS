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
import jetbrains.mps.core.xml.behavior.XmlPart_Behavior;

public class XmlProcessingInstruction_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_9277sk_a(editorContext, node);
  }

  private EditorCell createAlternation_9277sk_a0(EditorContext editorContext, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = XmlProcessingInstruction_Editor.renderingCondition_9277sk_a0a(node, editorContext, editorContext.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createConstant_9277sk_a0a(editorContext, node);
    } else {
      editorCell = this.createConstant_9277sk_a0a_0(editorContext, node);
    }
    return editorCell;
  }

  private EditorCell createAlternation_9277sk_d0(EditorContext editorContext, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = XmlProcessingInstruction_Editor.renderingCondition_9277sk_a3a(node, editorContext, editorContext.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createConstant_9277sk_a3a(editorContext, node);
    } else {
      editorCell = this.createConstant_9277sk_a3a_0(editorContext, node);
    }
    return editorCell;
  }

  private EditorCell createCollection_9277sk_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_9277sk_a");
    editorCell.addEditorCell(this.createAlternation_9277sk_a0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_9277sk_b0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_9277sk_c0(editorContext, node));
    editorCell.addEditorCell(this.createAlternation_9277sk_d0(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_9277sk_a0a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<?");
    editorCell.setCellId("Constant_9277sk_a0a");
    XmlSS_StyleSheet.getXmlPI(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9277sk_a0a_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<?");
    editorCell.setCellId("Constant_9277sk_a0a_0");
    XmlSS_StyleSheet.getXmlPI(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9277sk_a3a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "?>");
    editorCell.setCellId("Constant_9277sk_a3a");
    XmlSS_StyleSheet.getXmlPI(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9277sk_a3a_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "?>");
    editorCell.setCellId("Constant_9277sk_a3a_0");
    XmlSS_StyleSheet.getXmlPI(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createProperty_9277sk_b0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("target");
    provider.setNoTargetText("<no target>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_target");
    XmlSS_StyleSheet.getXmlPITarget(editorCell).apply(editorCell);
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

  private EditorCell createProperty_9277sk_c0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("rawData");
    provider.setNoTargetText("<no rawData>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_rawData");
    XmlSS_StyleSheet.getXmlPIData(editorCell).apply(editorCell);
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

  private static boolean renderingCondition_9277sk_a0a(SNode node, EditorContext editorContext, IScope scope) {
    // see MPS-15260 
    return XmlPart_Behavior.call_isFirstPositionAllowed_2133624044437631446(node);
  }

  private static boolean renderingCondition_9277sk_a3a(SNode node, EditorContext editorContext, IScope scope) {
    // see MPS-15260 
    return XmlPart_Behavior.call_isLastPositionAllowed_2133624044437631519(node);
  }
}
