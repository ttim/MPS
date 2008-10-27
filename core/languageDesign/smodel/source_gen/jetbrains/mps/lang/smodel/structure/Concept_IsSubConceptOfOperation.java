package jetbrains.mps.lang.smodel.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Concept_IsSubConceptOfOperation extends SNodeOperation {
  public static final String concept = "jetbrains.mps.lang.smodel.structure.Concept_IsSubConceptOfOperation";
  public static final String CONCEPT_ARGUMENT = "conceptArgument";

  public Concept_IsSubConceptOfOperation(SNode node) {
    super(node);
  }

  public IRefConceptArg getConceptArgument() {
    return (IRefConceptArg)this.getChild(Concept_IsSubConceptOfOperation.CONCEPT_ARGUMENT);
  }

  public void setConceptArgument(IRefConceptArg node) {
    super.setChild(Concept_IsSubConceptOfOperation.CONCEPT_ARGUMENT, node);
  }


  public static Concept_IsSubConceptOfOperation newInstance(SModel sm, boolean init) {
    return (Concept_IsSubConceptOfOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.Concept_IsSubConceptOfOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Concept_IsSubConceptOfOperation newInstance(SModel sm) {
    return Concept_IsSubConceptOfOperation.newInstance(sm, false);
  }

}
