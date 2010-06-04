package jetbrains.mps.build.distrib.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.build.distrib.behavior.DistribConfiguration_Behavior;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.AbstractSearchScope;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.Condition;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNodePointer;

public class DistribConfiguration_projectFolder_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public DistribConfiguration_projectFolder_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.build.distrib.structure.DistribConfiguration", "projectFolder", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.build.distrib.structure.DistribConfiguration", "projectFolder");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return DistribConfiguration_Behavior.call_getAvailableFolders_1230293856288(_context.getReferenceNode());
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
    return new SNodePointer("r:cbd3ad66-b4a6-4397-9afb-cbc7a80da1e5(jetbrains.mps.build.distrib.constraints)", "1230295109355");
  }
}
