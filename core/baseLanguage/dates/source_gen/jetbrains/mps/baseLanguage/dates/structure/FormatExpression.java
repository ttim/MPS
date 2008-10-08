package jetbrains.mps.baseLanguage.dates.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.dates.internal.structure.IDateFormat;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class FormatExpression extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.dates.structure.FormatExpression";
  public static String DATE_FORMAT = "dateFormat";
  public static String DATE_EXPRESSION = "dateExpression";

  public FormatExpression(SNode node) {
    super(node);
  }

  public IDateFormat getDateFormat() {
    return (IDateFormat)this.getReferent(FormatExpression.DATE_FORMAT);
  }

  public void setDateFormat(IDateFormat node) {
    super.setReferent(FormatExpression.DATE_FORMAT, node);
  }

  public Expression getDateExpression() {
    return (Expression)this.getChild(FormatExpression.DATE_EXPRESSION);
  }

  public void setDateExpression(Expression node) {
    super.setChild(FormatExpression.DATE_EXPRESSION, node);
  }


  public static FormatExpression newInstance(SModel sm, boolean init) {
    return (FormatExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.FormatExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static FormatExpression newInstance(SModel sm) {
    return FormatExpression.newInstance(sm, false);
  }

}
