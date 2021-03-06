package jetbrains.mps.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.lang.core.structure.Attribute;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Scroller extends BaseConcept implements IComponentInstance {
  public static final String concept = "jetbrains.mps.uiLanguage.structure.Scroller";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String CONTENT = "content";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public Scroller(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(Scroller.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(Scroller.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(Scroller.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(Scroller.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(Scroller.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(Scroller.VIRTUAL_PACKAGE, value);
  }

  public int getContentsCount() {
    return this.getChildCount(Scroller.CONTENT);
  }

  public Iterator<IComponentPart> contents() {
    return this.children(IComponentPart.class, Scroller.CONTENT);
  }

  public List<IComponentPart> getContents() {
    return this.getChildren(IComponentPart.class, Scroller.CONTENT);
  }

  public void addContent(IComponentPart node) {
    this.addChild(Scroller.CONTENT, node);
  }

  public void insertContent(IComponentPart prev, IComponentPart node) {
    this.insertChild(prev, Scroller.CONTENT, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(Scroller.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, Scroller.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, Scroller.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(Scroller.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, Scroller.SMODEL_ATTRIBUTE, node);
  }

  public static Scroller newInstance(SModel sm, boolean init) {
    return (Scroller) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.uiLanguage.structure.Scroller", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Scroller newInstance(SModel sm) {
    return Scroller.newInstance(sm, false);
  }
}
