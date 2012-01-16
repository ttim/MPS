package jetbrains.mps.lang.constraints.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConstraintFunction_ReferentSearchScope_Factory extends ConstraintFunction_ReferentSearchScope_AbstractBase implements NodeScopeFactory {
  public static final String concept = "jetbrains.mps.lang.constraints.structure.ConstraintFunction_ReferentSearchScope_Factory";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ConstraintFunction_ReferentSearchScope_Factory(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(ConstraintFunction_ReferentSearchScope_Factory.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ConstraintFunction_ReferentSearchScope_Factory.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ConstraintFunction_ReferentSearchScope_Factory.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ConstraintFunction_ReferentSearchScope_Factory.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ConstraintFunction_ReferentSearchScope_Factory.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ConstraintFunction_ReferentSearchScope_Factory.VIRTUAL_PACKAGE, value);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ConstraintFunction_ReferentSearchScope_Factory.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ConstraintFunction_ReferentSearchScope_Factory.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ConstraintFunction_ReferentSearchScope_Factory.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ConstraintFunction_ReferentSearchScope_Factory.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ConstraintFunction_ReferentSearchScope_Factory.SMODEL_ATTRIBUTE, node);
  }

  public static ConstraintFunction_ReferentSearchScope_Factory newInstance(SModel sm, boolean init) {
    return (ConstraintFunction_ReferentSearchScope_Factory) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.constraints.structure.ConstraintFunction_ReferentSearchScope_Factory", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConstraintFunction_ReferentSearchScope_Factory newInstance(SModel sm) {
    return ConstraintFunction_ReferentSearchScope_Factory.newInstance(sm, false);
  }
}
