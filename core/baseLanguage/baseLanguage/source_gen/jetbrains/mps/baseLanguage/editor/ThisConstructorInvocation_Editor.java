package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Horizontal;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandlerElementKeyMap;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;

public class ThisConstructorInvocation_Editor extends DefaultNodeEditor {

  /* package */AbstractCellListHandler myListHandler_1178893550247;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection1178893550245(context, node);
  }

  public EditorCell createCollection1178893550245(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11788935502451178893550245(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1178893550246(context, node, "this"));
    editorCell.addEditorCell(this.createConstant1178893553751(context, node, "("));
    editorCell.addEditorCell(this.createRefNodeList1178893550247(context, node));
    editorCell.addEditorCell(this.createConstant1178893550249(context, node, ")"));
    editorCell.addEditorCell(this.createConstant1178906643449(context, node, ";"));
    return editorCell;
  }

  public EditorCell createConstant1178893550246(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11788935502461178893550246(editorCell, node, context);
    setupLabel_Constant_1178893550246_1178893550246(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1178893550249(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11788935502491178893550249(editorCell, node, context);
    setupLabel_Constant_1178893550249_1178893550249(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1178893553751(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11788935537511178893553751(editorCell, node, context);
    setupLabel_Constant_1178893553751_1178893553751(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1178906643449(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11789066434491178906643449(editorCell, node, context);
    setupLabel_Constant_1178906643449_1178906643449(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNodeList1178893550247(EditorContext context, SNode node) {
    if (this.myListHandler_1178893550247 == null) {
      this.myListHandler_1178893550247 = new ThisConstructorInvocation_Editor.actualArgumentListHandler_8960_0(node, "actualArgument", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_1178893550247.createCells(context, new CellLayout_Horizontal(), false);
    setupBasic_refNodeList_actualArgument1178893550247(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.setRole(this.myListHandler_1178893550247.getElementRole());
    return editorCell;
  }


  private static void setupBasic_Collection_11788935502451178893550245(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1178893550245");
  }

  private static void setupBasic_Constant_11788935502461178893550246(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1178893550246");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
  }

  private static void setupBasic_refNodeList_actualArgument1178893550247(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refNodeList_actualArgument");
  }

  private static void setupBasic_Constant_11788935502491178893550249(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1178893550249");
    BaseLanguageStyle_StyleSheet.getRightParen(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_11788935537511178893553751(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1178893553751");
    BaseLanguageStyle_StyleSheet.getLeftParen(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_11789066434491178906643449(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1178906643449");
    BaseLanguageStyle_StyleSheet.getSemicolon(editorCell).apply(editorCell);
  }

  private static void setupLabel_Constant_1178893550246_1178893550246(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refNodeList_actualArgument_1178893550247(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1178893550249_1178893550249(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1178893553751_1178893553751(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1178906643449_1178906643449(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static class actualArgumentListHandler_8960_0 extends RefNodeListHandler {

    public actualArgumentListHandler_8960_0(SNode ownerNode, String childRole, EditorContext context) {
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
      emptyCell = this.createEmptyCell_internal(context, this.getOwner());
      this.installElementCellActions(super.getOwner(), null, emptyCell, context);
      return emptyCell;
    }

    public EditorCell createEmptyCell_internal(EditorContext context, SNode node) {
      return this.createConstant1178893550248(context, node, "");
    }

    public void installElementCellActions(SNode listOwner, SNode elementNode, EditorCell elementCell, EditorContext context) {
      if (elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if (elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(CellActionType.DELETE, new CellAction_DeleteNode(elementNode));
          elementCell.addKeyMap(new RefNodeListHandlerElementKeyMap(this, ","));
        }
        if (elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), context));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext context) {
      {
        EditorCell_Constant editorCell = new EditorCell_Constant(context, this.getOwner(), ",");
        editorCell.setSelectable(false);
        return editorCell;
      }
    }

    public EditorCell createConstant1178893550248(EditorContext context, SNode node, String text) {
      EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
      setupBasic_Constant_11788935502481178893550248(editorCell, node, context);
      setupLabel_Constant_1178893550248_1178893550248(editorCell, node, context);
      editorCell.setDefaultText("");
      return editorCell;
    }


    private static void setupBasic_Constant_11788935502481178893550248(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.setCellId("Constant_1178893550248");
      {
        Style inlineStyle = new Style(editorCell) {
          {
            this.set(StyleAttributes.SELECTABLE, true);
            this.set(StyleAttributes.EDITABLE, true);
          }

        };
        inlineStyle.apply(editorCell);
      }
    }

    private static void setupLabel_Constant_1178893550248_1178893550248(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}

}
