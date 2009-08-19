package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GivetypeStatement extends Statement {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.GivetypeStatement";
  public static final String TYPE_EXPRESSION = "typeExpression";
  public static final String TERM_EXPRESSION = "termExpression";

  public GivetypeStatement(SNode node) {
    super(node);
  }

  public Expression getTypeExpression() {
    return (Expression)this.getChild(Expression.class, GivetypeStatement.TYPE_EXPRESSION);
  }

  public void setTypeExpression(Expression node) {
    super.setChild(GivetypeStatement.TYPE_EXPRESSION, node);
  }

  public Expression getTermExpression() {
    return (Expression)this.getChild(Expression.class, GivetypeStatement.TERM_EXPRESSION);
  }

  public void setTermExpression(Expression node) {
    super.setChild(GivetypeStatement.TERM_EXPRESSION, node);
  }

  public static GivetypeStatement newInstance(SModel sm, boolean init) {
    return (GivetypeStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.GivetypeStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GivetypeStatement newInstance(SModel sm) {
    return GivetypeStatement.newInstance(sm, false);
  }
}
