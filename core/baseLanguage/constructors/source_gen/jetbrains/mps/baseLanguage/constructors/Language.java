package jetbrains.mps.baseLanguage.constructors;

/*Generated by MPS */

import jetbrains.mps.smodel.language.LanguageRuntime;
import jetbrains.mps.project.structure.modules.ModuleReference;
import java.util.Collection;
import jetbrains.mps.generator.runtime.TemplateModule;
import jetbrains.mps.generator.runtime.TemplateUtil;

public class Language extends LanguageRuntime {
  public static ModuleReference MODULE_REFERENCE = ModuleReference.fromString("0ae47ad3-5abd-486c-ac0f-298884f39393(jetbrains.mps.baseLanguage.constructors)");

  private final Collection<TemplateModule> generators;

  public Language() {
    generators = TemplateUtil.<TemplateModule>asCollection(new Generator());
  }

  public String getNamespace() {
    return "jetbrains.mps.baseLanguage.constructors";
  }

  public Collection<TemplateModule> getGenerators() {
    return generators;
  }
}
