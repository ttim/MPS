package jetbrains.mps.lang.editor.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import java.awt.Color;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.editor.behavior.EditorCellModel_Behavior;

public class CellModel_ConceptProperty_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_6697_0(editorContext, node);
  }

  public EditorCell createInspectedCell(EditorContext editorContext, SNode node) {
    return this.createCollection_6697_1(editorContext, node);
  }

  private EditorCell createCollection_6697_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_6697_0");
    Styles_StyleSheet.getBorderedCollection(editorCell).apply(editorCell);
    editorCell.addEditorCell(this.createComponent_6697_0(editorContext, node));
    editorCell.addEditorCell(this.createRefCell_6697_0(editorContext, node));
    editorCell.addEditorCell(this.createComponent_6697_1(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_6697_1(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_6697_1");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createComponent_6697_2(editorContext, node));
    editorCell.addEditorCell(this.createConstant_6697_3(editorContext, node));
    editorCell.addEditorCell(this.createConstant_6697_0(editorContext, node));
    editorCell.addEditorCell(this.createCollection_6697_2(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_6697_2(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_6697_2");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.DRAW_BORDER, true);
    }
    editorCell.setGridLayout(true);
    editorCell.addEditorCell(this.createCollection_6697_3(editorContext, node));
    editorCell.addEditorCell(this.createCollection_6697_4(editorContext, node));
    if (renderingCondition6697_0(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_6697_5(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_6697_3(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_6697_3");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.DRAW_BORDER, true);
    }
    editorCell.addEditorCell(this.createConstant_6697_1(editorContext, node));
    editorCell.addEditorCell(this.createRefCell_6697_1(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_6697_4(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_6697_4");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.DRAW_BORDER, true);
    }
    editorCell.addEditorCell(this.createConstant_6697_2(editorContext, node));
    editorCell.addEditorCell(this.createProperty_6697_1(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_6697_5(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_6697_5");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.DRAW_BORDER, true);
    }
    editorCell.addEditorCell(this.createConstant_6697_4(editorContext, node));
    editorCell.addEditorCell(this.createProperty_6697_3(editorContext, node));
    return editorCell;
  }

  private EditorCell createComponent_6697_0(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new _OpenTag(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    return editorCell;
  }

  private EditorCell createComponent_6697_1(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new _CloseTag(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.DRAW_BORDER, true);
    }
    return editorCell;
  }

  private EditorCell createComponent_6697_2(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new _CellModel_Common(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    return editorCell;
  }

  private EditorCell createConstant_6697_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "\u0421oncept property cell:");
    editorCell.setCellId("Constant_6697_0");
    Styles_StyleSheet.getHeader(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_6697_1(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "property");
    editorCell.setCellId("Constant_6697_1");
    Styles_StyleSheet.getProperty(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_6697_2(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "text*");
    editorCell.setCellId("Constant_6697_2");
    Styles_StyleSheet.getProperty(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_6697_3(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_6697_3");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_6697_4(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "empty text*");
    editorCell.setCellId("Constant_6697_4");
    Styles_StyleSheet.getProperty(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createRefCell_6697_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, editorContext);
    provider.setRole("propertyDeclaration");
    provider.setNoTargetText("<choose property declaration>");
    EditorCell editorCell;
    provider.setAuxiliaryCellProvider(new CellModel_ConceptProperty_Editor._Inline6697_0());
    editorCell = provider.createEditorCell(editorContext);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.DRAW_BORDER, true);
      style.set(StyleAttributes.TEXT_BACKGROUND_COLOR, new AttributeCalculator <Color>() {

        public Color calculate(EditorCell cell) {
          return CellModel_ConceptProperty_Editor._StyleParameter_QueryFunction_1221239216353((cell == null ?
            null :
            cell.getSNode()
          ), (cell == null ?
            null :
            cell.getEditorContext()
          ));
        }
      });
      style.set(StyleAttributes.BACKGROUND_COLOR, new AttributeCalculator <Color>() {

        public Color calculate(EditorCell cell) {
          return CellModel_ConceptProperty_Editor._StyleParameter_QueryFunction_1221239216360((cell == null ?
            null :
            cell.getSNode()
          ), (cell == null ?
            null :
            cell.getEditorContext()
          ));
        }
      });
      style.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

        public Color calculate(EditorCell cell) {
          return CellModel_ConceptProperty_Editor._StyleParameter_QueryFunction_1221239216367((cell == null ?
            null :
            cell.getSNode()
          ), (cell == null ?
            null :
            cell.getEditorContext()
          ));
        }
      });
      style.set(StyleAttributes.FONT_STYLE, new AttributeCalculator <Integer>() {

        public Integer calculate(EditorCell cell) {
          return CellModel_ConceptProperty_Editor._StyleParameter_QueryFunction_1221239216374((cell == null ?
            null :
            cell.getSNode()
          ), (cell == null ?
            null :
            cell.getEditorContext()
          ));
        }
      });
      style.set(StyleAttributes.UNDERLINED, new AttributeCalculator <Boolean>() {

        public Boolean calculate(EditorCell cell) {
          return CellModel_ConceptProperty_Editor._StyleParameter_QueryFunction_1221239216381((cell == null ?
            null :
            cell.getSNode()
          ), (cell == null ?
            null :
            cell.getEditorContext()
          ));
        }
      });
      style.set(StyleAttributes.STRIKE_OUT, new AttributeCalculator <Boolean>() {

        public Boolean calculate(EditorCell cell) {
          return CellModel_ConceptProperty_Editor._StyleParameter_QueryFunction_1223482294966((cell == null ?
            null :
            cell.getSNode()
          ), (cell == null ?
            null :
            cell.getEditorContext()
          ));
        }
      });
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createProperty_6697_1(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("noTargetText");
    provider.setNoTargetText("<none>");
    provider.setAllowsEmptyTarget(true);
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_noTargetText");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.DRAW_BORDER, true);
      style.set(StyleAttributes.TEXT_BACKGROUND_COLOR, MPSColors.yellow);
      style.set(StyleAttributes.SELECTED_TEXT_BACKGROUND_COLOR, MPSColors.cyan);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createRefCell_6697_1(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, editorContext);
    provider.setRole("propertyDeclaration");
    provider.setNoTargetText("<choose property declaration>");
    EditorCell editorCell;
    provider.setAuxiliaryCellProvider(new CellModel_ConceptProperty_Editor._Inline6697_1());
    editorCell = provider.createEditorCell(editorContext);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.DRAW_BORDER, true);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createProperty_6697_3(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("emptyNoTargetText");
    provider.setNoTargetText("<none>");
    provider.setAllowsEmptyTarget(true);
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_emptyNoTargetText");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.DRAW_BORDER, true);
      style.set(StyleAttributes.TEXT_BACKGROUND_COLOR, MPSColors.yellow);
      style.set(StyleAttributes.SELECTED_TEXT_BACKGROUND_COLOR, MPSColors.cyan);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }


  private static boolean renderingCondition6697_0(SNode node, EditorContext editorContext, IScope scope) {
    return SPropertyOperations.getString(node, "noTargetText") == null;
  }

  private static Color _StyleParameter_QueryFunction_1221239216353(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_getTextBackgroundColor_1220972190901(node);
  }

  private static Color _StyleParameter_QueryFunction_1221239216360(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_getBackgroundColor_1220969182195(node);
  }

  private static Color _StyleParameter_QueryFunction_1221239216367(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_getForegroundColor_1220960215403(node);
  }

  private static int _StyleParameter_QueryFunction_1221239216374(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_getFontStyle_1221053923273(node);
  }

  private static boolean _StyleParameter_QueryFunction_1221239216381(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_isUnderlined_1221220594206(node);
  }

  private static boolean _StyleParameter_QueryFunction_1223482294966(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_isStrikeOut_1223390694337(node);
  }

  public static class _Inline6697_0 extends AbstractCellProvider {

    public _Inline6697_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext editorContext) {
      return this.createEditorCell(editorContext, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
      return this.createProperty_6697_0(editorContext, node);
    }

    private EditorCell createProperty_6697_0(EditorContext editorContext, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      EditorCell editorCell;
      editorCell = provider.createEditorCell(editorContext);
      editorCell.setCellId("property_name");
      {
        Style style = editorCell.getStyle();
        style.set(StyleAttributes.DRAW_BORDER, true);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = editorContext.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
      } else
      return editorCell;
    }

}
  public static class _Inline6697_1 extends AbstractCellProvider {

    public _Inline6697_1() {
      super();
    }

    public EditorCell createEditorCell(EditorContext editorContext) {
      return this.createEditorCell(editorContext, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
      return this.createProperty_6697_2(editorContext, node);
    }

    private EditorCell createProperty_6697_2(EditorContext editorContext, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      EditorCell editorCell;
      editorCell = provider.createEditorCell(editorContext);
      editorCell.setCellId("property_name_1");
      {
        Style style = editorCell.getStyle();
        style.set(StyleAttributes.DRAW_BORDER, true);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = editorContext.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
      } else
      return editorCell;
    }

}

}
