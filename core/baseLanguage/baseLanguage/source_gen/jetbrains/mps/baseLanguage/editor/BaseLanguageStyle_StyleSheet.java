package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import java.awt.Color;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.MPSColors;

public class BaseLanguageStyle_StyleSheet {
  public static final Style KEY_WORD = new Style() {
    {
      this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

        public Color calculate(EditorCell cell) {
          return BaseLanguageStyle_StyleSheet.calculateColor(cell);
        }

      });
      this.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD);
    }

  };
  public static final Style COMPACT_KEY_WORD = new Style() {
    {
      this.putAll(BaseLanguageStyle_StyleSheet.KEY_WORD);
      this.set(StyleAttributes.PADDING_LEFT, 0.0);
      this.set(StyleAttributes.PADDING_RIGHT, 0.0);
    }

  };
  public static final Style COMMENT = new Style() {
    {
      this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

        public Color calculate(EditorCell cell) {
          return BaseLanguageStyle_StyleSheet.calculateColor4(cell);
        }

      });
      this.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD);
    }

  };
  public static final Style FIELD = new Style() {
    {
      this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

        public Color calculate(EditorCell cell) {
          return BaseLanguageStyle_StyleSheet.calculateColor5(cell);
        }

      });
      this.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD);
    }

  };
  public static final Style LOCAL_VARIABLE = new Style() {
    {
    }

  };
  public static final Style PARAMETER = new Style() {
    {
    }

  };
  public static final Style STATIC_FIELD = new Style() {
    {
      this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

        public Color calculate(EditorCell cell) {
          return BaseLanguageStyle_StyleSheet.calculateColor3(cell);
        }

      });
      this.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD_ITALIC);
    }

  };
  public static final Style STRING_LITERAL = new Style() {
    {
      this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

        public Color calculate(EditorCell cell) {
          return BaseLanguageStyle_StyleSheet.calculateColor1(cell);
        }

      });
      this.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD);
    }

  };
  public static final Style NUMERIC_LITERAL = new Style() {
    {
      this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

        public Color calculate(EditorCell cell) {
          return BaseLanguageStyle_StyleSheet.calculateColor6(cell);
        }

      });
    }

  };
  public static final Style EMPTY_CELL = new Style() {
    {
      this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

        public Color calculate(EditorCell cell) {
          return BaseLanguageStyle_StyleSheet.calculateColor2(cell);
        }

      });
    }

  };
  public static final Style INSTANCE_METHOD = new Style() {
    {
    }

  };
  public static final Style STATIC_METHOD = new Style() {
    {
      this.set(StyleAttributes.FONT_STYLE, MPSFonts.ITALIC);
    }

  };
  public static final Style ANNOTATION = new Style() {
    {
      this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

        public Color calculate(EditorCell cell) {
          return BaseLanguageStyle_StyleSheet.calculateColor7(cell);
        }

      });
    }

  };
  public static final Style OPERATOR = new Style() {
    {
      this.set(StyleAttributes.FONT_STYLE, MPSFonts.PLAIN);
      this.set(StyleAttributes.PADDING_LEFT, 1.0);
      this.set(StyleAttributes.PADDING_RIGHT, 1.0);
    }

  };
  public static final Style PARENTHESIS = new Style() {
    {
      this.set(StyleAttributes.FONT_STYLE, MPSFonts.PLAIN);
    }

  };
  public static final Style LEFT_PAREN = new Style() {
    {
      this.putAll(BaseLanguageStyle_StyleSheet.PARENTHESIS);
      this.set(StyleAttributes.FIRST_POSITION_ALLOWED, false);
      this.set(StyleAttributes.PADDING_LEFT, 0.0);
      this.set(StyleAttributes.PADDING_RIGHT, 0.0);
    }

  };
  public static final Style RIGHT_PAREN = new Style() {
    {
      this.putAll(BaseLanguageStyle_StyleSheet.PARENTHESIS);
      this.set(StyleAttributes.FIRST_POSITION_ALLOWED, false);
      this.set(StyleAttributes.PADDING_LEFT, 0.0);
      this.set(StyleAttributes.PADDING_RIGHT, 0.0);
    }

  };
  public static final Style BRACE = new Style() {
    {
      this.set(StyleAttributes.FONT_STYLE, MPSFonts.PLAIN);
    }

  };
  public static final Style LEFT_BRACE = new Style() {
    {
      this.putAll(BaseLanguageStyle_StyleSheet.BRACE);
      this.set(StyleAttributes.PADDING_LEFT, 1.0);
      this.set(StyleAttributes.PADDING_RIGHT, 0.0);
    }

  };
  public static final Style RIGHT_BRACE = new Style() {
    {
      this.putAll(BaseLanguageStyle_StyleSheet.BRACE);
    }

  };
  public static final Style BRACKET = new Style() {
    {
      this.set(StyleAttributes.FONT_STYLE, MPSFonts.PLAIN);
      this.set(StyleAttributes.PADDING_RIGHT, 0.0);
    }

  };
  public static final Style METHOD_NAME = new Style() {
    {
      this.set(StyleAttributes.PADDING_LEFT, 0.0);
      this.set(StyleAttributes.PADDING_RIGHT, 0.0);
    }

  };
  public static final Style VARIABLE_NAME = new Style() {
    {
      this.set(StyleAttributes.PADDING_RIGHT, 0.0);
    }

  };
  public static final Style CLASS_NAME = new Style() {
    {
      this.set(StyleAttributes.PADDING_LEFT, 0.0);
      this.set(StyleAttributes.PADDING_RIGHT, 0.0);
    }

  };
  public static final Style SEMICOLON = new Style() {
    {
      this.set(StyleAttributes.PADDING_LEFT, 0.0);
      this.set(StyleAttributes.PADDING_RIGHT, 0.0);
      this.set(StyleAttributes.FIRST_POSITION_ALLOWED, false);
    }

  };
  public static final Style DOT = new Style() {
    {
      this.set(StyleAttributes.PADDING_LEFT, 0.0);
      this.set(StyleAttributes.PADDING_RIGHT, 0.0);
      this.set(StyleAttributes.SELECTABLE, false);
    }

  };

  private static Color calculateColor(EditorCell cell) {
    Color result;
    result = MPSColors.DARK_BLUE;
    return result;
  }

  private static Color calculateColor1(EditorCell cell) {
    Color result;
    result = MPSColors.DARK_GREEN;
    return result;
  }

  private static Color calculateColor2(EditorCell cell) {
    Color result;
    result = Color.lightGray;
    return result;
  }

  private static Color calculateColor3(EditorCell cell) {
    Color result;
    result = MPSColors.DARK_MAGENTA;
    return result;
  }

  private static Color calculateColor4(EditorCell cell) {
    Color result;
    result = Color.darkGray;
    return result;
  }

  private static Color calculateColor5(EditorCell cell) {
    Color result;
    result = MPSColors.DARK_MAGENTA;
    return result;
  }

  private static Color calculateColor6(EditorCell cell) {
    Color result;
    result = Color.blue;
    return result;
  }

  private static Color calculateColor7(EditorCell cell) {
    Color result;
    result = MPSColors.DARK_GREEN;
    return result;
  }

}
