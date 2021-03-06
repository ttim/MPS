package jetbrains.mps.bash.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class CommentOutCommand_Intention extends BaseIntention implements Intention {
  public CommentOutCommand_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.core.structure.BaseConcept";
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
    return "Comment Out This Line";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return (SNodeOperations.getAncestor(node, "jetbrains.mps.bash.structure.CommandList", true, false) != null) && !((SNodeOperations.getAncestor(node, "jetbrains.mps.bash.structure.CommentedCommandList", true, false) != null));
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode commandList = SNodeOperations.getAncestor(node, "jetbrains.mps.bash.structure.CommandList", true, false);
    SNode commentedCommandList = SNodeFactoryOperations.createNewNode("jetbrains.mps.bash.structure.CommentedCommandList", null);
    SNodeOperations.replaceWithAnother(commandList, commentedCommandList);
    SLinkOperations.setTarget(commentedCommandList, "commandList", commandList, true);
  }

  public String getLocationString() {
    return "jetbrains.mps.bash.intentions";
  }
}
