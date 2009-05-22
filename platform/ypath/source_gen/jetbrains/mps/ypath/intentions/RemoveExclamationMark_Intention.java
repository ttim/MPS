package jetbrains.mps.ypath.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class RemoveExclamationMark_Intention extends BaseIntention {

  public RemoveExclamationMark_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.ypath.structure.TreePathAdapterExpression";
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
    return "Remove Cast to TreePathAspect";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    return (SNodeOperations.getAncestor(node, "jetbrains.mps.ypath.structure.TreePathOperationExpression", false, false) == null);
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNodeOperations.replaceWithAnother(node, SLinkOperations.getTarget(node, "expression", true));
  }

  public String getLocationString() {
    return "jetbrains.mps.ypath.intentions";
  }

}
