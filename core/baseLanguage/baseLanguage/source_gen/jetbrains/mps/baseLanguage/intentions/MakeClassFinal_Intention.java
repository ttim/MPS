package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class MakeClassFinal_Intention extends EditorIntention {
  public MakeClassFinal_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.ClassConcept";
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
    return "Make " + ((SPropertyOperations.getBoolean(node, "isFinal") ?
      "Non" :
      ""
    )) + " Final";
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
    return SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.AnonymousClass");
  }

  public boolean isVisibleInChild(final SNode node, final SNode childNode, final EditorContext editorContext) {
    return SNodeOperations.hasRole(childNode, "jetbrains.mps.baseLanguage.structure.ClassConcept", "visibility");
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SPropertyOperations.set(node, "isFinal", "" + (!(SPropertyOperations.getBoolean(node, "isFinal"))));
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }
}
