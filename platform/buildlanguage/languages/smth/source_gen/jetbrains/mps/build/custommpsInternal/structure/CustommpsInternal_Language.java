package jetbrains.mps.build.custommpsInternal.structure;

/*Generated by MPS */

import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleRepository;

public class CustommpsInternal_Language {
  public static ModuleReference MODULE_REFERENCE = ModuleReference.fromString("8d09fa8b-0d65-4c2f-aae6-d4847a49d862(jetbrains.mps.build.custommpsInternal)");

  public static Language get() {
    return (Language)MPSModuleRepository.getInstance().getModule(MODULE_REFERENCE);
  }

}
