package jetbrains.mps.ypath.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import java.awt.Color;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.MPSColors;

public class stylesheet_Feature_StyleSheet {

  public static Style getOpposite(final EditorCell cell) {
    return new Style(cell) {
      {
        this.set(StyleAttributes.BACKGROUND_COLOR, new AttributeCalculator <Color>() {

          public Color calculate(EditorCell cell) {
            return stylesheet_Feature_StyleSheet.calculateColor9403_0(cell);
          }

        });
        this.set(StyleAttributes.FONT_STYLE, new AttributeCalculator <Integer>() {

          public Integer calculate(EditorCell cell) {
            return stylesheet_Feature_StyleSheet.calculateFontStyle9403_0(cell);
          }

        });
      }

    };
  }

  private static Integer calculateFontStyle9403_0(EditorCell cell) {
    int result;
    result = MPSFonts.BOLD;
    return result;
  }

  private static Color calculateColor9403_0(EditorCell cell) {
    Color result;
    result = MPSColors.lightGray;
    return result;
  }

}
