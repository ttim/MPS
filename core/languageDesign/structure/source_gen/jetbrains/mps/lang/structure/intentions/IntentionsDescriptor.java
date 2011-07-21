package jetbrains.mps.lang.structure.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntentionsDescriptor;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.SModelReference;

public class IntentionsDescriptor extends BaseIntentionsDescriptor {
  public IntentionsDescriptor() {
    super(new ModuleReference("jetbrains.mps.lang.structure", "c72da2b9-7cce-4447-8389-f407dc1158b7"), SModelReference.fromString("r:e5a8b5c7-85b5-4d59-9e4e-850a142e2560(jetbrains.mps.lang.structure.intentions)"));
  }

  public void init() {
    add(new AddDeprecatedAnnotation_Intention(), "1224245135252");
    add(new CreateDefaultEditor_Intention(), "6757025334847042380");
    add(new CreateReferenceConcept_Intention(), "6895093993902311021");
    add(new MakeRootable_Intention(), "2799938697970315260");
  }
}
