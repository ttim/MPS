package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GFGetterFun extends ConceptFunction implements IDesignFunction {
  public static final String concept = "jetbrains.mps.ypath.structure.GFGetterFun";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";

  public GFGetterFun(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(GFGetterFun.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(GFGetterFun.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(GFGetterFun.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(GFGetterFun.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(GFGetterFun.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(GFGetterFun.VIRTUAL_PACKAGE, value);
  }


  public static GFGetterFun newInstance(SModel sm, boolean init) {
    return (GFGetterFun)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.GFGetterFun", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GFGetterFun newInstance(SModel sm) {
    return GFGetterFun.newInstance(sm, false);
  }

}
