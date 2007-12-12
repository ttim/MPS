package jetbrains.mps.ypath.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class IterateOperation_DELETE {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction("DELETE", new IterateOperation_DELETE.IterateOperation_DELETE_DELETE(node));
  }

  public static class IterateOperation_DELETE_DELETE extends EditorCellAction {

    /* package */SNode myNode;

    public  IterateOperation_DELETE_DELETE(SNode node) {
      this.myNode = node;
    }

    public void execute(EditorContext editorContext) {
      this.execute_internal(editorContext, this.myNode);
    }

    public void execute_internal(EditorContext editorContext, SNode node) {
      SNode tpoe = SNodeOperations.getParent(node, null, false, false);
      if(SNodeOperations.isInstanceOf(tpoe, "jetbrains.mps.ypath.structure.TreePathOperationExpression")) {
        SNodeOperations.replaceWithAnother(tpoe, SLinkOperations.getTarget(tpoe, "expression", true));
      }
    }

}

}
