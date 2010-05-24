package jetbrains.mps.lang.typesystem.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.Collections;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.pattern.IMatchingPattern;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.SNodePointer;

public class PropertyMessageTarget_propertyDeclaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public PropertyMessageTarget_propertyDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.typesystem.structure.PropertyMessageTarget", "propertyDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.typesystem.structure.PropertyMessageTarget", "propertyDeclaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode messageStatement = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.lang.typesystem.structure.MessageStatement", true, false);
    if (messageStatement == null) {
      return Sequence.fromIterable(Collections.<SNode>emptyList());
    }
    SNode nodetype = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(messageStatement, "nodeToReport", true));
    {
      IMatchingPattern pattern_hhynfx_d0a0 = HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.lang.smodel.structure.SNodeType");
      SNode coercedNode_hhynfx_d0a0 = TypeChecker.getInstance().getRuntimeSupport().coerce_(nodetype, pattern_hhynfx_d0a0);
      if (coercedNode_hhynfx_d0a0 != null) {
        return AbstractConceptDeclaration_Behavior.call_getPropertyDeclarations_1213877394546(SLinkOperations.getTarget(coercedNode_hhynfx_d0a0, "concept", false));
      } else {
        return Sequence.fromIterable(Collections.<SNode>emptyList());
      }
    }
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c895902ae(jetbrains.mps.lang.typesystem.constraints)", "1227098350409");
  }
}
