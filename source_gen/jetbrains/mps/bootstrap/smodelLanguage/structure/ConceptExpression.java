package jetbrains.mps.bootstrap.smodelLanguage.structure;

/*Generated by MPS  */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;

public class ConceptExpression extends Expression {
  public static String CONCEPT_DECLARATION = "conceptDeclaration";

  public  ConceptExpression(SNode node) {
    super(node);
  }

  public static ConceptExpression newInstance(SModel sm, boolean init) {
    return (ConceptExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.ConceptExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static ConceptExpression newInstance(SModel sm) {
    return ConceptExpression.newInstance(sm, false);
  }

  public ConceptDeclaration getConceptDeclaration() {
    return (ConceptDeclaration)this.getReferent(ConceptExpression.CONCEPT_DECLARATION);
  }
  public void setConceptDeclaration(ConceptDeclaration node) {
    super.setReferent(ConceptExpression.CONCEPT_DECLARATION, node);
  }
}
