package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class MoveInitializerToConstructor_Intention extends BaseIntention implements Intention {
  public MoveInitializerToConstructor_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.FieldDeclaration";
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
    return "Move Initializer to Constructor";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    if (SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false) == null) {
      return false;
    }
    if (SLinkOperations.getTarget(node, "initializer", true) == null) {
      return false;
    }
    return true;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode classNode = SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false);
    // 
    SNode assignmentStmt = SNodeFactoryOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ExpressionStatement", null);
    SNode assignmentExpr = SNodeFactoryOperations.setNewChild(assignmentStmt, "expression", "jetbrains.mps.baseLanguage.structure.AssignmentExpression");
    SLinkOperations.setTarget(assignmentExpr, "rValue", SNodeOperations.copyNode(SLinkOperations.getTarget(node, "initializer", true)), true);
    // 
    SNode lValue = SNodeFactoryOperations.setNewChild(assignmentExpr, "lValue", "jetbrains.mps.baseLanguage.structure.DotExpression");
    SNodeFactoryOperations.setNewChild(lValue, "operand", "jetbrains.mps.baseLanguage.structure.ThisExpression");
    SLinkOperations.setTarget(SNodeFactoryOperations.setNewChild(lValue, "operation", "jetbrains.mps.baseLanguage.structure.FieldReferenceOperation"), "fieldDeclaration", node, false);
    // 
    for (SNode constr : ListSequence.fromList(SLinkOperations.getTargets(classNode, "constructor", true))) {
      ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(constr, "body", true), "statement", true)).insertElement(0, SNodeOperations.copyNode(assignmentStmt));
    }
    // 
    SNodeOperations.detachNode(SLinkOperations.getTarget(node, "initializer", true));
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }
}
