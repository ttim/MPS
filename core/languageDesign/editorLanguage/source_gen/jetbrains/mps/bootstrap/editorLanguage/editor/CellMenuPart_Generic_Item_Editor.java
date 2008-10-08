package jetbrains.mps.bootstrap.editorLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.PropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefNodeCellProvider;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import java.awt.Color;
import jetbrains.mps.nodeEditor.MPSColors;

public class CellMenuPart_Generic_Item_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection1165424779461(context, node);
  }

  public EditorCell createCollection1165424779461(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_11654247794611165424779461(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createCollection1165424779462(context, node));
    editorCell.addEditorCell(this.createCollection1165424779464(context, node));
    return editorCell;
  }

  public EditorCell createCollection1165424779462(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11654247794621165424779462(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1165424779463(context, node, "generic item"));
    return editorCell;
  }

  public EditorCell createCollection1165424779464(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11654247794641165424779464(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1165424779465(context, node, "  "));
    editorCell.addEditorCell(this.createCollection1165424779466(context, node));
    return editorCell;
  }

  public EditorCell createCollection1165424779466(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_11654247794661165424779466(editorCell, node, context);
    editorCell.setGridLayout(true);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(true);
    editorCell.addEditorCell(this.createCollection1165424779467(context, node));
    editorCell.addEditorCell(this.createCollection1165424779471(context, node));
    return editorCell;
  }

  public EditorCell createCollection1165424779467(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11654247794671165424779467(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1165424779468(context, node, "matching text"));
    editorCell.addEditorCell(this.createConstant1165424779469(context, node, ":"));
    editorCell.addEditorCell(this.createProperty1165424779470(context, node));
    return editorCell;
  }

  public EditorCell createCollection1165424779471(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11654247794711165424779471(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1165424779472(context, node, "handler"));
    editorCell.addEditorCell(this.createConstant1165424779473(context, node, ":"));
    editorCell.addEditorCell(this.createRefNode1165424779474(context, node));
    return editorCell;
  }

  public EditorCell createConstant1165424779463(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11654247794631165424779463(editorCell, node, context);
    setupLabel_Constant_1165424779463_1165424779463(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1165424779465(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11654247794651165424779465(editorCell, node, context);
    setupLabel_Constant_1165424779465_1165424779465(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1165424779468(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11654247794681165424779468(editorCell, node, context);
    setupLabel_Constant_1165424779468_1165424779468(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1165424779469(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11654247794691165424779469(editorCell, node, context);
    setupLabel_Constant_1165424779469_1165424779469(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1165424779472(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11654247794721165424779472(editorCell, node, context);
    setupLabel_Constant_1165424779472_1165424779472(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1165424779473(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11654247794731165424779473(editorCell, node, context);
    setupLabel_Constant_1165424779473_1165424779473(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createProperty1165424779470_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_property_matchingText1165424779470(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_property_matchingText_1165424779470((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty1165424779470(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("matchingText");
    provider.setNoTargetText("<none>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createProperty1165424779470_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefNode1165424779474_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refNode_handlerFunction1165424779474(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refNode_handlerFunction_1165424779474((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode1165424779474(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("handlerFunction");
    provider.setNoTargetText("<default>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode1165424779474_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_11654247794611165424779461(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1165424779461");
  }

  private static void setupBasic_Collection_11654247794621165424779462(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1165424779462");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellMenuPart_Generic_Item_Editor.calculateBoolean8838_4(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11654247794631165424779463(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1165424779463");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellMenuPart_Generic_Item_Editor.calculateColor8838_0(cell);
            }

          });
          this.set(StyleAttributes.TEXT_BACKGROUND_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellMenuPart_Generic_Item_Editor.calculateColor8838_2(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11654247794641165424779464(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1165424779464");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellMenuPart_Generic_Item_Editor.calculateBoolean8838_2(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11654247794651165424779465(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1165424779465");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellMenuPart_Generic_Item_Editor.calculateBoolean8838_1(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11654247794661165424779466(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1165424779466");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellMenuPart_Generic_Item_Editor.calculateBoolean8838_6(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11654247794671165424779467(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1165424779467");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellMenuPart_Generic_Item_Editor.calculateBoolean8838_3(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11654247794681165424779468(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1165424779468");
  }

  private static void setupBasic_Constant_11654247794691165424779469(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1165424779469");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellMenuPart_Generic_Item_Editor.calculateBoolean8838_0(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_property_matchingText1165424779470(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "property_matchingText");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellMenuPart_Generic_Item_Editor.calculateColor8838_1(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11654247794711165424779471(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1165424779471");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellMenuPart_Generic_Item_Editor.calculateBoolean8838_5(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11654247794721165424779472(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1165424779472");
  }

  private static void setupBasic_Constant_11654247794731165424779473(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1165424779473");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellMenuPart_Generic_Item_Editor.calculateBoolean8838_7(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_refNode_handlerFunction1165424779474(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1165424779463_1165424779463(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1165424779465_1165424779465(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1165424779468_1165424779468(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1165424779469_1165424779469(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_property_matchingText_1165424779470(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1165424779472_1165424779472(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1165424779473_1165424779473(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refNode_handlerFunction_1165424779474(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static Color calculateColor8838_0(EditorCell cell) {
    Color result;
    result = MPSColors.DARK_BLUE;
    return result;
  }

  private static Color calculateColor8838_1(EditorCell cell) {
    Color result;
    result = MPSColors.DARK_GREEN;
    return result;
  }

  private static Color calculateColor8838_2(EditorCell cell) {
    Color result;
    result = MPSColors.lightGray;
    return result;
  }

  public static Boolean calculateBoolean8838_0(EditorCell cell) {
    boolean result;
    result = false;
    return result;
  }

  public static Boolean calculateBoolean8838_1(EditorCell cell) {
    boolean result;
    result = false;
    return result;
  }

  public static Boolean calculateBoolean8838_2(EditorCell cell) {
    boolean result;
    result = false;
    return result;
  }

  public static Boolean calculateBoolean8838_3(EditorCell cell) {
    boolean result;
    result = false;
    return result;
  }

  public static Boolean calculateBoolean8838_4(EditorCell cell) {
    boolean result;
    result = false;
    return result;
  }

  public static Boolean calculateBoolean8838_5(EditorCell cell) {
    boolean result;
    result = false;
    return result;
  }

  public static Boolean calculateBoolean8838_6(EditorCell cell) {
    boolean result;
    result = false;
    return result;
  }

  public static Boolean calculateBoolean8838_7(EditorCell cell) {
    boolean result;
    result = false;
    return result;
  }

}
