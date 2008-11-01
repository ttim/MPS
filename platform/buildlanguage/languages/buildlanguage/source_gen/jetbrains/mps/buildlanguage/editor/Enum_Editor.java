package jetbrains.mps.buildlanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Horizontal;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandlerElementKeyMap;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;

public class Enum_Editor extends DefaultNodeEditor {

  /* package */AbstractCellListHandler myListHandler_1197399052772;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection1197398999782(context, node);
  }

  public EditorCell createCollection1197398999782(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11973989997821197398999782(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1197399033003(context, node, "{"));
    editorCell.addEditorCell(this.createRefNodeList1197399052772(context, node));
    editorCell.addEditorCell(this.createConstant1197399041536(context, node, "}"));
    return editorCell;
  }

  public EditorCell createConstant1197399033003(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11973990330031197399033003(editorCell, node, context);
    setupLabel_Constant_1197399033003_1197399033003(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1197399041536(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11973990415361197399041536(editorCell, node, context);
    setupLabel_Constant_1197399041536_1197399041536(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNodeList1197399052772(EditorContext context, SNode node) {
    if (this.myListHandler_1197399052772 == null) {
      this.myListHandler_1197399052772 = new Enum_Editor.constantsListHandler_9947_0(node, "constants", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_1197399052772.createCells(context, new CellLayout_Horizontal(), false);
    setupBasic_refNodeList_constants1197399052772(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.setRole(this.myListHandler_1197399052772.getElementRole());
    return editorCell;
  }


  private static void setupBasic_Collection_11973989997821197398999782(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1197398999782");
  }

  private static void setupBasic_Constant_11973990330031197399033003(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1197399033003");
  }

  private static void setupBasic_Constant_11973990415361197399041536(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1197399041536");
  }

  private static void setupBasic_refNodeList_constants1197399052772(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refNodeList_constants");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupLabel_Constant_1197399033003_1197399033003(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1197399041536_1197399041536(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refNodeList_constants_1197399052772(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static class constantsListHandler_9947_0 extends RefNodeListHandler {

    public constantsListHandler_9947_0(SNode ownerNode, String childRole, EditorContext context) {
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
      return this.createConstant1200419310593(context, node, "<constant values>");
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

    public EditorCell createConstant1200419310593(EditorContext context, SNode node, String text) {
      EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
      setupBasic_Constant_12004193105931200419310593(editorCell, node, context);
      setupLabel_Constant_1200419310593_1200419310593(editorCell, node, context);
      editorCell.setDefaultText("");
      return editorCell;
    }


    private static void setupBasic_Constant_12004193105931200419310593(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.setCellId("Constant_1200419310593");
      BuildLanguageStyle_StyleSheet.getPrompting(editorCell).apply(editorCell);
    }

    private static void setupLabel_Constant_1200419310593_1200419310593(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}

}
