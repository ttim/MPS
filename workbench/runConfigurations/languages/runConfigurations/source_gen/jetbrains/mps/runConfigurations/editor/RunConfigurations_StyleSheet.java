package jetbrains.mps.runConfigurations.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.MPSColors;

public class RunConfigurations_StyleSheet {
  public static Style getLessThen(final EditorCell cell) {
    Style style = new Style(cell);
    style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    style.set(StyleAttributes.MATCHING_LABEL, "type.brace");
    return style;
  }

  public static Style getGreaterThen(final EditorCell cell) {
    Style style = new Style(cell);
    style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    style.set(StyleAttributes.MATCHING_LABEL, "type.brace");
    return style;
  }

  public static Style getOperation(final EditorCell cell) {
    Style style = new Style(cell);
    style.set(StyleAttributes.FONT_STYLE, MPSFonts.ITALIC);
    style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_BLUE);
    return style;
  }
}
