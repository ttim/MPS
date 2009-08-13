package jetbrains.mps.samples.agreementLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.MPSColors;

public class Date_Past_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createConstant_9001_0(context, node, "PAST");
  }

  private EditorCell createConstant_9001_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_9001_0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.ITALIC);
      style.set(StyleAttributes.EDITABLE, true);
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_BLUE);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

}
