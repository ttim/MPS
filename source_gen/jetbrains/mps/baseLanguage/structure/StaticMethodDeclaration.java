package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class StaticMethodDeclaration extends BaseMethodDeclaration implements ClassifierMember {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration";
  public static String VISIBILITY = "visibility";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";

  public  StaticMethodDeclaration(SNode node) {
    super(node);
  }

  public static StaticMethodDeclaration newInstance(SModel sm, boolean init) {
    return (StaticMethodDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static StaticMethodDeclaration newInstance(SModel sm) {
    return StaticMethodDeclaration.newInstance(sm, false);
  }


  public Visibility getVisibility() {
    return (Visibility)this.getChild(StaticMethodDeclaration.VISIBILITY);
  }

  public void setVisibility(Visibility node) {
    super.setChild(StaticMethodDeclaration.VISIBILITY, node);
  }

  public String getShortDescription() {
    return this.getProperty(StaticMethodDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(StaticMethodDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(StaticMethodDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(StaticMethodDeclaration.ALIAS, value);
  }

}
