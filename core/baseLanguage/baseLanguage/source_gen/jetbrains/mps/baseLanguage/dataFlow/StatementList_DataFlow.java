package jetbrains.mps.baseLanguage.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.behavior.IMethodLike_Behavior;
import jetbrains.mps.baseLanguage.behavior.ExpressionStatement_Behavior;

public class StatementList_DataFlow extends DataFlowBuilder {
  public StatementList_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration")) {
      SNode bmd = SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration");
      for (SNode param : ListSequence.fromList(SLinkOperations.getTargets(bmd, "parameter", true))) {
        _context.getBuilder().build((SNode)param);
      }
    }
    _context.getBuilder().emitNop();
    SNode lastStatement = null;
    if (ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "statement", true)).isNotEmpty()) {
      SNode methodLike = SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.baseLanguage.structure.IMethodLike", false, false);
      if ((methodLike != null)) {
        if (IMethodLike_Behavior.call_getBody_1239354440022(methodLike) == _context.getNode()) {
          lastStatement = IMethodLike_Behavior.call_getLastStatement_1239354409446(methodLike);
        }
      }
    }
    for (SNode s : SLinkOperations.getTargets(_context.getNode(), "statement", true)) {
      _context.getBuilder().build((SNode)s);
      if (s == lastStatement && SNodeOperations.isInstanceOf(s, "jetbrains.mps.baseLanguage.structure.ExpressionStatement") && ExpressionStatement_Behavior.call_canServeAsReturn_1239355137616(SNodeOperations.cast(s, "jetbrains.mps.baseLanguage.structure.ExpressionStatement"))) {
        _context.getBuilder().emitRet();
      }
    }
  }
}
