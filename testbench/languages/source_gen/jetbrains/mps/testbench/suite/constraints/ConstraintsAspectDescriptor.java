package jetbrains.mps.testbench.suite.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DescriptorProvider;
import jetbrains.mps.smodel.structure.ConstraintsDescriptor;
import jetbrains.mps.smodel.structure.DataHolderConstraintsDescriptor;
import jetbrains.mps.smodel.structure.EmptyConstraintsDataHolder;

public class ConstraintsAspectDescriptor extends DescriptorProvider<ConstraintsDescriptor> {
  public ConstraintsAspectDescriptor() {
  }

  public ConstraintsDescriptor getDescriptor(String fqName) {
    if ("jetbrains.mps.testbench.suite.structure.ModuleSuite".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new ModuleSuite_Constraints());
    }
    if ("jetbrains.mps.testbench.suite.structure.TestCaseRef".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new TestCaseRef_Constraints());
    }
    if ("jetbrains.mps.testbench.suite.structure.JUnit4TestCaseRef".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new JUnit4TestCaseRef_Constraints());
    }
    if ("jetbrains.mps.testbench.suite.structure.JUnit3TestCaseRef".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new JUnit3TestCaseRef_Constraints());
    }
    if ("jetbrains.mps.testbench.suite.structure.ITestRef".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.testbench.suite.structure.ITestRef"));
    }
    if ("jetbrains.mps.testbench.suite.structure.SolutionRef".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.testbench.suite.structure.SolutionRef"));
    }
    if ("jetbrains.mps.testbench.suite.structure.IModuleRef".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.testbench.suite.structure.IModuleRef"));
    }

    return null;
  }
}
