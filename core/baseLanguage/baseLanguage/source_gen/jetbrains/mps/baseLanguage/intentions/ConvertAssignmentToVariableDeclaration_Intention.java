package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.behavior.AssignmentExpression_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class ConvertAssignmentToVariableDeclaration_Intention extends EditorIntention {
  public ConvertAssignmentToVariableDeclaration_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.LocalVariableReference";
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
    return "Convert to Variable Declaration";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    if (!(SNodeOperations.isInstanceOf(SNodeOperations.getParent(node), "jetbrains.mps.baseLanguage.structure.AssignmentExpression"))) {
      return false;
    }
    SNode assignment = SNodeOperations.cast(SNodeOperations.getParent(node), "jetbrains.mps.baseLanguage.structure.AssignmentExpression");
    return AssignmentExpression_Behavior.call_canConvertToLocalVariableDeclaration_1221573334330(assignment) && SLinkOperations.getTarget(assignment, "lValue", true) == node;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode assignment = SNodeOperations.cast(SNodeOperations.getParent(node), "jetbrains.mps.baseLanguage.structure.AssignmentExpression");
    SNode result = AssignmentExpression_Behavior.call_convertToLocalVariableDeclaration_1221573391693(assignment);
    editorContext.selectWRTFocusPolicy(result);
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }
}
