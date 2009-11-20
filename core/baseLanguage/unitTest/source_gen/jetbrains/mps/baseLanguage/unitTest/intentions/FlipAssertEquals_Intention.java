package jetbrains.mps.baseLanguage.unitTest.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class FlipAssertEquals_Intention extends EditorIntention {
  public FlipAssertEquals_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.unitTest.structure.BinaryAssert";
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
    return "Flip Assert Statement";
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode expected = SLinkOperations.getTarget(node, "expected", true);
    SNode actual = SLinkOperations.getTarget(node, "actual", true);
    SLinkOperations.setTarget(node, "expected", SNodeOperations.copyNode(actual), true);
    SLinkOperations.setTarget(node, "actual", SNodeOperations.copyNode(expected), true);
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.unitTest.intentions";
  }
}
