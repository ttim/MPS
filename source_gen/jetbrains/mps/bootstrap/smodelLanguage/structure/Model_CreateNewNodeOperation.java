package jetbrains.mps.bootstrap.smodelLanguage.structure;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;

public class Model_CreateNewNodeOperation extends SNodeOperation {
  public static String CONCEPT = "concept";

  public  Model_CreateNewNodeOperation(SNode node) {
    super(node);
  }

  public static Model_CreateNewNodeOperation newInstance(SModel sm, boolean init) {
    return (Model_CreateNewNodeOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.Model_CreateNewNodeOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static Model_CreateNewNodeOperation newInstance(SModel sm) {
    return Model_CreateNewNodeOperation.newInstance(sm, false);
  }

  public ConceptDeclaration getConcept() {
    return (ConceptDeclaration)this.getReferent(Model_CreateNewNodeOperation.CONCEPT);
  }
  public void setConcept(ConceptDeclaration node) {
    super.setReferent(Model_CreateNewNodeOperation.CONCEPT, node);
  }
}
