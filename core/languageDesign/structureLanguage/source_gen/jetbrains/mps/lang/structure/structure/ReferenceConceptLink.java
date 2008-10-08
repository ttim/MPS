package jetbrains.mps.lang.structure.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ReferenceConceptLink extends ConceptLink {
  public static final String concept = "jetbrains.mps.lang.structure.structure.ReferenceConceptLink";
  public static String TARGET = "target";

  public ReferenceConceptLink(SNode node) {
    super(node);
  }

  public BaseConcept getTarget() {
    return (BaseConcept)this.getReferent(ReferenceConceptLink.TARGET);
  }

  public void setTarget(BaseConcept node) {
    super.setReferent(ReferenceConceptLink.TARGET, node);
  }

  public ReferenceConceptLinkDeclaration getReferenceConceptLinkDeclaration() {
    return (ReferenceConceptLinkDeclaration)this.getConceptLinkDeclaration();
  }

  public void setReferenceConceptLinkDeclaration(ReferenceConceptLinkDeclaration node) {
    this.setConceptLinkDeclaration(node);
  }


  public static ReferenceConceptLink newInstance(SModel sm, boolean init) {
    return (ReferenceConceptLink)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.structure.structure.ReferenceConceptLink", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ReferenceConceptLink newInstance(SModel sm) {
    return ReferenceConceptLink.newInstance(sm, false);
  }

}
