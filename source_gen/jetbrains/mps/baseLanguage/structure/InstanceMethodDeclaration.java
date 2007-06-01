package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration;
import jetbrains.mps.baseLanguage.structure.ClassifierMember;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.baseLanguage.structure.Visibility;

public class InstanceMethodDeclaration extends BaseMethodDeclaration implements ClassifierMember {
  public static String VISIBILITY = "visibility";
  public static String IS_ABSTRACT = "isAbstract";

  public  InstanceMethodDeclaration(SNode node) {
    super(node);
  }

  public static InstanceMethodDeclaration newInstance(SModel sm, boolean init) {
    return (InstanceMethodDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.InstanceMethodDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static InstanceMethodDeclaration newInstance(SModel sm) {
    return InstanceMethodDeclaration.newInstance(sm, false);
  }

  public Visibility getVisibility() {
    return (Visibility)this.getChild(InstanceMethodDeclaration.VISIBILITY);
  }
  public void setVisibility(Visibility node) {
    super.setChild(InstanceMethodDeclaration.VISIBILITY, node);
  }
  public boolean getIsAbstract() {
    return this.getBooleanProperty(InstanceMethodDeclaration.IS_ABSTRACT);
  }
  public void setIsAbstract(boolean value) {
    this.setBooleanProperty(InstanceMethodDeclaration.IS_ABSTRACT, value);
  }
}
