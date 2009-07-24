package jetbrains.mps.lang.typesystem.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Indent;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandlerElementKeyMap;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;

public class MultipleForeachLoop_Editor extends DefaultNodeEditor {

  /* package */AbstractCellListHandler myListHandler_4210_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_4210_0(context, node);
  }

  public EditorCell createCollection_4210_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_4210_0(editorCell, node, context);
    editorCell.addEditorCell(this.createConstant_4210_0(context, node, "foreach"));
    editorCell.addEditorCell(this.createConstant_4210_1(context, node, "("));
    editorCell.addEditorCell(this.createRefNodeList_4210_0(context, node));
    editorCell.addEditorCell(this.createConstant_4210_2(context, node, ")"));
    editorCell.addEditorCell(this.createConstant_4210_4(context, node, "{"));
    editorCell.addEditorCell(this.createRefNode_4210_1(context, node));
    editorCell.addEditorCell(this.createConstant_4210_3(context, node, "}"));
    return editorCell;
  }

  public EditorCell createConstant_4210_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4210_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4210_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4210_1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4210_2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4210_2(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4210_3(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4210_3(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_4210_4(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4210_4(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNodeList_4210_0(EditorContext context, SNode node) {
    if (this.myListHandler_4210_0 == null) {
      this.myListHandler_4210_0 = new MultipleForeachLoop_Editor.loopVariableListHandler_4210_0(node, "loopVariable", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_4210_0.createCells(context, new CellLayout_Indent(), false);
    setupBasic_RefNodeList_4210_0(editorCell, node, context);
    editorCell.setRole(this.myListHandler_4210_0.getElementRole());
    return editorCell;
  }

  public EditorCell createRefNode_4210_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_4210_0(editorCell, node, context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_4210_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("body");
    provider.setNoTargetText("<no body>");
    EditorCell cellWithRole = this.createRefNode_4210_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_4210_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_4210_0");
  }

  private static void setupBasic_Constant_4210_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4210_0");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_4210_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4210_1");
    BaseLanguageStyle_StyleSheet.getLeftParen(editorCell).apply(editorCell);
  }

  private static void setupBasic_RefNodeList_4210_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refNodeList_loopVariable");
  }

  private static void setupBasic_Constant_4210_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4210_2");
    BaseLanguageStyle_StyleSheet.getRightParen(editorCell).apply(editorCell);
  }

  private static void setupBasic_RefNode_4210_0(EditorCell editorCell, SNode node, EditorContext context) {
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_INDENT, true);
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
  }

  private static void setupBasic_Constant_4210_3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4210_3");
    BaseLanguageStyle_StyleSheet.getRightBrace(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_4210_4(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4210_4");
    BaseLanguageStyle_StyleSheet.getLeftBrace(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
  }

  public static class loopVariableListHandler_4210_0 extends RefNodeListHandler {

    public loopVariableListHandler_4210_0(SNode ownerNode, String childRole, EditorContext context) {
      super(ownerNode, childRole, context, false);
    }

    public SNode createNodeToInsert(EditorContext context) {
      SNode listOwner = super.getOwner();
      return NodeFactoryManager.createNode(listOwner, context, super.getElementRole());
    }

    public EditorCell createNodeCell(EditorContext context, SNode elementNode) {
      EditorCell elementCell = super.createNodeCell(context, elementNode);
      this.installElementCellActions(this.getOwner(), elementNode, elementCell, context);
      return elementCell;
    }

    public EditorCell createEmptyCell(EditorContext context) {
      EditorCell emptyCell = null;
      emptyCell = super.createEmptyCell(context);
      this.installElementCellActions(super.getOwner(), null, emptyCell, context);
      return emptyCell;
    }

    public void installElementCellActions(SNode listOwner, SNode elementNode, EditorCell elementCell, EditorContext context) {
      if (elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if (elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(CellActionType.DELETE, new CellAction_DeleteNode(elementNode));
          elementCell.addKeyMap(new RefNodeListHandlerElementKeyMap(this, ";"));
        }
        if (elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), context));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext context) {
      {
        EditorCell_Constant editorCell = new EditorCell_Constant(context, this.getOwner(), ";");
        editorCell.setSelectable(false);
        editorCell.getStyle().set(StyleAttributes.LAYOUT_CONSTRAINT, "");
        editorCell.getStyle().set(StyleAttributes.PUNCTUATION_LEFT, true);
        return editorCell;
      }
    }

}

}
