package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ApplicationPluginDisposeBlock extends jetbrains.mps.baseLanguage.structure.ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.ApplicationPluginDisposeBlock";

  public ApplicationPluginDisposeBlock(SNode node) {
    super(node);
  }

  public static ApplicationPluginDisposeBlock newInstance(SModel sm, boolean init) {
    return (ApplicationPluginDisposeBlock)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.ApplicationPluginDisposeBlock", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ApplicationPluginDisposeBlock newInstance(SModel sm) {
    return ApplicationPluginDisposeBlock.newInstance(sm, false);
  }

}
