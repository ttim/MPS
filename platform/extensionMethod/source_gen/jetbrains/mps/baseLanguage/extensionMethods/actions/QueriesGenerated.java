package jetbrains.mps.baseLanguage.extensionMethods.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSetupContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class QueriesGenerated {
  public static void nodeFactory_NodeSetup_ExtensionMethodDeclaration_720975379598240373(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (_context.getEnclosingNode() != null && SNodeOperations.isInstanceOf(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.structure.IVisible")) {
      SLinkOperations.setTarget(_context.getNewNode(), "visibility", SNodeOperations.copyNode(SLinkOperations.getTarget(SNodeOperations.cast(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.structure.IVisible"), "visibility", true)), true);
    } else {
      SLinkOperations.setNewChild(_context.getNewNode(), "visibility", "jetbrains.mps.baseLanguage.structure.PublicVisibility");
    }
  }
}
