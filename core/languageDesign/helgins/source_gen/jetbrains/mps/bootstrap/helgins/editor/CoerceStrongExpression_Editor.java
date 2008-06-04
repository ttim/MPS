package jetbrains.mps.bootstrap.helgins.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.BasicCellContext;
import jetbrains.mps.nodeEditor.cellMenu.ISubstituteInfoPart;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.bootstrap.editorLanguage.generator.internal.AbstractCellMenuPart_ReplaceNode_CustomNodeConcept;

public class CoerceStrongExpression_Editor extends DefaultNodeEditor {

  private static void setupBasic_CollectionCell9891_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_CollectionCell9891_0");
    editorCell.setSelectable(false);
  }

  private static void setupBasic_ConstantCell9891_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ConstantCell9891_0");
  }

  private static void setupBasic_ConstantCell9891_01(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ConstantCell9891_01");
  }

  private static void setupBasic_nodeToCoerceRefNodeCell9891_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_ConstantCell9891_02(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ConstantCell9891_02");
  }

  private static void setupBasic_patternRefNodeCell9891_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_ConstantCell9891_03(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ConstantCell9891_03");
  }

  private static void setupLabel_ConstantCell9891_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell9891_01(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_nodeToCoerceRefNodeCell9891_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell9891_02(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_patternRefNodeCell9891_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell9891_03(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }


  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.create_CollectionCell9891_0(context, node);
  }

  public EditorCell create_CollectionCell9891_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_CollectionCell9891_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.create_ConstantCell9891_0(context, node, "coerceStrong"));
    editorCell.addEditorCell(this.create_ConstantCell9891_01(context, node, "("));
    editorCell.addEditorCell(this.create_nodeToCoerceRefNodeCell9891_0(context, node));
    editorCell.addEditorCell(this.create_ConstantCell9891_02(context, node, ":<<"));
    editorCell.addEditorCell(this.create_patternRefNodeCell9891_0(context, node));
    editorCell.addEditorCell(this.create_ConstantCell9891_03(context, node, ")"));
    return editorCell;
  }

  public EditorCell create_ConstantCell9891_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell9891_0(editorCell, node, context);
    setupLabel_ConstantCell9891_0(editorCell, node, context);
    editorCell.setDefaultText("");
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(context, new BasicCellContext(node), new ISubstituteInfoPart[]{new CoerceStrongExpression_Editor.CoerceStrongExpression_Editor_replaceWith_CoerceExpression_cellMenu()}));
    return editorCell;
  }

  public EditorCell create_ConstantCell9891_01(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell9891_01(editorCell, node, context);
    setupLabel_ConstantCell9891_01(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell create_ConstantCell9891_02(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell9891_02(editorCell, node, context);
    setupLabel_ConstantCell9891_02(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell create_ConstantCell9891_03(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell9891_03(editorCell, node, context);
    setupLabel_ConstantCell9891_03(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell create_nodeToCoerceRefNodeCell9891_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_nodeToCoerceRefNodeCell9891_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_nodeToCoerceRefNodeCell9891_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell create_nodeToCoerceRefNodeCell9891_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("nodeToCoerce");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.create_nodeToCoerceRefNodeCell9891_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell create_patternRefNodeCell9891_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_patternRefNodeCell9891_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_patternRefNodeCell9891_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell create_patternRefNodeCell9891_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("pattern");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.create_patternRefNodeCell9891_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public static class CoerceStrongExpression_Editor_replaceWith_CoerceExpression_cellMenu extends AbstractCellMenuPart_ReplaceNode_CustomNodeConcept {

    public CoerceStrongExpression_Editor_replaceWith_CoerceExpression_cellMenu() {
    }

    public String getReplacementConceptName() {
      return "jetbrains.mps.bootstrap.helgins.structure.CoerceExpression";
    }

}

}
