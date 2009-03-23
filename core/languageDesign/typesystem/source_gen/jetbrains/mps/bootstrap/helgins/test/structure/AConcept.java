package jetbrains.mps.bootstrap.helgins.test.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AConcept extends BaseConcept {
  public static final String concept = "jetbrains.mps.bootstrap.helgins.test.structure.AConcept";
  public static final String EXPRESSION = "expression";

  public AConcept(SNode node) {
    super(node);
  }

  public Expression getExpression() {
    return (Expression)this.getChild(Expression.class, AConcept.EXPRESSION);
  }

  public void setExpression(Expression node) {
    super.setChild(AConcept.EXPRESSION, node);
  }


  public static AConcept newInstance(SModel sm, boolean init) {
    return (AConcept)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.helgins.test.structure.AConcept", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AConcept newInstance(SModel sm) {
    return AConcept.newInstance(sm, false);
  }

}
