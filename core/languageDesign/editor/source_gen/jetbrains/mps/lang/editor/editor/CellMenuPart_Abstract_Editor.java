package jetbrains.mps.lang.editor.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Error;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;

public class CellMenuPart_Abstract_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createError_7903_0(context, node);
  }

  public EditorCell createError_7903_0(EditorContext context, SNode node) {
    EditorCell_Error editorCell = new EditorCell_Error(context, node, "<choose menu part>");
    setupBasic_Error_7903_0(editorCell, node, context);
    setupLabel_Error_7903_0(editorCell, node, context);
    return editorCell;
  }


  private static void setupBasic_Error_7903_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Error_7903_0");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.FONT_STYLE, MPSFonts.ITALIC);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupLabel_Error_7903_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

}
