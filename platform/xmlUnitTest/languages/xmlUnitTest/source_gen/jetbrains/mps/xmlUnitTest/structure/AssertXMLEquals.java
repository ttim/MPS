package jetbrains.mps.xmlUnitTest.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.baseLanguage.unitTest.structure.MessageHolder;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.baseLanguage.unitTest.structure.Message;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AssertXMLEquals extends Statement implements MessageHolder {
  public static final String concept = "jetbrains.mps.xmlUnitTest.structure.AssertXMLEquals";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String EXPECTED = "expected";
  public static final String ACTUAL = "actual";
  public static final String MESSAGE = "message";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public AssertXMLEquals(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(AssertXMLEquals.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(AssertXMLEquals.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(AssertXMLEquals.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(AssertXMLEquals.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(AssertXMLEquals.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(AssertXMLEquals.VIRTUAL_PACKAGE, value);
  }

  public Expression getExpected() {
    return (Expression) this.getChild(Expression.class, AssertXMLEquals.EXPECTED);
  }

  public void setExpected(Expression node) {
    super.setChild(AssertXMLEquals.EXPECTED, node);
  }

  public Expression getActual() {
    return (Expression) this.getChild(Expression.class, AssertXMLEquals.ACTUAL);
  }

  public void setActual(Expression node) {
    super.setChild(AssertXMLEquals.ACTUAL, node);
  }

  public Message getMessage() {
    return (Message) this.getChild(Message.class, AssertXMLEquals.MESSAGE);
  }

  public void setMessage(Message node) {
    super.setChild(AssertXMLEquals.MESSAGE, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(AssertXMLEquals.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, AssertXMLEquals.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, AssertXMLEquals.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(AssertXMLEquals.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, AssertXMLEquals.SMODEL_ATTRIBUTE, node);
  }

  public static AssertXMLEquals newInstance(SModel sm, boolean init) {
    return (AssertXMLEquals) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlUnitTest.structure.AssertXMLEquals", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AssertXMLEquals newInstance(SModel sm) {
    return AssertXMLEquals.newInstance(sm, false);
  }
}
