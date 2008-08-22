package jetbrains.mps.baseLanguage.dataFlow;

/*Generated by MPS */

import jetbrains.mps.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.behavior.StatementList_Behavior;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.baseLanguage.LastStatementUtil;
import jetbrains.mps.project.GlobalScope;

public class StatementList_DataFlow extends DataFlowBuilder {

  public StatementList_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration") || SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.baseLanguage.structure.IStatementListContainer")) {
      for(SNode var : StatementList_Behavior.call_getExternalVariablesDeclarations_1214501165480(_context.getNode())) {
        _context.getBuilder().emitWrite(var);
      }
    }
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration")) {
      SNode bmd = SNodeOperations.getParent(_context.getNode());
      for(SNode parm : SLinkOperations.getTargets(bmd, "parameter", true)) {
        _context.getBuilder().emitWrite(parm);
      }
    }
    _context.getBuilder().emitNop();
    for(SNode s : SLinkOperations.getTargets(_context.getNode(), "statement", true)) {
      _context.getBuilder().build((SNode)s);
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "statement", true)).isNotEmpty()) {
      SNode lastStatement = ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "statement", true)).last();
      if (LastStatementUtil.canMakeReturnStatement(lastStatement, GlobalScope.getInstance())) {
        _context.getBuilder().emitRet();
      }
    }
  }

}
