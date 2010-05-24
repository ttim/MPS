package jetbrains.mps.ui.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.ui.behavior.IUIObjectContextProvider_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNodePointer;

public class ChildAspect_definition_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public ChildAspect_definition_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.ui.structure.ChildAspect", "definition", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.ui.structure.ChildAspect", "definition");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return SLinkOperations.getTargets(IUIObjectContextProvider_Behavior.call_getContainer_8923564134258257521(SNodeOperations.as(SNodeOperations.getAncestorWhereConceptInList(SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.ui.structure.UIObjectStatement", true, false), new String[]{"jetbrains.mps.ui.structure.IUIObjectContextProvider","jetbrains.mps.baseLanguage.structure.IStatementListContainer"}, false, false), "jetbrains.mps.ui.structure.IUIObjectContextProvider")), "requiredAspect", true);
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:383ba4d2-f4ec-41a6-8e7f-108e84a7c9f9(jetbrains.mps.ui.constraints)", "6424935405034937411");
  }
}
