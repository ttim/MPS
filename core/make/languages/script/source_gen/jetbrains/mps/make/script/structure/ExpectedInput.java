package jetbrains.mps.make.script.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ExpectedInput extends BaseConcept implements IExpected {
  public static final String concept = "jetbrains.mps.make.script.structure.ExpectedInput";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";

  public ExpectedInput(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(ExpectedInput.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ExpectedInput.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ExpectedInput.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ExpectedInput.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ExpectedInput.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ExpectedInput.VIRTUAL_PACKAGE, value);
  }

  public static ExpectedInput newInstance(SModel sm, boolean init) {
    return (ExpectedInput) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.make.script.structure.ExpectedInput", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ExpectedInput newInstance(SModel sm) {
    return ExpectedInput.newInstance(sm, false);
  }
}
