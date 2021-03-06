package jetbrains.mps.baseLanguage.regexp.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.nodeEditor.cells.CellConditions;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class ReplaceRegexpOperation_removeI {
  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction(CellActionType.DELETE, new ReplaceRegexpOperation_removeI.ReplaceRegexpOperation_removeI_DELETE(node));
  }

  public static class ReplaceRegexpOperation_removeI_DELETE extends EditorCellAction {
    /*package*/ SNode myNode;

    public ReplaceRegexpOperation_removeI_DELETE(SNode node) {
      this.myNode = node;
    }

    public void execute(EditorContext editorContext) {
      this.execute_internal(editorContext, this.myNode);
    }

    public void execute_internal(EditorContext editorContext, SNode node) {
      EditorCell current = editorContext.getSelectedCell();
      EditorCell toSelect = current.getPrevLeaf(CellConditions.SELECTABLE);
      SPropertyOperations.set(node, "caseInsensitive", "" + false);
      editorContext.getNodeEditorComponent().changeSelection(toSelect);
    }
  }
}
