package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class NullLiteral extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.NullLiteral";

  public  NullLiteral(SNode node) {
    super(node);
  }

  public static NullLiteral newInstance(SModel sm, boolean init) {
    return (NullLiteral)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.NullLiteral", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static NullLiteral newInstance(SModel sm) {
    return NullLiteral.newInstance(sm, false);
  }

}
