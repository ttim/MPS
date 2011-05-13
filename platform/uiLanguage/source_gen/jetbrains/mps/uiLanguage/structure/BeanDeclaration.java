package jetbrains.mps.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.baseLanguage.classifiers.structure.IClassifier;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.baseLanguage.classifiers.structure.DefaultClassifierMethodDeclaration;
import jetbrains.mps.baseLanguage.structure.ConstructorDeclaration;
import jetbrains.mps.lang.core.structure.Attribute;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BeanDeclaration extends BaseConcept implements IClassifier, INamedConcept {
  public static final String concept = "jetbrains.mps.uiLanguage.structure.BeanDeclaration";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String ATTRIBUTE = "attribute";
  public static final String METHOD = "method";
  public static final String CONSTRUCTOR = "constructor";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public BeanDeclaration(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(BeanDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(BeanDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(BeanDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(BeanDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(BeanDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(BeanDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(BeanDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(BeanDeclaration.VIRTUAL_PACKAGE, value);
  }

  public int getAttributesCount() {
    return this.getChildCount(BeanDeclaration.ATTRIBUTE);
  }

  public Iterator<AttributeDeclaration> attributes() {
    return this.children(AttributeDeclaration.class, BeanDeclaration.ATTRIBUTE);
  }

  public List<AttributeDeclaration> getAttributes() {
    return this.getChildren(AttributeDeclaration.class, BeanDeclaration.ATTRIBUTE);
  }

  public void addAttribute(AttributeDeclaration node) {
    this.addChild(BeanDeclaration.ATTRIBUTE, node);
  }

  public void insertAttribute(AttributeDeclaration prev, AttributeDeclaration node) {
    this.insertChild(prev, BeanDeclaration.ATTRIBUTE, node);
  }

  public int getMethodsCount() {
    return this.getChildCount(BeanDeclaration.METHOD);
  }

  public Iterator<DefaultClassifierMethodDeclaration> methods() {
    return this.children(DefaultClassifierMethodDeclaration.class, BeanDeclaration.METHOD);
  }

  public List<DefaultClassifierMethodDeclaration> getMethods() {
    return this.getChildren(DefaultClassifierMethodDeclaration.class, BeanDeclaration.METHOD);
  }

  public void addMethod(DefaultClassifierMethodDeclaration node) {
    this.addChild(BeanDeclaration.METHOD, node);
  }

  public void insertMethod(DefaultClassifierMethodDeclaration prev, DefaultClassifierMethodDeclaration node) {
    this.insertChild(prev, BeanDeclaration.METHOD, node);
  }

  public int getConstructorsCount() {
    return this.getChildCount(BeanDeclaration.CONSTRUCTOR);
  }

  public Iterator<ConstructorDeclaration> constructors() {
    return this.children(ConstructorDeclaration.class, BeanDeclaration.CONSTRUCTOR);
  }

  public List<ConstructorDeclaration> getConstructors() {
    return this.getChildren(ConstructorDeclaration.class, BeanDeclaration.CONSTRUCTOR);
  }

  public void addConstructor(ConstructorDeclaration node) {
    this.addChild(BeanDeclaration.CONSTRUCTOR, node);
  }

  public void insertConstructor(ConstructorDeclaration prev, ConstructorDeclaration node) {
    this.insertChild(prev, BeanDeclaration.CONSTRUCTOR, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(BeanDeclaration.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, BeanDeclaration.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, BeanDeclaration.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(BeanDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, BeanDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public static BeanDeclaration newInstance(SModel sm, boolean init) {
    return (BeanDeclaration) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.uiLanguage.structure.BeanDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BeanDeclaration newInstance(SModel sm) {
    return BeanDeclaration.newInstance(sm, false);
  }
}
