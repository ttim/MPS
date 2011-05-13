package jetbrains.mps.gtext.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.lang.core.structure.Attribute;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GContentBlock extends GItem implements INamedConcept, GCompositeItem {
  public static final String concept = "jetbrains.mps.gtext.structure.GContentBlock";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String ITEM = "item";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public GContentBlock(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(GContentBlock.NAME);
  }

  public void setName(String value) {
    this.setProperty(GContentBlock.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(GContentBlock.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(GContentBlock.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(GContentBlock.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(GContentBlock.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(GContentBlock.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(GContentBlock.VIRTUAL_PACKAGE, value);
  }

  public int getItemsCount() {
    return this.getChildCount(GContentBlock.ITEM);
  }

  public Iterator<GItem> items() {
    return this.children(GItem.class, GContentBlock.ITEM);
  }

  public List<GItem> getItems() {
    return this.getChildren(GItem.class, GContentBlock.ITEM);
  }

  public void addItem(GItem node) {
    this.addChild(GContentBlock.ITEM, node);
  }

  public void insertItem(GItem prev, GItem node) {
    this.insertChild(prev, GContentBlock.ITEM, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(GContentBlock.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, GContentBlock.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, GContentBlock.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(GContentBlock.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, GContentBlock.SMODEL_ATTRIBUTE, node);
  }

  public static GContentBlock newInstance(SModel sm, boolean init) {
    return (GContentBlock) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.gtext.structure.GContentBlock", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GContentBlock newInstance(SModel sm) {
    return GContentBlock.newInstance(sm, false);
  }
}
