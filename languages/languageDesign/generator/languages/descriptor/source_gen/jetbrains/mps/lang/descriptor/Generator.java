package jetbrains.mps.lang.descriptor;

/*Generated by MPS */

import jetbrains.mps.generator.runtime.TemplateModule;
import jetbrains.mps.project.structure.modules.ModuleReference;
import java.util.Collection;
import jetbrains.mps.generator.runtime.TemplateModel;
import jetbrains.mps.generator.runtime.TemplateUtil;
import jetbrains.mps.lang.descriptor.generator.template.main.TemplateModelImpl;
import jetbrains.mps.generator.runtime.TemplateMappingPriorityRule;
import jetbrains.mps.smodel.language.LanguageRuntime;

public class Generator implements TemplateModule {
  public static ModuleReference MODULE_REFERENCE = ModuleReference.fromString("3ac18869-0828-4401-abad-822a47bf83f1(jetbrains.mps.lang.descriptor#9020561928507175817)");

  private Language sourceLanguage;
  private final Collection<TemplateModel> models;
  private Collection<String> usedLanguages;

  public Generator(Language sourceLanguage) {
    this.sourceLanguage = sourceLanguage;
    models = TemplateUtil.<TemplateModel>asCollection(new TemplateModelImpl(this));
    usedLanguages = TemplateUtil.<String>asCollection("jetbrains.mps.baseLanguage", "jetbrains.mps.baseLanguageInternal", "jetbrains.mps.lang.descriptor", "jetbrains.mps.lang.project");
  }

  public String getAlias() {
    return "jetbrains.mps.lang.descriptor/main";
  }

  public Collection<TemplateModel> getModels() {
    return models;
  }

  public Collection<TemplateMappingPriorityRule> getPriorities() {
    return null;
  }

  public ModuleReference getReference() {
    return MODULE_REFERENCE;
  }

  public Collection<String> getUsedLanguages() {
    return usedLanguages;
  }

  public LanguageRuntime getSourceLanguage() {
    return sourceLanguage;
  }

  public Collection<String> getReferencedModules() {
    return null;
  }
}
