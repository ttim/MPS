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
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.core.xml.behavior.XmlValuePart_Behavior;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_PropertyValues;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.core.xml.constraints.XmlNameUtil;

public class XmlEntityRefValue_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_poez2y_a(editorContext, node);
  }

  private EditorCell createAlternation_poez2y_a0(EditorContext editorContext, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = XmlEntityRefValue_Editor.renderingCondition_poez2y_a0a(node, editorContext, editorContext.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createConstant_poez2y_a0a(editorContext, node);
    } else {
      editorCell = this.createConstant_poez2y_a0a_0(editorContext, node);
    }
    return editorCell;
  }

  private EditorCell createAlternation_poez2y_c0(EditorContext editorContext, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = XmlEntityRefValue_Editor.renderingCondition_poez2y_a2a(node, editorContext, editorContext.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createConstant_poez2y_a2a(editorContext, node);
    } else {
      editorCell = this.createConstant_poez2y_a2a_0(editorContext, node);
    }
    return editorCell;
  }

  private EditorCell createCollection_poez2y_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_poez2y_a");
    editorCell.addEditorCell(this.createAlternation_poez2y_a0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_poez2y_b0(editorContext, node));
    editorCell.addEditorCell(this.createAlternation_poez2y_c0(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_poez2y_a0a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "&");
    editorCell.setCellId("Constant_poez2y_a0a");
    XmlSS_StyleSheet.getXmlAttrEntityRefValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
    delete_XmlEntityRefValueDelete.setCellActions(editorCell, node, editorContext);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_poez2y_a0a_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "&");
    editorCell.setCellId("Constant_poez2y_a0a_0");
    XmlSS_StyleSheet.getXmlAttrEntityRefValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    }
    delete_XmlEntityRefValueDelete.setCellActions(editorCell, node, editorContext);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_poez2y_a2a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ";");
    editorCell.setCellId("Constant_poez2y_a2a");
    XmlSS_StyleSheet.getXmlAttrEntityRefValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    }
    delete_XmlEntityRefValueDelete.setCellActions(editorCell, node, editorContext);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_poez2y_a2a_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ";");
    editorCell.setCellId("Constant_poez2y_a2a_0");
    XmlSS_StyleSheet.getXmlAttrEntityRefValue(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
    delete_XmlEntityRefValueDelete.setCellActions(editorCell, node, editorContext);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createProperty_poez2y_b0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("entityName");
    provider.setNoTargetText("<no entityName>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_entityName");
    XmlSS_StyleSheet.getXmlAttrEntityRefValue(editorCell).apply(editorCell);
    delete_XmlEntityRefValueDelete.setCellActions(editorCell, node, editorContext);
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(editorContext, provider.getCellContext(), new SubstituteInfoPart[]{new XmlEntityRefValue_Editor.XmlEntityRefValue_entityName_cellMenu_a0b0()}));
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private static boolean renderingCondition_poez2y_a0a(SNode node, EditorContext editorContext, IScope scope) {
    // see MPS-15260 
    return XmlValuePart_Behavior.call_isFirstPositionAllowed_3080189811177340436(node);
  }

  private static boolean renderingCondition_poez2y_a2a(SNode node, EditorContext editorContext, IScope scope) {
    // see MPS-15260 
    return XmlValuePart_Behavior.call_isLastPositionAllowed_3080189811177340441(node);
  }

  public static class XmlEntityRefValue_entityName_cellMenu_a0b0 extends AbstractCellMenuPart_PropertyValues {
    public XmlEntityRefValue_entityName_cellMenu_a0b0() {
    }

    public List<String> getPropertyValues(SNode node, IScope scope, IOperationContext operationContext) {
      return Sequence.fromIterable(Sequence.fromArray(XmlNameUtil.getDefaultEntities())).toListSequence();
    }
  }
}
