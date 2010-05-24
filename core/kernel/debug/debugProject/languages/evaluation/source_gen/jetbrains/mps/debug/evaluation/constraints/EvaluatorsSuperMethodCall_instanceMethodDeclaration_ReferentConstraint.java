package jetbrains.mps.debug.evaluation.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.constraints.SuperMethodCall_InstanceMethodScope;
import jetbrains.mps.baseLanguage.structure.ClassifierType;
import jetbrains.mps.baseLanguage.behavior.ClassConcept_Behavior;
import jetbrains.mps.smodel.SNodePointer;

public class EvaluatorsSuperMethodCall_instanceMethodDeclaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public EvaluatorsSuperMethodCall_instanceMethodDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.debug.evaluation.structure.EvaluatorsSuperMethodCall", "baseMethodDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.debug.evaluation.structure.EvaluatorsSuperMethodCall", "baseMethodDeclaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode enclosingClass = SNodeOperations.cast(SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.debug.evaluation.structure.EvaluatorConcept", false, false), "thisType", true), "classifier", false), "jetbrains.mps.baseLanguage.structure.ClassConcept");
    return new SuperMethodCall_InstanceMethodScope(((ClassifierType) SNodeOperations.getAdapter(ClassConcept_Behavior.call_getSuperclass_1240936569950(enclosingClass))), _context.getEnclosingNode());
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:edfcb13b-e239-462c-8aae-e4b4a03e7c8b(jetbrains.mps.debug.evaluation.constraints)", "6036237525966325249");
  }
}
