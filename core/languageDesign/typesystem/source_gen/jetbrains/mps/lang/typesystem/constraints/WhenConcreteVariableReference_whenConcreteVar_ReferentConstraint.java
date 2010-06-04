package jetbrains.mps.lang.typesystem.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.AbstractSearchScope;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.util.Condition;
import jetbrains.mps.smodel.SNodePointer;

public class WhenConcreteVariableReference_whenConcreteVar_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public WhenConcreteVariableReference_whenConcreteVar_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.typesystem.structure.WhenConcreteVariableReference", "whenConcreteVar", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.typesystem.structure.WhenConcreteVariableReference", "whenConcreteVar");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> whenConcreteStatements = SNodeOperations.getAncestors(_context.getEnclosingNode(), "jetbrains.mps.lang.typesystem.structure.WhenConcreteStatement", false);
    List<SNode> declarations = new ArrayList<SNode>();
    for (SNode whenConcreteStatement : whenConcreteStatements) {
      ListSequence.fromList(declarations).addElement(SLinkOperations.getTarget(whenConcreteStatement, "argumentRepresentator", true));
    }
    return declarations;
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
    return new SNodePointer("r:00000000-0000-4000-0000-011c895902ae(jetbrains.mps.lang.typesystem.constraints)", "1213104837477");
  }
}
