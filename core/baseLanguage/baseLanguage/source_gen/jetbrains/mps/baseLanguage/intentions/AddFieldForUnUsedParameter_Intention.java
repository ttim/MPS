package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import java.util.Set;
import jetbrains.mps.lang.dataFlow.DataFlow;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class AddFieldForUnUsedParameter_Intention extends BaseIntention {

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.ParameterDeclaration";
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return false;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Add Field For Unused Parameter.";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    Set<SNode> unusedAssignments = DataFlow.getUnusedAssignments(SLinkOperations.getTarget(SNodeOperations.cast(SNodeOperations.getParent(node), "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration"), "body", true));
    return SetSequence.fromSet(unusedAssignments).contains(node);
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode clazz = SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false);
    SNode field = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.FieldDeclaration", null);
    SPropertyOperations.set(field, "name", SPropertyOperations.getString(node, "name"));
    SLinkOperations.setTarget(field, "type", SNodeOperations.copyNode(SLinkOperations.getTarget(node, "type", true)), true);
    SLinkOperations.addChild(clazz, "field", field);
    SNode newStatement = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ExpressionStatement", null);
    SNode expr = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.AssignmentExpression", null);
    SLinkOperations.setTarget(newStatement, "expression", expr, true);
    SNode fieldRef = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.FieldReferenceOperation", null);
    SLinkOperations.setTarget(fieldRef, "fieldDeclaration", field, false);
    SNode leftPart = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.DotExpression", null);
    SLinkOperations.setTarget(leftPart, "operand", SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ThisExpression", null), true);
    SLinkOperations.setTarget(leftPart, "operation", fieldRef, true);
    SLinkOperations.setTarget(expr, "lValue", leftPart, true);
    SNode paramRef = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ParameterReference", null);
    SLinkOperations.setTarget(paramRef, "variableDeclaration", node, false);
    SLinkOperations.setTarget(expr, "rValue", paramRef, true);
    SLinkOperations.addChild(SLinkOperations.getTarget(SNodeOperations.cast(SNodeOperations.getParent(node), "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration"), "body", true), "statement", newStatement);
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }

}
