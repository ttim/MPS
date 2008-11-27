package jetbrains.mps.lang.actions.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.search.ModelNodesSearchScope;

public class NodeFactory_applicableConcept_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {

  public NodeFactory_applicableConcept_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.actions.structure.NodeFactory", "applicableConcept", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.actions.structure.NodeFactory", "applicableConcept");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    // concepts from this language
    Language language = Language.getLanguageForLanguageAspect(_context.getModel().getModelDescriptor());
    SModel structureModel = language.getStructureModelDescriptor().getSModel();
    return new ModelNodesSearchScope(structureModel);
  }

}
