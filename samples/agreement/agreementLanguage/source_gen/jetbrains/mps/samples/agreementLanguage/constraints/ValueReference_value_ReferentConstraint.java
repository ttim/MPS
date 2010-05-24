package jetbrains.mps.samples.agreementLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.search.SubnodesSearchScope;
import jetbrains.mps.smodel.SNodePointer;

public class ValueReference_value_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public ValueReference_value_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.samples.agreementLanguage.structure.ValueReference", "value", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.samples.agreementLanguage.structure.ValueReference", "value");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode plan = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.samples.agreementLanguage.structure.Plan", true, false);
    return new SubnodesSearchScope(plan);
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c89590408(jetbrains.mps.samples.agreementLanguage.constraints)", "1214253543334");
  }
}
