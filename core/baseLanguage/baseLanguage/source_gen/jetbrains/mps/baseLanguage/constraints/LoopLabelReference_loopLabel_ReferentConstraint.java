package jetbrains.mps.baseLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class LoopLabelReference_loopLabel_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public LoopLabelReference_loopLabel_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.structure.LoopLabelReference", "loopLabel", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.structure.LoopLabelReference", "loopLabel");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> labels = new ArrayList<SNode>();
    for (SNode loop : SNodeOperations.getAncestors(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement", false)) {
      if ((SLinkOperations.getTarget(loop, "loopLabel", true) != null)) {
        ListSequence.fromList(labels).addElement(SLinkOperations.getTarget(loop, "loopLabel", true));
      }
    }
    return labels;
  }
}
