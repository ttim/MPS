package jetbrains.mps.build.custommps.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.build.packaging.editor.IncludeExcludeEditorComponent;
import jetbrains.mps.build.packaging.editor.ConfigurationReferencesEditorComponent;
import jetbrains.mps.build.packaging.editor.IncludeExcludeInInspector;
import jetbrains.mps.build.packaging.editor.CompositecomponentEntriesEditorComponent;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.ConceptPropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.build.packaging.editor.PackagingStyles_StyleSheet;

public class LibraryFolder_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider myIncludeExcludeEditorComponent6803_0;
  /* package */AbstractCellProvider myConfigurationReferencesEditorComponent6803_0;
  /* package */AbstractCellProvider myIncludeExcludeInInspector6803_0;
  /* package */AbstractCellProvider myConfigurationReferencesEditorComponent6803_1;
  /* package */AbstractCellProvider myCompositecomponentEntriesEditorComponent6803_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_6803_0(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection_6803_2(context, node);
  }

  public EditorCell createCollection_6803_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_6803_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createCollection_6803_1(context, node));
    editorCell.addEditorCell(this.createComponent_6803_4(context, node));
    return editorCell;
  }

  public EditorCell createCollection_6803_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_6803_1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConceptProperty_6803_1(context, node));
    editorCell.addEditorCell(this.createRefNode_6803_5(context, node));
    editorCell.addEditorCell(this.createConstant_6803_1(context, node, "in folder"));
    editorCell.addEditorCell(this.createRefNode_6803_1(context, node));
    editorCell.addEditorCell(this.createConstant_6803_0(context, node, "from"));
    editorCell.addEditorCell(this.createRefNode_6803_3(context, node));
    editorCell.addEditorCell(this.createComponent_6803_0(context, node));
    editorCell.addEditorCell(this.createComponent_6803_1(context, node));
    return editorCell;
  }

  public EditorCell createCollection_6803_2(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_6803_2(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createComponent_6803_2(context, node));
    editorCell.addEditorCell(this.createComponent_6803_3(context, node));
    return editorCell;
  }

  public EditorCell createComponent_6803_0(EditorContext context, SNode node) {
    if (this.myIncludeExcludeEditorComponent6803_0 == null) {
      this.myIncludeExcludeEditorComponent6803_0 = new IncludeExcludeEditorComponent(node);
    }
    EditorCell editorCell = this.myIncludeExcludeEditorComponent6803_0.createEditorCell(context);
    setupBasic_Component_6803_0(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createComponent_6803_1(EditorContext context, SNode node) {
    if (this.myConfigurationReferencesEditorComponent6803_0 == null) {
      this.myConfigurationReferencesEditorComponent6803_0 = new ConfigurationReferencesEditorComponent(node);
    }
    EditorCell editorCell = this.myConfigurationReferencesEditorComponent6803_0.createEditorCell(context);
    setupBasic_Component_6803_1(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createComponent_6803_2(EditorContext context, SNode node) {
    if (this.myIncludeExcludeInInspector6803_0 == null) {
      this.myIncludeExcludeInInspector6803_0 = new IncludeExcludeInInspector(node);
    }
    EditorCell editorCell = this.myIncludeExcludeInInspector6803_0.createEditorCell(context);
    setupBasic_Component_6803_2(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createComponent_6803_3(EditorContext context, SNode node) {
    if (this.myConfigurationReferencesEditorComponent6803_1 == null) {
      this.myConfigurationReferencesEditorComponent6803_1 = new ConfigurationReferencesEditorComponent(node);
    }
    EditorCell editorCell = this.myConfigurationReferencesEditorComponent6803_1.createEditorCell(context);
    setupBasic_Component_6803_3(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createComponent_6803_4(EditorContext context, SNode node) {
    if (this.myCompositecomponentEntriesEditorComponent6803_0 == null) {
      this.myCompositecomponentEntriesEditorComponent6803_0 = new CompositecomponentEntriesEditorComponent(node);
    }
    EditorCell editorCell = this.myCompositecomponentEntriesEditorComponent6803_0.createEditorCell(context);
    setupBasic_Component_6803_4(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createConstant_6803_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6803_0(editorCell, node, context);
    setupLabel_Constant_6803_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6803_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6803_1(editorCell, node, context);
    setupLabel_Constant_6803_1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConceptProperty_6803_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_ConceptProperty_6803_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_ConceptProperty_6803_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createConceptProperty_6803_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new ConceptPropertyCellProvider(node, context);
    provider.setRole("alias");
    provider.setNoTargetText("<no alias>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createConceptProperty_6803_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefNode_6803_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_6803_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_6803_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_6803_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("title");
    provider.setNoTargetText("<no title>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_6803_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefNode_6803_2_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_6803_1(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_6803_1((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_6803_3(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("sourcePath");
    provider.setNoTargetText("<no sourcePath>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_6803_2_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefNode_6803_4_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_6803_2(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_6803_2((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_6803_5(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("libraryName");
    provider.setNoTargetText("<no libraryName>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_6803_4_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_6803_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_6803_0");
  }

  private static void setupBasic_Collection_6803_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_6803_1");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_ConceptProperty_6803_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("conceptProperty_alias");
    PackagingStyles_StyleSheet.getProjectComponent(editorCell).apply(editorCell);
  }

  private static void setupBasic_RefNode_6803_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Constant_6803_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6803_0");
    PackagingStyles_StyleSheet.getKeyword(editorCell).apply(editorCell);
  }

  private static void setupBasic_RefNode_6803_1(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Component_6803_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Component_6803_1(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Collection_6803_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_6803_2");
  }

  private static void setupBasic_Component_6803_2(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Component_6803_3(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Component_6803_4(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_RefNode_6803_2(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Constant_6803_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6803_1");
    PackagingStyles_StyleSheet.getKeyword(editorCell).apply(editorCell);
  }

  private static void setupLabel_ConceptProperty_6803_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNode_6803_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_6803_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNode_6803_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNode_6803_2(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_6803_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

}
