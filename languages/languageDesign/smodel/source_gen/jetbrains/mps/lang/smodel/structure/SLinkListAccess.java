package jetbrains.mps.lang.smodel.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SLinkListAccess extends SNodeOperation implements ILinkAccess {
  public static final String concept = "jetbrains.mps.lang.smodel.structure.SLinkListAccess";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String LINK = "link";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public SLinkListAccess(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(SLinkListAccess.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(SLinkListAccess.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(SLinkListAccess.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(SLinkListAccess.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(SLinkListAccess.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(SLinkListAccess.VIRTUAL_PACKAGE, value);
  }

  public LinkDeclaration getLink() {
    return (LinkDeclaration) this.getReferent(LinkDeclaration.class, SLinkListAccess.LINK);
  }

  public void setLink(LinkDeclaration node) {
    super.setReferent(SLinkListAccess.LINK, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(SLinkListAccess.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, SLinkListAccess.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, SLinkListAccess.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(SLinkListAccess.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, SLinkListAccess.SMODEL_ATTRIBUTE, node);
  }

  public static SLinkListAccess newInstance(SModel sm, boolean init) {
    return (SLinkListAccess) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SLinkListAccess", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SLinkListAccess newInstance(SModel sm) {
    return SLinkListAccess.newInstance(sm, false);
  }
}
