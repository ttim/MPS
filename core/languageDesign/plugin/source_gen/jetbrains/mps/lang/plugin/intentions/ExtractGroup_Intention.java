package jetbrains.mps.lang.plugin.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class ExtractGroup_Intention extends EditorIntention {
  public ExtractGroup_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.plugin.structure.ActionGroupDeclaration";
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
    return "Extract Group";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return SNodeOperations.getParent(node) != null;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode rootGroup = SModelOperations.createNewRootNode(SNodeOperations.getModel(node), "jetbrains.mps.lang.plugin.structure.ActionGroupDeclaration", null);
    SPropertyOperations.set(rootGroup, "name", SPropertyOperations.getString(node, "name"));
    SLinkOperations.setTarget(rootGroup, "contents", SLinkOperations.getTarget(node, "contents", true), true);
    SNodeOperations.deleteNode(node);
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.plugin.intentions";
  }
}
