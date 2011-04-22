package jetbrains.mps.make.facet;

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
    priorities = TemplateUtil.asCollection(TemplateUtil.createStrictlyBeforeRule(TemplateUtil.createRefExternal("3349c57b-62f9-4ce2-a22d-d9bd99edc6a6(jetbrains.mps.make.facet#5086995156117116954)", TemplateUtil.createRefLocal()), TemplateUtil.createRefExternal("5f9babc9-8d5d-4825-8e61-17b241ee6272(jetbrains.mps.baseLanguage.collections#1151699677197)", TemplateUtil.createRefLocal())), TemplateUtil.createStrictlyTogetherRule(TemplateUtil.createRefExternal("3349c57b-62f9-4ce2-a22d-d9bd99edc6a6(jetbrains.mps.make.facet#5086995156117116954)", TemplateUtil.createRefLocal()), TemplateUtil.createRefExternal("a150150e-46ee-4c9e-b080-08d136e4eefb(jetbrains.mps.baseLanguage.tuples#1238919486295)", TemplateUtil.createRefLocal())), TemplateUtil.createStrictlyTogetherRule(TemplateUtil.createRefExternal("3349c57b-62f9-4ce2-a22d-d9bd99edc6a6(jetbrains.mps.make.facet#5086995156117116954)", TemplateUtil.createRefLocal()), TemplateUtil.createRefExternal("aaee1c4d-a7f9-41f6-9218-3a0ebac06eb4(jetbrains.mps.make.script#4629164904928166564)", TemplateUtil.createRefLocal())));
  }

  public String getAlias() {
    return "jetbrains.mps.make.facet/java";
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
