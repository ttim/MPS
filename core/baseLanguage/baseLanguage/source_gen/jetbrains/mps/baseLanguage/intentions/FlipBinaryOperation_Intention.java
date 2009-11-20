package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class FlipBinaryOperation_Intention extends EditorIntention {
  public FlipBinaryOperation_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.BinaryOperation";
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
    return "Flip Binary Operation";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return true;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode leftExpression = SLinkOperations.getTarget(node, "leftExpression", true);
    SNode rightExpression = SLinkOperations.getTarget(node, "rightExpression", true);
    SLinkOperations.setTarget(node, "leftExpression", SNodeOperations.copyNode(rightExpression), true);
    SLinkOperations.setTarget(node, "rightExpression", SNodeOperations.copyNode(leftExpression), true);
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }
}
