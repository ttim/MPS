package jetbrains.mps.lang.structure.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class DataTypeDeclaration extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.lang.structure.structure.DataTypeDeclaration";
  public static String NAME = "name";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";

  public DataTypeDeclaration(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(DataTypeDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(DataTypeDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(DataTypeDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(DataTypeDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(DataTypeDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(DataTypeDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(DataTypeDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(DataTypeDeclaration.VIRTUAL_PACKAGE, value);
  }


  public static DataTypeDeclaration newInstance(SModel sm, boolean init) {
    return (DataTypeDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.structure.structure.DataTypeDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static DataTypeDeclaration newInstance(SModel sm) {
    return DataTypeDeclaration.newInstance(sm, false);
  }

}
