package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ToStringFun extends ConceptFunction implements IDesignFunction {
  public static final String concept = "jetbrains.mps.ypath.structure.ToStringFun";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";

  public ToStringFun(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(ToStringFun.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ToStringFun.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ToStringFun.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ToStringFun.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ToStringFun.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ToStringFun.VIRTUAL_PACKAGE, value);
  }

  public static ToStringFun newInstance(SModel sm, boolean init) {
    return (ToStringFun) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.ToStringFun", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ToStringFun newInstance(SModel sm) {
    return ToStringFun.newInstance(sm, false);
  }
}
