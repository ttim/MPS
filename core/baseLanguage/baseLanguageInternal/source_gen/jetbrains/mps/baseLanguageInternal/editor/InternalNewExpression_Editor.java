package jetbrains.mps.baseLanguageInternal.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.baseLanguage.editor.IMethodCall_actualArguments;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;

public class InternalNewExpression_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider myIMethodCall_actualArguments4191_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_4191_0(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection_4191_1(context, node);
  }

  public EditorCell createCollection_4191_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_4191_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_4191_1(context, node, "["));
    editorCell.addEditorCell(this.createRefNode_4191_1(context, node));
    editorCell.addEditorCell(this.createConstant_4191_2(context, node, "]"));
    editorCell.addEditorCell(this.createConstant_4191_0(context, node, "new"));
    editorCell.addEditorCell(this.createProperty_4191_1(context, node));
    editorCell.addEditorCell(this.createComponent_4191_0(context, node));
    return editorCell;
  }

  public EditorCell createCollection_4191_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createFlow(context, node);
    setupBasic_Collection_4191_1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_4191_3(context, node, "Package"));
    editorCell.addEditorCell(this.createConstant_4191_4(context, node, "name"));
    editorCell.addEditorCell(this.createConstant_4191_5(context, node, "may"));
    editorCell.addEditorCell(this.createConstant_4191_6(context, node, "be"));
    editorCell.addEditorCell(this.createConstant_4191_7(context, node, "splitted"));
    editorCell.addEditorCell(this.createConstant_4191_8(context, node, "from"));
    editorCell.addEditorCell(this.createConstant_4191_9(context, node, "short"));
    editorCell.addEditorCell(this.createConstant_4191_10(context, node, "class"));
    editorCell.addEditorCell(this.createConstant_4191_11(context, node, "name"));
    editorCell.addEditorCell(this.createConstant_4191_12(context, node, "with"));
    editorCell.addEditorCell(this.createConstant_4191_13(context, node, "either"));
    editorCell.addEditorCell(this.createConstant_4191_14(context, node, "'.'"));
    editorCell.addEditorCell(this.createConstant_4191_15(context, node, "or"));
    editorCell.addEditorCell(this.createConstant_4191_16(context, node, "'!'"));
    return editorCell;
  }

  public EditorCell createComponent_4191_0(EditorContext context, SNode node) {
    if (this.myIMethodCall_actualArguments4191_0 == null) {
      this.myIMethodCall_actualArguments4191_0 = new IMethodCall_actualArguments(node);
    }
    EditorCell editorCell = this.myIMethodCall_actualArguments4191_0.createEditorCell(context);
    setupBasic_Component_4191_0(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createConstant_4191_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_0(editorCell, node, context);
    setupLabel_Constant_4191_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_1(editorCell, node, context);
    setupLabel_Constant_4191_1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_2(editorCell, node, context);
    setupLabel_Constant_4191_2(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_3(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_3(editorCell, node, context);
    setupLabel_Constant_4191_3(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_4(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_4(editorCell, node, context);
    setupLabel_Constant_4191_4(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_5(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_5(editorCell, node, context);
    setupLabel_Constant_4191_5(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_6(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_6(editorCell, node, context);
    setupLabel_Constant_4191_6(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_7(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_7(editorCell, node, context);
    setupLabel_Constant_4191_7(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_8(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_8(editorCell, node, context);
    setupLabel_Constant_4191_8(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_9(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_9(editorCell, node, context);
    setupLabel_Constant_4191_9(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_10(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_10(editorCell, node, context);
    setupLabel_Constant_4191_10(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_11(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_11(editorCell, node, context);
    setupLabel_Constant_4191_11(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_12(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_12(editorCell, node, context);
    setupLabel_Constant_4191_12(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_13(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_13(editorCell, node, context);
    setupLabel_Constant_4191_13(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_14(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_14(editorCell, node, context);
    setupLabel_Constant_4191_14(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_15(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_15(editorCell, node, context);
    setupLabel_Constant_4191_15(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4191_16(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4191_16(editorCell, node, context);
    setupLabel_Constant_4191_16(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createProperty_4191_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_Property_4191_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_Property_4191_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty_4191_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("fqClassName");
    provider.setNoTargetText("<no fqClassName>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createProperty_4191_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefNode_4191_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_4191_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_4191_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_4191_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("type");
    provider.setNoTargetText("no type");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_4191_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_4191_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_4191_0");
  }

  private static void setupBasic_Constant_4191_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_0");
    StyleSheet_StyleSheet.getInternalKeyword(editorCell).apply(editorCell);
  }

  private static void setupBasic_Property_4191_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("property_fqClassName");
    StyleSheet_StyleSheet.getInternalName(editorCell).apply(editorCell);
  }

  private static void setupBasic_Component_4191_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Constant_4191_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_1");
    StyleSheet_StyleSheet.getSquareBracket(editorCell).apply(editorCell);
  }

  private static void setupBasic_RefNode_4191_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Constant_4191_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_2");
    StyleSheet_StyleSheet.getSquareBracket(editorCell).apply(editorCell);
  }

  private static void setupBasic_Collection_4191_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_4191_1");
  }

  private static void setupBasic_Constant_4191_3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_3");
  }

  private static void setupBasic_Constant_4191_4(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_4");
  }

  private static void setupBasic_Constant_4191_5(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_5");
  }

  private static void setupBasic_Constant_4191_6(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_6");
  }

  private static void setupBasic_Constant_4191_7(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_7");
  }

  private static void setupBasic_Constant_4191_8(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_8");
  }

  private static void setupBasic_Constant_4191_9(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_9");
  }

  private static void setupBasic_Constant_4191_10(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_10");
  }

  private static void setupBasic_Constant_4191_11(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_11");
  }

  private static void setupBasic_Constant_4191_12(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_12");
  }

  private static void setupBasic_Constant_4191_13(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_13");
  }

  private static void setupBasic_Constant_4191_14(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_14");
  }

  private static void setupBasic_Constant_4191_15(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_15");
  }

  private static void setupBasic_Constant_4191_16(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4191_16");
  }

  private static void setupLabel_Constant_4191_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Property_4191_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNode_4191_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_2(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_3(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_4(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_5(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_6(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_7(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_8(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_9(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_10(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_11(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_12(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_13(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_14(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_15(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4191_16(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

}
