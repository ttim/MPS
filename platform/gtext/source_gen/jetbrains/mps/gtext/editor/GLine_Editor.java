package jetbrains.mps.gtext.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Indent;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;
import jetbrains.mps.nodeEditor.MPSColors;

public class GLine_Editor extends DefaultNodeEditor {

  /* package */AbstractCellListHandler myListHandler_6865_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_6865_0(context, node);
  }

  public EditorCell createCollection_6865_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_6865_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_6865_0(context, node, ">"));
    editorCell.addEditorCell(this.createRefNodeList_6865_0(context, node));
    return editorCell;
  }

  public EditorCell createConstant_6865_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_6865_0(editorCell, node, context);
    setupLabel_Constant_6865_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNodeList_6865_0(EditorContext context, SNode node) {
    if (this.myListHandler_6865_0 == null) {
      this.myListHandler_6865_0 = new GLine_Editor.itemListHandler_6865_0(node, "item", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_6865_0.createCells(context, new CellLayout_Indent(), false);
    setupBasic_RefNodeList_6865_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.setRole(this.myListHandler_6865_0.getElementRole());
    return editorCell;
  }


  private static void setupBasic_Collection_6865_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_6865_0");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, true);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_6865_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_6865_0");
  }

  private static void setupBasic_RefNodeList_6865_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refNodeList_item");
  }

  private static void setupLabel_Constant_6865_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNodeList_6865_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static class itemListHandler_6865_0 extends RefNodeListHandler {

    public itemListHandler_6865_0(SNode ownerNode, String childRole, EditorContext context) {
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
      return this.createConstant_6865_1(context, node, "<< items >>");
    }

    public void installElementCellActions(SNode listOwner, SNode elementNode, EditorCell elementCell, EditorContext context) {
      if (elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if (elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(CellActionType.DELETE, new CellAction_DeleteNode(elementNode));
        }
        if (elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), context));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext context) {
      return super.createSeparatorCell(context);
    }

    public EditorCell createConstant_6865_1(EditorContext context, SNode node, String text) {
      EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
      setupBasic_Constant_6865_1(editorCell, node, context);
      setupLabel_Constant_6865_1(editorCell, node, context);
      editorCell.setDefaultText("");
      return editorCell;
    }


    private static void setupBasic_Constant_6865_1(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.setCellId("Constant_6865_1");
      {
        Style inlineStyle = new Style(editorCell) {
          {
            this.set(StyleAttributes.EDITABLE, true);
            this.set(StyleAttributes.TEXT_COLOR, MPSColors.lightGray);
          }
        };
        inlineStyle.apply(editorCell);
      }
    }

    private static void setupLabel_Constant_6865_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}

}
