package jetbrains.mpslite.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorCellKeyMap;
import jetbrains.mps.nodeEditor.EditorCellKeyMapAction;
import java.awt.event.KeyEvent;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class _Line_Actions extends EditorCellKeyMap {

  public _Line_Actions() {
    this.setApplicableToEveryModel(false);
    EditorCellKeyMapAction action;
    action = new _Line_Actions._Line_Actions_Action0();
    this.putAction("ctrl", "VK_ENTER", action);
  }
  public static class _Line_Actions_Action0 extends EditorCellKeyMapAction {

    public _Line_Actions_Action0() {
      this.setShownInPopupMenu(false);
    }

    public boolean isMenuAlwaysShown() {
      return false;
    }

    public boolean canExecute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      if ((contextCell == null)) {
        return false;
      }
      SNode contextNode = contextCell.getSNode();
      if (contextNode == null) {
        return false;
      }
      if (contextNode.isInstanceOfConcept("jetbrains.mpslite.structure.Line")) {
        return true;
      }
      return false;
    }

    public void execute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      this.execute_internal(keyEvent, editorContext, contextCell.getSNode(), this.getSelectedNodes(editorContext));
    }

    private void execute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      SNode selectedNode = editorContext.getSelectedNode();
      if (selectedNode == null) {
        return;
      }
      SNode part = SNodeOperations.getAncestor(selectedNode, "jetbrains.mpslite.structure.LinePart", true, false);
      SNode currentLine = SNodeOperations.getParent(part, null, false, false);
      SModel model = SNodeOperations.getModel(node);
      SNode newLine = SModelOperations.createNewNode(model, "jetbrains.mpslite.structure.Line", null);
      SNodeOperations.insertNextSiblingChild(currentLine, newLine);
      for(SNode p : SNodeOperations.getNextSiblings(part, false)) {
        SNodeOperations.getParent(p, null, false, false).removeChild(p);
        SLinkOperations.addChild(newLine, "linePart", p);
      }
    }

    public String getKeyStroke() {
      return "ctrl ENTER";
    }

}

}
