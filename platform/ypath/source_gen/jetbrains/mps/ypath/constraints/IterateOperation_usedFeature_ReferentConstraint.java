package jetbrains.mps.ypath.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.search.SimpleSearchScope;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.ypath.behavior.TreePath_Behavior;
import jetbrains.mps.ypath.behavior.ITreePathExpression_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;

public class IterateOperation_usedFeature_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {

  public IterateOperation_usedFeature_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.ypath.structure.IterateOperation", "usedFeature", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.ypath.structure.IterateOperation", "usedFeature");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode tpoe;
    if (SNodeOperations.isInstanceOf(_context.getEnclosingNode(), "jetbrains.mps.ypath.structure.TreePathOperationExpression")) {
      tpoe = _context.getEnclosingNode();
    } else
    {
      tpoe = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.ypath.structure.TreePathOperationExpression", false, false);
    }
    return new SimpleSearchScope(Sequence.fromIterable(TreePath_Behavior.call_getFeature_1213877481312(ITreePathExpression_Behavior.call_getTreePath_1213877496973(tpoe), SLinkOperations.getTarget(TypeChecker.getInstance().getTypeOf(tpoe), "nodeType", true))).toListSequence());
  }

}
