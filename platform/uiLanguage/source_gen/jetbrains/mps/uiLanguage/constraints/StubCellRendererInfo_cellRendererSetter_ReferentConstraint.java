package jetbrains.mps.uiLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.baseLanguage.search.ClassifierAndSuperClassifiersScope;
import jetbrains.mps.baseLanguage.structure.ClassConcept;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;

public class StubCellRendererInfo_cellRendererSetter_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {

  public StubCellRendererInfo_cellRendererSetter_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.uiLanguage.structure.StubCellRendererInfo", "cellRendererSetter", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.uiLanguage.structure.StubCellRendererInfo", "cellRendererSetter");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return new ClassifierAndSuperClassifiersScope(((ClassConcept)SNodeOperations.getAdapter(SLinkOperations.getTarget(SNodeOperations.getParent(_context.getReferenceNode()), "mapTo", false))), IClassifiersSearchScope.INSTANCE_METHOD);
  }

}
