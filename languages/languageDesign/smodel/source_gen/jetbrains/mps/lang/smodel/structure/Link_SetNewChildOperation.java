package jetbrains.mps.lang.smodel.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.structure.ConceptDeclaration;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Link_SetNewChildOperation extends SNodeOperation {
  public static final String concept = "jetbrains.mps.lang.smodel.structure.Link_SetNewChildOperation";
  public static final String CONCEPT = "concept";

  public Link_SetNewChildOperation(SNode node) {
    super(node);
  }

  public ConceptDeclaration getConcept() {
    return (ConceptDeclaration) this.getReferent(ConceptDeclaration.class, Link_SetNewChildOperation.CONCEPT);
  }

  public void setConcept(ConceptDeclaration node) {
    super.setReferent(Link_SetNewChildOperation.CONCEPT, node);
  }

  public static Link_SetNewChildOperation newInstance(SModel sm, boolean init) {
    return (Link_SetNewChildOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.Link_SetNewChildOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Link_SetNewChildOperation newInstance(SModel sm) {
    return Link_SetNewChildOperation.newInstance(sm, false);
  }
}
