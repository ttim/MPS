package jetbrains.mps.bootstrap.smodelLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;

public class _LinkAccessT extends BaseConcept {
  public static final String concept = "jetbrains.mps.bootstrap.smodelLanguage.structure._LinkAccessT";
  public static String TARGET_CONCEPT = "targetConcept";

  public  _LinkAccessT(SNode node) {
    super(node);
  }

  public static _LinkAccessT newInstance(SModel sm, boolean init) {
    return (_LinkAccessT)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.structure._LinkAccessT", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static _LinkAccessT newInstance(SModel sm) {
    return _LinkAccessT.newInstance(sm, false);
  }


  public AbstractConceptDeclaration getTargetConcept() {
    return (AbstractConceptDeclaration)this.getReferent(_LinkAccessT.TARGET_CONCEPT);
  }

  public void setTargetConcept(AbstractConceptDeclaration node) {
    super.setReferent(_LinkAccessT.TARGET_CONCEPT, node);
  }

}
