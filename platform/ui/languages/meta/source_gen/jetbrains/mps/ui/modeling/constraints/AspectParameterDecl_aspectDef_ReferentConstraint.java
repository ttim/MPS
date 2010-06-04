package jetbrains.mps.ui.modeling.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.AbstractSearchScope;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.Condition;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNodePointer;

public class AspectParameterDecl_aspectDef_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public AspectParameterDecl_aspectDef_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.ui.modeling.structure.AspectParameterDecl", "aspectDef", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.ui.modeling.structure.AspectParameterDecl", "aspectDef");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.ui.modeling.structure.ContainerTemplate", true, false), "container", false), "requiredAspect", true);
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
    return new SNodePointer("r:3cad8b0f-ef3c-442c-8c6f-1ab422f65805(jetbrains.mps.ui.modeling.constraints)", "5572604531249633268");
  }
}
