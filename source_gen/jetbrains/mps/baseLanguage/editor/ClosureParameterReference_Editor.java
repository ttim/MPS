package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Jul 26, 2006 2:07:31 PM */


import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import java.awt.Color;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.nodeEditor.EditorCell_Basic;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;

public class ClosureParameterReference_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createClosureParameterReferenceCell(context, node);
  }
  public EditorCell createClosureParameterReferenceCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new ClosureParameterReference_Editor_closureParameter_InlineComponent());
    EditorCell editorCell = provider.createEditorCell(context);
    editorCell.setDrawBorder(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    if(editorCell instanceof EditorCell_Label) {
      EditorCell_Label editorCellLabel = (EditorCell_Label)editorCell;
      editorCellLabel.setEditable(true);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.putUserObject(EditorCell.CELL_ID, "1153179576790");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createClosureParameterReferenceCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("closureParameter");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createClosureParameterReferenceCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else 
    return cellWithRole;
  }
}
