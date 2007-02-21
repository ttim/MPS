package jetbrains.mps.baseLanguage.unitTest.structure;

/*Generated by MPS  */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.baseLanguage.structure.Expression;

public class AssertIsNull extends Statement {
  public static String EXPRESSION = "expression";

  public  AssertIsNull(SNode node) {
    super(node);
  }

  public static AssertIsNull newInstance(SModel sm, boolean init) {
    return (AssertIsNull)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.unitTest.AssertIsNull", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static AssertIsNull newInstance(SModel sm) {
    return AssertIsNull.newInstance(sm, false);
  }

  public Expression getExpression() {
    return (Expression)this.getChild(AssertIsNull.EXPRESSION);
  }
  public void setExpression(Expression node) {
    super.setChild(AssertIsNull.EXPRESSION, node);
  }
}
