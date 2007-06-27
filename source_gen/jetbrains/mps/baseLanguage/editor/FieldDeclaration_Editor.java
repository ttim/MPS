package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import java.awt.Color;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;

public class FieldDeclaration_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider my_Component_Visibility4;
  /* package */AbstractCellProvider myVariableDeclaration_NameCellComponent;

  private static void setup_Component_VisibilityCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1178547814213");
  }
  private static void setupTypeCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1075289941064");
    editorCell.setDrawBorder(false);
  }
  private static void setupVariableDeclaration_NameCellComponentCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1181827128215");
  }
  private static void setupConstantCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1075290218688");
    editorCell.setDrawBorder(false);
  }
  private static void setupInitializerCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1075290268533");
    editorCell.setDrawBorder(false);
  }
  private static void setupInitializerArea(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1075290206265");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }
  private static void setupConstantCell1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1075289999925");
    editorCell.setDrawBorder(false);
  }
  private static void setupDeclarationBox(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1075289941063");
    editorCell.setDrawBorder(false);
  }
  public static boolean _QueryFunction_NodeCondition_1145916298341(SNode node, IScope scope) {
    return SLinkOperations.getTarget(node, "initializer", true) != null;
  }

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createDeclarationBox(context, node);
  }
  public EditorCell createInitializerArea(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    FieldDeclaration_Editor.setupInitializerArea(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell(context, node, "="));
    editorCell.addEditorCell(this.createInitializerCell(context, node));
    return editorCell;
  }
  public EditorCell createDeclarationBox(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    FieldDeclaration_Editor.setupDeclarationBox(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.create_Component_VisibilityCell(context, node));
    editorCell.addEditorCell(this.createTypeCell(context, node));
    editorCell.addEditorCell(this.createVariableDeclaration_NameCellComponentCell(context, node));
    if(FieldDeclaration_Editor._QueryFunction_NodeCondition_1145916298341(node, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createInitializerArea(context, node));
    }
    editorCell.addEditorCell(this.createConstantCell1(context, node, ";"));
    return editorCell;
  }
  public EditorCell create_Component_VisibilityCell(EditorContext context, SNode node) {
    if(this.my_Component_Visibility4 == null) {
      this.my_Component_Visibility4 = new _Component_Visibility(node);
    }
    EditorCell componentCell = this.my_Component_Visibility4.createEditorCell(context);
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.addEditorCell(componentCell);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1178547814213");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createVariableDeclaration_NameCellComponentCell(EditorContext context, SNode node) {
    if(this.myVariableDeclaration_NameCellComponent == null) {
      this.myVariableDeclaration_NameCellComponent = new VariableDeclaration_NameCellComponent(node);
    }
    EditorCell componentCell = this.myVariableDeclaration_NameCellComponent.createEditorCell(context);
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.addEditorCell(componentCell);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1181827128215");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    FieldDeclaration_Editor.setupConstantCell(editorCell, node, context);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    return editorCell;
  }
  public EditorCell createConstantCell1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    FieldDeclaration_Editor.setupConstantCell1(editorCell, node, context);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    return editorCell;
  }
  public EditorCell createTypeCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
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
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1075289941064");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createTypeCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("type");
    provider.setNoTargetText("<no type>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createTypeCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }
  public EditorCell createInitializerCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
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
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1075290268533");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createInitializerCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("initializer");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createInitializerCellinternal(context, node, provider);
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
