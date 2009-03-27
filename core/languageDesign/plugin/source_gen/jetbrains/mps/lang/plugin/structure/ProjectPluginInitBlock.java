package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ProjectPluginInitBlock extends jetbrains.mps.baseLanguage.structure.ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.ProjectPluginInitBlock";

  public ProjectPluginInitBlock(SNode node) {
    super(node);
  }

  public static ProjectPluginInitBlock newInstance(SModel sm, boolean init) {
    return (ProjectPluginInitBlock)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.ProjectPluginInitBlock", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ProjectPluginInitBlock newInstance(SModel sm) {
    return ProjectPluginInitBlock.newInstance(sm, false);
  }

}
