package jetbrains.mps.ypath.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.search.SimpleSearchScope;
import jetbrains.mps.smodel.search.EmptySearchScope;

public class TreeNodeKindReference_treeNodeKind_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {

  public TreeNodeKindReference_treeNodeKind_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.ypath.structure.TreeNodeKindReference", "treeNodeKind", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.ypath.structure.TreeNodeKindReference", "treeNodeKind");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    ISearchScope searchScope;
    if ((_context.getReferenceNode() != null) && (SLinkOperations.getTarget(_context.getReferenceNode(), "treePathAspect", false) != null)) {
      searchScope = new SimpleSearchScope(SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getReferenceNode(), "treePathAspect", false), "nodeKinds", true));
    } else
    {
      searchScope = new EmptySearchScope();
    }
    return searchScope;
  }

}
