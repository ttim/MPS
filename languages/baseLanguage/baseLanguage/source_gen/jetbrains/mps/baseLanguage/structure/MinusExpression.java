package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MinusExpression extends BinaryOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.MinusExpression";

  public MinusExpression(SNode node) {
    super(node);
  }

  public static MinusExpression newInstance(SModel sm, boolean init) {
    return (MinusExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.MinusExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MinusExpression newInstance(SModel sm) {
    return MinusExpression.newInstance(sm, false);
  }
}
