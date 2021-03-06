package jetbrains.mps.bash.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ExpExpression extends BinaryArithmeticExpression {
  public static final String concept = "jetbrains.mps.bash.structure.ExpExpression";

  public ExpExpression(SNode node) {
    super(node);
  }

  public static ExpExpression newInstance(SModel sm, boolean init) {
    return (ExpExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bash.structure.ExpExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ExpExpression newInstance(SModel sm) {
    return ExpExpression.newInstance(sm, false);
  }
}
