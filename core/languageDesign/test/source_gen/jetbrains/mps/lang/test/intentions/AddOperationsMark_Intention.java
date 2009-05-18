package jetbrains.mps.lang.test.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.test.behavior.NodesTestCase_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.AttributesRolesUtil;

public class AddOperationsMark_Intention extends BaseIntention {

  public AddOperationsMark_Intention() {
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
    return "Add Test Operations Annotation";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    return NodesTestCase_Behavior.isIntentionApplicable_1217250498008(node);
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode newAnootation = SConceptOperations.createNewNode("jetbrains.mps.lang.test.structure.NodeOperationsContainer", null);
    SLinkOperations.setTarget(node, AttributesRolesUtil.childRoleFromAttributeRole("nodeOpraretionsMark"), newAnootation, true);
    editorContext.select(newAnootation);
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.test.intentions";
  }

}
