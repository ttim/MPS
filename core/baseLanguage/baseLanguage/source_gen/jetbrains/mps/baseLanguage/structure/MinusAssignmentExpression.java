package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MinusAssignmentExpression extends BaseAssignmentExpression {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.MinusAssignmentExpression";

  public MinusAssignmentExpression(SNode node) {
    super(node);
  }

  public static MinusAssignmentExpression newInstance(SModel sm, boolean init) {
    return (MinusAssignmentExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.MinusAssignmentExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MinusAssignmentExpression newInstance(SModel sm) {
    return MinusAssignmentExpression.newInstance(sm, false);
  }
}
