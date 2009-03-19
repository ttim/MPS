package jetbrains.mps.build.packaging.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.search.SimpleSearchScope;
import jetbrains.mps.baseLanguage.collections.internal.query.ListOperations;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class Antcall_targetDeclaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {

  public Antcall_targetDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.build.packaging.structure.Antcall", "targetDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.build.packaging.structure.Antcall", "targetDeclaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    if ((SLinkOperations.getTarget(_context.getReferenceNode(), "project", false) == null)) {
      return new SimpleSearchScope(ListOperations.<SNode>createList());
    }
    List<SNode> nodes = ListOperations.<SNode>createList();
    ListSequence.fromList(nodes).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getReferenceNode(), "project", false), "target", true)));
    return new SimpleSearchScope(nodes);
  }

}
