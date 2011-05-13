package jetbrains.mps.transformation.test.outputLang.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CustomStatement extends Statement implements INamedConcept {
  public static final String concept = "jetbrains.mps.transformation.test.outputLang.structure.CustomStatement";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String INNER = "inner";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public CustomStatement(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(CustomStatement.NAME);
  }

  public void setName(String value) {
    this.setProperty(CustomStatement.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(CustomStatement.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(CustomStatement.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(CustomStatement.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(CustomStatement.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(CustomStatement.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(CustomStatement.VIRTUAL_PACKAGE, value);
  }

  public Expression getInner() {
    return (Expression) this.getChild(Expression.class, CustomStatement.INNER);
  }

  public void setInner(Expression node) {
    super.setChild(CustomStatement.INNER, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(CustomStatement.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, CustomStatement.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, CustomStatement.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(CustomStatement.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, CustomStatement.SMODEL_ATTRIBUTE, node);
  }

  public static CustomStatement newInstance(SModel sm, boolean init) {
    return (CustomStatement) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.transformation.test.outputLang.structure.CustomStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CustomStatement newInstance(SModel sm) {
    return CustomStatement.newInstance(sm, false);
  }
}
