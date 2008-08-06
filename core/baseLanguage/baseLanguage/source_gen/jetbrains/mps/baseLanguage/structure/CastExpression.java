package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CastExpression extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.CastExpression";
  public static String TYPE = "type";
  public static String EXPRESSION = "expression";

  public CastExpression(SNode node) {
    super(node);
  }

  public Type getType() {
    return (Type)this.getChild(CastExpression.TYPE);
  }

  public void setType(Type node) {
    super.setChild(CastExpression.TYPE, node);
  }

  public Expression getExpression() {
    return (Expression)this.getChild(CastExpression.EXPRESSION);
  }

  public void setExpression(Expression node) {
    super.setChild(CastExpression.EXPRESSION, node);
  }


  public static CastExpression newInstance(SModel sm, boolean init) {
    return (CastExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.CastExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CastExpression newInstance(SModel sm) {
    return CastExpression.newInstance(sm, false);
  }

}
