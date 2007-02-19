package jetbrains.mps.bootstrap.smodelLanguage.structure;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;

public class Node_ReplaceWithNewOperation extends SNodeOperation {
  public static String CONCEPT = "concept";

  public  Node_ReplaceWithNewOperation(SNode node) {
    super(node);
  }

  public static Node_ReplaceWithNewOperation newInstance(SModel sm, boolean init) {
    return (Node_ReplaceWithNewOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.Node_ReplaceWithNewOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static Node_ReplaceWithNewOperation newInstance(SModel sm) {
    return Node_ReplaceWithNewOperation.newInstance(sm, false);
  }

  public ConceptDeclaration getConcept() {
    return (ConceptDeclaration)this.getReferent(Node_ReplaceWithNewOperation.CONCEPT);
  }
  public void setConcept(ConceptDeclaration node) {
    super.setReferent(Node_ReplaceWithNewOperation.CONCEPT, node);
  }
}
