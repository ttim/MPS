package jetbrains.mps.runConfigurations.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class RedirectOutputExpression extends Expression {
  public static final String concept = "jetbrains.mps.runConfigurations.structure.RedirectOutputExpression";
  public static final String PROCESS_HANDLER = "processHandler";
  public static final String LISTENER = "listener";

  public RedirectOutputExpression(SNode node) {
    super(node);
  }

  public Expression getProcessHandler() {
    return (Expression) this.getChild(Expression.class, RedirectOutputExpression.PROCESS_HANDLER);
  }

  public void setProcessHandler(Expression node) {
    super.setChild(RedirectOutputExpression.PROCESS_HANDLER, node);
  }

  public Expression getListener() {
    return (Expression) this.getChild(Expression.class, RedirectOutputExpression.LISTENER);
  }

  public void setListener(Expression node) {
    super.setChild(RedirectOutputExpression.LISTENER, node);
  }

  public static RedirectOutputExpression newInstance(SModel sm, boolean init) {
    return (RedirectOutputExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.runConfigurations.structure.RedirectOutputExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static RedirectOutputExpression newInstance(SModel sm) {
    return RedirectOutputExpression.newInstance(sm, false);
  }
}
