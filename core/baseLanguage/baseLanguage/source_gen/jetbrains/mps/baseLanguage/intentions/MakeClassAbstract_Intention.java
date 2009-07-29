package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class MakeClassAbstract_Intention extends BaseIntention {

  public MakeClassAbstract_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.ClassConcept";
  }

  public boolean isParameterized() {
    return false;
  }

  public boolean isErrorIntention() {
    return true;
  }

  public boolean isAvailableInChildNodes() {
    return true;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Make Class Abstract";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    if (editorContext.getSelectedNode() != node && !(this.isVisibleInChild(node, editorContext.getSelectedNode(), editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return !(SPropertyOperations.getBoolean(node, "abstractClass")) && ListSequence.fromList(SLinkOperations.getTargets(node, "method", true)).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return SPropertyOperations.getBoolean(it, "isAbstract");
      }
    }).isNotEmpty();
  }

  public boolean isVisibleInChild(final SNode node, final SNode childNode, final EditorContext editorContext) {
    return SNodeOperations.isInstanceOf(childNode, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration") && SPropertyOperations.getBoolean(SNodeOperations.cast(childNode, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), "isAbstract");
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SPropertyOperations.set(node, "abstractClass", "" + (true));
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }

}
