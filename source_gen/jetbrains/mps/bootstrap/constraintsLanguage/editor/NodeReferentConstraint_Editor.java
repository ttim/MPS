package jetbrains.mps.bootstrap.constraintsLanguage.editor;

/*Generated by MPS  */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import java.awt.Color;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefNodeCellProvider;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.PropertyCellProvider;

public class NodeReferentConstraint_Editor extends DefaultNodeEditor {

  public static boolean _QueryFunction_NodeCondition_1167867771752(SNode node, IScope scope) {
    return SLinkOperations.getTarget(node, "searchScopeFactory", true) != null;
  }
  public static boolean _QueryFunction_NodeCondition_1167867771766(SNode node, IScope scope) {
    return SLinkOperations.getTarget(node, "searchScopeFactory", true) != null;
  }
  public static boolean _QueryFunction_NodeCondition_1167867771778(SNode node, IScope scope) {
    return SLinkOperations.getTarget(node, "searchScopeFactory", true) != null;
  }

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createColumnCell(context, node);
  }
  public EditorCell createColumnCell(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createRowCell(context, node));
    editorCell.addEditorCell(this.createColumnCell1(context, node));
    editorCell.addEditorCell(this.createConstantCell12(context, node, ""));
    editorCell.putUserObject(EditorCell.CELL_ID, "1148929618471");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createRowCell(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell(context, node, "link"));
    editorCell.addEditorCell(this.createConstantCell1(context, node, "{"));
    editorCell.addEditorCell(this.createApplicableConceptReferenceCell(context, node));
    editorCell.addEditorCell(this.createConstantCell2(context, node, ":"));
    editorCell.addEditorCell(this.createApplicableLinkReferenceCell(context, node));
    editorCell.addEditorCell(this.createConstantCell3(context, node, "}"));
    editorCell.putUserObject(EditorCell.CELL_ID, "1148929633721");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1148929648238");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.getTextLine().setTextColor(MPSColors.DARK_MAGENTA);
    editorCell.putUserObject(EditorCell.CELL_ID, "1149010293559");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createApplicableConceptReferenceCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new NodeReferentConstraint_Editor_applicableConcept_InlineComponent());
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
    editorCell.putUserObject(EditorCell.CELL_ID, "1148929664542");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createApplicableConceptReferenceCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("applicableConcept");
    provider.setNoTargetText("<choose declaring concept>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createApplicableConceptReferenceCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else 
    return cellWithRole;
  }
  public EditorCell createConstantCell2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1148929692476");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createApplicableLinkReferenceCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new NodeReferentConstraint_Editor_applicableLink_InlineComponent());
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
    editorCell.putUserObject(EditorCell.CELL_ID, "1148929692477");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createApplicableLinkReferenceCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("applicableLink");
    provider.setNoTargetText("<choose role>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createApplicableLinkReferenceCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else 
    return cellWithRole;
  }
  public EditorCell createConstantCell3(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.getTextLine().setTextColor(MPSColors.DARK_MAGENTA);
    editorCell.putUserObject(EditorCell.CELL_ID, "1149010336689");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createColumnCell1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(true);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createRowCell1(context, node));
    editorCell.addEditorCell(this.createRowCell2(context, node));
    if(NodeReferentConstraint_Editor._QueryFunction_NodeCondition_1167867771766(node, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createRowCell3(context, node));
    }
    if(NodeReferentConstraint_Editor._QueryFunction_NodeCondition_1167867771778(node, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createRowCell4(context, node));
    }
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771743");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createRowCell1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell4(context, node, "referent set handler"));
    editorCell.addEditorCell(this.createConstantCell5(context, node, ":"));
    editorCell.addEditorCell(this.createReferentSetHandlerCell(context, node));
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771744");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell4(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771745");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell5(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771746");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createReferentSetHandlerCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
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
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771747");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createReferentSetHandlerCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("referentSetHandler");
    provider.setNoTargetText("<none>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createReferentSetHandlerCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else 
    return cellWithRole;
  }
  public EditorCell createRowCell2(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell6(context, node, "search scope"));
    editorCell.addEditorCell(this.createConstantCell7(context, node, ":"));
    editorCell.addEditorCell(this.createCellAlternation(context, node));
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771748");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell6(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771749");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell7(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771750");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createCellAlternation(EditorContext context, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = NodeReferentConstraint_Editor._QueryFunction_NodeCondition_1167867771752(node, context.getOperationContext().getScope());
    EditorCell editorCell = null;
    if(alternationCondition) {
      editorCell = this.createSearchScopeDescriptionCell(context, node);
    } else 
    {
      editorCell = this.createSearchScopeFactoryCell(context, node);
    }
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771751");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createSearchScopeDescriptionCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
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
      editorCellLabel.getTextLine().setTextColor(MPSColors.DARK_GREEN);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771760");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createSearchScopeDescriptionCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("searchScopeDescription");
    provider.setNoTargetText("<no description>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(true);
    EditorCell cellWithRole = this.createSearchScopeDescriptionCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else 
    return cellWithRole;
  }
  public EditorCell createSearchScopeFactoryCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
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
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771761");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createSearchScopeFactoryCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("searchScopeFactory");
    provider.setNoTargetText("<default>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createSearchScopeFactoryCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else 
    return cellWithRole;
  }
  public EditorCell createRowCell3(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell8(context, node, "   can create"));
    editorCell.addEditorCell(this.createConstantCell9(context, node, ":"));
    editorCell.addEditorCell(this.createSearchScopeCanCreateCell(context, node));
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771762");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell8(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771763");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell9(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771764");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createSearchScopeCanCreateCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
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
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771765");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createSearchScopeCanCreateCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("searchScopeCanCreate");
    provider.setNoTargetText("<yes>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createSearchScopeCanCreateCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else 
    return cellWithRole;
  }
  public EditorCell createRowCell4(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell10(context, node, "   create"));
    editorCell.addEditorCell(this.createConstantCell11(context, node, ":"));
    editorCell.addEditorCell(this.createSearchScopeFactoryCell1(context, node));
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771774");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell10(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771775");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell11(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771776");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createSearchScopeFactoryCell1internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
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
    editorCell.putUserObject(EditorCell.CELL_ID, "1167867771777");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createSearchScopeFactoryCell1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("searchScopeFactory");
    provider.setNoTargetText("<default>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createSearchScopeFactoryCell1internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else 
    return cellWithRole;
  }
  public EditorCell createConstantCell12(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1148937787386");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
}
