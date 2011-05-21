package jetbrains.mps.samples.secretCompartmentLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DescriptorProvider;
import jetbrains.mps.smodel.structure.ConstraintsDescriptor;
import jetbrains.mps.smodel.structure.DataHolderConstraintsDescriptor;
import jetbrains.mps.smodel.structure.EmptyConstraintsDataHolder;

public class ConstraintsAspectDescriptor extends DescriptorProvider<ConstraintsDescriptor> {
  public ConstraintsAspectDescriptor() {
  }

  public ConstraintsDescriptor getDescriptor(String fqName) {
    if ("jetbrains.mps.samples.secretCompartmentLanguage.structure.StateMachine".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new StateMachine_Constraints());
    }
    if ("jetbrains.mps.samples.secretCompartmentLanguage.structure.Event".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new Event_Constraints());
    }
    if ("jetbrains.mps.samples.secretCompartmentLanguage.structure.State".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new State_Constraints());
    }
    if ("jetbrains.mps.samples.secretCompartmentLanguage.structure.Transition".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.samples.secretCompartmentLanguage.structure.Transition"));
    }
    if ("jetbrains.mps.samples.secretCompartmentLanguage.structure.StateMachineTest".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new StateMachineTest_Constraints());
    }
    if ("jetbrains.mps.samples.secretCompartmentLanguage.structure.StateMachineTestMethod".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.samples.secretCompartmentLanguage.structure.StateMachineTestMethod"));
    }
    if ("jetbrains.mps.samples.secretCompartmentLanguage.structure.HandleEvent".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.samples.secretCompartmentLanguage.structure.HandleEvent"));
    }

    return null;
  }
}
