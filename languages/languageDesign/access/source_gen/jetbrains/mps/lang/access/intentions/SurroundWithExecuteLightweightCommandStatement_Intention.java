package jetbrains.mps.lang.access.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.SurroundWithIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class SurroundWithExecuteLightweightCommandStatement_Intention extends SurroundWithIntention implements Intention {
  public SurroundWithExecuteLightweightCommandStatement_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.Statement";
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
    return "Read Action";
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode readActionStatement = SNodeFactoryOperations.createNewNode("jetbrains.mps.lang.access.structure.ExecuteLightweightCommandStatement", null);
    List<SNode> selectedNodes = editorContext.getSelectedNodes();
    SNodeOperations.insertNextSiblingChild(node, readActionStatement);
    for (SNode selectedNode : ListSequence.fromList(selectedNodes)) {
      ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(SLinkOperations.getTarget(readActionStatement, "commandClosureLiteral", true), "body", true), "statement", true)).addElement(SNodeOperations.getAncestor(selectedNode, "jetbrains.mps.baseLanguage.structure.Statement", true, false));
    }
    editorContext.select(ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(SLinkOperations.getTarget(readActionStatement, "commandClosureLiteral", true), "body", true), "statement", true)).first());
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.access.intentions";
  }
}
