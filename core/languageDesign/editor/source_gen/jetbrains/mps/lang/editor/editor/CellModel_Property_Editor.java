package jetbrains.mps.lang.editor.editor;

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
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import java.awt.Color;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.editor.behavior.EditorCellModel_Behavior;

public class CellModel_Property_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider my_OpenTag3263_0;
  /* package */AbstractCellProvider my_CloseTag3263_0;
  /* package */AbstractCellProvider my_CellModel_Common3263_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_3263_0(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection_3263_1(context, node);
  }

  public EditorCell createCollection_3263_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_3263_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createComponent_3263_0(context, node));
    editorCell.addEditorCell(this.createRefCell_3263_1(context, node));
    editorCell.addEditorCell(this.createComponent_3263_1(context, node));
    return editorCell;
  }

  public EditorCell createCollection_3263_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_3263_1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createComponent_3263_2(context, node));
    editorCell.addEditorCell(this.createConstant_3263_5(context, node, ""));
    editorCell.addEditorCell(this.createConstant_3263_0(context, node, "Property cell:"));
    editorCell.addEditorCell(this.createCollection_3263_4(context, node));
    return editorCell;
  }

  public EditorCell createCollection_3263_2(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_3263_2(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_3263_1(context, node, "property"));
    editorCell.addEditorCell(this.createRefCell_3263_3(context, node));
    return editorCell;
  }

  public EditorCell createCollection_3263_3(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_3263_3(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_3263_2(context, node, "text*"));
    editorCell.addEditorCell(this.createProperty_3263_1(context, node));
    return editorCell;
  }

  public EditorCell createCollection_3263_4(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_3263_4(editorCell, node, context);
    editorCell.setGridLayout(true);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createCollection_3263_2(context, node));
    if (renderingCondition3263_1(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_3263_3(context, node));
    }
    if (renderingCondition3263_0(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_3263_7(context, node));
    }
    editorCell.addEditorCell(this.createCollection_3263_5(context, node));
    editorCell.addEditorCell(this.createCollection_3263_6(context, node));
    return editorCell;
  }

  public EditorCell createCollection_3263_5(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_3263_5(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_3263_3(context, node, "read only"));
    editorCell.addEditorCell(this.createProperty_3263_7(context, node));
    return editorCell;
  }

  public EditorCell createCollection_3263_6(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_3263_6(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_3263_4(context, node, "allow empty"));
    editorCell.addEditorCell(this.createProperty_3263_9(context, node));
    return editorCell;
  }

  public EditorCell createCollection_3263_7(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_3263_7(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_3263_6(context, node, "empty text*"));
    editorCell.addEditorCell(this.createProperty_3263_11(context, node));
    return editorCell;
  }

  public EditorCell createComponent_3263_0(EditorContext context, SNode node) {
    if (this.my_OpenTag3263_0 == null) {
      this.my_OpenTag3263_0 = new _OpenTag(node);
    }
    EditorCell editorCell = this.my_OpenTag3263_0.createEditorCell(context);
    setupBasic_Component_3263_0(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createComponent_3263_1(EditorContext context, SNode node) {
    if (this.my_CloseTag3263_0 == null) {
      this.my_CloseTag3263_0 = new _CloseTag(node);
    }
    EditorCell editorCell = this.my_CloseTag3263_0.createEditorCell(context);
    setupBasic_Component_3263_1(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createComponent_3263_2(EditorContext context, SNode node) {
    if (this.my_CellModel_Common3263_0 == null) {
      this.my_CellModel_Common3263_0 = new _CellModel_Common(node);
    }
    EditorCell editorCell = this.my_CellModel_Common3263_0.createEditorCell(context);
    setupBasic_Component_3263_2(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createConstant_3263_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_3263_0(editorCell, node, context);
    setupLabel_Constant_3263_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_3263_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_3263_1(editorCell, node, context);
    setupLabel_Constant_3263_1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_3263_2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_3263_2(editorCell, node, context);
    setupLabel_Constant_3263_2(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_3263_3(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_3263_3(editorCell, node, context);
    setupLabel_Constant_3263_3(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_3263_4(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_3263_4(editorCell, node, context);
    setupLabel_Constant_3263_4(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_3263_5(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_3263_5(editorCell, node, context);
    setupLabel_Constant_3263_5(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_3263_6(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_3263_6(editorCell, node, context);
    setupLabel_Constant_3263_6(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createProperty_3263_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_Property_3263_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_Property_3263_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty_3263_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("noTargetText");
    provider.setNoTargetText("<none>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(true);
    EditorCell cellWithRole = this.createProperty_3263_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefCell_3263_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new CellModel_Property_Editor._Inline3263_0());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefCell_3263_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefCell_3263_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell_3263_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("propertyDeclaration");
    provider.setNoTargetText("<no property>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefCell_3263_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefCell_3263_2_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new CellModel_Property_Editor._Inline3263_1());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefCell_3263_1(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefCell_3263_1((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell_3263_3(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("propertyDeclaration");
    provider.setNoTargetText("<no property>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefCell_3263_2_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createProperty_3263_6_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_Property_3263_3(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_Property_3263_3((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty_3263_7(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("readOnly");
    provider.setNoTargetText("<no readOnly>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createProperty_3263_6_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createProperty_3263_8_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_Property_3263_4(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_Property_3263_4((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty_3263_9(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("allowEmptyText");
    provider.setNoTargetText("<no allowEmptyText>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createProperty_3263_8_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createProperty_3263_10_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_Property_3263_5(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_Property_3263_5((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty_3263_11(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("emptyNoTargetText");
    provider.setNoTargetText("<none>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(true);
    EditorCell cellWithRole = this.createProperty_3263_10_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_3263_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_3263_0");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_3263_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_3263_1");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_3263_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_3263_0");
    Styles_StyleSheet.getHeader(editorCell).apply(editorCell);
  }

  private static void setupBasic_Collection_3263_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_3263_2");
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

  private static void setupBasic_Constant_3263_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_3263_1");
    Styles_StyleSheet.getProperty(editorCell).apply(editorCell);
  }

  private static void setupBasic_Collection_3263_3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_3263_3");
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

  private static void setupBasic_Constant_3263_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_3263_2");
    Styles_StyleSheet.getProperty(editorCell).apply(editorCell);
  }

  private static void setupBasic_Property_3263_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("property_noTargetText");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
          this.set(StyleAttributes.TEXT_BACKGROUND_COLOR, MPSColors.yellow);
          this.set(StyleAttributes.SELECTED_TEXT_BACKGROUND_COLOR, MPSColors.cyan);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_RefCell_3263_0(EditorCell editorCell, SNode node, EditorContext context) {
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
          this.set(StyleAttributes.TEXT_BACKGROUND_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellModel_Property_Editor._StyleParameter_QueryFunction_1221239223937((cell == null ?
                null :
                cell.getSNode()
              ), (cell == null ?
                null :
                cell.getEditorContext()
              ));
            }

          });
          this.set(StyleAttributes.BACKGROUND_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellModel_Property_Editor._StyleParameter_QueryFunction_1221239223944((cell == null ?
                null :
                cell.getSNode()
              ), (cell == null ?
                null :
                cell.getEditorContext()
              ));
            }

          });
          this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellModel_Property_Editor._StyleParameter_QueryFunction_1221239223951((cell == null ?
                null :
                cell.getSNode()
              ), (cell == null ?
                null :
                cell.getEditorContext()
              ));
            }

          });
          this.set(StyleAttributes.FONT_STYLE, new AttributeCalculator <Integer>() {

            public Integer calculate(EditorCell cell) {
              return CellModel_Property_Editor._StyleParameter_QueryFunction_1221239223958((cell == null ?
                null :
                cell.getSNode()
              ), (cell == null ?
                null :
                cell.getEditorContext()
              ));
            }

          });
          this.set(StyleAttributes.UNDERLINED, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellModel_Property_Editor._StyleParameter_QueryFunction_1221239223965((cell == null ?
                null :
                cell.getSNode()
              ), (cell == null ?
                null :
                cell.getEditorContext()
              ));
            }

          });
          this.set(StyleAttributes.STRIKE_OUT, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellModel_Property_Editor._StyleParameter_QueryFunction_1223482349120((cell == null ?
                null :
                cell.getSNode()
              ), (cell == null ?
                null :
                cell.getEditorContext()
              ));
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_RefCell_3263_1(EditorCell editorCell, SNode node, EditorContext context) {
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Component_3263_0(EditorCell editorCell, SNode node, EditorContext context) {
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Component_3263_1(EditorCell editorCell, SNode node, EditorContext context) {
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_3263_4(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_3263_4");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_3263_5(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_3263_5");
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

  private static void setupBasic_Constant_3263_3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_3263_3");
    Styles_StyleSheet.getProperty(editorCell).apply(editorCell);
  }

  private static void setupBasic_Property_3263_3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("property_readOnly");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_3263_6(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_3263_6");
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

  private static void setupBasic_Constant_3263_4(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_3263_4");
    Styles_StyleSheet.getProperty(editorCell).apply(editorCell);
  }

  private static void setupBasic_Property_3263_4(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("property_allowEmptyText");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_3263_5(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_3263_5");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Component_3263_2(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Collection_3263_7(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_3263_7");
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

  private static void setupBasic_Constant_3263_6(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_3263_6");
    Styles_StyleSheet.getProperty(editorCell).apply(editorCell);
  }

  private static void setupBasic_Property_3263_5(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("property_emptyNoTargetText");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
          this.set(StyleAttributes.TEXT_BACKGROUND_COLOR, MPSColors.yellow);
          this.set(StyleAttributes.SELECTED_TEXT_BACKGROUND_COLOR, MPSColors.cyan);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupLabel_Constant_3263_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_3263_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_3263_2(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Property_3263_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefCell_3263_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefCell_3263_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_3263_3(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Property_3263_3(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_3263_4(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Property_3263_4(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_3263_5(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_3263_6(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Property_3263_5(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static boolean renderingCondition3263_0(SNode node, EditorContext editorContext, IScope scope) {
    return SPropertyOperations.getString(node, "noTargetText") == null;
  }

  public static boolean renderingCondition3263_1(SNode node, EditorContext editorContext, IScope scope) {
    return !(SPropertyOperations.getBoolean(node, "emptyNoTargetText"));
  }

  public static Color _StyleParameter_QueryFunction_1221239223937(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_getTextBackgroundColor_1220972190901(node);
  }

  public static Color _StyleParameter_QueryFunction_1221239223944(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_getBackgroundColor_1220969182195(node);
  }

  public static Color _StyleParameter_QueryFunction_1221239223951(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_getForegroundColor_1220960215403(node);
  }

  public static int _StyleParameter_QueryFunction_1221239223958(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_getFontStyle_1221053923273(node);
  }

  public static boolean _StyleParameter_QueryFunction_1221239223965(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_isUnderlined_1221220594206(node);
  }

  public static boolean _StyleParameter_QueryFunction_1223482349120(SNode node, EditorContext editorContext) {
    return EditorCellModel_Behavior.call_isStrikeOut_1223390694337(node);
  }

  public static class _Inline3263_0 extends AbstractCellProvider {

    public _Inline3263_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty_3263_3(context, node);
    }

    public EditorCell createProperty_3263_2_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_Property_3263_1(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_Property_3263_1((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty_3263_3(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.createProperty_3263_2_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }


    private static void setupBasic_Property_3263_1(EditorCell editorCell, SNode node, EditorContext context) {
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

    private static void setupLabel_Property_3263_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}
  public static class _Inline3263_1 extends AbstractCellProvider {

    public _Inline3263_1() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty_3263_5(context, node);
    }

    public EditorCell createProperty_3263_4_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_Property_3263_2(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_Property_3263_2((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty_3263_5(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.createProperty_3263_4_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }


    private static void setupBasic_Property_3263_2(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.setCellId("property_name_1");
      {
        Style inlineStyle = new Style(editorCell) {
          {
            this.set(StyleAttributes.DRAW_BORDER, true);
          }

        };
        inlineStyle.apply(editorCell);
      }
    }

    private static void setupLabel_Property_3263_2(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}

}
