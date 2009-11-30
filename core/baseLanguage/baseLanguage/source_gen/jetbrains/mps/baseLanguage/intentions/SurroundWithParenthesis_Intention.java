package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.SurroundWithIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class SurroundWithParenthesis_Intention extends SurroundWithIntention {
  public SurroundWithParenthesis_Intention() {
  }

  public String getDescription(SNode p0, EditorContext p1) {
    return "( expr )";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return editorContext.getSelectedNodes().size() == 1;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNodeOperations.replaceWithNewChild(node, "jetbrains.mps.baseLanguage.structure.ParenthesizedExpression");
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.Expression";
  }
}
