package jetbrains.mps.lang.editor.constraints;

/*Generated by MPS */

import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.CanBeAChildContext;

public class CellModel_ReferencePresentation_Constraints {
  public static boolean canBeAChild(final IOperationContext operationContext, final CanBeAChildContext _context) {
    return (SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.lang.editor.structure.CellModel_RefCell", true, false) != null);
  }
}
