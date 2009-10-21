package jetbrains.mps.baseLanguage.math.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SineExpression extends MathFuncExpression {
  public static final String concept = "jetbrains.mps.baseLanguage.math.structure.SineExpression";

  public SineExpression(SNode node) {
    super(node);
  }

  public static SineExpression newInstance(SModel sm, boolean init) {
    return (SineExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.SineExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SineExpression newInstance(SModel sm) {
    return SineExpression.newInstance(sm, false);
  }
}
