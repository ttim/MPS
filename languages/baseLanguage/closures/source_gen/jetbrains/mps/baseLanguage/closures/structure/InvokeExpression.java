package jetbrains.mps.baseLanguage.closures.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InvokeExpression extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.closures.structure.InvokeExpression";
  public static final String PARAMETER = "parameter";

  public InvokeExpression(SNode node) {
    super(node);
  }

  public int getParametersCount() {
    return this.getChildCount(InvokeExpression.PARAMETER);
  }

  public Iterator<Expression> parameters() {
    return this.children(Expression.class, InvokeExpression.PARAMETER);
  }

  public List<Expression> getParameters() {
    return this.getChildren(Expression.class, InvokeExpression.PARAMETER);
  }

  public void addParameter(Expression node) {
    this.addChild(InvokeExpression.PARAMETER, node);
  }

  public void insertParameter(Expression prev, Expression node) {
    this.insertChild(prev, InvokeExpression.PARAMETER, node);
  }

  public static InvokeExpression newInstance(SModel sm, boolean init) {
    return (InvokeExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.closures.structure.InvokeExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InvokeExpression newInstance(SModel sm) {
    return InvokeExpression.newInstance(sm, false);
  }
}
