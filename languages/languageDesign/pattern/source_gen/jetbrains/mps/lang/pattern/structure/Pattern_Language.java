package jetbrains.mps.lang.pattern.structure;

/*Generated by MPS */

import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleRepository;

public class Pattern_Language {
  public static ModuleReference MODULE_REFERENCE = ModuleReference.fromString("d4615e3b-d671-4ba9-af01-2b78369b0ba7(jetbrains.mps.lang.pattern)");

  public static Language get() {
    return (Language) MPSModuleRepository.getInstance().getModule(MODULE_REFERENCE);
  }
}
