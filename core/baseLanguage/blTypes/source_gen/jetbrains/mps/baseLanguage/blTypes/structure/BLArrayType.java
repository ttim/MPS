package jetbrains.mps.baseLanguage.blTypes.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BLArrayType extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.blTypes.structure.BLArrayType";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String COMPONENT_TYPE = "componentType";

  public BLArrayType(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(BLArrayType.NAME);
  }

  public void setName(String value) {
    this.setProperty(BLArrayType.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(BLArrayType.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(BLArrayType.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(BLArrayType.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(BLArrayType.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(BLArrayType.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(BLArrayType.VIRTUAL_PACKAGE, value);
  }

  public INamedConcept getComponentType() {
    return (INamedConcept)this.getReferent(INamedConcept.class, BLArrayType.COMPONENT_TYPE);
  }

  public void setComponentType(INamedConcept node) {
    super.setReferent(BLArrayType.COMPONENT_TYPE, node);
  }

  public static BLArrayType newInstance(SModel sm, boolean init) {
    return (BLArrayType)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.blTypes.structure.BLArrayType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BLArrayType newInstance(SModel sm) {
    return BLArrayType.newInstance(sm, false);
  }
}
