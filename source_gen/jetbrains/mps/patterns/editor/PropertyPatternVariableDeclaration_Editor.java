package jetbrains.mps.patterns.editor;

/*Generated by MPS 08.01.2006 15:22:31 */


import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import java.awt.Color;
import jetbrains.mps.nodeEditor.PropertyAccessor;
import jetbrains.mps.nodeEditor.EditorCell_Property;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.nodeEditor.CellAction_DeleteProperty;
import jetbrains.mps.annotations.PropertyAttributeConcept;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;

public class PropertyPatternVariableDeclaration_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createRowCell(context, node);
  }
  public EditorCell createRowCell(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.addEditorCell(this.createVarNameCell(context, node));
    editorCell.putUserObject(EditorCell.CELL_ID, "1136720096759");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createVarNameCellinternal(EditorContext context, SNode node) {
    String propertyName = "varName";
    PropertyAccessor propertyAccessor = new PropertyAccessor(node, propertyName, false, false, context);
    EditorCell_Property editorCell = EditorCell_Property.create(context, propertyAccessor, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(true);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setFontType(MPSFonts.BOLD_ITALIC);
    editorCell.getTextLine().setTextColor(MPSColors.DARK_BLUE);
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteProperty(node, "varName"));
    editorCell.putUserObject(EditorCell.CELL_ID, "1136720096760");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createVarNameCell(EditorContext context, SNode node) {
    String propertyName = "varName";
    EditorCell propertyCell = this.createVarNameCellinternal(context, node);
    PropertyAttributeConcept propertyAttributeConcept = node.getPropertyAttribute(propertyName);
    if(propertyAttributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createPropertyAttributeCell(context, propertyAttributeConcept, propertyCell);
    } else 
    return propertyCell;
  }
}
