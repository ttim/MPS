package jetbrains.mps.lang.plugin.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.CanBeAChildContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class AddElementStatement_Constraints {
  public static boolean canBeAChild(final IOperationContext operationContext, final CanBeAChildContext _context) {
    return SNodeOperations.getAncestorWhereConceptInList(_context.getParentNode(), new String[]{"jetbrains.mps.lang.plugin.structure.BuildGroupBlock","jetbrains.mps.lang.plugin.structure.UpdateGroupFunction"}, true, false) != null;
  }
}
