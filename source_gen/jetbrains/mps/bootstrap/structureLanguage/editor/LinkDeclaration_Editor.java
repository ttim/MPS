package jetbrains.mps.bootstrap.structureLanguage.editor;

/*Generated by MPS*/


import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import java.awt.Color;
import jetbrains.mps.bootstrap.structureLanguage.editor.Queries;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.ModelAccessor;
import jetbrains.mps.nodeEditor.EditorCell_Property;
import jetbrains.mps.nodeEditor.PropertyAccessor;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.nodeEditor.CellAction_DeleteProperty;
import jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration;
import jetbrains.mps.smodel.SModelUtil;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.nodeEditor.EditorCell_Error;
import jetbrains.mps.resolve.BadReferenceTextProvider;
import jetbrains.mps.nodeEditor.CellAction_Empty;
import jetbrains.mps.nodeEditor.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.EditorUtil;

public class LinkDeclaration_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createRowCell(context, node);
  }
  public EditorCell createRowCell(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.addEditorCell(this.createRoleCell(context, node));
    if(Queries.semanticNodeCondition_LinkDeclaration_NotSpecializes(node)) {
      editorCell.addEditorCell(this.createMetaClassCell(context, node));
    }
    if(Queries.semanticNodeCondition_LinkDeclaration_NotSpecializes(node)) {
      editorCell.addEditorCell(this.createSourceCardinalityCell(context, node));
    }
    if(Queries.semanticNodeCondition_LinkDeclaration_NotSpecializes(node)) {
      editorCell.addEditorCell(this.createTargetCardinalityCell(context, node));
    }
    if(Queries.semanticNodeCondition_LinkDeclaration_Specializes(node)) {
      editorCell.addEditorCell(this.createLinkDeclaration_SpecializedMetaclassCell(context, node));
    }
    if(Queries.semanticNodeCondition_LinkDeclaration_Specializes(node)) {
      editorCell.addEditorCell(this.createLinkDeclaration_SpecializedSourceCardinalityCell(context, node));
    }
    if(Queries.semanticNodeCondition_LinkDeclaration_Specializes(node)) {
      editorCell.addEditorCell(this.createLinkDeclaration_SpecializedTargetCardinalityCell(context, node));
    }
    editorCell.addEditorCell(this.createConstantCell(context, node, "target:"));
    editorCell.addEditorCell(this.createTargetReferenceCell(context, node));
    editorCell.addEditorCell(this.createConstantCell1(context, node, "specializes:"));
    editorCell.addEditorCell(this.createLinkDeclaration_SpecializedLinkRoleCell(context, node));
    editorCell.putUserObject(EditorCell.CELL_ID, "1084189569970");
    return editorCell;
  }
  public EditorCell createConstantCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1084192678902");
    return editorCell;
  }
  public EditorCell createConstantCell1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1084189693806");
    return editorCell;
  }
  public EditorCell createLinkDeclaration_SpecializedMetaclassCell(EditorContext context, SNode node) {
    ModelAccessor modelAccessor = Queries.createModelAccessor_LinkDeclaration_SpecializedMetaclass(node);
    EditorCell_Property editorCell = EditorCell_Property.create(context, modelAccessor, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.getTextLine().setTextBackgroundColor(Color.lightGray);
    LinkDeclaration_DisableDelete_Actions.setCellActions(editorCell, node, context);
    editorCell.putUserObject(EditorCell.CELL_ID, "1084205682784");
    return editorCell;
  }
  public EditorCell createLinkDeclaration_SpecializedSourceCardinalityCell(EditorContext context, SNode node) {
    ModelAccessor modelAccessor = Queries.createModelAccessor_LinkDeclaration_SpecializedSourceCardinality(node);
    EditorCell_Property editorCell = EditorCell_Property.create(context, modelAccessor, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.getTextLine().setTextBackgroundColor(Color.lightGray);
    LinkDeclaration_DisableDelete_Actions.setCellActions(editorCell, node, context);
    editorCell.putUserObject(EditorCell.CELL_ID, "1084205682785");
    return editorCell;
  }
  public EditorCell createLinkDeclaration_SpecializedTargetCardinalityCell(EditorContext context, SNode node) {
    ModelAccessor modelAccessor = Queries.createModelAccessor_LinkDeclaration_SpecializedTargetCardinality(node);
    EditorCell_Property editorCell = EditorCell_Property.create(context, modelAccessor, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.getTextLine().setTextBackgroundColor(Color.lightGray);
    LinkDeclaration_DisableDelete_Actions.setCellActions(editorCell, node, context);
    editorCell.putUserObject(EditorCell.CELL_ID, "1084205682786");
    return editorCell;
  }
  public EditorCell createLinkDeclaration_SpecializedLinkRoleCell(EditorContext context, SNode node) {
    ModelAccessor modelAccessor = Queries.createModelAccessor_LinkDeclaration_SpecializedLinkRole(node);
    EditorCell_Property editorCell = EditorCell_Property.create(context, modelAccessor, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setEditable(true);
    editorCell.setDefaultText("<none>");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    LinkDeclaration_SpecializedLink_Actions.setCellActions(editorCell, node, context);
    editorCell.putUserObject(EditorCell.CELL_ID, "1084189693807");
    return editorCell;
  }
  public EditorCell createRoleCell(EditorContext context, SNode node) {
    PropertyAccessor propertyAccessor = new PropertyAccessor(node, "role", false, false, context);
    EditorCell_Property editorCell = EditorCell_Property.create(context, propertyAccessor, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setEditable(true);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteProperty(node, "role"));
    editorCell.putUserObject(EditorCell.CELL_ID, "1084189569972");
    return editorCell;
  }
  public EditorCell createMetaClassCell(EditorContext context, SNode node) {
    PropertyAccessor propertyAccessor = new PropertyAccessor(node, "metaClass", false, false, context);
    EditorCell_Property editorCell = EditorCell_Property.create(context, propertyAccessor, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setEditable(true);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setSubstituteInfo(new LinkMetaclass_PropertySubstituteInfo(node, "metaClass", context));
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteProperty(node, "metaClass"));
    editorCell.putUserObject(EditorCell.CELL_ID, "1084205682781");
    return editorCell;
  }
  public EditorCell createSourceCardinalityCell(EditorContext context, SNode node) {
    PropertyAccessor propertyAccessor = new PropertyAccessor(node, "sourceCardinality", false, false, context);
    EditorCell_Property editorCell = EditorCell_Property.create(context, propertyAccessor, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setEditable(true);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setSubstituteInfo(new Cardinality_PropertySubstituteInfo(node, "sourceCardinality", context));
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteProperty(node, "sourceCardinality"));
    editorCell.putUserObject(EditorCell.CELL_ID, "1084205682782");
    return editorCell;
  }
  public EditorCell createTargetCardinalityCell(EditorContext context, SNode node) {
    PropertyAccessor propertyAccessor = new PropertyAccessor(node, "targetCardinality", false, false, context);
    EditorCell_Property editorCell = EditorCell_Property.create(context, propertyAccessor, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setEditable(true);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setSubstituteInfo(new Cardinality_PropertySubstituteInfo(node, "targetCardinality", context));
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteProperty(node, "targetCardinality"));
    editorCell.putUserObject(EditorCell.CELL_ID, "1084205682783");
    return editorCell;
  }
  public EditorCell createTargetReferenceCell(EditorContext context, SNode node) {
    SNode effectiveNode = null;
    effectiveNode = node.getReferent("target");
    LinkDeclaration linkDeclaration = SModelUtil.getLinkDeclaration(node, "target", context.getOperationContext());
    SReference reference = node.getReference("target");
    if(reference != null && !(reference.isResolved())) {
      EditorCell_Error noRefCell = EditorCell_Error.create(context, node, BadReferenceTextProvider.getBadReferenceText(reference));
      noRefCell.setEditable(true);
      noRefCell.setDrawBrackets(false);
      noRefCell.setBracketsColor(Color.black);
      noRefCell.putUserObject(EditorCell.METAINFO_LINK_DECLARATION, linkDeclaration);
      noRefCell.putUserObject(EditorCell.METAINFO_SOURCE_NODE, node);
      noRefCell.setAction(EditorCellAction.DELETE, new CellAction_Empty());
      noRefCell.setSubstituteInfo(new DefaultReferenceSubstituteInfo(node, linkDeclaration, context));
      noRefCell.putUserObject(EditorCell.CELL_ID, "1096455263454");
      return noRefCell;
    }
    if(effectiveNode == null) {
      {
        EditorCell_Error noRefCell = EditorCell_Error.create(context, node, "<no target>");
        noRefCell.setEditable(true);
        noRefCell.setDrawBrackets(false);
        noRefCell.setBracketsColor(Color.black);
        noRefCell.putUserObject(EditorCell.METAINFO_LINK_DECLARATION, linkDeclaration);
        noRefCell.putUserObject(EditorCell.METAINFO_SOURCE_NODE, node);
        noRefCell.setAction(EditorCellAction.DELETE, new CellAction_Empty());
        noRefCell.setSubstituteInfo(new DefaultReferenceSubstituteInfo(node, linkDeclaration, context));
        noRefCell.putUserObject(EditorCell.CELL_ID, "1096455263454");
        return noRefCell;
      }
    }
    AbstractCellProvider inlineComponent = new LinkDeclaration_Editor_target_InlineComponent(effectiveNode);
    EditorCell editorCell = inlineComponent.createEditorCell(context);
    EditorUtil.setSemanticNodeToCells(editorCell, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.METAINFO_LINK_DECLARATION, linkDeclaration);
    editorCell.putUserObject(EditorCell.METAINFO_SOURCE_NODE, node);
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_Empty());
    editorCell.setSubstituteInfo(new DefaultReferenceSubstituteInfo(node, linkDeclaration, context));
    return editorCell;
  }
}
