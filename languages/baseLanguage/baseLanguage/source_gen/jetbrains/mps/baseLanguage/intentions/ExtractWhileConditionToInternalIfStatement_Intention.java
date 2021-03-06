package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class ExtractWhileConditionToInternalIfStatement_Intention extends BaseIntention implements Intention {
  public ExtractWhileConditionToInternalIfStatement_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.WhileStatement";
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
    return "Extract While Condition to Internal If Statement";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return true;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    // produce break statement 
    SNode breakStatement = SNodeFactoryOperations.createNewNode("jetbrains.mps.baseLanguage.structure.BreakStatement", null);
    // produce if statement 
    SNode ifStatement = SNodeFactoryOperations.createNewNode("jetbrains.mps.baseLanguage.structure.IfStatement", null);
    SNode conditionExpr = SNodeFactoryOperations.setNewChild(ifStatement, "condition", "jetbrains.mps.baseLanguage.structure.NotExpression");
    SLinkOperations.setTarget(conditionExpr, "expression", SLinkOperations.getTarget(node, "condition", true), true);
    SNodeFactoryOperations.setNewChild(ifStatement, "ifTrue", "jetbrains.mps.baseLanguage.structure.StatementList");
    ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(ifStatement, "ifTrue", true), "statement", true)).insertElement(0, breakStatement);
    // insert if statement and replace condition with true 
    ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(node, "body", true), "statement", true)).insertElement(0, ifStatement);
    SNode condition = SNodeFactoryOperations.setNewChild(node, "condition", "jetbrains.mps.baseLanguage.structure.BooleanConstant");
    SPropertyOperations.set(condition, "value", "" + (true));
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }
}
