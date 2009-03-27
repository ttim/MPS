package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class IsDefaultBlock extends jetbrains.mps.baseLanguage.structure.ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.IsDefaultBlock";

  public IsDefaultBlock(SNode node) {
    super(node);
  }

  public static IsDefaultBlock newInstance(SModel sm, boolean init) {
    return (IsDefaultBlock)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.IsDefaultBlock", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static IsDefaultBlock newInstance(SModel sm) {
    return IsDefaultBlock.newInstance(sm, false);
  }

}
