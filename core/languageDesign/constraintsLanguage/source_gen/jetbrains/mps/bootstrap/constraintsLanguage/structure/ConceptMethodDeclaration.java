package jetbrains.mps.bootstrap.constraintsLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConceptMethodDeclaration extends BaseMethodDeclaration {
  public static final String concept = "jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration";
  public static String IS_VIRTUAL = "isVirtual";
  public static String IS_PRIVATE = "isPrivate";
  public static String IS_ABSTRACT = "isAbstract";
  public static String OVERRIDDEN_METHOD = "overriddenMethod";

  public  ConceptMethodDeclaration(SNode node) {
    super(node);
  }

  public static ConceptMethodDeclaration newInstance(SModel sm, boolean init) {
    return (ConceptMethodDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConceptMethodDeclaration newInstance(SModel sm) {
    return ConceptMethodDeclaration.newInstance(sm, false);
  }


  public boolean getIsVirtual() {
    return this.getBooleanProperty(ConceptMethodDeclaration.IS_VIRTUAL);
  }

  public void setIsVirtual(boolean value) {
    this.setBooleanProperty(ConceptMethodDeclaration.IS_VIRTUAL, value);
  }

  public boolean getIsPrivate() {
    return this.getBooleanProperty(ConceptMethodDeclaration.IS_PRIVATE);
  }

  public void setIsPrivate(boolean value) {
    this.setBooleanProperty(ConceptMethodDeclaration.IS_PRIVATE, value);
  }

  public boolean getIsAbstract() {
    return this.getBooleanProperty(ConceptMethodDeclaration.IS_ABSTRACT);
  }

  public void setIsAbstract(boolean value) {
    this.setBooleanProperty(ConceptMethodDeclaration.IS_ABSTRACT, value);
  }

  public ConceptMethodDeclaration getOverriddenMethod() {
    return (ConceptMethodDeclaration)this.getReferent(ConceptMethodDeclaration.OVERRIDDEN_METHOD);
  }

  public void setOverriddenMethod(ConceptMethodDeclaration node) {
    super.setReferent(ConceptMethodDeclaration.OVERRIDDEN_METHOD, node);
  }

}
