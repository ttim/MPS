package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class VisitChildrenExpression extends Expression {
  public static final String concept = "jetbrains.mps.ypath.structure.VisitChildrenExpression";
  public static final String ACTUAL_ARGUMENT = "actualArgument";

  public VisitChildrenExpression(SNode node) {
    super(node);
  }

  public int getActualArgumentsCount() {
    return this.getChildCount(VisitChildrenExpression.ACTUAL_ARGUMENT);
  }

  public Iterator<Expression> actualArguments() {
    return this.children(Expression.class, VisitChildrenExpression.ACTUAL_ARGUMENT);
  }

  public List<Expression> getActualArguments() {
    return this.getChildren(Expression.class, VisitChildrenExpression.ACTUAL_ARGUMENT);
  }

  public void addActualArgument(Expression node) {
    this.addChild(VisitChildrenExpression.ACTUAL_ARGUMENT, node);
  }

  public void insertActualArgument(Expression prev, Expression node) {
    this.insertChild(prev, VisitChildrenExpression.ACTUAL_ARGUMENT, node);
  }

  public static VisitChildrenExpression newInstance(SModel sm, boolean init) {
    return (VisitChildrenExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.VisitChildrenExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static VisitChildrenExpression newInstance(SModel sm) {
    return VisitChildrenExpression.newInstance(sm, false);
  }
}
