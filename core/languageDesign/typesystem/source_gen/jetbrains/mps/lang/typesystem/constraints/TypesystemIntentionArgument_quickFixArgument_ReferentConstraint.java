package jetbrains.mps.lang.typesystem.constraints;

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
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SNodePointer;

public class TypesystemIntentionArgument_quickFixArgument_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public TypesystemIntentionArgument_quickFixArgument_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.typesystem.structure.TypesystemIntentionArgument", "quickFixArgument", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.typesystem.structure.TypesystemIntentionArgument", "quickFixArgument");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> nodes = new ArrayList<SNode>();
    SNode helginsIntention = SNodeOperations.getAncestor(_context.getReferenceNode(), "jetbrains.mps.lang.typesystem.structure.TypesystemIntention", false, false);
    if (helginsIntention != null) {
      ListSequence.fromList(nodes).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(helginsIntention, "quickFix", false), "quickFixArgument", true)));
    }
    return nodes;
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c895902ae(jetbrains.mps.lang.typesystem.constraints)", "1216387794916");
  }
}
