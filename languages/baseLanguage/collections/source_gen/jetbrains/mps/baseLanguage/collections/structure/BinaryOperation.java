package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BinaryOperation extends SequenceOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.BinaryOperation";
  public static final String RIGHT_EXPRESSION = "rightExpression";

  public BinaryOperation(SNode node) {
    super(node);
  }

  public Expression getRightExpression() {
    return (Expression) this.getChild(Expression.class, BinaryOperation.RIGHT_EXPRESSION);
  }

  public void setRightExpression(Expression node) {
    super.setChild(BinaryOperation.RIGHT_EXPRESSION, node);
  }

  public static BinaryOperation newInstance(SModel sm, boolean init) {
    return (BinaryOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.BinaryOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BinaryOperation newInstance(SModel sm) {
    return BinaryOperation.newInstance(sm, false);
  }
}
