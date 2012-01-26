package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.errors.QuickFix_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class RemoveUnusedAssignment_QuickFix extends QuickFix_Runtime {
  public RemoveUnusedAssignment_QuickFix() {
  }

  public String getDescription(SNode node) {
    return "remove unused assignment";
  }

  public void execute(SNode node) {
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.AssignmentExpression")) {
      SNode assignmentExpression = SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.AssignmentExpression");
      SNode lValue = SLinkOperations.getTarget(assignmentExpression, "lValue", true);
      SNodeOperations.replaceWithAnother(assignmentExpression, lValue);
      if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(lValue), "jetbrains.mps.baseLanguage.structure.ExpressionStatement")) {
        SNodeOperations.deleteNode(SNodeOperations.getParent(lValue));
      }
    }
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration")) {
      SNodeOperations.detachNode(SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), "initializer", true));
    }
  }
}
