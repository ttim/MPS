package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Jul 20, 2006 1:58:03 PM */


import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import java.awt.Color;
import jetbrains.mps.nodeEditor.EditorCell_Basic;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.CellLayout_Horizontal;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefNodeCellProvider;

public class StaticMethodCall_Editor extends DefaultNodeEditor {

  public AbstractCellListHandler myActualArgumentListHandler;

  public static boolean _QueryFunction_NodeCondition_1146678190954(SNode node, IScope scope) {
    return SLinkOperations.getTarget(node, "classType", true) != null;
  }

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
    editorCell.setUsesBraces(false);
    editorCell.addKeyMap(new Expression_KeyMap());
    if(StaticMethodCall_Editor._QueryFunction_NodeCondition_1146678190954(node, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createColumnCell(context, node));
    }
    editorCell.addEditorCell(this.createClassConceptReferenceCell(context, node));
    editorCell.addEditorCell(this.createConstantCell1(context, node, "."));
    editorCell.addEditorCell(this.createStaticMethodDeclarationReferenceCell(context, node));
    editorCell.addEditorCell(this.createConstantCell2(context, node, "("));
    editorCell.addEditorCell(this.createActualArgumentList(context, node));
    editorCell.addEditorCell(this.createConstantCell4(context, node, ")"));
    editorCell.putUserObject(EditorCell.CELL_ID, "1081149310028");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createColumnCell(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.addEditorCell(this.createClassTypeCell(context, node));
    editorCell.addEditorCell(this.createConstantCell(context, node, "deprecated!"));
    editorCell.putUserObject(EditorCell.CELL_ID, "1144433223660");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstantCell2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1081149570780");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstantCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.getTextLine().setTextBackgroundColor(Color.yellow);
    editorCell.putUserObject(EditorCell.CELL_ID, "1144433223662");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstantCell1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1081149570778");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstantCell4(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1081149570782");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createActualArgumentList(EditorContext context, SNode node) {
    if(this.myActualArgumentListHandler == null) {
      this.myActualArgumentListHandler = new StaticMethodCall_Editor_ActualArgumentListHandler(node, "actualArgument", context);
    }
    EditorCell_Collection editorCell = this.myActualArgumentListHandler.createCells(context, new CellLayout_Horizontal());
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myActualArgumentListHandler.getElementRole());
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createStaticMethodDeclarationReferenceCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new StaticMethodCall_Editor_staticMethodDeclaration_InlineComponent());
    EditorCell editorCell = provider.createEditorCell(context);
    editorCell.setDrawBorder(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    if(editorCell instanceof EditorCell_Label) {
      EditorCell_Label editorCellLabel = (EditorCell_Label)editorCell;
      editorCellLabel.setEditable(true);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.putUserObject(EditorCell.CELL_ID, "1088427863670");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createStaticMethodDeclarationReferenceCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("staticMethodDeclaration");
    provider.setNoTargetText("<no method>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createStaticMethodDeclarationReferenceCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else 
    return cellWithRole;
  }
  public EditorCell createClassTypeCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    editorCell.setDrawBorder(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    if(editorCell instanceof EditorCell_Label) {
      EditorCell_Label editorCellLabel = (EditorCell_Label)editorCell;
      editorCellLabel.setEditable(true);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.putUserObject(EditorCell.CELL_ID, "1144433231056");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createClassTypeCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("classType");
    provider.setNoTargetText("<no type>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createClassTypeCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else 
    return cellWithRole;
  }
  public EditorCell createClassConceptReferenceCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new StaticMethodCall_Editor_classConcept_InlineComponent());
    EditorCell editorCell = provider.createEditorCell(context);
    editorCell.setDrawBorder(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    if(editorCell instanceof EditorCell_Label) {
      EditorCell_Label editorCellLabel = (EditorCell_Label)editorCell;
      editorCellLabel.setEditable(true);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.putUserObject(EditorCell.CELL_ID, "1144433246063");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createClassConceptReferenceCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("classConcept");
    provider.setNoTargetText("<no class>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createClassConceptReferenceCellinternal(context, node, provider);
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
