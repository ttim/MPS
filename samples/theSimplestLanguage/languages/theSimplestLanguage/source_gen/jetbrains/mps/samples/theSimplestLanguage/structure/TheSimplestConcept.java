package jetbrains.mps.samples.theSimplestLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TheSimplestConcept extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.samples.theSimplestLanguage.structure.TheSimplestConcept";
  public static final String TEXT = "text";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";

  public TheSimplestConcept(SNode node) {
    super(node);
  }

  public String getText() {
    return this.getProperty(TheSimplestConcept.TEXT);
  }

  public void setText(String value) {
    this.setProperty(TheSimplestConcept.TEXT, value);
  }

  public String getName() {
    return this.getProperty(TheSimplestConcept.NAME);
  }

  public void setName(String value) {
    this.setProperty(TheSimplestConcept.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(TheSimplestConcept.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(TheSimplestConcept.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(TheSimplestConcept.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(TheSimplestConcept.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(TheSimplestConcept.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(TheSimplestConcept.VIRTUAL_PACKAGE, value);
  }

  public static TheSimplestConcept newInstance(SModel sm, boolean init) {
    return (TheSimplestConcept) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.samples.theSimplestLanguage.structure.TheSimplestConcept", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TheSimplestConcept newInstance(SModel sm) {
    return TheSimplestConcept.newInstance(sm, false);
  }
}
