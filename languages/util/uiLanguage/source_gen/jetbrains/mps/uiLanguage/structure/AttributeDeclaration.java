package jetbrains.mps.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.baseLanguage.classifiers.structure.IMember;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.baseLanguage.structure.Expression;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AttributeDeclaration extends BaseConcept implements IMember {
  public static final String concept = "jetbrains.mps.uiLanguage.structure.AttributeDeclaration";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String TYPE = "type";
  public static final String INITIALIZER = "initializer";
  public static final String ON_CHANGE = "onChange";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public AttributeDeclaration(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(AttributeDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(AttributeDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(AttributeDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(AttributeDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(AttributeDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(AttributeDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(AttributeDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(AttributeDeclaration.VIRTUAL_PACKAGE, value);
  }

  public Type getType() {
    return (Type) this.getChild(Type.class, AttributeDeclaration.TYPE);
  }

  public void setType(Type node) {
    super.setChild(AttributeDeclaration.TYPE, node);
  }

  public Expression getInitializer() {
    return (Expression) this.getChild(Expression.class, AttributeDeclaration.INITIALIZER);
  }

  public void setInitializer(Expression node) {
    super.setChild(AttributeDeclaration.INITIALIZER, node);
  }

  public Expression getOnChange() {
    return (Expression) this.getChild(Expression.class, AttributeDeclaration.ON_CHANGE);
  }

  public void setOnChange(Expression node) {
    super.setChild(AttributeDeclaration.ON_CHANGE, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(AttributeDeclaration.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, AttributeDeclaration.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, AttributeDeclaration.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(AttributeDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, AttributeDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public static AttributeDeclaration newInstance(SModel sm, boolean init) {
    return (AttributeDeclaration) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.uiLanguage.structure.AttributeDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AttributeDeclaration newInstance(SModel sm) {
    return AttributeDeclaration.newInstance(sm, false);
  }
}
