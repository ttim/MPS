package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Nov 17, 2005 9:28:43 PM */


import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.PropertyAccessor;
import jetbrains.mps.nodeEditor.EditorCell_Property;
import java.awt.Color;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.BooleanPropertySubstituteInfo;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.nodeEditor.CellAction_DeleteProperty;

public class BooleanConstant_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createValueCell(context, node);
  }
  public EditorCell createValueCell(EditorContext context, SNode node) {
    PropertyAccessor propertyAccessor = new PropertyAccessor(node, "value", false, false, context);
    EditorCell_Property editorCell = EditorCell_Property.create(context, propertyAccessor, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(true);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.getTextLine().setFontType(MPSFonts.BOLD);
    editorCell.getTextLine().setTextColor(MPSColors.DARK_BLUE);
    editorCell.setSubstituteInfo(new BooleanPropertySubstituteInfo(node, "value", context));
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteProperty(node, "value"));
    __Expression_RTransform_ActionSet.setCellActions(editorCell, node, context);
    editorCell.addKeyMap(new _Expression_KeyMap());
    editorCell.putUserObject(EditorCell.CELL_ID, "1088424970609");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
}
