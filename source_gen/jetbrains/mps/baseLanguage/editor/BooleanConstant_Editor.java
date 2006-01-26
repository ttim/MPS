package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Jan 25, 2006 10:42:58 PM */


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
import jetbrains.mps.annotations.PropertyAttributeConcept;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;

public class BooleanConstant_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createValueCell(context, node);
  }
  public EditorCell createValueCellinternal(EditorContext context, SNode node) {
    String propertyName = "value";
    PropertyAccessor propertyAccessor = new PropertyAccessor(node, propertyName, false, false, context);
    EditorCell_Property editorCell = EditorCell_Property.create(context, propertyAccessor, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(true);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setFontType(MPSFonts.BOLD);
    editorCell.getTextLine().setTextColor(MPSColors.DARK_BLUE);
    editorCell.setSubstituteInfo(new BooleanPropertySubstituteInfo(node, "value", context));
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteProperty(node, "value"));
    editorCell.addKeyMap(new _Expression_KeyMap());
    editorCell.putUserObject(EditorCell.CELL_ID, "1088424970609");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createValueCell(EditorContext context, SNode node) {
    String propertyName = "value";
    EditorCell propertyCell = this.createValueCellinternal(context, node);
    PropertyAttributeConcept propertyAttributeConcept = node.getPropertyAttribute(propertyName);
    if(propertyAttributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createPropertyAttributeCell(context, propertyAttributeConcept, propertyCell);
    } else 
    return propertyCell;
  }
}
