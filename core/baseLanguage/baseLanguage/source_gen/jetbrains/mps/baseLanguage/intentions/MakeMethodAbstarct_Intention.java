package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.Sequence;

public class MakeMethodAbstarct_Intention extends BaseIntention implements Intention {
  public MakeMethodAbstarct_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration";
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
    return (SPropertyOperations.getBoolean(node, "isAbstract") ?
      "Make Method Not Abstract" :
      "Make Method Abstract"
    );
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    SNode contextNode = editorContext.getSelectedNode();
    if (contextNode == null) {
      return true;
    }
    SNode containingClassifier = SNodeOperations.getAncestor(contextNode, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    if (!(SNodeOperations.isInstanceOf(containingClassifier, "jetbrains.mps.baseLanguage.structure.ClassConcept"))) {
      return false;
    }
    List<SNode> includingStatementLists = SNodeOperations.getAncestors(contextNode, "jetbrains.mps.baseLanguage.structure.StatementList", true);
    Iterable<SNode> includingBodies = ListSequence.fromList(includingStatementLists).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.hasRole(it, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", "body");
      }
    });
    return Sequence.fromIterable(includingBodies).isEmpty();
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SPropertyOperations.set(node, "isAbstract", "" + !(SPropertyOperations.getBoolean(node, "isAbstract")));
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }
}
