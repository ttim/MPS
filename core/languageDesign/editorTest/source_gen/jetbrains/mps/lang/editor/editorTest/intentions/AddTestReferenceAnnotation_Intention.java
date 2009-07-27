package jetbrains.mps.lang.editor.editorTest.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.test.behavior.NodesTestCase_Behavior;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.lang.generator.editor.QueriesUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.AttributesRolesUtil;

public class AddTestReferenceAnnotation_Intention extends BaseIntention {

  public AddTestReferenceAnnotation_Intention() {
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
    return "Add Test Refernce Annotation";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return NodesTestCase_Behavior.isIntentionApplicable_1217250498008(node);
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    EditorCell cell = editorContext.getSelectedCell();
    String linkRole = QueriesUtil.getEditedLinkRole(cell);
    SNode referentNode = QueriesUtil.getEditedLinkReferentNode(cell);
    SNode result = SLinkOperations.setNewChild(referentNode, AttributesRolesUtil.childRoleFromLinkAttributeRole("referenceAnnotation", linkRole), "jetbrains.mps.lang.editor.editorTest.structure.ReferenceAnnotataion");
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.editor.editorTest.intentions";
  }

}
