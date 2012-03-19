package jetbrains.mps.lang.plugin.scripts;

/*Generated by MPS */

import jetbrains.mps.lang.script.runtime.BaseMigrationScript;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.script.runtime.AbstractMigrationRefactoring;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SReference;

public class UpdateMPSModules_MigrationScript extends BaseMigrationScript {
  public UpdateMPSModules_MigrationScript(IOperationContext operationContext) {
    super("Resolve broken stub references to MPS.Core/Editor/Platform/Workbench");
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "MPS.Workbench -> MPS.Core / .Editor / .Platform";
      }

      public String getAdditionalInfo() {
        return "MPS.Workbench -> MPS.Core / .Editor / .Platform";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.lang.core.structure.BaseConcept";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        return Sequence.fromIterable(SNodeOperations.getReferences(node)).where(new IWhereFilter<SReference>() {
          public boolean accept(SReference it) {
            return it.getTargetNodeSilently() == null;
          }
        }).isNotEmpty();
      }

      public void doUpdateInstanceNode(SNode node) {
        MpsClasspathRefUtil.updateReferencesToMpsClasspath(node);
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
  }
}
