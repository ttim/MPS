package jetbrains.mps.bootstrap.editorLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
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
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.PropertyCellProvider;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import java.awt.Color;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.bootstrap.editorLanguage.behavior.EditorCellModel_Behavior;
import jetbrains.mps.nodeEditor.MPSColors;

public class CellModel_ConceptProperty_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider my_OpenTag6697_0;
  /* package */AbstractCellProvider my_CloseTag6697_0;
  /* package */AbstractCellProvider my_CellModel_Common6697_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection1137555427555(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection1137633209013(context, node);
  }

  public EditorCell createCollection1137555427555(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11375554275551137555427555(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createComponent1176717232411(context, node));
    editorCell.addEditorCell(this.createRefCell1137555500983(context, node));
    editorCell.addEditorCell(this.createComponent1176717240099(context, node));
    return editorCell;
  }

  public EditorCell createCollection1137633209013(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_11376332090131137633209013(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createComponent1214478593121(context, node));
    editorCell.addEditorCell(this.createConstant1214478581228(context, node, ""));
    editorCell.addEditorCell(this.createConstant1137633209014(context, node, "\u0421oncept property cell:"));
    editorCell.addEditorCell(this.createCollection1137633209015(context, node));
    return editorCell;
  }

  public EditorCell createCollection1137633209015(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_11376332090151137633209015(editorCell, node, context);
    editorCell.setGridLayout(true);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createCollection1137633209016(context, node));
    editorCell.addEditorCell(this.createCollection1137633209019(context, node));
    if (renderingCondition6697_0(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection1214560486333(context, node));
    }
    return editorCell;
  }

  public EditorCell createCollection1137633209016(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11376332090161137633209016(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1137633209017(context, node, "property"));
    editorCell.addEditorCell(this.createRefCell1137633280382(context, node));
    return editorCell;
  }

  public EditorCell createCollection1137633209019(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11376332090191137633209019(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1137633209020(context, node, "text*"));
    editorCell.addEditorCell(this.createProperty1137633209021(context, node));
    return editorCell;
  }

  public EditorCell createCollection1214560486333(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_12145604863331214560486333(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1214560486334(context, node, "empty text*"));
    editorCell.addEditorCell(this.createProperty1214560486335(context, node));
    return editorCell;
  }

  public EditorCell createComponent1176717232411(EditorContext context, SNode node) {
    if (this.my_OpenTag6697_0 == null) {
      this.my_OpenTag6697_0 = new _OpenTag(node);
    }
    EditorCell editorCell = this.my_OpenTag6697_0.createEditorCell(context);
    setupBasic_component__OpenTag1176717232411(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createComponent1176717240099(EditorContext context, SNode node) {
    if (this.my_CloseTag6697_0 == null) {
      this.my_CloseTag6697_0 = new _CloseTag(node);
    }
    EditorCell editorCell = this.my_CloseTag6697_0.createEditorCell(context);
    setupBasic_component__CloseTag1176717240099(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createComponent1214478593121(EditorContext context, SNode node) {
    if (this.my_CellModel_Common6697_0 == null) {
      this.my_CellModel_Common6697_0 = new _CellModel_Common(node);
    }
    EditorCell editorCell = this.my_CellModel_Common6697_0.createEditorCell(context);
    setupBasic_component__CellModel_Common1214478593121(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createConstant1137633209014(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11376332090141137633209014(editorCell, node, context);
    setupLabel_Constant_1137633209014_1137633209014(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1137633209017(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11376332090171137633209017(editorCell, node, context);
    setupLabel_Constant_1137633209017_1137633209017(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1137633209020(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11376332090201137633209020(editorCell, node, context);
    setupLabel_Constant_1137633209020_1137633209020(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1214478581228(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12144785812281214478581228(editorCell, node, context);
    setupLabel_Constant_1214478581228_1214478581228(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1214560486334(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12145604863341214560486334(editorCell, node, context);
    setupLabel_Constant_1214560486334_1214560486334(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefCell1137555500983_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new CellModel_ConceptProperty_Editor._Inline6697_0());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refCell_propertyDeclaration1137555500983(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refCell_propertyDeclaration_1137555500983((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell1137555500983(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("propertyDeclaration");
    provider.setNoTargetText("<choose property declaration>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefCell1137555500983_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createProperty1137633209021_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_property_noTargetText1137633209021(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_property_noTargetText_1137633209021((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty1137633209021(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("noTargetText");
    provider.setNoTargetText("<none>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(true);
    EditorCell cellWithRole = this.createProperty1137633209021_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefCell1137633280382_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new CellModel_ConceptProperty_Editor._Inline6697_1());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refCell_propertyDeclaration1137633280382(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refCell_propertyDeclaration_1137633280382((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell1137633280382(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("propertyDeclaration");
    provider.setNoTargetText("<choose property declaration>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefCell1137633280382_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createProperty1214560486335_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_property_emptyNoTargetText1214560486335(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_property_emptyNoTargetText_1214560486335((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty1214560486335(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("emptyNoTargetText");
    provider.setNoTargetText("<none>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(true);
    EditorCell cellWithRole = this.createProperty1214560486335_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_11375554275551137555427555(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1137555427555");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_refCell_propertyDeclaration1137555500983(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "refCell_propertyDeclaration");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
          this.set(StyleAttributes.TEXT_BACKGROUND_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellModel_ConceptProperty_Editor.calculateColor6697_4(cell);
            }

          });
          this.set(StyleAttributes.BACKGROUND_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellModel_ConceptProperty_Editor.calculateColor6697_5(cell);
            }

          });
          this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellModel_ConceptProperty_Editor.calculateColor6697_6(cell);
            }

          });
          this.set(StyleAttributes.FONT_STYLE, new AttributeCalculator <Integer>() {

            public Integer calculate(EditorCell cell) {
              return CellModel_ConceptProperty_Editor.calculateFontStyle6697_0(cell);
            }

          });
          this.set(StyleAttributes.UNDERLINED, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellModel_ConceptProperty_Editor.calculateUnderlined6697_0(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11376332090131137633209013(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1137633209013");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11376332090141137633209014(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1137633209014");
    Styles_StyleSheet.HEADER.apply(editorCell);
  }

  private static void setupBasic_Collection_11376332090151137633209015(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1137633209015");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11376332090161137633209016(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1137633209016");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11376332090171137633209017(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1137633209017");
    Styles_StyleSheet.PROPERTY.apply(editorCell);
  }

  private static void setupBasic_Collection_11376332090191137633209019(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1137633209019");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11376332090201137633209020(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1137633209020");
    Styles_StyleSheet.PROPERTY.apply(editorCell);
  }

  private static void setupBasic_property_noTargetText1137633209021(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "property_noTargetText");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
          this.set(StyleAttributes.TEXT_BACKGROUND_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellModel_ConceptProperty_Editor.calculateColor6697_0(cell);
            }

          });
          this.set(StyleAttributes.SELECTED_TEXT_BACKGROUND_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellModel_ConceptProperty_Editor.calculateColor6697_1(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_refCell_propertyDeclaration1137633280382(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "refCell_propertyDeclaration");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_component__OpenTag1176717232411(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "component__OpenTag");
  }

  private static void setupBasic_component__CloseTag1176717240099(EditorCell editorCell, SNode node, EditorContext context) {
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

  private static void setupBasic_Constant_12144785812281214478581228(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1214478581228");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_component__CellModel_Common1214478593121(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "component__CellModel_Common");
  }

  private static void setupBasic_Collection_12145604863331214560486333(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1214560486333");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_12145604863341214560486334(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1214560486334");
    Styles_StyleSheet.PROPERTY.apply(editorCell);
  }

  private static void setupBasic_property_emptyNoTargetText1214560486335(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "property_emptyNoTargetText");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
          this.set(StyleAttributes.TEXT_BACKGROUND_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellModel_ConceptProperty_Editor.calculateColor6697_2(cell);
            }

          });
          this.set(StyleAttributes.SELECTED_TEXT_BACKGROUND_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellModel_ConceptProperty_Editor.calculateColor6697_3(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupLabel_refCell_propertyDeclaration_1137555500983(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1137633209014_1137633209014(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1137633209017_1137633209017(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1137633209020_1137633209020(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_property_noTargetText_1137633209021(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refCell_propertyDeclaration_1137633280382(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1214478581228_1214478581228(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1214560486334_1214560486334(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_property_emptyNoTargetText_1214560486335(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static boolean renderingCondition6697_0(SNode node, EditorContext editorContext, IScope scope) {
    return SPropertyOperations.getString(node, "noTargetText") == null;
  }

  public static Color _null_1221239216353(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_getTextBackgroundColor_1220972190901(node);
  }

  public static Color _null_1221239216360(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_getBackgroundColor_1220969182195(node);
  }

  public static Color _null_1221239216367(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_getForegroundColor_1220960215403(node);
  }

  public static int _null_1221239216374(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_getFontStyle_1221053923273(node);
  }

  public static boolean _null_1221239216381(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_isUnderlined_1221220594206(node);
  }

  private static Integer calculateFontStyle6697_0(EditorCell cell) {
    int result;
    result = CellModel_ConceptProperty_Editor._null_1221239216374(cell.getSNode(), cell.getEditorContext());
    return result;
  }

  private static Color calculateColor6697_0(EditorCell cell) {
    Color result;
    result = MPSColors.yellow;
    return result;
  }

  private static Color calculateColor6697_1(EditorCell cell) {
    Color result;
    result = MPSColors.cyan;
    return result;
  }

  private static Color calculateColor6697_2(EditorCell cell) {
    Color result;
    result = MPSColors.yellow;
    return result;
  }

  private static Color calculateColor6697_3(EditorCell cell) {
    Color result;
    result = MPSColors.cyan;
    return result;
  }

  private static Color calculateColor6697_4(EditorCell cell) {
    Color result;
    result = CellModel_ConceptProperty_Editor._null_1221239216353(cell.getSNode(), cell.getEditorContext());
    return result;
  }

  private static Color calculateColor6697_5(EditorCell cell) {
    Color result;
    result = CellModel_ConceptProperty_Editor._null_1221239216360(cell.getSNode(), cell.getEditorContext());
    return result;
  }

  private static Color calculateColor6697_6(EditorCell cell) {
    Color result;
    result = CellModel_ConceptProperty_Editor._null_1221239216367(cell.getSNode(), cell.getEditorContext());
    return result;
  }

  private static boolean calculateUnderlined6697_0(EditorCell cell) {
    boolean result;
    result = CellModel_ConceptProperty_Editor._null_1221239216381(cell.getSNode(), cell.getEditorContext());
    return result;
  }

  public static class _Inline6697_0 extends AbstractCellProvider {

    public _Inline6697_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty1137555520594(context, node);
    }

    public EditorCell createProperty1137555520594_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_property_name1137555520594(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_property_name_1137555520594((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty1137555520594(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.createProperty1137555520594_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }


    private static void setupBasic_property_name1137555520594(EditorCell editorCell, SNode node, EditorContext context) {
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

    private static void setupLabel_property_name_1137555520594(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}
  public static class _Inline6697_1 extends AbstractCellProvider {

    public _Inline6697_1() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty1137633280384(context, node);
    }

    public EditorCell createProperty1137633280384_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_property_name1137633280384(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_property_name_1137633280384((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty1137633280384(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.createProperty1137633280384_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }


    private static void setupBasic_property_name1137633280384(EditorCell editorCell, SNode node, EditorContext context) {
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

    private static void setupLabel_property_name_1137633280384(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}

}
