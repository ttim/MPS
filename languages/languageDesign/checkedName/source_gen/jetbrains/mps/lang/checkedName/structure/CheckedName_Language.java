package jetbrains.mps.lang.checkedName.structure;

/*Generated by MPS */

import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleRepository;

public class CheckedName_Language {
  public static ModuleReference MODULE_REFERENCE = ModuleReference.fromString("fe9d76d7-5809-45c9-ae28-a40915b4d6ff(jetbrains.mps.lang.checkedName)");

  public static Language get() {
    return (Language) MPSModuleRepository.getInstance().getModule(MODULE_REFERENCE);
  }
}
