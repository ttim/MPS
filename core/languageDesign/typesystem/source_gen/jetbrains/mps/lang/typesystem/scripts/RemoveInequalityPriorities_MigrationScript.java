package jetbrains.mps.lang.typesystem.scripts;

/*Generated by MPS */

import jetbrains.mps.lang.script.runtime.BaseMigrationScript;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.script.runtime.AbstractMigrationRefactoring;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class RemoveInequalityPriorities_MigrationScript extends BaseMigrationScript {
  public RemoveInequalityPriorities_MigrationScript(IOperationContext operationContext) {
    super("Remove Inequality Priorities");
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Get";
      }

      public String getAdditionalInfo() {
        return "Get";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.lang.typesystem.structure.AbstractInequationStatement";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        return ListSequence.fromList(SLinkOperations.getTargets(node, "afterEquations", true)).isNotEmpty() || ListSequence.fromList(SLinkOperations.getTargets(node, "afterGroups", true)).isNotEmpty() || ListSequence.fromList(SLinkOperations.getTargets(node, "beforeGroups", true)).isNotEmpty() || ListSequence.fromList(SLinkOperations.getTargets(node, "beforeEquations", true)).isNotEmpty() || SLinkOperations.getTarget(node, "inequationGroup", true) != null || SPropertyOperations.getInteger_def(node, "inequationPriority", "0") != 0;
      }

      public void doUpdateInstanceNode(SNode node) {
        ListSequence.fromList(SLinkOperations.getTargets(node, "afterEquations", true)).clear();
        ListSequence.fromList(SLinkOperations.getTargets(node, "beforeEquations", true)).clear();
        ListSequence.fromList(SLinkOperations.getTargets(node, "afterGroups", true)).clear();
        ListSequence.fromList(SLinkOperations.getTargets(node, "beforeGroups", true)).clear();
        ListSequence.fromList(SLinkOperations.getTargets(node, "rulesToSkip", true)).clear();
        SLinkOperations.setTarget(node, "inequationGroup", null, true);
        SPropertyOperations.set(node, "inequationPriority", "" + 0);
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
  }
}
