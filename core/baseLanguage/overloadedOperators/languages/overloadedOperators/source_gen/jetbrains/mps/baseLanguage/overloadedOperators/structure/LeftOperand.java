package jetbrains.mps.baseLanguage.overloadedOperators.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class LeftOperand extends ConceptFunctionParameter implements INamedConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.overloadedOperators.structure.LeftOperand";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";

  public LeftOperand(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(LeftOperand.NAME);
  }

  public void setName(String value) {
    this.setProperty(LeftOperand.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(LeftOperand.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(LeftOperand.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(LeftOperand.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(LeftOperand.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(LeftOperand.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(LeftOperand.VIRTUAL_PACKAGE, value);
  }

  public static LeftOperand newInstance(SModel sm, boolean init) {
    return (LeftOperand) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.overloadedOperators.structure.LeftOperand", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static LeftOperand newInstance(SModel sm) {
    return LeftOperand.newInstance(sm, false);
  }
}
