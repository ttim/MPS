package jetbrains.mps.build.packaging.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.workbench.editors.MPSEditorOpener;

public class CreateNewBuildLanguageProject_Intention extends BaseIntention {

  public String getConcept() {
    return "jetbrains.mps.build.packaging.structure.Antcall";
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return false;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Create new buildlanguage project";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    return (SLinkOperations.getTarget(node, "project", false) == null) && (SLinkOperations.getTarget(node, "targetDeclaration", false) == null);
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode project = SConceptOperations.createNewNode("jetbrains.mps.buildlanguage.structure.Project", null);
    SModel model = editorContext.getModel();
    model.addRoot(project);
    SLinkOperations.setTarget(node, "project", project, false);
    SLinkOperations.setTarget(node, "targetDeclaration", SLinkOperations.getTarget(SLinkOperations.getTarget(project, "default", true), "targetDeclaration", false), false);
    MPSEditorOpener opener = editorContext.getOperationContext().getProject().getComponent(MPSEditorOpener.class);
    opener.openNode(project);
  }

  public String getLocationString() {
    return "jetbrains.mps.build.packaging.intentions";
  }

}
