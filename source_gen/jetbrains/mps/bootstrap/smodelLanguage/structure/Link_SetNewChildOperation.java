package jetbrains.mps.bootstrap.smodelLanguage.structure;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;

public class Link_SetNewChildOperation extends SNodeOperation {
  public static String CONCEPT = "concept";

  public  Link_SetNewChildOperation(SNode node) {
    super(node);
  }

  public static Link_SetNewChildOperation newInstance(SModel sm, boolean init) {
    return (Link_SetNewChildOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.Link_SetNewChildOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static Link_SetNewChildOperation newInstance(SModel sm) {
    return Link_SetNewChildOperation.newInstance(sm, false);
  }

  public ConceptDeclaration getConcept() {
    return (ConceptDeclaration)this.getReferent(Link_SetNewChildOperation.CONCEPT);
  }
  public void setConcept(ConceptDeclaration node) {
    super.setReferent(Link_SetNewChildOperation.CONCEPT, node);
  }
}
