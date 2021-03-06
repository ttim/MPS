package jetbrains.mps.build.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;

public class delete_CustomCopy {
  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction(CellActionType.DELETE, new delete_CustomCopy.delete_CustomCopy_DELETE(node));
  }

  public static class delete_CustomCopy_DELETE extends EditorCellAction {
    /*package*/ SNode myNode;

    public delete_CustomCopy_DELETE(SNode node) {
      this.myNode = node;
    }

    public void execute(EditorContext editorContext) {
      this.execute_internal(editorContext, this.myNode);
    }

    public void execute_internal(EditorContext editorContext, SNode node) {
      SNodeFactoryOperations.replaceWithNewChild(node, "jetbrains.mps.build.structure.BuildLayout_Copy");
    }
  }
}
