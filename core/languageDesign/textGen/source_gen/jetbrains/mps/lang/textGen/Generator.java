package jetbrains.mps.lang.textGen;

/*Generated by MPS */

import jetbrains.mps.generator.runtime.TemplateModule;
import java.util.Collection;
import jetbrains.mps.generator.runtime.TemplateMappingPriorityRule;
import jetbrains.mps.generator.runtime.TemplateUtil;
import jetbrains.mps.generator.runtime.TemplateModel;
import jetbrains.mps.project.structure.modules.ModuleReference;

public class Generator implements TemplateModule {
  private final Collection<TemplateMappingPriorityRule> priorities;

  public Generator() {
    priorities = TemplateUtil.asCollection(TemplateUtil.createStrictlyBeforeRule(TemplateUtil.createRefExternal("6477ee8f-eec2-4bda-bd85-252b93f5f0ec(jetbrains.mps.lang.textGen#1233678176149)", TemplateUtil.createRefLocal()), TemplateUtil.createRefExternal("985c8c6a-64b4-486d-a91e-7d4112742556(jetbrains.mps.baseLanguage#1129914002933)", TemplateUtil.createRefLocal())), TemplateUtil.createStrictlyBeforeRule(TemplateUtil.createRefExternal("6477ee8f-eec2-4bda-bd85-252b93f5f0ec(jetbrains.mps.lang.textGen#1233678176149)", TemplateUtil.createRefLocal()), TemplateUtil.createRefExternal("2bdcefec-ba49-4b32-ab50-ebc7a41d5090(jetbrains.mps.lang.smodel#1139186730696)", TemplateUtil.createRefLocal())));
  }

  public String getAlias() {
    return "jetbrains.mps.lang.textGen/<no name>";
  }

  public Collection<TemplateModel> getModels() {
    return null;
  }

  public Collection<TemplateMappingPriorityRule> getPriorities() {
    return priorities;
  }

  public ModuleReference getReference() {
    return null;
  }
}
