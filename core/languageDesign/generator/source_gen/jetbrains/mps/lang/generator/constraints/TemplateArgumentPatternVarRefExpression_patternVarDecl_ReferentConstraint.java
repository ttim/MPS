package jetbrains.mps.lang.generator.constraints;

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
import jetbrains.mps.smodel.SNodePointer;

public class TemplateArgumentPatternVarRefExpression_patternVarDecl_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public TemplateArgumentPatternVarRefExpression_patternVarDecl_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.generator.structure.TemplateArgumentPatternVarRefExpression", "patternVarDecl", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.generator.structure.TemplateArgumentPatternVarRefExpression", "patternVarDecl");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> result = new ArrayList<SNode>();
    SNode rule = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.lang.generator.structure.PatternReduction_MappingRule", false, false);
    if ((rule != null) && (SLinkOperations.getTarget(rule, "pattern", true) != null)) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getDescendants(SLinkOperations.getTarget(rule, "pattern", true), "jetbrains.mps.lang.pattern.structure.PatternVariableDeclaration", false, new String[]{})));
    }
    return result;
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c895902e2(jetbrains.mps.lang.generator.constraints)", "4665309944889434725");
  }
}
