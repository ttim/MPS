package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GenericFeature extends BaseConcept implements IGenericFeature, INamedConcept, IFeature {
  public static final String concept = "jetbrains.mps.ypath.structure.GenericFeature";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String WRITABLE = "writable";
  public static final String DEFAULT = "default";
  public static final String ASCENDING = "ascending";
  public static final String OPPOSITE = "opposite";
  public static final String GETTER = "getter";

  public GenericFeature(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(GenericFeature.NAME);
  }

  public void setName(String value) {
    this.setProperty(GenericFeature.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(GenericFeature.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(GenericFeature.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(GenericFeature.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(GenericFeature.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(GenericFeature.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(GenericFeature.VIRTUAL_PACKAGE, value);
  }

  public boolean getWritable() {
    return this.getBooleanProperty(GenericFeature.WRITABLE);
  }

  public void setWritable(boolean value) {
    this.setBooleanProperty(GenericFeature.WRITABLE, value);
  }

  public boolean getDefault() {
    return this.getBooleanProperty(GenericFeature.DEFAULT);
  }

  public void setDefault(boolean value) {
    this.setBooleanProperty(GenericFeature.DEFAULT, value);
  }

  public boolean getAscending() {
    return this.getBooleanProperty(GenericFeature.ASCENDING);
  }

  public void setAscending(boolean value) {
    this.setBooleanProperty(GenericFeature.ASCENDING, value);
  }

  public IFeature getOpposite() {
    return (IFeature) this.getReferent(IFeature.class, GenericFeature.OPPOSITE);
  }

  public void setOpposite(IFeature node) {
    super.setReferent(GenericFeature.OPPOSITE, node);
  }

  public GFGetterFun getGetter() {
    return (GFGetterFun) this.getChild(GFGetterFun.class, GenericFeature.GETTER);
  }

  public void setGetter(GFGetterFun node) {
    super.setChild(GenericFeature.GETTER, node);
  }

  public static GenericFeature newInstance(SModel sm, boolean init) {
    return (GenericFeature) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.GenericFeature", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GenericFeature newInstance(SModel sm) {
    return GenericFeature.newInstance(sm, false);
  }
}
