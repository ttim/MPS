package jetbrains.mps.lang.findUsages.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.CanBeAChildContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;

public class NodeStatement_Constraints {

  public static boolean canBeAChild(final IOperationContext operationContext, final CanBeAChildContext _context) {
    return SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.lang.findUsages.structure.SearchedNodesBlock", false, false) != null;
  }

}
