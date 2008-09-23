package jetbrains.mps.transformation.generationContext.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefNodeCellProvider;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.PropertyCellProvider;

public class GenerationContextOp_GetOutputByLabelAndInput_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection1216860146339(context, node);
  }

  public EditorCell createCollection1216860146339(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_12168601463391216860146339(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1216860146340(context, node, "get output"));
    editorCell.addEditorCell(this.createRefCell1216860146341(context, node));
    editorCell.addEditorCell(this.createConstant1216860146344(context, node, "for input"));
    editorCell.addEditorCell(this.createRefNode1216860146345(context, node));
    return editorCell;
  }

  public EditorCell createConstant1216860146340(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12168601463401216860146340(editorCell, node, context);
    setupLabel_Constant_1216860146340_1216860146340(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1216860146344(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12168601463441216860146344(editorCell, node, context);
    setupLabel_Constant_1216860146344_1216860146344(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefCell1216860146341_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new GenerationContextOp_GetOutputByLabelAndInput_Editor._Inline6100_0());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refCell_label1216860146341(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refCell_label_1216860146341((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell1216860146341(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("label");
    provider.setNoTargetText("<choose mapping label>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefCell1216860146341_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefNode1216860146345_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refNode_inputNode1216860146345(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refNode_inputNode_1216860146345((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode1216860146345(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("inputNode");
    provider.setNoTargetText("<no input node>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode1216860146345_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_12168601463391216860146339(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1216860146339");
  }

  private static void setupBasic_Constant_12168601463401216860146340(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1216860146340");
    Styles_StyleSheet.getGenContext_operation(editorCell).apply(editorCell);
  }

  private static void setupBasic_refCell_label1216860146341(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "refCell_label");
    jetbrains.mps.transformation.TLBase.editor.Styles_StyleSheet.getMappingLabelReference(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_12168601463441216860146344(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1216860146344");
    Styles_StyleSheet.getGenContext_operation(editorCell).apply(editorCell);
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_refNode_inputNode1216860146345(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1216860146340_1216860146340(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refCell_label_1216860146341(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1216860146344_1216860146344(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refNode_inputNode_1216860146345(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static class _Inline6100_0 extends AbstractCellProvider {

    public _Inline6100_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty1216860146343(context, node);
    }

    public EditorCell createProperty1216860146343_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_property_name1216860146343(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_property_name_1216860146343((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty1216860146343(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.createProperty1216860146343_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }


    private static void setupBasic_property_name1216860146343(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.putUserObject(EditorCell.CELL_ID, "property_name");
    }

    private static void setupLabel_property_name_1216860146343(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}

}
