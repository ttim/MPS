package jetbrains.mps.bootstrap.editorLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.PropertyCellProvider;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefNodeCellProvider;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.bootstrap.sharedConcepts.editor.SharedStyles_StyleSheet;

public class EditorComponentDeclaration_Editor extends DefaultNodeEditor {

  private static void setupBasic_NodeBox(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_052");
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_HeaderRow(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_053");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_ConstantCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_054");
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_SemanticTypeAreaIndented(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_055");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_IndentCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_056");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_SemanticTypeArea(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_057");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_ConstantCell1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_058");
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_CellsLayoutPanel(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_059");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_NodeCellArea(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_060");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_IndentCell2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_061");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_NodeCellPanel(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_062");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_ConstantCell2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_063");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_ConstantCell3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_064");
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_CellsLayoutPanel1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_065");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_ConceptDeclarationReferenceCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_0232");
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_NameCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_0298");
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_IndentCell1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_0376");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_IndentCell3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_0377");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_CellModelCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_0496");
    editorCell.setDrawBorder(false);
    editorCell.addKeyMap(new EditorCellModel_KeyMap());
  }

  private static void setupLabel_ConstantCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_IndentCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_IndentCell2(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell2(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell3(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConceptDeclarationReferenceCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_NameCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_IndentCell1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_IndentCell3(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_CellModelCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }


  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createNodeBox(context, node);
  }

  public EditorCell createNodeBox(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_NodeBox(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createHeaderRow(context, node));
    editorCell.addEditorCell(this.createSemanticTypeAreaIndented(context, node));
    editorCell.addEditorCell(this.createNodeCellArea(context, node));
    return editorCell;
  }

  public EditorCell createHeaderRow(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_HeaderRow(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell(context, node, "editor component"));
    editorCell.addEditorCell(this.createNameCell(context, node));
    return editorCell;
  }

  public EditorCell createSemanticTypeAreaIndented(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_SemanticTypeAreaIndented(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createIndentCell(context, node, "    "));
    editorCell.addEditorCell(this.createSemanticTypeArea(context, node));
    return editorCell;
  }

  public EditorCell createSemanticTypeArea(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_SemanticTypeArea(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell1(context, node, "applicable concept:"));
    editorCell.addEditorCell(this.createCellsLayoutPanel(context, node));
    return editorCell;
  }

  public EditorCell createCellsLayoutPanel(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_CellsLayoutPanel(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createIndentCell1(context, node, "    "));
    editorCell.addEditorCell(this.createConceptDeclarationReferenceCell(context, node));
    return editorCell;
  }

  public EditorCell createNodeCellArea(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_NodeCellArea(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createIndentCell2(context, node, "    "));
    editorCell.addEditorCell(this.createNodeCellPanel(context, node));
    return editorCell;
  }

  public EditorCell createNodeCellPanel(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_NodeCellPanel(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell2(context, node, ""));
    editorCell.addEditorCell(this.createConstantCell3(context, node, "component cell layout:"));
    editorCell.addEditorCell(this.createCellsLayoutPanel1(context, node));
    return editorCell;
  }

  public EditorCell createCellsLayoutPanel1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_CellsLayoutPanel1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createIndentCell3(context, node, "    "));
    editorCell.addEditorCell(this.createCellModelCell(context, node));
    return editorCell;
  }

  public EditorCell createConstantCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell(editorCell, node, context);
    setupLabel_ConstantCell(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createIndentCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_IndentCell(editorCell, node, context);
    setupLabel_IndentCell(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstantCell1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell1(editorCell, node, context);
    setupLabel_ConstantCell1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createIndentCell2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_IndentCell2(editorCell, node, context);
    setupLabel_IndentCell2(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstantCell2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell2(editorCell, node, context);
    setupLabel_ConstantCell2(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstantCell3(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell3(editorCell, node, context);
    setupLabel_ConstantCell3(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createIndentCell1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_IndentCell1(editorCell, node, context);
    setupLabel_IndentCell1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createIndentCell3(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_IndentCell3(editorCell, node, context);
    setupLabel_IndentCell3(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConceptDeclarationReferenceCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new EditorComponentDeclaration_Editor._Inline());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_ConceptDeclarationReferenceCell(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_ConceptDeclarationReferenceCell((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createConceptDeclarationReferenceCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("conceptDeclaration");
    provider.setNoTargetText("<choose concept>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createConceptDeclarationReferenceCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createNameCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_NameCell(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_NameCell((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createNameCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("name");
    provider.setNoTargetText("<no name>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createNameCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createCellModelCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_CellModelCell(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_CellModelCell((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createCellModelCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("cellModel");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createCellModelCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public static class _Inline extends AbstractCellProvider {

    public _Inline() {
      super();
    }

    private static void setupBasic_NameCell(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_0233");
      SharedStyles_StyleSheet.REFERENCE_ON_CONCEPT.apply(editorCell);
    }

    private static void setupLabel_NameCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }


    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createNameCell(context, node);
    }

    public EditorCell createNameCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_NameCell(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_NameCell((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createNameCell(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("");
      provider.setReadOnly(true);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.createNameCellinternal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }

}

}
