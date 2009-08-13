package jetbrains.mps.build.packaging.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Vertical;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;

public class ComponentsList_Editor extends DefaultNodeEditor {

  private AbstractCellListHandler myListHandler_0824_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_0824_0(context, node);
  }

  private EditorCell createCollection_0824_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    editorCell.setCellId("Collection_0824_0");
    editorCell.addEditorCell(this.createRefNodeList_0824_0(context, node));
    return editorCell;
  }

  private EditorCell createRefNodeList_0824_0(EditorContext context, SNode node) {
    if (this.myListHandler_0824_0 == null) {
      this.myListHandler_0824_0 = new ComponentsList_Editor.entryListHandler_0824_0(node, "entry", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_0824_0.createCells(context, new CellLayout_Vertical(), false);
    editorCell.setCellId("refNodeList_entry");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.DRAW_BRACKETS, true);
      style.set(StyleAttributes.BRACKETS_COLOR, MPSColors.darkGray);
      style.set(StyleAttributes.GET_PARENT_SUBSTITUDE_INFO, true);
    }
    editorCell.setRole(this.myListHandler_0824_0.getElementRole());
    return editorCell;
  }

  private static class entryListHandler_0824_0 extends RefNodeListHandler {

    public entryListHandler_0824_0(SNode ownerNode, String childRole, EditorContext context) {
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
        }
        if (elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), context));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext context) {
      return super.createSeparatorCell(context);
    }

}

}
