package jetbrains.mps.build.custommpsInternal.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.CanBeAChildContext;
import jetbrains.mps.build.custommps.behavior.MPSBuild_Behavior;

public class IfProjectComponent_Constraints {
  public static boolean canBeAChild(final IOperationContext operationContext, final CanBeAChildContext _context) {
    return MPSBuild_Behavior.isInCustomMPSGenerator_1238403397946(operationContext);
  }
}
