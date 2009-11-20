package jetbrains.mps.build.packaging.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.workbench.editors.MPSEditorOpener;

public class CreateNewTarget_Intention extends EditorIntention {
  public CreateNewTarget_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.build.packaging.structure.Antcall";
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
    return "Create New Target in Project " + SLinkOperations.getTarget(node, "project", false);
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return (SLinkOperations.getTarget(node, "project", false) != null) && (SLinkOperations.getTarget(node, "targetDeclaration", false) == null);
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode targetDeclaration = SConceptOperations.createNewNode("jetbrains.mps.buildlanguage.structure.TargetDeclaration", null);
    SLinkOperations.addChild(SLinkOperations.getTarget(node, "project", false), "target", targetDeclaration);
    SLinkOperations.setTarget(node, "targetDeclaration", targetDeclaration, false);
    MPSEditorOpener opener = editorContext.getOperationContext().getProject().getComponent(MPSEditorOpener.class);
    opener.openNode(targetDeclaration);
  }

  public String getLocationString() {
    return "jetbrains.mps.build.packaging.intentions";
  }
}
