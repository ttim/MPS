package jetbrains.mps.lang.smodelTests.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.AbstractSearchScope;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.Condition;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.constraints.PresentationReferentConstraintContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class ReferenceContainer_leftChild_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public ReferenceContainer_leftChild_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.smodelTests.structure.ReferenceContainer", "leftChild", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.smodelTests.structure.ReferenceContainer", "leftChild");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return SModelOperations.getNodes(_context.getModel(), "jetbrains.mps.lang.smodelTests.structure.Child");
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
    return new SNodePointer("r:c3114115-c401-467f-8766-388ee2aa9908(jetbrains.mps.lang.smodelTests.constraints)", "8758390115029226005");
  }

  public boolean hasPresentation() {
    return true;
  }

  public String getPresentation(final IOperationContext operationContext, final PresentationReferentConstraintContext _context) {
    return SPropertyOperations.getString(_context.getParameterNode(), "name");
  }
}
