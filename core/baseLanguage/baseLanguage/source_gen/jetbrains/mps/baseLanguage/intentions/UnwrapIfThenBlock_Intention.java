package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IVisitor;

public class UnwrapIfThenBlock_Intention extends BaseIntention implements Intention {
  public UnwrapIfThenBlock_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.IfStatement";
  }

  public boolean isParameterized() {
    return false;
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return true;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Unwrap If Then Block";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    SNode selectedNode = editorContext.getSelectedNode();
    for (SNode ancestor : ListSequence.fromList(SNodeOperations.getAncestors(selectedNode, null, true))) {
      if (SNodeOperations.isInstanceOf(ancestor, "jetbrains.mps.baseLanguage.structure.IfStatement")) {
        return eq_qjygni_a0a0a0b0g(ancestor, node);
      }
    }
    return false;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(node), "jetbrains.mps.baseLanguage.structure.StatementList")) {
      final SNode statementList = SNodeOperations.cast(SNodeOperations.getParent(node), "jetbrains.mps.baseLanguage.structure.StatementList");
      final Wrappers._int index = new Wrappers._int(ListSequence.fromList(SLinkOperations.getTargets(statementList, "statement", true)).indexOf(node));
      ListSequence.fromList(SLinkOperations.getTargets(statementList, "statement", true)).removeElementAt(index.value);
      ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(node, "ifTrue", true), "statement", true)).visitAll(new IVisitor<SNode>() {
        public void visit(SNode it) {
          ListSequence.fromList(SLinkOperations.getTargets(statementList, "statement", true)).insertElement(index.value, it);
          index.value += 1;
        }
      });
    } else {
      SNode statement = SNodeOperations.replaceWithNewChild(node, "jetbrains.mps.baseLanguage.structure.BlockStatement");
      SLinkOperations.setTarget(statement, "statements", SLinkOperations.getTarget(node, "ifTrue", true), true);
    }
    SNodeOperations.deleteNode(node);
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }

  private static boolean eq_qjygni_a0a0a0b0g(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
