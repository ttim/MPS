package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.nodeEditor.cells.CellConditions;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;

public class LocalVariableDeclaration_Initializer_Actions {
  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction(CellActionType.DELETE, new LocalVariableDeclaration_Initializer_Actions.LocalVariableDeclaration_Initializer_Actions_DELETE(node));
  }

  public static class LocalVariableDeclaration_Initializer_Actions_DELETE extends EditorCellAction {
    /*package*/ SNode myNode;

    public LocalVariableDeclaration_Initializer_Actions_DELETE(SNode node) {
      this.myNode = node;
    }

    public String getDescriptionText() {
      return "remove initializer";
    }

    public void execute(EditorContext editorContext) {
      this.execute_internal(editorContext, this.myNode);
    }

    public void execute_internal(EditorContext editorContext, SNode node) {
      SNodeOperations.detachNode(SLinkOperations.getTarget(node, "initializer", true));
      editorContext.flushEvents();
      EditorComponent editor = editorContext.getNodeEditorComponent();
      EditorCell nodeCell = editor.findNodeCell(node);
      EditorCell lastSelectable = nodeCell.getLastLeaf(CellConditions.SELECTABLE);
      editor.changeSelection(lastSelectable);
      if (lastSelectable instanceof EditorCell_Label) {
        ((EditorCell_Label)lastSelectable).end();
      }
    }
  }
}
