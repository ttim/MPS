package jetbrains.mps.samples.formulaLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Constant extends Expression {
  public static final String concept = "jetbrains.mps.samples.formulaLanguage.structure.Constant";

  public Constant(SNode node) {
    super(node);
  }

  public static Constant newInstance(SModel sm, boolean init) {
    return (Constant)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.samples.formulaLanguage.structure.Constant", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Constant newInstance(SModel sm) {
    return Constant.newInstance(sm, false);
  }

}
