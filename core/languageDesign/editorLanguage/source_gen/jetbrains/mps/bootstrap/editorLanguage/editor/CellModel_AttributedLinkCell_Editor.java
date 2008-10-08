package jetbrains.mps.bootstrap.editorLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import java.awt.Color;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.nodeEditor.MPSColors;

public class CellModel_AttributedLinkCell_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider my_CellModel_Common5840_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection1136564583726(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection1149850641679(context, node);
  }

  public EditorCell createCollection1136564583726(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11365645837261136564583726(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1136564583727(context, node, "//>"));
    editorCell.addEditorCell(this.createConstant1136564583728(context, node, "attributed link"));
    editorCell.addEditorCell(this.createConstant1136564583729(context, node, "<//"));
    return editorCell;
  }

  public EditorCell createCollection1149850641679(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_11498506416791149850641679(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createComponent1214478688195(context, node));
    return editorCell;
  }

  public EditorCell createComponent1214478688195(EditorContext context, SNode node) {
    if (this.my_CellModel_Common5840_0 == null) {
      this.my_CellModel_Common5840_0 = new _CellModel_Common(node);
    }
    EditorCell editorCell = this.my_CellModel_Common5840_0.createEditorCell(context);
    setupBasic_component__CellModel_Common1214478688195(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createConstant1136564583727(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11365645837271136564583727(editorCell, node, context);
    setupLabel_Constant_1136564583727_1136564583727(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1136564583728(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11365645837281136564583728(editorCell, node, context);
    setupLabel_Constant_1136564583728_1136564583728(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1136564583729(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11365645837291136564583729(editorCell, node, context);
    setupLabel_Constant_1136564583729_1136564583729(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }


  private static void setupBasic_Collection_11365645837261136564583726(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1136564583726");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellModel_AttributedLinkCell_Editor.calculateBoolean5840_5(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11365645837271136564583727(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1136564583727");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellModel_AttributedLinkCell_Editor.calculateBoolean5840_0(cell);
            }

          });
          this.set(StyleAttributes.DRAW_BORDER, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellModel_AttributedLinkCell_Editor.calculateBoolean5840_6(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11365645837281136564583728(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1136564583728");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellModel_AttributedLinkCell_Editor.calculateBoolean5840_4(cell);
            }

          });
          this.set(StyleAttributes.EDITABLE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellModel_AttributedLinkCell_Editor.calculateBoolean5840_7(cell);
            }

          });
          this.set(StyleAttributes.TEXT_BACKGROUND_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return CellModel_AttributedLinkCell_Editor.calculateColor5840_0(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11365645837291136564583729(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1136564583729");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellModel_AttributedLinkCell_Editor.calculateBoolean5840_1(cell);
            }

          });
          this.set(StyleAttributes.DRAW_BORDER, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellModel_AttributedLinkCell_Editor.calculateBoolean5840_3(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11498506416791149850641679(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1149850641679");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return CellModel_AttributedLinkCell_Editor.calculateBoolean5840_2(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_component__CellModel_Common1214478688195(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "component__CellModel_Common");
  }

  private static void setupLabel_Constant_1136564583727_1136564583727(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1136564583728_1136564583728(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1136564583729_1136564583729(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static Color calculateColor5840_0(EditorCell cell) {
    Color result;
    result = MPSColors.green;
    return result;
  }

  public static Boolean calculateBoolean5840_0(EditorCell cell) {
    boolean result;
    result = false;
    return result;
  }

  public static Boolean calculateBoolean5840_1(EditorCell cell) {
    boolean result;
    result = false;
    return result;
  }

  public static Boolean calculateBoolean5840_2(EditorCell cell) {
    boolean result;
    result = false;
    return result;
  }

  public static Boolean calculateBoolean5840_3(EditorCell cell) {
    boolean result;
    result = true;
    return result;
  }

  public static Boolean calculateBoolean5840_4(EditorCell cell) {
    boolean result;
    result = true;
    return result;
  }

  public static Boolean calculateBoolean5840_5(EditorCell cell) {
    boolean result;
    result = true;
    return result;
  }

  public static Boolean calculateBoolean5840_6(EditorCell cell) {
    boolean result;
    result = true;
    return result;
  }

  public static Boolean calculateBoolean5840_7(EditorCell cell) {
    boolean result;
    result = false;
    return result;
  }

}
