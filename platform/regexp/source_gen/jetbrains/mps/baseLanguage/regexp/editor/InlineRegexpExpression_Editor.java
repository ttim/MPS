package jetbrains.mps.baseLanguage.regexp.editor;

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
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class InlineRegexpExpression_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_6834_0(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection_6834_1(context, node);
  }

  public EditorCell createCollection_6834_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_6834_0(editorCell, node, context);
    editorCell.addEditorCell(this.createConstant_6834_15(context, node, "["));
    editorCell.addEditorCell(this.createRefNode_6834_1(context, node));
    editorCell.addEditorCell(this.createConstant_6834_16(context, node, "]"));
    if (renderingCondition6834_1(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_6834_13(context, node, "CASE_INSENSITIVE"));
    }
    if (renderingCondition6834_0(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_6834_12(context, node, "DOTALL"));
    }
    if (renderingCondition6834_2(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_6834_14(context, node, "MULTILINE"));
    }
    return editorCell;
  }

  public EditorCell createCollection_6834_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_6834_1(editorCell, node, context);
    editorCell.addEditorCell(this.createConstant_6834_0(context, node, "Options:"));
    editorCell.addEditorCell(this.createConstant_6834_11(context, node, "Case insensitive :"));
    editorCell.addEditorCell(this.createProperty_6834_5(context, node));
    editorCell.addEditorCell(this.createConstant_6834_10(context, node, ""));
    editorCell.addEditorCell(this.createConstant_6834_1(context, node, "Dot all : "));
    editorCell.addEditorCell(this.createProperty_6834_1(context, node));
    editorCell.addEditorCell(this.createConstant_6834_2(context, node, "  "));
    editorCell.addEditorCell(this.createConstant_6834_3(context, node, "If dot all mode is enabled, the . symbol class will include new line characters"));
    editorCell.addEditorCell(this.createConstant_6834_4(context, node, ""));
    editorCell.addEditorCell(this.createConstant_6834_5(context, node, "Multiline mode : "));
    editorCell.addEditorCell(this.createProperty_6834_3(context, node));
    editorCell.addEditorCell(this.createConstant_6834_6(context, node, "  "));
    editorCell.addEditorCell(this.createConstant_6834_7(context, node, "If multiline mode is enabled, the $ and ^ will work not only in the start and"));
    editorCell.addEditorCell(this.createConstant_6834_8(context, node, "  "));
    editorCell.addEditorCell(this.createConstant_6834_9(context, node, "the end of the text but on starts and ends of lines separated by new line characters"));
    return editorCell;
  }

  public EditorCell createConstant_6834_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_2(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_3(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_3(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_4(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_4(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_5(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_5(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_6(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_6(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_7(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_7(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_8(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_8(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_9(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_9(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_10(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_10(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_11(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_11(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_12(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_12(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_13(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_13(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_14(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_14(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_15(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_15(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6834_16(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6834_16(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNode_6834_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_6834_0(editorCell, node, context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_6834_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("regexp");
    provider.setNoTargetText("<no regexp>");
    EditorCell cellWithRole = this.createRefNode_6834_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createProperty_6834_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_Property_6834_0(editorCell, node, context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty_6834_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("dotAll");
    provider.setNoTargetText("<no dotAll>");
    EditorCell cellWithRole = this.createProperty_6834_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createProperty_6834_2_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_Property_6834_1(editorCell, node, context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty_6834_3(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("multiLine");
    provider.setNoTargetText("<no multiLine>");
    EditorCell cellWithRole = this.createProperty_6834_2_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createProperty_6834_4_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_Property_6834_2(editorCell, node, context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty_6834_5(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("caseInsensitive");
    provider.setNoTargetText("<no caseInsensitive>");
    EditorCell cellWithRole = this.createProperty_6834_4_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_6834_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_6834_0");
  }

  private static void setupBasic_RefNode_6834_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Collection_6834_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_6834_1");
  }

  private static void setupBasic_Constant_6834_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
  }

  private static void setupBasic_Constant_6834_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_1");
  }

  private static void setupBasic_Property_6834_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("property_dotAll");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
  }

  private static void setupBasic_Constant_6834_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_2");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
  }

  private static void setupBasic_Constant_6834_3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_3");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.ITALIC);
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
  }

  private static void setupBasic_Constant_6834_4(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_4");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
  }

  private static void setupBasic_Constant_6834_5(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_5");
  }

  private static void setupBasic_Property_6834_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("property_multiLine");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
  }

  private static void setupBasic_Constant_6834_6(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_6");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
  }

  private static void setupBasic_Constant_6834_7(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_7");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.ITALIC);
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
  }

  private static void setupBasic_Constant_6834_8(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_8");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
  }

  private static void setupBasic_Constant_6834_9(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_9");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.ITALIC);
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
  }

  private static void setupBasic_Constant_6834_10(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_10");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
  }

  private static void setupBasic_Constant_6834_11(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_11");
  }

  private static void setupBasic_Property_6834_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("property_caseInsensitive");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
  }

  private static void setupBasic_Constant_6834_12(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_12");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_MAGENTA);
    }
  }

  private static void setupBasic_Constant_6834_13(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_13");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_MAGENTA);
    }
  }

  private static void setupBasic_Constant_6834_14(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_14");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_MAGENTA);
    }
  }

  private static void setupBasic_Constant_6834_15(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_15");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_MAGENTA);
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
  }

  private static void setupBasic_Constant_6834_16(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6834_16");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_MAGENTA);
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    }
  }

  public static boolean renderingCondition6834_0(SNode node, EditorContext editorContext, IScope scope) {
    return SPropertyOperations.getBoolean(node, "dotAll");
  }

  public static boolean renderingCondition6834_1(SNode node, EditorContext editorContext, IScope scope) {
    return SPropertyOperations.getBoolean(node, "caseInsensitive");
  }

  public static boolean renderingCondition6834_2(SNode node, EditorContext editorContext, IScope scope) {
    return SPropertyOperations.getBoolean(node, "multiLine");
  }

}
