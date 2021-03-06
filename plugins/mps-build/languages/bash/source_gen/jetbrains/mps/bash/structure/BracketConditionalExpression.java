package jetbrains.mps.bash.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BracketConditionalExpression extends ConditionalExpression {
  public static final String concept = "jetbrains.mps.bash.structure.BracketConditionalExpression";
  public static final String EXPRESSION = "expression";

  public BracketConditionalExpression(SNode node) {
    super(node);
  }

  public ConditionalExpression getExpression() {
    return (ConditionalExpression) this.getChild(ConditionalExpression.class, BracketConditionalExpression.EXPRESSION);
  }

  public void setExpression(ConditionalExpression node) {
    super.setChild(BracketConditionalExpression.EXPRESSION, node);
  }

  public static BracketConditionalExpression newInstance(SModel sm, boolean init) {
    return (BracketConditionalExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bash.structure.BracketConditionalExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BracketConditionalExpression newInstance(SModel sm) {
    return BracketConditionalExpression.newInstance(sm, false);
  }
}
