package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class StaticFieldDeclaration extends VariableDeclaration implements ClassifierMember {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration";
  public static String VISIBILITY = "visibility";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";

  public  StaticFieldDeclaration(SNode node) {
    super(node);
  }

  public static StaticFieldDeclaration newInstance(SModel sm, boolean init) {
    return (StaticFieldDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static StaticFieldDeclaration newInstance(SModel sm) {
    return StaticFieldDeclaration.newInstance(sm, false);
  }


  public Visibility getVisibility() {
    return (Visibility)this.getChild(StaticFieldDeclaration.VISIBILITY);
  }

  public void setVisibility(Visibility node) {
    super.setChild(StaticFieldDeclaration.VISIBILITY, node);
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

}
