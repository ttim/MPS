package jetbrains.mps.build.custommps.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.build.packaging.editor.PackagingStyles_StyleSheet;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;

public class CustomMpsStyles_StyleSheet {

  public static Style getUndeclaredVaribale(final EditorCell cell) {
    return new Style(cell) {
      {
        this.putAll(PackagingStyles_StyleSheet.getVariable(null));
        this.set(StyleAttributes.UNDERLINED, new AttributeCalculator <Boolean>() {

          public Boolean calculate(EditorCell cell) {
            return CustomMpsStyles_StyleSheet._StyleParameter_QueryFunction_1233937956200((cell == null ?
              null :
              cell.getSNode()
            ), (cell == null ?
              null :
              cell.getEditorContext()
            ));
          }
        });
      }
    };
  }

  public static boolean _StyleParameter_QueryFunction_1233937956200(SNode node, EditorContext editorContext) {
    return true;
  }

}
