package jetbrains.mps.bash.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CommaExpression extends BinaryArithmeticExpression {
  public static final String concept = "jetbrains.mps.bash.structure.CommaExpression";

  public CommaExpression(SNode node) {
    super(node);
  }

  public static CommaExpression newInstance(SModel sm, boolean init) {
    return (CommaExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bash.structure.CommaExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CommaExpression newInstance(SModel sm) {
    return CommaExpression.newInstance(sm, false);
  }
}
