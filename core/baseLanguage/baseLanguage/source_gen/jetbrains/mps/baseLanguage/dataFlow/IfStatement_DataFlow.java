package jetbrains.mps.baseLanguage.dataFlow;

/*Generated by MPS */

import jetbrains.mps.dataFlow.DataFlowBuilder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;

public class IfStatement_DataFlow extends DataFlowBuilder {

  public IfStatement_DataFlow() {
  }

  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    _context.getBuilder().build((SNode)SLinkOperations.getTarget(_context.getNode(), "condition", true));
    if ((SLinkOperations.getTarget(_context.getNode(), "ifFalseStatement", true) == null)) {
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "condition", true), "jetbrains.mps.baseLanguage.structure.BooleanConstant")) {
        SNode bconst = SLinkOperations.getTarget(_context.getNode(), "condition", true);
        if (!(SPropertyOperations.getBoolean(bconst, "value"))) {
          _context.getBuilder().emitJump(_context.getBuilder().after(_context.getNode()));
        }
      } else
      {
        _context.getBuilder().emitIfJump(_context.getBuilder().after(_context.getNode()));
      }
    } else
    {
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "condition", true), "jetbrains.mps.baseLanguage.structure.BooleanConstant")) {
        SNode bconst = SLinkOperations.getTarget(_context.getNode(), "condition", true);
        if (!(SPropertyOperations.getBoolean(bconst, "value"))) {
          _context.getBuilder().emitJump(_context.getBuilder().label(_context.getNode(), "endOfTrue"));
        }
      } else
      {
        _context.getBuilder().emitIfJump(_context.getBuilder().label(_context.getNode(), "endOfTrue"));
      }
    }
    _context.getBuilder().build((SNode)SLinkOperations.getTarget(_context.getNode(), "ifTrue", true));
    if ((SLinkOperations.getTarget(_context.getNode(), "ifFalseStatement", true) != null)) {
      _context.getBuilder().emitMayBeUnreachable(new Runnable() {

        public void run() {
          _context.getBuilder().emitJump(_context.getBuilder().after(SLinkOperations.getTarget(_context.getNode(), "ifFalseStatement", true)));
        }

      });
    }
    _context.getBuilder().emitLabel("endOfTrue");
    for(SNode elseIf : SLinkOperations.getTargets(_context.getNode(), "elsifClauses", true)) {
      _context.getBuilder().build((SNode)elseIf);
    }
    if ((SLinkOperations.getTarget(_context.getNode(), "ifFalseStatement", true) != null)) {
      _context.getBuilder().build((SNode)SLinkOperations.getTarget(_context.getNode(), "ifFalseStatement", true));
    }
  }

}
