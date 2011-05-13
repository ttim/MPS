package jetbrains.mps.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PngIcon extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.uiLanguage.structure.PngIcon";
  public static final String ICON_DATA = "iconData";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public PngIcon(SNode node) {
    super(node);
  }

  public String getIconData() {
    return this.getProperty(PngIcon.ICON_DATA);
  }

  public void setIconData(String value) {
    this.setProperty(PngIcon.ICON_DATA, value);
  }

  public String getName() {
    return this.getProperty(PngIcon.NAME);
  }

  public void setName(String value) {
    this.setProperty(PngIcon.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(PngIcon.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(PngIcon.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(PngIcon.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(PngIcon.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(PngIcon.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(PngIcon.VIRTUAL_PACKAGE, value);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(PngIcon.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, PngIcon.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, PngIcon.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(PngIcon.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, PngIcon.SMODEL_ATTRIBUTE, node);
  }

  public static PngIcon newInstance(SModel sm, boolean init) {
    return (PngIcon) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.uiLanguage.structure.PngIcon", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static PngIcon newInstance(SModel sm) {
    return PngIcon.newInstance(sm, false);
  }
}
