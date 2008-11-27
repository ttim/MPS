package jetbrains.mps.baseLanguage.dates.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.search.SimpleSearchScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class DateTimePropertyFormatToken_dateTimePropertyFormatType_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {

  public DateTimePropertyFormatToken_dateTimePropertyFormatType_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.dates.structure.DateTimePropertyFormatToken", "dateTimePropertyFormatType", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.dates.structure.DateTimePropertyFormatToken", "dateTimePropertyFormatType");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return new SimpleSearchScope(SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getReferenceNode(), "dateTimePropertyFormatConfiguration", false), "dateTimePropertyFormatType", true));
  }

}
