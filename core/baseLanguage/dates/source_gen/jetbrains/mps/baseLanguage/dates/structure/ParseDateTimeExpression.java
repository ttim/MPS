package jetbrains.mps.baseLanguage.dates.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.datesInternal.structure.IDateFormat;
import jetbrains.mps.baseLanguage.datesInternal.structure.Locale;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ParseDateTimeExpression extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.dates.structure.ParseDateTimeExpression";
  public static final String DATE_FORMAT = "dateFormat";
  public static final String LOCALE = "locale";
  public static final String SOURCE = "source";
  public static final String ZONE = "zone";
  public static final String DEFAULT = "default";

  public ParseDateTimeExpression(SNode node) {
    super(node);
  }

  public IDateFormat getDateFormat() {
    return (IDateFormat)this.getReferent(IDateFormat.class, ParseDateTimeExpression.DATE_FORMAT);
  }

  public void setDateFormat(IDateFormat node) {
    super.setReferent(ParseDateTimeExpression.DATE_FORMAT, node);
  }

  public Locale getLocale() {
    return (Locale)this.getReferent(Locale.class, ParseDateTimeExpression.LOCALE);
  }

  public void setLocale(Locale node) {
    super.setReferent(ParseDateTimeExpression.LOCALE, node);
  }

  public Expression getSource() {
    return (Expression)this.getChild(Expression.class, ParseDateTimeExpression.SOURCE);
  }

  public void setSource(Expression node) {
    super.setChild(ParseDateTimeExpression.SOURCE, node);
  }

  public Expression getZone() {
    return (Expression)this.getChild(Expression.class, ParseDateTimeExpression.ZONE);
  }

  public void setZone(Expression node) {
    super.setChild(ParseDateTimeExpression.ZONE, node);
  }

  public Expression getDefault() {
    return (Expression)this.getChild(Expression.class, ParseDateTimeExpression.DEFAULT);
  }

  public void setDefault(Expression node) {
    super.setChild(ParseDateTimeExpression.DEFAULT, node);
  }

  public static ParseDateTimeExpression newInstance(SModel sm, boolean init) {
    return (ParseDateTimeExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.ParseDateTimeExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ParseDateTimeExpression newInstance(SModel sm) {
    return ParseDateTimeExpression.newInstance(sm, false);
  }
}
