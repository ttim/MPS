package jetbrains.mps.baseLanguage.datesInternal.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Month extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.datesInternal.structure.Month";
  public static final String SHORT_NAME = "shortName";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String DAYS = "days";
  public static final String NUMBER = "number";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public Month(SNode node) {
    super(node);
  }

  public String getShortName() {
    return this.getProperty(Month.SHORT_NAME);
  }

  public void setShortName(String value) {
    this.setProperty(Month.SHORT_NAME, value);
  }

  public String getName() {
    return this.getProperty(Month.NAME);
  }

  public void setName(String value) {
    this.setProperty(Month.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(Month.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(Month.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(Month.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(Month.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(Month.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(Month.VIRTUAL_PACKAGE, value);
  }

  public int getDays() {
    return this.getIntegerProperty(Month.DAYS);
  }

  public void setDays(int value) {
    this.setIntegerProperty(Month.DAYS, value);
  }

  public int getNumber() {
    return this.getIntegerProperty(Month.NUMBER);
  }

  public void setNumber(int value) {
    this.setIntegerProperty(Month.NUMBER, value);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(Month.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, Month.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, Month.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(Month.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, Month.SMODEL_ATTRIBUTE, node);
  }

  public static Month newInstance(SModel sm, boolean init) {
    return (Month) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.datesInternal.structure.Month", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Month newInstance(SModel sm) {
    return Month.newInstance(sm, false);
  }
}
