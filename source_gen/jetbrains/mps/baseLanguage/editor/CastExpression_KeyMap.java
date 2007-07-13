package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorCellKeyMap;
import jetbrains.mps.nodeEditor.EditorCellKeyMapAction;
import java.awt.event.KeyEvent;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.actions.CastExpression_FactoryUtil;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class CastExpression_KeyMap extends EditorCellKeyMap {

  public  CastExpression_KeyMap() {
    this.setApplicableToEveryModel(false);
    EditorCellKeyMapAction action;
    this.putAction("ctrl+shift", "VK_SPACE", new CastExpression_KeyMap.CastExpression_KeyMap_Action0());
  }
  public static class CastExpression_KeyMap_Action0 extends EditorCellKeyMapAction {

    public  CastExpression_KeyMap_Action0() {
      this.setShownInPopupMenu(false);
    }

    public String getDescriptionText() {
      return "fills cast type of cast expression";
    }
    public boolean isMenuAlwaysShown() {
      return false;
    }
    public boolean canExecute(KeyEvent keyEvent, EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      if((contextCell == null)) {
        return false;
      }
      SNode contextNode = contextCell.getSNode();
      if(contextNode == null) {
        return false;
      }
      if(contextNode.isInstanceOfConcept("jetbrains.mps.baseLanguage.structure.CastExpression", editorContext.getOperationContext().getScope())) {
        return this.canExecute_internal(keyEvent, editorContext, contextNode);
      }
      return false;
    }
    public void execute(KeyEvent keyEvent, EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      this.execute_internal(keyEvent, editorContext, contextCell.getSNode());
    }
    public boolean canExecute_internal(KeyEvent keyEvent, EditorContext editorContext, SNode node) {
      return CastExpression_FactoryUtil.canComputeCastType(node);
    }
    public void execute_internal(KeyEvent keyEvent, EditorContext editorContext, SNode node) {
      SNode type = CastExpression_FactoryUtil.computeCastType(node);
      SLinkOperations.setTarget(node, "type", type, true);
    }
}

}
