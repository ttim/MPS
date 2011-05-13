package jetbrains.mps.lang.behavior.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration;
import jetbrains.mps.baseLanguage.structure.IVisible;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Visibility;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class StaticConceptMethodDeclaration extends BaseMethodDeclaration implements IVisible {
  public static final String concept = "jetbrains.mps.lang.behavior.structure.StaticConceptMethodDeclaration";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String IS_PRIVATE = "isPrivate";
  public static final String VISIBILITY = "visibility";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public StaticConceptMethodDeclaration(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(StaticConceptMethodDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(StaticConceptMethodDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(StaticConceptMethodDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(StaticConceptMethodDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(StaticConceptMethodDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(StaticConceptMethodDeclaration.VIRTUAL_PACKAGE, value);
  }

  public boolean getIsPrivate() {
    return this.getBooleanProperty(StaticConceptMethodDeclaration.IS_PRIVATE);
  }

  public void setIsPrivate(boolean value) {
    this.setBooleanProperty(StaticConceptMethodDeclaration.IS_PRIVATE, value);
  }

  public Visibility getVisibility() {
    return (Visibility) this.getChild(Visibility.class, StaticConceptMethodDeclaration.VISIBILITY);
  }

  public void setVisibility(Visibility node) {
    super.setChild(StaticConceptMethodDeclaration.VISIBILITY, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(StaticConceptMethodDeclaration.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, StaticConceptMethodDeclaration.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, StaticConceptMethodDeclaration.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(StaticConceptMethodDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, StaticConceptMethodDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public static StaticConceptMethodDeclaration newInstance(SModel sm, boolean init) {
    return (StaticConceptMethodDeclaration) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.behavior.structure.StaticConceptMethodDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static StaticConceptMethodDeclaration newInstance(SModel sm) {
    return StaticConceptMethodDeclaration.newInstance(sm, false);
  }
}
