package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.IResolveInfo;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class LocalVariableDeclaration extends VariableDeclaration implements IResolveInfo {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration";
  public static String RESOLVE_INFO = "resolveInfo";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";

  public LocalVariableDeclaration(SNode node) {
    super(node);
  }

  public String getResolveInfo() {
    return this.getProperty(LocalVariableDeclaration.RESOLVE_INFO);
  }

  public void setResolveInfo(String value) {
    this.setProperty(LocalVariableDeclaration.RESOLVE_INFO, value);
  }

  public String getShortDescription() {
    return this.getProperty(LocalVariableDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(LocalVariableDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(LocalVariableDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(LocalVariableDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(LocalVariableDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(LocalVariableDeclaration.VIRTUAL_PACKAGE, value);
  }


  public static LocalVariableDeclaration newInstance(SModel sm, boolean init) {
    return (LocalVariableDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static LocalVariableDeclaration newInstance(SModel sm) {
    return LocalVariableDeclaration.newInstance(sm, false);
  }

}
