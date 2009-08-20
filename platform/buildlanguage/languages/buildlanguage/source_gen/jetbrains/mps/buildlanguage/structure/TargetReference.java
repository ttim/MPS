package jetbrains.mps.buildlanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TargetReference extends BaseConcept {
  public static final String concept = "jetbrains.mps.buildlanguage.structure.TargetReference";
  public static final String TARGET_DECLARATION = "targetDeclaration";

  public TargetReference(SNode node) {
    super(node);
  }


  public TargetDeclaration getTargetDeclaration() {
    return (TargetDeclaration)this.getReferent(TargetDeclaration.class, TargetReference.TARGET_DECLARATION);
  }

  public void setTargetDeclaration(TargetDeclaration node) {
    super.setReferent(TargetReference.TARGET_DECLARATION, node);
  }

  public static TargetReference newInstance(SModel sm, boolean init) {
    return (TargetReference)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildlanguage.structure.TargetReference", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TargetReference newInstance(SModel sm) {
    return TargetReference.newInstance(sm, false);
  }
}
