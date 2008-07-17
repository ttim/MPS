package jetbrains.mps.bootstrap.editorLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.nodeEditor.cells.EditorCell_Error;

public class CellMenuPart_Abstract_Editor extends DefaultNodeEditor {

  private static void setupBasic_ErrorCell9457_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ErrorCell9457_0");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.FONT_STYLE, MPSFonts.ITALIC);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupLabel_ErrorCell9457_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }


  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.create_ErrorCell9457_0(context, node);
  }

  public EditorCell create_ErrorCell9457_0(EditorContext context, SNode node) {
    EditorCell_Error editorCell = new EditorCell_Error(context, node, "<choose menu part>");
    setupBasic_ErrorCell9457_0(editorCell, node, context);
    setupLabel_ErrorCell9457_0(editorCell, node, context);
    return editorCell;
  }

}
