package jetbrains.mps.baseLanguage.regexp.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorCellKeyMap;
import jetbrains.mps.nodeEditor.EditorCellKeyMapAction;
import java.awt.event.KeyEvent;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class RegexpSequenceByEnter extends EditorCellKeyMap {
  public RegexpSequenceByEnter() {
    this.setApplicableToEveryModel(false);
    EditorCellKeyMapAction action;
    action = new RegexpSequenceByEnter.RegexpSequenceByEnter_Action0();
    this.putAction("none", "VK_ENTER", action);
    action = new RegexpSequenceByEnter.RegexpSequenceByEnter_Action1();
    this.putAction("none", "VK_ENTER", action);
  }

  public static class RegexpSequenceByEnter_Action0 extends EditorCellKeyMapAction {
    public RegexpSequenceByEnter_Action0() {
      super.setCaretPolicy(EditorCellKeyMapAction.CARET_AT_LAST_POSITION);
      this.setShownInPopupMenu(false);
    }

    public String getDescriptionText() {
      return "insert an item after";
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
      if (contextNode.isInstanceOfConcept("jetbrains.mps.baseLanguage.regexp.structure.Regexp")) {
        return true;
      }
      return false;
    }

    public void execute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      this.execute_internal(keyEvent, editorContext, contextCell.getSNode(), this.getSelectedNodes(editorContext));
    }

    private void execute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      SNode nt = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.regexp.structure.SeqRegexp", null);
      SNodeOperations.replaceWithAnother(node, nt);
      SLinkOperations.setTarget(nt, "left", node, true);
      editorContext.select(nt, "right");
    }

    public String getKeyStroke() {
      return "none ENTER";
    }
  }

  public static class RegexpSequenceByEnter_Action1 extends EditorCellKeyMapAction {
    public RegexpSequenceByEnter_Action1() {
      super.setCaretPolicy(EditorCellKeyMapAction.CARET_AT_FIRST_POSITION);
      this.setShownInPopupMenu(false);
    }

    public String getDescriptionText() {
      return "insert an item before";
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
      if (contextNode.isInstanceOfConcept("jetbrains.mps.baseLanguage.regexp.structure.Regexp")) {
        return true;
      }
      return false;
    }

    public void execute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      this.execute_internal(keyEvent, editorContext, contextCell.getSNode(), this.getSelectedNodes(editorContext));
    }

    private void execute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      SNode nt = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.regexp.structure.SeqRegexp", null);
      SNodeOperations.replaceWithAnother(node, nt);
      SLinkOperations.setTarget(nt, "right", node, true);
      editorContext.select(nt, "left");
    }

    public String getKeyStroke() {
      return "none ENTER";
    }
  }
}
