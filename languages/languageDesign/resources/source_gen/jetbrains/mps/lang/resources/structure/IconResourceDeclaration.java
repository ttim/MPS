package jetbrains.mps.lang.resources.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class IconResourceDeclaration extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.lang.resources.structure.IconResourceDeclaration";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String ICON_EXPRESSION = "iconExpression";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public IconResourceDeclaration(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(IconResourceDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(IconResourceDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(IconResourceDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(IconResourceDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(IconResourceDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(IconResourceDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(IconResourceDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(IconResourceDeclaration.VIRTUAL_PACKAGE, value);
  }

  public Expression getIconExpression() {
    return (Expression) this.getChild(Expression.class, IconResourceDeclaration.ICON_EXPRESSION);
  }

  public void setIconExpression(Expression node) {
    super.setChild(IconResourceDeclaration.ICON_EXPRESSION, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(IconResourceDeclaration.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, IconResourceDeclaration.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, IconResourceDeclaration.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(IconResourceDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, IconResourceDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public static IconResourceDeclaration newInstance(SModel sm, boolean init) {
    return (IconResourceDeclaration) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.resources.structure.IconResourceDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static IconResourceDeclaration newInstance(SModel sm) {
    return IconResourceDeclaration.newInstance(sm, false);
  }
}
