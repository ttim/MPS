package jetbrains.mps.debugger.api.lang.scripts;

/*Generated by MPS */

import jetbrains.mps.lang.script.runtime.BaseMigrationScript;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.script.runtime.AbstractMigrationRefactoring;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class DebuggerMovedToPlugin_MigrationScript extends BaseMigrationScript {
  public DebuggerMovedToPlugin_MigrationScript(IOperationContext operationContext) {
    super("Fix references to debugger classes");
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Fix references to debugger classes";
      }

      public String getAdditionalInfo() {
        return "Fix references to debugger classes";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.lang.core.structure.BaseConcept";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        return node.isRoot() && Sequence.fromIterable(ScriptsUtil.getStubImports(SNodeOperations.getModel(node), "jetbrains.mps.debug")).isNotEmpty();
      }

      public void doUpdateInstanceNode(SNode node) {
        ScriptsUtil.updateReferencesToPrefix(node, "jetbrains.mps.debug");
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
  }
}
