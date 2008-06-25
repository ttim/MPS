package jetbrains.mps.bootstrap.editorLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import java.awt.Color;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.nodeEditor.ModelAccessor;
import jetbrains.mps.nodeEditor.EditorCell_Property;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.nodeEditor.CellAction_Empty;
import jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;

public class _OpenTag extends AbstractCellProvider {

  public _OpenTag(SNode node) {
    super(node);
  }

  private static void setupBasic_ModelAccessCell15352_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ModelAccessCell15352_0");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
          this.set(StyleAttributes.BACKGROUND_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return _OpenTag.calculateColor9(cell);
            }

          });
          this.set(StyleAttributes.EDITABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupLabel_ModelAccessCell15352_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static Color _QueryFunction_Color_1214396913666(SNode node, EditorContext editorContext) {
    return _EditorUtil.grayIfNotSelectable(node);
  }

  private static Color calculateColor9(EditorCell cell) {
    Color result;
    result = _QueryFunction_Color_1214396913666((cell == null ?
      null :
      cell.getSNode()
    ), (cell == null ?
      null :
      cell.getEditorContext()
    ));
    return result;
  }


  public EditorCell createEditorCell(EditorContext context) {
    return this.createEditorCell(context, this.getSNode());
  }

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.create_ModelAccessCell15352_0(context, node);
  }

  public EditorCell create_ModelAccessCell15352_0(EditorContext context, SNode node) {
    ModelAccessor modelAccessor = this._modelAcessorFactory_1176716878596(context, node);
    EditorCell_Property editorCell = EditorCell_Property.create(context, modelAccessor, node);
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_Empty());
    setupBasic_ModelAccessCell15352_0(editorCell, node, context);
    setupLabel_ModelAccessCell15352_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public ModelAccessor _modelAcessorFactory_1176716878596(final EditorContext editorContext, final SNode node) {
    return new ModelAccessor() {

      public String getText() {
        return EditorCellTags.getOpeningText(((EditorCellModel)SNodeOperations.getAdapter(node)));
      }

      public void setText(String text) {
      }

      public boolean isValidText(String text) {
        return true;
      }

    };
  }

}
