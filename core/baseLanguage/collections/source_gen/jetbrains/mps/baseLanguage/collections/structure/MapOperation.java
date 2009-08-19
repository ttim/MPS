package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.baseLanguage.structure.IOperation;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MapOperation extends BaseConcept implements IOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.MapOperation";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";

  public MapOperation(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(MapOperation.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(MapOperation.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(MapOperation.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(MapOperation.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(MapOperation.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(MapOperation.VIRTUAL_PACKAGE, value);
  }

  public static MapOperation newInstance(SModel sm, boolean init) {
    return (MapOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.MapOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MapOperation newInstance(SModel sm) {
    return MapOperation.newInstance(sm, false);
  }
}
