package jetbrains.mps.ui.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.pattern.IMatchingPattern;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.ui.modeling.behavior.UIObject_Behavior;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.smodel.SNodePointer;

public class CallUIActionOperation_action_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public CallUIActionOperation_action_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.ui.structure.CallUIActionOperation", "action", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.ui.structure.CallUIActionOperation", "action");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode ot = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(SNodeOperations.as(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true));
    {
      IMatchingPattern pattern_cl463f_b0a0 = HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.ui.structure.UIObjectType");
      SNode coercedNode_cl463f_b0a0 = TypeChecker.getInstance().getRuntimeSupport().coerce_(ot, pattern_cl463f_b0a0);
      if (coercedNode_cl463f_b0a0 != null) {
        return Sequence.fromIterable(UIObject_Behavior.call_allExtends_8115675450774407592(SLinkOperations.getTarget(coercedNode_cl463f_b0a0, "uiObject", false))).translate(new ITranslator2<SNode, SNode>() {
          public Iterable<SNode> translate(SNode uio) {
            return SLinkOperations.getTargets(uio, "action", true);
          }
        });
      } else {
        return (Iterable<SNode>) null;
      }
    }
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:383ba4d2-f4ec-41a6-8e7f-108e84a7c9f9(jetbrains.mps.ui.constraints)", "6261739386030567651");
  }
}
