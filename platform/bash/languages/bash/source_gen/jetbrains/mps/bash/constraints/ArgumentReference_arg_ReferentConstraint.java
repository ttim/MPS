package jetbrains.mps.bash.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bash.behavior.ExternalCommandCall_Behavior;
import jetbrains.mps.smodel.SNodePointer;

public class ArgumentReference_arg_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public ArgumentReference_arg_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.bash.structure.ArgumentReference", "arg", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.bash.structure.ArgumentReference", "arg");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode call = SNodeOperations.cast(_context.getEnclosingNode(), "jetbrains.mps.bash.structure.ExternalCommandCall");
    return ExternalCommandCall_Behavior.call_getUnusedArguments_3263637656466355284(call);
  }

  public SNodePointer getSearchScopeValidatorNodePointer() {
    return new SNodePointer("r:32c4fb44-9e66-4976-aa43-e37da5fe27dd(jetbrains.mps.bash.constraints)", "3263637656466344330");
  }
}
