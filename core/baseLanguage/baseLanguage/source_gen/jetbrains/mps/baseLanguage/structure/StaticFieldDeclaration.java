package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.IResolveInfo;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class StaticFieldDeclaration extends VariableDeclaration implements ClassifierMember, IResolveInfo, IBLDeprecatable {
public    static final String concept = "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration";
public    static final String SHORT_DESCRIPTION = "shortDescription";
public    static final String ALIAS = "alias";
public    static final String VIRTUAL_PACKAGE = "virtualPackage";
public    static final String RESOLVE_INFO = "resolveInfo";
public    static final String IS_DEPRECATED = "isDeprecated";
public    static final String BUILD = "build";
public    static final String VISIBILITY = "visibility";

  public StaticFieldDeclaration(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(StaticFieldDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(StaticFieldDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(StaticFieldDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(StaticFieldDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(StaticFieldDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(StaticFieldDeclaration.VIRTUAL_PACKAGE, value);
  }

  public String getResolveInfo() {
    return this.getProperty(StaticFieldDeclaration.RESOLVE_INFO);
  }

  public void setResolveInfo(String value) {
    this.setProperty(StaticFieldDeclaration.RESOLVE_INFO, value);
  }

  public boolean getIsDeprecated() {
    return this.getBooleanProperty(StaticFieldDeclaration.IS_DEPRECATED);
  }

  public void setIsDeprecated(boolean value) {
    this.setBooleanProperty(StaticFieldDeclaration.IS_DEPRECATED, value);
  }

  public int getBuild() {
    return this.getIntegerProperty(StaticFieldDeclaration.BUILD);
  }

  public void setBuild(int value) {
    this.setIntegerProperty(StaticFieldDeclaration.BUILD, value);
  }

  public Visibility getVisibility() {
    return (Visibility)this.getChild(StaticFieldDeclaration.VISIBILITY);
  }

  public void setVisibility(Visibility node) {
    super.setChild(StaticFieldDeclaration.VISIBILITY, node);
  }


  public static StaticFieldDeclaration newInstance(SModel sm, boolean init) {
    return (StaticFieldDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static StaticFieldDeclaration newInstance(SModel sm) {
    return StaticFieldDeclaration.newInstance(sm, false);
  }

}
