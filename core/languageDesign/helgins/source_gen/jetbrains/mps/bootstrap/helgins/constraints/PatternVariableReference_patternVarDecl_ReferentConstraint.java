package jetbrains.mps.bootstrap.helgins.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.search.SimpleSearchScope;

public class PatternVariableReference_patternVarDecl_ReferentConstraint implements IModelConstraints, INodeReferentSearchScopeProvider {

  public PatternVariableReference_patternVarDecl_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.bootstrap.helgins.structure.PatternVariableReference", "patternVarDecl", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.bootstrap.helgins.structure.PatternVariableReference", "patternVarDecl");
  }

  public ISearchScope createNodeReferentSearchScope(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> result = new ArrayList<SNode>();
    SNode rule = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.bootstrap.helgins.structure.AbstractRule", false, false);
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(rule, "applicableNode", true), "jetbrains.mps.bootstrap.helgins.structure.PatternCondition")) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getDescendants(SLinkOperations.getTarget(SLinkOperations.getTarget(rule, "applicableNode", true), "pattern", true), "jetbrains.mps.patterns.structure.PatternVariableDeclaration", false)));
    }
    if (SNodeOperations.isInstanceOf(rule, "jetbrains.mps.bootstrap.helgins.structure.InequationReplacementRule")) {
      SNode supertypeNode = SLinkOperations.getTarget(rule, "supertypeNode", true);
      if (SNodeOperations.isInstanceOf(supertypeNode, "jetbrains.mps.bootstrap.helgins.structure.PatternCondition")) {
        ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getDescendants(SLinkOperations.getTarget(supertypeNode, "pattern", true), "jetbrains.mps.patterns.structure.PatternVariableDeclaration", false)));
      }
    }
    if (SNodeOperations.isInstanceOf(rule, "jetbrains.mps.bootstrap.helgins.structure.ComparisonRule")) {
      SNode anotherNode = SLinkOperations.getTarget(rule, "anotherNode", true);
      if (SNodeOperations.isInstanceOf(anotherNode, "jetbrains.mps.bootstrap.helgins.structure.PatternCondition")) {
        ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getDescendants(SLinkOperations.getTarget(anotherNode, "pattern", true), "jetbrains.mps.patterns.structure.PatternVariableDeclaration", false)));
      }
    }
    SNode coerceStatement = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.bootstrap.helgins.structure.CoerceStatement", false, false);
    while (coerceStatement != null) {
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(coerceStatement, "pattern", true), "jetbrains.mps.bootstrap.helgins.structure.PatternCondition")) {
        ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getDescendants(SLinkOperations.getTarget(SLinkOperations.getTarget(coerceStatement, "pattern", true), "pattern", true), "jetbrains.mps.patterns.structure.PatternVariableDeclaration", false)));
      }
      coerceStatement = SNodeOperations.getAncestor(coerceStatement, "jetbrains.mps.bootstrap.helgins.structure.CoerceStatement", false, false);
    }
    SNode matchStatementItem = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.bootstrap.helgins.structure.MatchStatementItem", false, false);
    while (matchStatementItem != null) {
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(matchStatementItem, "condition", true), "jetbrains.mps.bootstrap.helgins.structure.PatternCondition")) {
        ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getDescendants(SLinkOperations.getTarget(SLinkOperations.getTarget(matchStatementItem, "condition", true), "pattern", true), "jetbrains.mps.patterns.structure.PatternVariableDeclaration", false)));
      }
      matchStatementItem = SNodeOperations.getAncestor(matchStatementItem, "jetbrains.mps.bootstrap.helgins.structure.MatchStatementItem", false, false);
    }
    return new SimpleSearchScope(result);
  }

}
