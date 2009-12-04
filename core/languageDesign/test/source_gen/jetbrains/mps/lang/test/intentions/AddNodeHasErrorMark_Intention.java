package jetbrains.mps.lang.test.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.test.behavior.NodesTestCase_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.AttributesRolesUtil;

public class AddNodeHasErrorMark_Intention extends BaseIntention implements Intention {
  public AddNodeHasErrorMark_Intention() {
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
    return "Add Node Has Error Annotation";
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
    SNode newAnnotation = SConceptOperations.createNewNode("jetbrains.mps.lang.test.structure.NodePropertiesContainer", null);
    SLinkOperations.setTarget(node, AttributesRolesUtil.childRoleFromAttributeRole("nodePropertiesMarker"), newAnnotation, true);
    SLinkOperations.addNewChild(newAnnotation, "properties", "jetbrains.mps.lang.test.structure.NodeErrorPropety");
    editorContext.select(newAnnotation);
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.test.intentions";
  }
}
