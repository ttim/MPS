package jetbrains.mps.bootstrap.editorLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cells.ModelAccessor;
import jetbrains.mps.nodeEditor.cells.EditorCell_Property;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_Empty;
import jetbrains.mps.bootstrap.editorLanguage.behavior.EditorCellModel_Behavior;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import java.awt.Color;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;

public class _OpenTag extends AbstractCellProvider {

  public _OpenTag(SNode node) {
    super(node);
  }

  public EditorCell createEditorCell(EditorContext context) {
    return this.createEditorCell(context, this.getSNode());
  }

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createModelAccess1176716878596(context, node);
  }

  public EditorCell createModelAccess1176716878596(EditorContext context, SNode node) {
    ModelAccessor modelAccessor = this._modelAcessorFactory_1176716878596(context, node);
    EditorCell_Property editorCell = EditorCell_Property.create(context, modelAccessor, node);
    editorCell.setAction(CellActionType.DELETE, new CellAction_Empty());
    setupBasic_ModelAccess_11767168785961176716878596(editorCell, node, context);
    setupLabel_ModelAccess_1176716878596_1176716878596(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public ModelAccessor _modelAcessorFactory_1176716878596(final EditorContext editorContext, final SNode node) {
    return new ModelAccessor() {

      public String getText() {
        return EditorCellModel_Behavior.call_getOpeningTag_1220340471382(node);
      }

      public void setText(String text) {
      }

      public boolean isValidText(String text) {
        return true;
      }

    };
  }


  private static void setupBasic_ModelAccess_11767168785961176716878596(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "ModelAccess_1176716878596");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
          this.set(StyleAttributes.BACKGROUND_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return _OpenTag.calculateColor4575_0(cell);
            }

          });
          this.set(StyleAttributes.EDITABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupLabel_ModelAccess_1176716878596_1176716878596(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static Color _QueryFunction_Color_1214396913666(SNode node, EditorContext editorContext) {
    return _EditorUtil.grayIfNotSelectable(node);
  }

  private static Color calculateColor4575_0(EditorCell cell) {
    Color result;
    result = _OpenTag._QueryFunction_Color_1214396913666((cell == null ?
      null :
      cell.getSNode()
    ), (cell == null ?
      null :
      cell.getEditorContext()
    ));
    return result;
  }

}
