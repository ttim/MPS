package jetbrains.mps.baseLanguage.dates.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.datesInternal.structure.DateTimeProperty;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class DateTimeWithPropertyOperation extends UnaryDateTimeOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.dates.structure.DateTimeWithPropertyOperation";
  public static final String DATE_TIME_PROPERTY = "dateTimeProperty";
  public static final String EXPRESSION = "expression";

  public DateTimeWithPropertyOperation(SNode node) {
    super(node);
  }

  public DateTimeProperty getDateTimeProperty() {
    return (DateTimeProperty)this.getReferent(DateTimeProperty.class, DateTimeWithPropertyOperation.DATE_TIME_PROPERTY);
  }

  public void setDateTimeProperty(DateTimeProperty node) {
    super.setReferent(DateTimeWithPropertyOperation.DATE_TIME_PROPERTY, node);
  }

  public Expression getExpression() {
    return (Expression)this.getChild(Expression.class, DateTimeWithPropertyOperation.EXPRESSION);
  }

  public void setExpression(Expression node) {
    super.setChild(DateTimeWithPropertyOperation.EXPRESSION, node);
  }


  public static DateTimeWithPropertyOperation newInstance(SModel sm, boolean init) {
    return (DateTimeWithPropertyOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.DateTimeWithPropertyOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static DateTimeWithPropertyOperation newInstance(SModel sm) {
    return DateTimeWithPropertyOperation.newInstance(sm, false);
  }

}
