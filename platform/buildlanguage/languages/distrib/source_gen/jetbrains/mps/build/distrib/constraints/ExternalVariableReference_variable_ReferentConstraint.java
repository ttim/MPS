package jetbrains.mps.build.distrib.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.build.packaging.behavior.Configuration_Behavior;
import jetbrains.mps.smodel.SNodePointer;

public class ExternalVariableReference_variable_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public ExternalVariableReference_variable_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.build.distrib.structure.ExternalVariableReference", "variable", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.build.distrib.structure.ExternalVariableReference", "variable");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode ancestor = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.build.distrib.structure.DistribConfiguration", true, false);
    List<SNode> availableVars = ListSequence.fromList(new ArrayList<SNode>());
    ListSequence.fromList(availableVars).addSequence(ListSequence.fromList(SLinkOperations.getTargets(Configuration_Behavior.call_getLayout_1213877261819(SLinkOperations.getTarget(ancestor, "buildScriptConfiguration", false)), "builtInVariable", true)));
    ListSequence.fromList(availableVars).addSequence(ListSequence.fromList(SLinkOperations.getTargets(Configuration_Behavior.call_getLayout_1213877261819(SLinkOperations.getTarget(ancestor, "buildScriptConfiguration", false)), "variable", true)));
    return availableVars;
  }

  public SNodePointer getSearchScopeValidatorNodePointer() {
    return new SNodePointer("r:cbd3ad66-b4a6-4397-9afb-cbc7a80da1e5(jetbrains.mps.build.distrib.constraints)", "1234515222366");
  }
}
