package jetbrains.mps.build.dependency.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Macros extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.build.dependency.structure.Macros";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";

  public Macros(SNode node) {
    super(node);
  }


  public String getName() {
    return this.getProperty(Macros.NAME);
  }

  public void setName(String value) {
    this.setProperty(Macros.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(Macros.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(Macros.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(Macros.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(Macros.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(Macros.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(Macros.VIRTUAL_PACKAGE, value);
  }

  public static Macros newInstance(SModel sm, boolean init) {
    return (Macros)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.dependency.structure.Macros", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Macros newInstance(SModel sm) {
    return Macros.newInstance(sm, false);
  }
}
