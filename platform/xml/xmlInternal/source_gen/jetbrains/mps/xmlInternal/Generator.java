package jetbrains.mps.xmlInternal;

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
    priorities = TemplateUtil.asCollection(TemplateUtil.createStrictlyBeforeRule(TemplateUtil.createRefExternal("54e8601c-dee3-4b7a-94f7-5ee53b3f2dcb(jetbrains.mps.xmlInternal#1165632612566)", TemplateUtil.createRefNormal("r:00000000-0000-4000-0000-011c89590592(jetbrains.mps.xmlInternal.generator.baseLanguage.template.main@generator)", "*")), TemplateUtil.createRefExternal("bfcadeff-430f-4472-9641-06156a02be37(jetbrains.mps.gtext#1164413905312)", TemplateUtil.createRefNormal("r:00000000-0000-4000-0000-011c89590576(jetbrains.mps.gtext.generator.baseLanguage.template.main@generator)", "*"))), TemplateUtil.createStrictlyBeforeRule(TemplateUtil.createRefExternal("54e8601c-dee3-4b7a-94f7-5ee53b3f2dcb(jetbrains.mps.xmlInternal#1165632612566)", TemplateUtil.createRefNormal("r:00000000-0000-4000-0000-011c89590592(jetbrains.mps.xmlInternal.generator.baseLanguage.template.main@generator)", "6534112263211761987")), TemplateUtil.createRefExternal("54e8601c-dee3-4b7a-94f7-5ee53b3f2dcb(jetbrains.mps.xmlInternal#1165632612566)", TemplateUtil.createRefNormal("r:00000000-0000-4000-0000-011c89590592(jetbrains.mps.xmlInternal.generator.baseLanguage.template.main@generator)", "1165632618759"))));
  }

  public String getAlias() {
    return "jetbrains.mps.xmlInternal/<no name>";
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
