package jetbrains.mps.build.mps.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntentionsDescriptor;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.SModelReference;

public class IntentionsDescriptor extends BaseIntentionsDescriptor {
  public IntentionsDescriptor() {
    super(new ModuleReference("jetbrains.mps.build.mps", "0cf935df-4699-4e9c-a132-fa109541cba3"), SModelReference.fromString("r:e8fca550-89ba-41bb-ae28-dc9cae640a8a(jetbrains.mps.build.mps.intentions)"));
  }

  public void init() {
    add(new AddCustomLocationDependency_Intention(), "2798275735916376328");
    add(new AddCustomLocationRuntime_Intention(), "202934866058893735");
    add(new ToggleCompactMpsModule_Intention(), "8369506495128778230");
  }
}
