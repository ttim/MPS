package jetbrains.mps.samples.readerConfigLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Field extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.samples.readerConfigLanguage.structure.Field";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String START = "start";
  public static final String END = "end";

  public Field(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(Field.NAME);
  }

  public void setName(String value) {
    this.setProperty(Field.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(Field.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(Field.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(Field.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(Field.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(Field.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(Field.VIRTUAL_PACKAGE, value);
  }

  public int getStart() {
    return this.getIntegerProperty(Field.START);
  }

  public void setStart(int value) {
    this.setIntegerProperty(Field.START, value);
  }

  public int getEnd() {
    return this.getIntegerProperty(Field.END);
  }

  public void setEnd(int value) {
    this.setIntegerProperty(Field.END, value);
  }

  public static Field newInstance(SModel sm, boolean init) {
    return (Field) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.samples.readerConfigLanguage.structure.Field", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Field newInstance(SModel sm) {
    return Field.newInstance(sm, false);
  }
}
