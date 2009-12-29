package jetbrains.mps.lang.behavior.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.INodeReferentSetEventHandler;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;

public class ConceptMethodDeclaration_overriddenMethod_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints, INodeReferentSetEventHandler {
  public ConceptMethodDeclaration_overriddenMethod_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSetEventHandler("jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration", "overriddenMethod", this);
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration", "overriddenMethod", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSetEventHandler("jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration", "overriddenMethod");
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration", "overriddenMethod");
  }

  public void processReferentSetEvent(final SNode referenceNode, final SNode oldReferentNode, final SNode newReferentNode, IScope scope) {
    if (newReferentNode != null && referenceNode != null) {
      for (SNode p : SLinkOperations.getTargets(referenceNode, "parameter", true)) {
        SNodeOperations.deleteNode(p);
      }
      for (SNode p : SLinkOperations.getTargets(newReferentNode, "parameter", true)) {
        ListSequence.fromList(SLinkOperations.getTargets(referenceNode, "parameter", true)).addElement(SNodeOperations.copyNode(p));
      }
      SPropertyOperations.set(referenceNode, "name", SPropertyOperations.getString(newReferentNode, "name"));
      SLinkOperations.setTarget(referenceNode, "returnType", SNodeOperations.copyNode(SLinkOperations.getTarget(newReferentNode, "returnType", true)), true);
    }
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode concept = SLinkOperations.getTarget(SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.lang.behavior.structure.ConceptBehavior", true, false), "concept", false);
    List<SNode> methods = AbstractConceptDeclaration_Behavior.call_getVirtualConceptMethods_1213877394290(concept, operationContext.getScope());
    return methods;
  }
}
