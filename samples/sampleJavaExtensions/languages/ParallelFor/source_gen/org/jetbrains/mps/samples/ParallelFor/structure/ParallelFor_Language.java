package org.jetbrains.mps.samples.ParallelFor.structure;

/*Generated by MPS */

import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleRepository;

public class ParallelFor_Language {
  public static ModuleReference MODULE_REFERENCE = ModuleReference.fromString("cb7388e8-f182-4cda-bd83-9796e8634856(org.jetbrains.mps.samples.ParallelFor)");

  public static Language get() {
    return (Language) MPSModuleRepository.getInstance().getModule(MODULE_REFERENCE);
  }
}
