package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import java.awt.Color;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;

public class SwitchCase_Editor extends DefaultNodeEditor {

  private static void setupConstantCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1163670716711");
    editorCell.setDrawBorder(false);
  }
  private static void setupExpressionCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1163670720712");
    editorCell.setDrawBorder(false);
  }
  private static void setupConstantCell1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1163670734837");
    editorCell.setDrawBorder(false);
  }
  private static void setupRowCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1163670713648");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }
  private static void setupConstantCell2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1163670742518");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }
  private static void setupBodyCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1163670745145");
    editorCell.setDrawBorder(false);
  }
  private static void setupRowCell1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1163670739981");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }
  private static void setupColumnCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1163670711192");
    editorCell.setDrawBorder(false);
  }

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createColumnCell(context, node);
  }
  public EditorCell createRowCell(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    SwitchCase_Editor.setupRowCell(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell(context, node, "case"));
    editorCell.addEditorCell(this.createExpressionCell(context, node));
    editorCell.addEditorCell(this.createConstantCell1(context, node, ":"));
    return editorCell;
  }
  public EditorCell createRowCell1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    SwitchCase_Editor.setupRowCell1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell2(context, node, "  "));
    editorCell.addEditorCell(this.createBodyCell(context, node));
    return editorCell;
  }
  public EditorCell createColumnCell(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    SwitchCase_Editor.setupColumnCell(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createRowCell(context, node));
    editorCell.addEditorCell(this.createRowCell1(context, node));
    return editorCell;
  }
  public EditorCell createConstantCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    SwitchCase_Editor.setupConstantCell(editorCell, node, context);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.getTextLine().setTextColor(MPSColors.DARK_BLUE);
    return editorCell;
  }
  public EditorCell createConstantCell1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    SwitchCase_Editor.setupConstantCell1(editorCell, node, context);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    return editorCell;
  }
  public EditorCell createConstantCell2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    SwitchCase_Editor.setupConstantCell2(editorCell, node, context);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    return editorCell;
  }
  public EditorCell createExpressionCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    if(editorCell instanceof EditorCell_Label) {
      EditorCell_Label editorCellLabel = (EditorCell_Label)editorCell;
      editorCellLabel.setEditable(true);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1163670720712");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createExpressionCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("expression");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createExpressionCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }
  public EditorCell createBodyCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    if(editorCell instanceof EditorCell_Label) {
      EditorCell_Label editorCellLabel = (EditorCell_Label)editorCell;
      editorCellLabel.setEditable(true);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1163670745145");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createBodyCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("body");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createBodyCellinternal(context, node, provider);
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
