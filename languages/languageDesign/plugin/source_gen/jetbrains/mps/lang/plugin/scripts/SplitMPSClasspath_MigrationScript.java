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

public class SplitMPSClasspath_MigrationScript extends BaseMigrationScript {
  public SplitMPSClasspath_MigrationScript(IOperationContext operationContext) {
    super("Split MPS.Classpath Stubs");
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "MPS.Classpath -> MPS.Core / .Editor / .Workbench";
      }

      public String getAdditionalInfo() {
        return "MPS.Classpath -> MPS.Core / .Editor / .Workbench";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.lang.core.structure.BaseConcept";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        return Sequence.fromIterable(SNodeOperations.getReferences(node)).where(new IWhereFilter<SReference>() {
          public boolean accept(SReference it) {
            return it.getTargetSModelReference().getSModelFqName().toString().contains("MPS.Classpath");
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
