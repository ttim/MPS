package jetbrains.mps.lang.refactoring.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.AbstractSearchScope;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.util.Condition;
import jetbrains.mps.smodel.SNodePointer;

public class RequiredAdditionalArgumentReference_argument_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public RequiredAdditionalArgumentReference_argument_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.refactoring.structure.RequiredAdditionalArgumentReference", "argument", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.refactoring.structure.RequiredAdditionalArgumentReference", "argument");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> nodes = ListSequence.fromList(new ArrayList<SNode>());
    SNode refactoring = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.lang.refactoring.structure.OldRefactoring", false, false);
    ListSequence.fromList(nodes).addSequence(ListSequence.fromList(SLinkOperations.getTargets(refactoring, "arguments", true)));
    ListSequence.fromList(nodes).addSequence(ListSequence.fromList(SLinkOperations.getTargets(refactoring, "internalArguments", true)));
    return nodes;
  }

  public ISearchScope createNodeReferentSearchScope(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return new AbstractSearchScope() {
      @NotNull
      public List<SNode> getNodes(Condition<SNode> condition) {
        Iterable<SNode> seq = (Iterable<SNode>) createSearchScopeOrListOfNodes(operationContext, _context);
        List<SNode> result = new ArrayList<SNode>();
        if (seq != null) {
          for (SNode node : seq) {
            if (condition.met(node)) {
              result.add(node);
            }
          }
        }
        return result;
      }
    };
  }

  public SNodePointer getSearchScopeValidatorNodePointer() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c89590313(jetbrains.mps.lang.refactoring.constraints)", "1214839131317");
  }
}
