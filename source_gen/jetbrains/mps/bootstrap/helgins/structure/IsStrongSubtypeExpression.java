package jetbrains.mps.bootstrap.helgins.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class IsStrongSubtypeExpression extends IsSubtypeExpression {

  public  IsStrongSubtypeExpression(SNode node) {
    super(node);
  }

  public static IsStrongSubtypeExpression newInstance(SModel sm, boolean init) {
    return (IsStrongSubtypeExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.helgins.IsStrongSubtypeExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static IsStrongSubtypeExpression newInstance(SModel sm) {
    return IsStrongSubtypeExpression.newInstance(sm, false);
  }

}
