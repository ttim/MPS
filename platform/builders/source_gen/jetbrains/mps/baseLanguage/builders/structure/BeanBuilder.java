package jetbrains.mps.baseLanguage.builders.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.IMethodCall;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration;
import jetbrains.mps.baseLanguage.structure.ConstructorDeclaration;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.structure.Expression;
import java.util.List;
import jetbrains.mps.lang.core.structure.Attribute;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BeanBuilder extends Builder implements IMethodCall {
  public static final String concept = "jetbrains.mps.baseLanguage.builders.structure.BeanBuilder";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String BASE_METHOD_DECLARATION = "baseMethodDeclaration";
  public static final String ACTUAL_ARGUMENT = "actualArgument";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public BeanBuilder(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(BeanBuilder.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(BeanBuilder.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(BeanBuilder.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(BeanBuilder.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(BeanBuilder.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(BeanBuilder.VIRTUAL_PACKAGE, value);
  }

  public BaseMethodDeclaration getBaseMethodDeclaration() {
    return (BaseMethodDeclaration) this.getReferent(BaseMethodDeclaration.class, BeanBuilder.BASE_METHOD_DECLARATION);
  }

  public void setBaseMethodDeclaration(BaseMethodDeclaration node) {
    super.setReferent(BeanBuilder.BASE_METHOD_DECLARATION, node);
  }

  public ConstructorDeclaration getConstructor() {
    return this.ensureAdapter(ConstructorDeclaration.class, "baseMethodDeclaration", this.getBaseMethodDeclaration());
  }

  public void setConstructor(ConstructorDeclaration node) {
    this.setBaseMethodDeclaration(node);
  }

  public int getActualArgumentsCount() {
    return this.getChildCount(BeanBuilder.ACTUAL_ARGUMENT);
  }

  public Iterator<Expression> actualArguments() {
    return this.children(Expression.class, BeanBuilder.ACTUAL_ARGUMENT);
  }

  public List<Expression> getActualArguments() {
    return this.getChildren(Expression.class, BeanBuilder.ACTUAL_ARGUMENT);
  }

  public void addActualArgument(Expression node) {
    this.addChild(BeanBuilder.ACTUAL_ARGUMENT, node);
  }

  public void insertActualArgument(Expression prev, Expression node) {
    this.insertChild(prev, BeanBuilder.ACTUAL_ARGUMENT, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(BeanBuilder.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, BeanBuilder.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, BeanBuilder.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(BeanBuilder.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, BeanBuilder.SMODEL_ATTRIBUTE, node);
  }

  public static BeanBuilder newInstance(SModel sm, boolean init) {
    return (BeanBuilder) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.builders.structure.BeanBuilder", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BeanBuilder newInstance(SModel sm) {
    return BeanBuilder.newInstance(sm, false);
  }
}
