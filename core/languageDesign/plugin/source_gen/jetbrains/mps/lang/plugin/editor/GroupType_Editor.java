package jetbrains.mps.lang.plugin.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;

public class GroupType_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_1859_0(context, node);
  }

  public EditorCell createCollection_1859_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_1859_0(editorCell, node, context);
    editorCell.addEditorCell(this.createConstant_1859_0(context, node, "group"));
    editorCell.addEditorCell(this.createConstant_1859_1(context, node, "<"));
    editorCell.addEditorCell(this.createRefCell_1859_1(context, node));
    editorCell.addEditorCell(this.createConstant_1859_2(context, node, ">"));
    return editorCell;
  }

  public EditorCell createConstant_1859_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_1859_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_1859_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_1859_1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_1859_2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_1859_2(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefCell_1859_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new GroupType_Editor._Inline1859_0());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefCell_1859_0(editorCell, node, context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell_1859_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("actionGroup");
    provider.setNoTargetText("<no actionGroup>");
    EditorCell cellWithRole = this.createRefCell_1859_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_1859_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1859_0");
  }

  private static void setupBasic_Constant_1859_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1859_0");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_1859_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1859_1");
    BaseLanguageStyle_StyleSheet.getBaseAngleBracket(editorCell).apply(editorCell);
  }

  private static void setupBasic_RefCell_1859_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Constant_1859_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1859_2");
    BaseLanguageStyle_StyleSheet.getBaseAngleBracket(editorCell).apply(editorCell);
  }

  public static class _Inline1859_0 extends AbstractCellProvider {

    public _Inline1859_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty_1859_1(context, node);
    }

    public EditorCell createProperty_1859_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_Property_1859_0(editorCell, node, context);
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty_1859_1(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      EditorCell cellWithRole = this.createProperty_1859_0_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }


    private static void setupBasic_Property_1859_0(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.setCellId("property_name");
    }

}

}
