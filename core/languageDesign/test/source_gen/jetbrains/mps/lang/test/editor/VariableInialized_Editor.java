package jetbrains.mps.lang.test.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;

public class VariableInialized_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_0887_0(context, node);
  }

  public EditorCell createCollection_0887_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_0887_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_0887_0(context, node, "init"));
    editorCell.addEditorCell(this.createRefNode_0887_1(context, node));
    return editorCell;
  }

  public EditorCell createConstant_0887_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_0887_0(editorCell, node, context);
    setupLabel_Constant_0887_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNode_0887_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_0887_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_0887_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_0887_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("var");
    provider.setNoTargetText("<no var>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_0887_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_0887_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_0887_0");
  }

  private static void setupBasic_Constant_0887_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_0887_0");
    BaseLanguageStyle_StyleSheet.getAnnotation(editorCell).apply(editorCell);
  }

  private static void setupBasic_RefNode_0887_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_0887_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNode_0887_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

}
