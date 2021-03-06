package jetbrains.mps.baseLanguage.closures.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class YieldStatement extends Statement {
  public static final String concept = "jetbrains.mps.baseLanguage.closures.structure.YieldStatement";
  public static final String EXPRESSION = "expression";

  public YieldStatement(SNode node) {
    super(node);
  }

  public Expression getExpression() {
    return (Expression) this.getChild(Expression.class, YieldStatement.EXPRESSION);
  }

  public void setExpression(Expression node) {
    super.setChild(YieldStatement.EXPRESSION, node);
  }

  public static YieldStatement newInstance(SModel sm, boolean init) {
    return (YieldStatement) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.closures.structure.YieldStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static YieldStatement newInstance(SModel sm) {
    return YieldStatement.newInstance(sm, false);
  }
}
