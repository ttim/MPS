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
    return this.createCollection1078939636327(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection1078941097162(context, node);
  }

  public EditorCell createCollection1078939636327(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_10789396363271078939636327(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createComponent1176717023528(context, node));
    editorCell.addEditorCell(this.createRefCell1140222839466(context, node));
    editorCell.addEditorCell(this.createComponent1176717029764(context, node));
    return editorCell;
  }

  public EditorCell createCollection1078941097162(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_10789410971621078941097162(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createComponent1214478501206(context, node));
    return editorCell;
  }

  public EditorCell createComponent1176717023528(EditorContext context, SNode node) {
    if (this.my_OpenTag6025_0 == null) {
      this.my_OpenTag6025_0 = new _OpenTag(node);
    }
    EditorCell editorCell = this.my_OpenTag6025_0.createEditorCell(context);
    setupBasic_component__OpenTag1176717023528(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createComponent1176717029764(EditorContext context, SNode node) {
    if (this.my_CloseTag6025_0 == null) {
      this.my_CloseTag6025_0 = new _CloseTag(node);
    }
    EditorCell editorCell = this.my_CloseTag6025_0.createEditorCell(context);
    setupBasic_component__CloseTag1176717029764(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createComponent1214478501206(EditorContext context, SNode node) {
    if (this.my_CellModel_Common6025_0 == null) {
      this.my_CellModel_Common6025_0 = new _CellModel_Common(node);
    }
    EditorCell editorCell = this.my_CellModel_Common6025_0.createEditorCell(context);
    setupBasic_component__CellModel_Common1214478501206(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createRefCell1140222839466_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new CellModel_Component_Editor._Inline6025_0());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refCell_editorComponent1140222839466(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refCell_editorComponent_1140222839466((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell1140222839466(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("editorComponent");
    provider.setNoTargetText("<no component>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefCell1140222839466_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_10789396363271078939636327(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1078939636327");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
    editorCell.addKeyMap(new CellModel_Component_KeyMap());
  }

  private static void setupBasic_Collection_10789410971621078941097162(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1078941097162");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_refCell_editorComponent1140222839466(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "refCell_editorComponent");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_component__OpenTag1176717023528(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "component__OpenTag");
  }

  private static void setupBasic_component__CloseTag1176717029764(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "component__CloseTag");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_component__CellModel_Common1214478501206(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "component__CellModel_Common");
  }

  private static void setupLabel_refCell_editorComponent_1140222839466(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static class _Inline6025_0 extends AbstractCellProvider {

    public _Inline6025_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty1140222845140(context, node);
    }

    public EditorCell createProperty1140222845140_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_property_name1140222845140(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_property_name_1140222845140((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty1140222845140(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.createProperty1140222845140_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }


    private static void setupBasic_property_name1140222845140(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.putUserObject(EditorCell.CELL_ID, "property_name");
      {
        Style inlineStyle = new Style(editorCell) {
          {
            this.set(StyleAttributes.DRAW_BORDER, true);
          }

        };
        inlineStyle.apply(editorCell);
      }
    }

    private static void setupLabel_property_name_1140222845140(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}

}
