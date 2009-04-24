package jetbrains.mps.lang.editor.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;

public class CellModel_Component_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider my_OpenTag6025_0;
  /* package */AbstractCellProvider my_CloseTag6025_0;
  /* package */AbstractCellProvider my_CellModel_Common6025_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_6025_0(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection_6025_1(context, node);
  }

  public EditorCell createCollection_6025_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_6025_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createComponent_6025_0(context, node));
    editorCell.addEditorCell(this.createRefCell_6025_1(context, node));
    editorCell.addEditorCell(this.createComponent_6025_1(context, node));
    return editorCell;
  }

  public EditorCell createCollection_6025_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_6025_1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createComponent_6025_2(context, node));
    return editorCell;
  }

  public EditorCell createComponent_6025_0(EditorContext context, SNode node) {
    if (this.my_OpenTag6025_0 == null) {
      this.my_OpenTag6025_0 = new _OpenTag(node);
    }
    EditorCell editorCell = this.my_OpenTag6025_0.createEditorCell(context);
    setupBasic_Component_6025_0(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createComponent_6025_1(EditorContext context, SNode node) {
    if (this.my_CloseTag6025_0 == null) {
      this.my_CloseTag6025_0 = new _CloseTag(node);
    }
    EditorCell editorCell = this.my_CloseTag6025_0.createEditorCell(context);
    setupBasic_Component_6025_1(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createComponent_6025_2(EditorContext context, SNode node) {
    if (this.my_CellModel_Common6025_0 == null) {
      this.my_CellModel_Common6025_0 = new _CellModel_Common(node);
    }
    EditorCell editorCell = this.my_CellModel_Common6025_0.createEditorCell(context);
    setupBasic_Component_6025_2(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createRefCell_6025_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new CellModel_Component_Editor._Inline6025_0());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefCell_6025_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefCell_6025_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell_6025_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("editorComponent");
    provider.setNoTargetText("<no component>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefCell_6025_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_6025_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_6025_0");
    Styles_StyleSheet.getRootCellModelStyle(editorCell).apply(editorCell);
    editorCell.addKeyMap(new CellModel_Component_KeyMap());
  }

  private static void setupBasic_Collection_6025_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_6025_1");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_RefCell_6025_0(EditorCell editorCell, SNode node, EditorContext context) {
    Styles_StyleSheet.getBordered(editorCell).apply(editorCell);
  }

  private static void setupBasic_Component_6025_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Component_6025_1(EditorCell editorCell, SNode node, EditorContext context) {
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Component_6025_2(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefCell_6025_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static class _Inline6025_0 extends AbstractCellProvider {

    public _Inline6025_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty_6025_1(context, node);
    }

    public EditorCell createProperty_6025_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_Property_6025_0(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_Property_6025_0((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty_6025_1(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.createProperty_6025_0_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }


    private static void setupBasic_Property_6025_0(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.setCellId("property_name");
      {
        Style inlineStyle = new Style(editorCell) {
          {
            this.set(StyleAttributes.DRAW_BORDER, true);
          }
        };
        inlineStyle.apply(editorCell);
      }
    }

    private static void setupLabel_Property_6025_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}

}
