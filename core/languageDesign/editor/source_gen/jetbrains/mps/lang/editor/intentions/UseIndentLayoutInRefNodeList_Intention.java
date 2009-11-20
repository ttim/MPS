package jetbrains.mps.lang.editor.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class UseIndentLayoutInRefNodeList_Intention extends EditorIntention {
  public UseIndentLayoutInRefNodeList_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.editor.structure.CellModel_RefNodeList";
  }

  public boolean isParameterized() {
    return false;
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return false;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "cellLayout", true), "jetbrains.mps.lang.editor.structure.CellLayout_Indent"))) {
      return "Use Indent Layout";
    } else {
      return "Use Horizontal Layout";
    }
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "cellLayout", true), "jetbrains.mps.lang.editor.structure.CellLayout_Indent"))) {
      SLinkOperations.setNewChild(node, "cellLayout", "jetbrains.mps.lang.editor.structure.CellLayout_Indent");
    } else {
      SLinkOperations.setNewChild(node, "cellLayout", "jetbrains.mps.lang.editor.structure.CellLayout_Horizontal");
    }
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.editor.intentions";
  }
}
