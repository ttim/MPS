package jetbrains.mps.baseLanguage.dates.internal.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class DateTimeProperty extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.dates.internal.structure.DateTimeProperty";
  public static String PLURAL_FORM = "pluralForm";
  public static String NAME = "name";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";
  public static String JODA_DATE_TIME_FIELD_TYPE = "jodaDateTimeFieldType";
  public static String JODA_PERIOD_TYPE = "jodaPeriodType";

  public DateTimeProperty(SNode node) {
    super(node);
  }

  public String getPluralForm() {
    return this.getProperty(DateTimeProperty.PLURAL_FORM);
  }

  public void setPluralForm(String value) {
    this.setProperty(DateTimeProperty.PLURAL_FORM, value);
  }

  public String getName() {
    return this.getProperty(DateTimeProperty.NAME);
  }

  public void setName(String value) {
    this.setProperty(DateTimeProperty.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(DateTimeProperty.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(DateTimeProperty.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(DateTimeProperty.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(DateTimeProperty.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(DateTimeProperty.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(DateTimeProperty.VIRTUAL_PACKAGE, value);
  }

  public StaticMethodDeclaration getJodaDateTimeFieldType() {
    return (StaticMethodDeclaration)this.getReferent(DateTimeProperty.JODA_DATE_TIME_FIELD_TYPE);
  }

  public void setJodaDateTimeFieldType(StaticMethodDeclaration node) {
    super.setReferent(DateTimeProperty.JODA_DATE_TIME_FIELD_TYPE, node);
  }

  public StaticMethodDeclaration getJodaPeriodType() {
    return (StaticMethodDeclaration)this.getReferent(DateTimeProperty.JODA_PERIOD_TYPE);
  }

  public void setJodaPeriodType(StaticMethodDeclaration node) {
    super.setReferent(DateTimeProperty.JODA_PERIOD_TYPE, node);
  }


  public static DateTimeProperty newInstance(SModel sm, boolean init) {
    return (DateTimeProperty)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.internal.structure.DateTimeProperty", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static DateTimeProperty newInstance(SModel sm) {
    return DateTimeProperty.newInstance(sm, false);
  }

}
