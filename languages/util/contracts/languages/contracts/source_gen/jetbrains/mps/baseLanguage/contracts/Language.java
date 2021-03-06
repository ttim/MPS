package jetbrains.mps.baseLanguage.contracts;

/*Generated by MPS */

import jetbrains.mps.smodel.language.LanguageRuntime;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.lang.typesystem.runtime.IHelginsDescriptor;
import jetbrains.mps.baseLanguage.contracts.typesystem.TypesystemDescriptor;
import jetbrains.mps.ide.findusages.BaseFindUsagesDescriptor;
import java.util.Collection;
import jetbrains.mps.generator.runtime.TemplateModule;
import jetbrains.mps.generator.runtime.TemplateUtil;

public class Language extends LanguageRuntime {
  public static ModuleReference MODULE_REFERENCE = ModuleReference.fromString("c1b26490-e316-44a3-bb8e-c9120732af93(jetbrains.mps.baseLanguage.contracts)");

  public Language() {

  }

  public String getNamespace() {
    return "jetbrains.mps.baseLanguage.contracts";
  }

  @Override
  public IHelginsDescriptor getTypesystem() {
    return new TypesystemDescriptor();
  }

  @Override
  public BaseFindUsagesDescriptor getFindUsages() {
    return null;
  }

  public Collection<TemplateModule> getGenerators() {
    return TemplateUtil.<TemplateModule>asCollection(TemplateUtil.createInterpretedGenerator(this, "79cf1015-4eac-4065-ae6b-f1c45d62ddff(jetbrains.mps.baseLanguage.contracts#1399727060253192359)"));
  }
}
