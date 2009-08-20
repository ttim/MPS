package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ExpressionFunctionParam extends ConceptFunctionParameter implements IFunctionParam {
  public static final String concept = "jetbrains.mps.ypath.structure.ExpressionFunctionParam";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";

  public ExpressionFunctionParam(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(ExpressionFunctionParam.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ExpressionFunctionParam.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ExpressionFunctionParam.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ExpressionFunctionParam.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ExpressionFunctionParam.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ExpressionFunctionParam.VIRTUAL_PACKAGE, value);
  }

  public static ExpressionFunctionParam newInstance(SModel sm, boolean init) {
    return (ExpressionFunctionParam)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.ExpressionFunctionParam", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ExpressionFunctionParam newInstance(SModel sm) {
    return ExpressionFunctionParam.newInstance(sm, false);
  }
}
