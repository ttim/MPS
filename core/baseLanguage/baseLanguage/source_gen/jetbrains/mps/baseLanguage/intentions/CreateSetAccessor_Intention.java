package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class CreateSetAccessor_Intention extends EditorIntention {
  public CreateSetAccessor_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.GetAccessor";
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
    return "Create Set Accessor";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return (SLinkOperations.getTarget(SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.CustomPropertyImplementation", false, false), "setAccessor", true) == null);
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SLinkOperations.setNewChild(SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.CustomPropertyImplementation", false, false), "setAccessor", "jetbrains.mps.baseLanguage.structure.SetAccessor");
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }
}
