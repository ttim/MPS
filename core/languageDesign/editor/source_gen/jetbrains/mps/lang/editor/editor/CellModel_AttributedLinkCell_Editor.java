package jetbrains.mps.lang.editor.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.lang.editor.editor._CellModel_Common;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.lang.editor.editor.Styles_StyleSheet;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;

public class CellModel_AttributedLinkCell_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider my_CellModel_Common5840_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_5840_0(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection_5840_1(context, node);
  }

  public EditorCell createCollection_5840_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_5840_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_5840_0(context, node, "//>"));
    editorCell.addEditorCell(this.createConstant_5840_1(context, node, "attributed link"));
    editorCell.addEditorCell(this.createConstant_5840_2(context, node, "<//"));
    return editorCell;
  }

  public EditorCell createCollection_5840_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_5840_1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createComponent_5840_0(context, node));
    return editorCell;
  }

  public EditorCell createComponent_5840_0(EditorContext context, SNode node) {
    if (this.my_CellModel_Common5840_0 == null) {
      this.my_CellModel_Common5840_0 = new _CellModel_Common(node);
    }
    EditorCell editorCell = this.my_CellModel_Common5840_0.createEditorCell(context);
    setupBasic_Component_5840_0(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createConstant_5840_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_5840_0(editorCell, node, context);
    setupLabel_Constant_5840_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_5840_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_5840_1(editorCell, node, context);
    setupLabel_Constant_5840_1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_5840_2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_5840_2(editorCell, node, context);
    setupLabel_Constant_5840_2(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }


  private static void setupBasic_Collection_5840_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_5840_0");
    Styles_StyleSheet.getBorderedCollection(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_5840_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_5840_0");
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

  private static void setupBasic_Constant_5840_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_5840_1");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
          this.set(StyleAttributes.EDITABLE, false);
          this.set(StyleAttributes.TEXT_BACKGROUND_COLOR, MPSColors.green);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_5840_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_5840_2");
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

  private static void setupBasic_Collection_5840_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_5840_1");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Component_5840_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_5840_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_5840_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_5840_2(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

}
