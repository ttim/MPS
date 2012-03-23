package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.IResolveInfo;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class StaticMethodDeclaration extends BaseMethodDeclaration implements ClassifierMember, StaticKind, IResolveInfo {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String RESOLVE_INFO = "resolveInfo";
  public static final String VISIBILITY = "visibility";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public StaticMethodDeclaration(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(StaticMethodDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(StaticMethodDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(StaticMethodDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(StaticMethodDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(StaticMethodDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(StaticMethodDeclaration.VIRTUAL_PACKAGE, value);
  }

  public String getResolveInfo() {
    return this.getProperty(StaticMethodDeclaration.RESOLVE_INFO);
  }

  public void setResolveInfo(String value) {
    this.setProperty(StaticMethodDeclaration.RESOLVE_INFO, value);
  }

  public Visibility getVisibility() {
    return (Visibility) this.getChild(Visibility.class, StaticMethodDeclaration.VISIBILITY);
  }

  public void setVisibility(Visibility node) {
    super.setChild(StaticMethodDeclaration.VISIBILITY, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(StaticMethodDeclaration.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, StaticMethodDeclaration.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, StaticMethodDeclaration.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(StaticMethodDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, StaticMethodDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public static StaticMethodDeclaration newInstance(SModel sm, boolean init) {
    return (StaticMethodDeclaration) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static StaticMethodDeclaration newInstance(SModel sm) {
    return StaticMethodDeclaration.newInstance(sm, false);
  }
}
