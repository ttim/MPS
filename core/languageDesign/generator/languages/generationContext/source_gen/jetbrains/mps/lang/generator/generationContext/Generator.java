package jetbrains.mps.lang.generator.generationContext;

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
    priorities = TemplateUtil.asCollection(TemplateUtil.createStrictlyTogetherRule(TemplateUtil.createRefExternal("715b4f28-d9b2-45a3-a1a4-a7966d9df2d4(jetbrains.mps.lang.generator.generationContext#1216862161405)", TemplateUtil.createRefLocal()), TemplateUtil.createRefExternal("e7d4970e-3e9f-4cf0-a129-f5976c82d635(jetbrains.mps.lang.patterns#1174810948060)", TemplateUtil.createRefLocal())));
  }

  public String getAlias() {
    return "jetbrains.mps.lang.generator.generationContext/<no name>";
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
