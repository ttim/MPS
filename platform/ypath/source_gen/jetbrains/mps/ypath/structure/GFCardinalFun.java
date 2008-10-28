package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GFCardinalFun extends ConceptFunction implements IDesignFunction {
  public static final String concept = "jetbrains.mps.ypath.structure.GFCardinalFun";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";

  public GFCardinalFun(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(GFCardinalFun.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(GFCardinalFun.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(GFCardinalFun.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(GFCardinalFun.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(GFCardinalFun.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(GFCardinalFun.VIRTUAL_PACKAGE, value);
  }


  public static GFCardinalFun newInstance(SModel sm, boolean init) {
    return (GFCardinalFun)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.GFCardinalFun", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GFCardinalFun newInstance(SModel sm) {
    return GFCardinalFun.newInstance(sm, false);
  }

}
