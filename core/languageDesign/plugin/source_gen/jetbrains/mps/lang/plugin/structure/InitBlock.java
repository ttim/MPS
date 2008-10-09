package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InitBlock extends ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.InitBlock";

  public InitBlock(SNode node) {
    super(node);
  }

  public static InitBlock newInstance(SModel sm, boolean init) {
    return (InitBlock)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.InitBlock", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InitBlock newInstance(SModel sm) {
    return InitBlock.newInstance(sm, false);
  }

}
