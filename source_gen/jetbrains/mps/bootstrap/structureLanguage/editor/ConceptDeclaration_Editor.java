package jetbrains.mps.bootstrap.structureLanguage.editor;

/*Generated by MPS*/


import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCellListHandler;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.semanticModel.SemanticNode;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import java.awt.Color;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.PropertyAccessor;
import jetbrains.mps.nodeEditor.EditorCell_Property;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.nodeEditor.CellAction_DeleteProperty;
import jetbrains.mps.nodeEditor.BooleanPropertySubstituteInfo;
import jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration;
import jetbrains.mps.semanticModel.SModelUtil;
import jetbrains.mps.nodeEditor.CellAction_Empty;
import jetbrains.mps.nodeEditor.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.EditorUtil;
import jetbrains.mps.nodeEditor.CellAction_DeleteReferenceToNode;

public class ConceptDeclaration_Editor extends DefaultNodeEditor {

  EditorCellListHandler myPropertyDeclarationListHandler;
  EditorCellListHandler myLinkDeclarationListHandler;
  EditorCellListHandler myConceptPropertyListHandler;
  EditorCellListHandler myConceptLinkListHandler;

  public EditorCell createEditorCell(EditorContext context, SemanticNode node) {
    return this.createNodeBox(context, node);
  }
  public EditorCell createNodeBox(EditorContext context, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.addEditorCell(this.createHeaderRow(context, node));
    editorCell.addEditorCell(this.createSeparator(context, node, ""));
    editorCell.addEditorCell(this.createRowCell(context, node));
    return editorCell;
  }
  public EditorCell createHeaderRow(EditorContext context, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.addEditorCell(this.createConstantCell(context, node, "concept declaration"));
    editorCell.addEditorCell(this.createNameCell(context, node));
    return editorCell;
  }
  public EditorCell createRowCell(EditorContext context, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.addEditorCell(this.createIndent(context, node, "    "));
    editorCell.addEditorCell(this.createContentArea(context, node));
    return editorCell;
  }
  public EditorCell createContentArea(EditorContext context, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.addEditorCell(this.createRowCell1(context, node));
    editorCell.addEditorCell(this.createRowCell2(context, node));
    editorCell.addEditorCell(this.createSeparator1(context, node, ""));
    editorCell.addEditorCell(this.createConstantCell3(context, node, "properties:"));
    editorCell.addEditorCell(this.createPropertyDeclarationList(context, node));
    editorCell.addEditorCell(this.createSeparator2(context, node, ""));
    editorCell.addEditorCell(this.createConstantCell4(context, node, "links:"));
    editorCell.addEditorCell(this.createLinkDeclarationList(context, node));
    editorCell.addEditorCell(this.createSeparator3(context, node, ""));
    editorCell.addEditorCell(this.createConstantCell5(context, node, "concept properties:"));
    editorCell.addEditorCell(this.createConceptPropertyList(context, node));
    editorCell.addEditorCell(this.createSeparator4(context, node, ""));
    editorCell.addEditorCell(this.createConstantCell6(context, node, "concept links:"));
    editorCell.addEditorCell(this.createConceptLinkList(context, node));
    return editorCell;
  }
  public EditorCell createRowCell1(EditorContext context, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.addEditorCell(this.createConstantCell1(context, node, "extends:"));
    editorCell.addEditorCell(this.createExtendsReferenceCell(context, node));
    return editorCell;
  }
  public EditorCell createRowCell2(EditorContext context, SemanticNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.addEditorCell(this.createConstantCell2(context, node, "is root:"));
    editorCell.addEditorCell(this.createRootableCell(context, node));
    return editorCell;
  }
  public EditorCell createSeparator(EditorContext context, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createConstantCell(EditorContext context, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createIndent(EditorContext context, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createSeparator1(EditorContext context, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createConstantCell3(EditorContext context, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createSeparator2(EditorContext context, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createConstantCell4(EditorContext context, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createSeparator3(EditorContext context, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createConstantCell5(EditorContext context, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createSeparator4(EditorContext context, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createConstantCell6(EditorContext context, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createConstantCell1(EditorContext context, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createConstantCell2(EditorContext context, SemanticNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createNameCell(EditorContext context, SemanticNode node) {
    PropertyAccessor propertyAccessor = new PropertyAccessor(node, "name", false, false);
    EditorCell_Property editorCell = EditorCell_Property.create(context, propertyAccessor, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setEditable(true);
    editorCell.setDefaultText("<no name>");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.getTextLine().setTextBackgroundColor(Color.yellow);
    editorCell.getTextLine().setSelectedTextBackgroundColor(Color.cyan);
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteProperty(node, "name"));
    return editorCell;
  }
  public EditorCell createRootableCell(EditorContext context, SemanticNode node) {
    PropertyAccessor propertyAccessor = new PropertyAccessor(node, "rootable", false, false);
    EditorCell_Property editorCell = EditorCell_Property.create(context, propertyAccessor, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setEditable(true);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setSubstituteInfo(new BooleanPropertySubstituteInfo(node, "rootable"));
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteProperty(node, "rootable"));
    return editorCell;
  }
  public EditorCell createExtendsReferenceCell(EditorContext context, SemanticNode node) {
    SemanticNode effectiveNode = null;
    effectiveNode = node.getReferent("extends");
    LinkDeclaration linkDeclaration = SModelUtil.getLinkDeclaration(node, "extends");
    if(effectiveNode == null) {
      {
        EditorCell_Constant noRefCell = EditorCell_Constant.create(context, node, null, true);
        noRefCell.setDefaultText("<none>");
        noRefCell.setEditable(true);
        noRefCell.setDrawBrackets(false);
        noRefCell.setBracketsColor(Color.black);
        noRefCell.putUserObject(EditorCell.METAINFO_LINK_DECLARATION, linkDeclaration);
        noRefCell.putUserObject(EditorCell.METAINFO_SOURCE_NODE, node);
        noRefCell.setAction(EditorCellAction.DELETE, new CellAction_Empty());
        noRefCell.setSubstituteInfo(new DefaultReferenceSubstituteInfo(node, linkDeclaration));
        return noRefCell;
      }
    }
    AbstractCellProvider inlineComponent = new ConceptDeclaration_Editor_extends_InlineComponent(effectiveNode);
    EditorCell editorCell = inlineComponent.createEditorCell(context);
    EditorUtil.setSemanticNodeToCells(editorCell, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(true);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.METAINFO_LINK_DECLARATION, linkDeclaration);
    editorCell.putUserObject(EditorCell.METAINFO_SOURCE_NODE, node);
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteReferenceToNode(node, "extends", effectiveNode));
    editorCell.setSubstituteInfo(new DefaultReferenceSubstituteInfo(node, linkDeclaration));
    return editorCell;
  }
  public EditorCell createPropertyDeclarationList(EditorContext context, SemanticNode node) {
    if(this.myPropertyDeclarationListHandler == null) {
      this.myPropertyDeclarationListHandler = new ConceptDeclaration_Editor_PropertyDeclarationListHandler(node, "propertyDeclaration", true);
    }
    EditorCell_Collection editorCell = null;
    editorCell = this.myPropertyDeclarationListHandler.createCells_Vertical(context);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(true);
    editorCell.setGridLayout(true);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createLinkDeclarationList(EditorContext context, SemanticNode node) {
    if(this.myLinkDeclarationListHandler == null) {
      this.myLinkDeclarationListHandler = new ConceptDeclaration_Editor_LinkDeclarationListHandler(node, "linkDeclaration", true);
    }
    EditorCell_Collection editorCell = null;
    editorCell = this.myLinkDeclarationListHandler.createCells_Vertical(context);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(true);
    editorCell.setGridLayout(true);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createConceptPropertyList(EditorContext context, SemanticNode node) {
    if(this.myConceptPropertyListHandler == null) {
      this.myConceptPropertyListHandler = new ConceptDeclaration_Editor_ConceptPropertyListHandler(node, "conceptProperty", true);
    }
    EditorCell_Collection editorCell = null;
    editorCell = this.myConceptPropertyListHandler.createCells_Vertical(context);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(true);
    editorCell.setGridLayout(true);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
  public EditorCell createConceptLinkList(EditorContext context, SemanticNode node) {
    if(this.myConceptLinkListHandler == null) {
      this.myConceptLinkListHandler = new ConceptDeclaration_Editor_ConceptLinkListHandler(node, "conceptLink", true);
    }
    EditorCell_Collection editorCell = null;
    editorCell = this.myConceptLinkListHandler.createCells_Vertical(context);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(true);
    editorCell.setGridLayout(true);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    return editorCell;
  }
}
