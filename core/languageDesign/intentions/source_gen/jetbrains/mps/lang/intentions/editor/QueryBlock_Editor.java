package jetbrains.mps.lang.intentions.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.baseLanguage.editor.ConceptFunction_Component;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.behavior.ConceptFunction_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.FocusPolicy;

public class QueryBlock_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider myConceptFunction_Component6409_0;
  /* package */AbstractCellProvider myCellProvider6409_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_6409_0(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCustom_6409_0(context, node);
  }

  public EditorCell createCollection_6409_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_6409_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createCollection_6409_1(context, node));
    editorCell.addEditorCell(this.createComponent_6409_0(context, node));
    return editorCell;
  }

  public EditorCell createCollection_6409_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_6409_1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_6409_0(context, node, "type"));
    editorCell.addEditorCell(this.createConstant_6409_1(context, node, ":"));
    editorCell.addEditorCell(this.createRefNode_6409_1(context, node));
    return editorCell;
  }

  public EditorCell createComponent_6409_0(EditorContext context, SNode node) {
    if (this.myConceptFunction_Component6409_0 == null) {
      this.myConceptFunction_Component6409_0 = new ConceptFunction_Component(node);
    }
    EditorCell editorCell = this.myConceptFunction_Component6409_0.createEditorCell(context);
    setupBasic_Component_6409_0(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createConstant_6409_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6409_0(editorCell, node, context);
    setupLabel_Constant_6409_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_6409_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6409_1(editorCell, node, context);
    setupLabel_Constant_6409_1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createCustom_6409_0(EditorContext context, SNode node) {
    if (this.myCellProvider6409_0 == null) {
      this.myCellProvider6409_0 = this._cellProviderFactory_1240319640305(node, context);
    }
    EditorCell editorCell = this.myCellProvider6409_0.createEditorCell(context);
    setupBasic_Custom_6409_0(editorCell, node, context);
    return editorCell;
  }

  public AbstractCellProvider _cellProviderFactory_1240319640305(final SNode node, final EditorContext editorContext) {
    return new AbstractCellProvider() {

      public EditorCell createEditorCell(EditorContext editorContext) {
        EditorCell_Collection collection = EditorCell_Collection.createVertical(editorContext, node);
        collection.addEditorCell(new EditorCell_Constant(editorContext, node, "Concept function help:"));
        if (SConceptPropertyOperations.getString(SNodeOperations.getConceptDeclaration(node), "shortDescription") != null) {
          collection.addEditorCell(new EditorCell_Constant(editorContext, node, SConceptPropertyOperations.getString(SNodeOperations.getConceptDeclaration(node), "shortDescription")));
        }
        collection.addEditorCell(new EditorCell_Constant(editorContext, node, ""));
        collection.addEditorCell(new EditorCell_Constant(editorContext, node, "Parameter help:"));
        for(SNode cfp : ConceptFunction_Behavior.call_getParameters_1213877374450(node)) {
          String alias = SPropertyOperations.getString(cfp, "alias");
          String description = SPropertyOperations.getString(cfp, "shortDescription");
          if (description == null) {
            description = "<no help. use short_description concept function property to create one>";
          }
          EditorCell_Constant message = new EditorCell_Constant(editorContext, node, alias + " : " + description);
          collection.addEditorCell(message);
        }
        return collection;
      }
    };
  }

  public EditorCell createRefNode_6409_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_6409_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_6409_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_6409_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("paramType");
    provider.setNoTargetText("<no paramType>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_6409_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Component_6409_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Custom_6409_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Custom_6409_0");
  }

  private static void setupBasic_Collection_6409_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_6409_0");
  }

  private static void setupBasic_Collection_6409_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_6409_1");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.SELECTABLE, false);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_6409_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6409_0");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.FONT_STYLE, MPSFonts.PLAIN);
          this.set(StyleAttributes.SELECTABLE, true);
          this.set(StyleAttributes.EDITABLE, false);
          this.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_BLUE);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_6409_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6409_1");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, true);
          this.set(StyleAttributes.EDITABLE, false);
          this.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_BLUE);
          this.set(StyleAttributes.PUNCTUATION_LEFT, true);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_RefNode_6409_0(EditorCell editorCell, SNode node, EditorContext context) {
    if (true) {
      editorCell.setFocusPolicy(FocusPolicy.ATTRACTS_FOCUS);
    }
  }

  private static void setupLabel_Constant_6409_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_6409_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNode_6409_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

}
