package jetbrains.mps.buildScript.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSetupContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class QueriesGenerated {
  public static void nodeFactory_NodeSetup_BuildSourcePath_7389400916848172016(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.buildScript.structure.BuildSourcePath")) {
      SPropertyOperations.set(_context.getNewNode(), "relativePath", SPropertyOperations.getString(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.buildScript.structure.BuildSourcePath"), "relativePath"));
    }
  }
}
