package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class DisposeBlock extends jetbrains.mps.baseLanguage.structure.ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.DisposeBlock";

  public DisposeBlock(SNode node) {
    super(node);
  }

  public static DisposeBlock newInstance(SModel sm, boolean init) {
    return (DisposeBlock)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.DisposeBlock", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static DisposeBlock newInstance(SModel sm) {
    return DisposeBlock.newInstance(sm, false);
  }

}
