package jetbrains.mps.lang.plugin.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.lang.plugin.behavior.ActionDataParameterDeclaration_Behavior;

public class ActionDataParameterDeclaration_key_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {

  public ActionDataParameterDeclaration_key_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.plugin.structure.ActionDataParameterDeclaration", "key", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.plugin.structure.ActionDataParameterDeclaration", "key");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return ActionDataParameterDeclaration_Behavior.getVariants_1227641865136();
  }

}
