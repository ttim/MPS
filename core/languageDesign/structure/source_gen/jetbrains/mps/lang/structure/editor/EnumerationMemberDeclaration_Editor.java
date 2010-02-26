package jetbrains.mps.lang.structure.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.structure.behavior.EnumerationDataTypeDeclaration_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class EnumerationMemberDeclaration_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_n0n6wp_a(editorContext, node);
  }

  private EditorCell createCollection_n0n6wp_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_n0n6wp_a");
    if (renderingCondition_n0n6wp_a0a(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_n0n6wp_a0(editorContext, node));
    }
    editorCell.addEditorCell(this.createConstant_n0n6wp_b0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_n0n6wp_c0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_n0n6wp_d0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_n0n6wp_e0(editorContext, node));
    if (renderingCondition_n0n6wp_a5a(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_n0n6wp_f0(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_n0n6wp_a0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_n0n6wp_a0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_n0n6wp_a0a(editorContext, node));
    editorCell.addEditorCell(this.createProperty_n0n6wp_b0a(editorContext, node));
    editorCell.addEditorCell(this.createConstant_n0n6wp_c0a(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_n0n6wp_f0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "    (default)");
    editorCell.setCellId("Constant_n0n6wp_f0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.PLAIN);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_n0n6wp_b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "value");
    editorCell.setCellId("Constant_n0n6wp_b0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.ITALIC);
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.darkGray);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_n0n6wp_d0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "  presentation");
    editorCell.setCellId("Constant_n0n6wp_d0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.ITALIC);
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.darkGray);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_n0n6wp_a0a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "identifier");
    editorCell.setCellId("Constant_n0n6wp_a0a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.ITALIC);
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.darkGray);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_n0n6wp_c0a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "  ");
    editorCell.setCellId("Constant_n0n6wp_c0a");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createProperty_n0n6wp_e0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("externalValue");
    provider.setNoTargetText("<no external value>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_externalValue");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD);
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_MAGENTA);
    }
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

  private EditorCell createProperty_n0n6wp_c0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("internalValue");
    provider.setNoTargetText("<NULL>");
    provider.setAllowsEmptyTarget(true);
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_internalValue");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.blue);
      style.set(StyleAttributes.SELECTED_TEXT_BACKGROUND_COLOR, MPSColors.cyan);
    }
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

  private EditorCell createProperty_n0n6wp_b0a(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("javaIdentifier");
    provider.setNoTargetText("<no identifier>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_javaIdentifier");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD_ITALIC);
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_MAGENTA);
      style.set(StyleAttributes.SELECTED_TEXT_BACKGROUND_COLOR, MPSColors.cyan);
    }
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

  private static boolean renderingCondition_n0n6wp_a5a(SNode node, EditorContext editorContext, IScope scope) {
    return node == EnumerationDataTypeDeclaration_Behavior.call_getDefaultMember_1213877397785(SNodeOperations.cast(SNodeOperations.getParent(node), "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration"));
  }

  private static boolean renderingCondition_n0n6wp_a0a(SNode node, EditorContext editorContext, IScope scope) {
    return SPropertyOperations.hasValue(SNodeOperations.cast(SNodeOperations.getParent(node), "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration"), "memberIdentifierPolicy", "custom", "derive_from_presentation");
  }
}
