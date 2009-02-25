package jetbrains.mps.lang.textGen.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.MPSFonts;

public class TextGenStyles_StyleSheet {

  public static Style getReferenceOfConcept(final EditorCell cell) {
    return new Style(cell) {
      {
        this.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_MAGENTA);
      }

    };
  }

  public static Style getTextGenOperation(final EditorCell cell) {
    return new Style(cell) {
      {
        this.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_MAGENTA);
        this.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD);
      }

    };
  }

}
