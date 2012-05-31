package jetbrains.mps.build.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorCellKeyMap;
import jetbrains.mps.nodeEditor.EditorCellKeyMapAction;
import java.awt.event.KeyEvent;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;

public class BuildSimpleName_text extends EditorCellKeyMap {
  public BuildSimpleName_text() {
    this.setApplicableToEveryModel(false);
    EditorCellKeyMapAction action;
    action = new BuildSimpleName_text.BuildSimpleName_text_Action0();
    this.putAction("any", "$", action);
  }

  public static class BuildSimpleName_text_Action0 extends EditorCellKeyMapAction {
    public BuildSimpleName_text_Action0() {
      this.setShownInPopupMenu(false);
    }

    public String getDescriptionText() {
      return "insert variable reference";
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
      if (contextNode.isInstanceOfConcept("jetbrains.mps.build.structure.BuildTextStringPart")) {
        return this.canExecute_internal(keyEvent, editorContext, contextNode, this.getSelectedNodes(editorContext));
      }
      return false;
    }

    public void execute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      this.execute_internal(keyEvent, editorContext, contextCell.getSNode(), this.getSelectedNodes(editorContext));
    }

    private boolean canExecute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      if (!(editorContext.getSelectedCell() instanceof EditorCell_Label)) {
        return false;
      }
      if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.build.structure.BuildStringPart"))) {
        return false;
      }
      return isNotEmpty_4bhgsw_a0c0e0(SPropertyOperations.getString(node, "text"));
    }

    private void execute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      int index = ((EditorCell_Label) editorContext.getSelectedCell()).getCaretPosition();

      String currText = SPropertyOperations.getString(node, "text");
      if (index < currText.length() && index > 0) {
        SNode newText = SModelOperations.createNewNode(SNodeOperations.getModel(node), "jetbrains.mps.build.structure.BuildTextStringPart", null);
        SPropertyOperations.set(newText, "text", currText.substring(index));
        SPropertyOperations.set(node, "text", currText.substring(0, index));
        SNodeOperations.insertNextSiblingChild(node, newText);
      }
      SNode newRef = SModelOperations.createNewNode(SNodeOperations.getModel(node), "jetbrains.mps.build.structure.BuildVarRefStringPart", null);
      if (index != 0) {
        SNodeOperations.insertNextSiblingChild(node, newRef);
      } else {
        SNodeOperations.insertPrevSiblingChild(node, newRef);
      }
      editorContext.selectWRTFocusPolicy(newRef);
    }

    public String getKeyStroke() {
      return " $";
    }

    public static boolean isNotEmpty_4bhgsw_a0c0e0(String str) {
      return str != null && str.length() > 0;
    }
  }
}
