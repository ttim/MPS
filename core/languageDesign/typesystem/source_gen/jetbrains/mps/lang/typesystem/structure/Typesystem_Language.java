package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleRepository;

public class Typesystem_Language {
  public static ModuleReference MODULE_REFERENCE = ModuleReference.fromString("7a5dda62-9140-4668-ab76-d5ed1746f2b2(jetbrains.mps.lang.typesystem)");

  public static Language get() {
    return (Language)MPSModuleRepository.getInstance().getModule(MODULE_REFERENCE);
  }
}
