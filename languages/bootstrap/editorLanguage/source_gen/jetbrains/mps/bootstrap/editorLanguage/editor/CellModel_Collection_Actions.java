package jetbrains.mps.bootstrap.editorLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.ext.collections.internal.ICursor;
import jetbrains.mps.baseLanguage.ext.collections.internal.CursorFactory;

public class CellModel_Collection_Actions {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction("DELETE", new CellModel_Collection_Actions.CellModel_Collection_Actions_DELETE(node));
  }

  public static class CellModel_Collection_Actions_DELETE extends EditorCellAction {

    /* package */SNode myNode;

    public  CellModel_Collection_Actions_DELETE(SNode node) {
      this.myNode = node;
    }

    public String getDescriptionText() {
      return "Delete collection and copy its content to the parent collection";
    }

    public void execute(EditorContext editorContext) {
      this.execute_internal(editorContext, this.myNode);
    }

    public void execute_internal(EditorContext editorContext, SNode node) {
      if(SNodeOperations.isInstanceOf(SNodeOperations.getParent(node, null, false, false), "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection")) {
        SNode p = SNodeOperations.getParent(node, null, false, false);
        List<SNode> children = SLinkOperations.getTargets(node, "childCellModel", true);
        {
          ICursor<SNode> _zCursor = CursorFactory.createCursor(children);
          try {
            while(_zCursor.moveToNext()) {
              SNode child = _zCursor.getCurrent();
              SNodeOperations.insertPrevSiblingChild(node, child);
            }
          } finally {
            _zCursor.release();
          }
        }
      }
      SNodeOperations.deleteNode(node);
    }

}

}
