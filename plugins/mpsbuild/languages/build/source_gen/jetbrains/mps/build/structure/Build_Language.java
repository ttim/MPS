package jetbrains.mps.build.structure;

/*Generated by MPS */

import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleRepository;

public class Build_Language {
  public static ModuleReference MODULE_REFERENCE = ModuleReference.fromString("798100da-4f0a-421a-b991-71f8c50ce5d2(jetbrains.mps.build)");

  public static Language get() {
    return (Language) MPSModuleRepository.getInstance().getModule(MODULE_REFERENCE);
  }
}
