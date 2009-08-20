package jetbrains.mps.baseLanguage.money.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MoneyMethodCall extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.money.structure.MoneyMethodCall";
  public static final String INSTANCE = "instance";

  public MoneyMethodCall(SNode node) {
    super(node);
  }

  public Expression getInstance() {
    return (Expression)this.getChild(Expression.class, MoneyMethodCall.INSTANCE);
  }

  public void setInstance(Expression node) {
    super.setChild(MoneyMethodCall.INSTANCE, node);
  }

  public static MoneyMethodCall newInstance(SModel sm, boolean init) {
    return (MoneyMethodCall)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.money.structure.MoneyMethodCall", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MoneyMethodCall newInstance(SModel sm) {
    return MoneyMethodCall.newInstance(sm, false);
  }
}
