package jetbrains.mps.make.facet.structure;

/*Generated by MPS */

import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleRepository;

public class Facet_Language {
  public static ModuleReference MODULE_REFERENCE = ModuleReference.fromString("696c1165-4a59-463b-bc5d-902caab85dd0(jetbrains.mps.make.facet)");

  public static Language get() {
    return (Language) MPSModuleRepository.getInstance().getModule(MODULE_REFERENCE);
  }
}
