package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConstructorDeclaration extends BaseMethodDeclaration implements ClassifierMember {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VISIBILITY = "visibility";

  public  ConstructorDeclaration(SNode node) {
    super(node);
  }

  public static ConstructorDeclaration newInstance(SModel sm, boolean init) {
    return (ConstructorDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ConstructorDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConstructorDeclaration newInstance(SModel sm) {
    return ConstructorDeclaration.newInstance(sm, false);
  }


  public String getShortDescription() {
    return this.getProperty(ConstructorDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ConstructorDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ConstructorDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ConstructorDeclaration.ALIAS, value);
  }

  public Visibility getVisibility() {
    return (Visibility)this.getChild(ConstructorDeclaration.VISIBILITY);
  }

  public void setVisibility(Visibility node) {
    super.setChild(ConstructorDeclaration.VISIBILITY, node);
  }

}
