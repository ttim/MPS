package jetbrains.mps.lang.dataFlow.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSColors;

public class DataFlow_StyleSheet {

  public static Style getInstruction(final EditorCell cell) {
    Style style = new Style(cell);
    style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_MAGENTA);
    return style;
  }

  public static Style getPosition(final EditorCell cell) {
    Style style = new Style(cell);
    style.set(StyleAttributes.TEXT_COLOR, MPSColors.blue);
    return style;
  }

  public static Style getMayBeUnreachable(final EditorCell cell) {
    Style style = new Style(cell);
    style.set(StyleAttributes.MATCHING_LABEL, "MayBeUnreachable");
    style.set(StyleAttributes.TEXT_COLOR, MPSColors.lightGray);
    return style;
  }

  public static Style getLabel(final EditorCell cell) {
    Style style = new Style(cell);
    style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_GREEN);
    return style;
  }

}
