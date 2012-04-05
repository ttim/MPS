package jetbrains.mps.lang.plugin.generator.util;

/*Generated by MPS */

import jetbrains.mps.generator.template.TemplateQueryContext;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class PluginUtils {
  public PluginUtils() {
  }

  public static boolean needAppPlugin(TemplateQueryContext genContext) {
    return (genContext.getOriginalInputModel().getLongName().endsWith("." + LanguageAspect.PLUGIN.getName()) || ListSequence.fromList(SModelOperations.getRoots(genContext.getInputModel(), "jetbrains.mps.lang.plugin.structure.IdeaInitializerDescriptor")).isNotEmpty()) && (ListSequence.fromList(SModelOperations.getRoots(genContext.getInputModel(), "jetbrains.mps.lang.plugin.structure.ActionGroupDeclaration")).isNotEmpty() || ListSequence.fromList(SModelOperations.getRoots(genContext.getInputModel(), "jetbrains.mps.lang.plugin.structure.ActionDeclaration")).isNotEmpty() || ListSequence.fromList(SModelOperations.getRoots(genContext.getInputModel(), "jetbrains.mps.lang.plugin.structure.InterfaceGroup")).isNotEmpty() || ListSequence.fromList(SModelOperations.getRoots(genContext.getInputModel(), "jetbrains.mps.lang.plugin.structure.KeymapChangesDeclaration")).isNotEmpty()) || ListSequence.fromList(SModelOperations.getRoots(genContext.getInputModel(), "jetbrains.mps.baseLanguage.structure.ClassConcept")).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return eq_l4wyvj_a0a0a0a0a0a0a0a(SPropertyOperations.getString(it, "name"), "ApplicationPluginExtension");
      }
    }).isNotEmpty();
  }

  public static boolean needProjectPlugin(TemplateQueryContext genContext) {
    return (genContext.getOriginalInputModel().getLongName().endsWith("." + LanguageAspect.PLUGIN.getName()) || ListSequence.fromList(SModelOperations.getRoots(genContext.getInputModel(), "jetbrains.mps.lang.plugin.structure.IdeaInitializerDescriptor")).isNotEmpty()) && (ListSequence.fromList(SModelOperations.getRoots(genContext.getInputModel(), "jetbrains.mps.lang.plugin.structure.EditorTab")).isNotEmpty() || ListSequence.fromList(SModelOperations.getRoots(genContext.getInputModel(), "jetbrains.mps.lang.plugin.structure.BaseToolDeclaration")).isNotEmpty() || ListSequence.fromList(SModelOperations.getRoots(genContext.getInputModel(), "jetbrains.mps.lang.plugin.structure.PreferencesComponentDeclaration")).isNotEmpty()) || ListSequence.fromList(SModelOperations.getRoots(genContext.getInputModel(), "jetbrains.mps.baseLanguage.structure.ClassConcept")).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return eq_l4wyvj_a0a0a0a0a0a0a0b(SPropertyOperations.getString(it, "name"), "ProjectPluginExtension");
      }
    }).isNotEmpty();
  }

  private static boolean eq_l4wyvj_a0a0a0a0a0a0a0a(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_l4wyvj_a0a0a0a0a0a0a0b(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
