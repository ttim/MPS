package jetbrains.mps.ui.modeling.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
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

  public SNodePointer getSearchScopeValidatorNodePointer() {
    return new SNodePointer("r:3cad8b0f-ef3c-442c-8c6f-1ab422f65805(jetbrains.mps.ui.modeling.constraints)", "5572604531249633268");
  }
}
