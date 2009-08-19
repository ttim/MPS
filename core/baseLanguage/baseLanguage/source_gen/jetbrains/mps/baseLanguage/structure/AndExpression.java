package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AndExpression extends BinaryOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.AndExpression";

  public AndExpression(SNode node) {
    super(node);
  }

  public static AndExpression newInstance(SModel sm, boolean init) {
    return (AndExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.AndExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AndExpression newInstance(SModel sm) {
    return AndExpression.newInstance(sm, false);
  }
}
