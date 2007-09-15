package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class StaticMethodCall extends BaseMethodCall {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.StaticMethodCall";
  public static String CLASS_CONCEPT = "classConcept";

  public  StaticMethodCall(SNode node) {
    super(node);
  }

  public static StaticMethodCall newInstance(SModel sm, boolean init) {
    return (StaticMethodCall)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticMethodCall", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static StaticMethodCall newInstance(SModel sm) {
    return StaticMethodCall.newInstance(sm, false);
  }


  public ClassConcept getClassConcept() {
    return (ClassConcept)this.getReferent(StaticMethodCall.CLASS_CONCEPT);
  }

  public void setClassConcept(ClassConcept node) {
    super.setReferent(StaticMethodCall.CLASS_CONCEPT, node);
  }

  public StaticMethodDeclaration getStaticMethodDeclaration() {
    return (StaticMethodDeclaration)this.getBaseMethodDeclaration();
  }

  public void setStaticMethodDeclaration(StaticMethodDeclaration node) {
    this.setBaseMethodDeclaration(node);
  }

}
