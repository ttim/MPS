package jetbrains.mps.baseLanguage.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.dataFlow.DataFlowBuilderContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.baseLanguage.behavior.StatementList_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class AnonymousClassCreator_DataFlow extends DataFlowBuilder {
  public AnonymousClassCreator_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    List<SNode> methods = SNodeOperations.getDescendants(_context.getNode(), "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, new String[]{});
    Set<SNode> vars = SetSequence.fromSet(new HashSet<SNode>());
    for (SNode method : methods) {
      SetSequence.fromSet(vars).addSequence(SetSequence.fromSet(StatementList_Behavior.call_getExternalVariablesDeclarations_1214501165480(SLinkOperations.getTarget(method, "body", true))));
    }
    for (SNode var : vars) {
      _context.getBuilder().emitRead(var);
    }
    for (SNode expr : SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "cls", true), "parameter", true)) {
      _context.getBuilder().build((SNode)expr);
    }
    for (SNode expr : SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "cls", true), "actualArgument", true)) {
      _context.getBuilder().build((SNode)expr);
    }
  }
}
