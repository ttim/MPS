package jetbrains.mps.uiLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.MPSFonts;

public class Stylesheet_StyleSheet {

  public static Style getAttribute(final EditorCell cell) {
    return new Style(cell) {
      {
        this.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_MAGENTA);
        this.set(StyleAttributes.FONT_STYLE, MPSFonts.PLAIN);
      }

    };
  }

  public static Style getComponent(final EditorCell cell) {
    return new Style(cell) {
      {
        this.set(StyleAttributes.TEXT_COLOR, MPSColors.blue);
        this.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD);
      }

    };
  }

  public static Style getComponentInstanceName(final EditorCell cell) {
    return new Style(cell) {
      {
        this.set(StyleAttributes.TEXT_COLOR, MPSColors.blue);
        this.set(StyleAttributes.FONT_STYLE, MPSFonts.ITALIC);
      }

    };
  }

  public static Style getLayoutConstraint(final EditorCell cell) {
    return new Style(cell) {
      {
        this.putAll(Stylesheet_StyleSheet.getAttribute(null));
        this.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD);
      }

    };
  }

  public static Style getActionHandler(final EditorCell cell) {
    return new Style(cell) {
      {
        this.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_GREEN);
        this.set(StyleAttributes.FONT_STYLE, MPSFonts.PLAIN);
      }

    };
  }

  public static Style getModel(final EditorCell cell) {
    return new Style(cell) {
      {
        this.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_BLUE);
        this.set(StyleAttributes.FONT_STYLE, MPSFonts.PLAIN);
      }

    };
  }

}
