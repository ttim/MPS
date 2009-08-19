package jetbrains.mps.lang.typesystem.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class LinkPatternVariableReference_patternVarDecl_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public LinkPatternVariableReference_patternVarDecl_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.typesystem.structure.LinkPatternVariableReference", "patternVarDecl", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.typesystem.structure.LinkPatternVariableReference", "patternVarDecl");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> result = new ArrayList<SNode>();
    SNode rule = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.lang.typesystem.structure.AbstractRule", false, false);
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(rule, "applicableNode", true), "jetbrains.mps.lang.typesystem.structure.PatternCondition")) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getDescendants(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(rule, "applicableNode", true), "jetbrains.mps.lang.typesystem.structure.PatternCondition"), "pattern", true), "jetbrains.mps.lang.pattern.structure.LinkPatternVariableDeclaration", false, new String[]{})));
    }
    SNode coerceStatement = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.lang.typesystem.structure.CoerceStatement", false, false);
    while (coerceStatement != null) {
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(coerceStatement, "pattern", true), "jetbrains.mps.lang.typesystem.structure.PatternCondition")) {
        ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getDescendants(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(coerceStatement, "pattern", true), "jetbrains.mps.lang.typesystem.structure.PatternCondition"), "pattern", true), "jetbrains.mps.lang.pattern.structure.LinkPatternVariableDeclaration", false, new String[]{})));
      }
      coerceStatement = SNodeOperations.getAncestor(coerceStatement, "jetbrains.mps.lang.typesystem.structure.CoerceStatement", false, false);
    }
    SNode matchStatementItem = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.lang.typesystem.structure.MatchStatementItem", false, false);
    while (matchStatementItem != null) {
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(matchStatementItem, "condition", true), "jetbrains.mps.lang.typesystem.structure.PatternCondition")) {
        ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getDescendants(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(matchStatementItem, "condition", true), "jetbrains.mps.lang.typesystem.structure.PatternCondition"), "pattern", true), "jetbrains.mps.lang.pattern.structure.LinkPatternVariableDeclaration", false, new String[]{})));
      }
      matchStatementItem = SNodeOperations.getAncestor(matchStatementItem, "jetbrains.mps.lang.typesystem.structure.MatchStatementItem", false, false);
    }
    return result;
  }
}
