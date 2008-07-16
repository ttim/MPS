package jetbrains.mps.ypath.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class TreePathOperationExpression_DELETE {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction(EditorCellAction.DELETE, new TreePathOperationExpression_DELETE.TreePathOperationExpression_DELETE_DELETE(node));
  }

  public static class TreePathOperationExpression_DELETE_DELETE extends EditorCellAction {

    /* package */SNode myNode;

    public TreePathOperationExpression_DELETE_DELETE(SNode node) {
      this.myNode = node;
    }

    public String getDescriptionText() {
      return "Smart delete";
    }

    public void execute(EditorContext editorContext) {
      this.execute_internal(editorContext, this.myNode);
    }

    public void execute_internal(EditorContext editorContext, SNode node) {
      SNodeOperations.replaceWithAnother(node, SLinkOperations.getTarget(node, "expression", true));
    }

}

}
