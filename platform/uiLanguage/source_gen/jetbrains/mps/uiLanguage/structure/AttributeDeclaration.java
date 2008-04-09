package jetbrains.mps.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.baseLanguage.classifiers.structure.IMember;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.baseLanguage.structure.Expression;

public class AttributeDeclaration extends BaseConcept implements IMember {
  public static final String concept = "jetbrains.mps.uiLanguage.structure.AttributeDeclaration";
  public static String NAME = "name";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";
  public static String TYPE = "type";
  public static String INITIALIZER = "initializer";
  public static String ON_CHANGE = "onChange";

  public AttributeDeclaration(SNode node) {
    super(node);
  }

  public static AttributeDeclaration newInstance(SModel sm, boolean init) {
    return (AttributeDeclaration) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.uiLanguage.structure.AttributeDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AttributeDeclaration newInstance(SModel sm) {
    return AttributeDeclaration.newInstance(sm, false);
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
    return (Type) this.getChild(AttributeDeclaration.TYPE);
  }

  public void setType(Type node) {
    super.setChild(AttributeDeclaration.TYPE, node);
  }

  public Expression getInitializer() {
    return (Expression) this.getChild(AttributeDeclaration.INITIALIZER);
  }

  public void setInitializer(Expression node) {
    super.setChild(AttributeDeclaration.INITIALIZER, node);
  }

  public Expression getOnChange() {
    return (Expression) this.getChild(AttributeDeclaration.ON_CHANGE);
  }

  public void setOnChange(Expression node) {
    super.setChild(AttributeDeclaration.ON_CHANGE, node);
  }

}
