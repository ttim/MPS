package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AssignmentExpression extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.AssignmentExpression";
  public static String L_VALUE = "lValue";
  public static String R_VALUE = "rValue";

  public  AssignmentExpression(SNode node) {
    super(node);
  }

  public static AssignmentExpression newInstance(SModel sm, boolean init) {
    return (AssignmentExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.AssignmentExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AssignmentExpression newInstance(SModel sm) {
    return AssignmentExpression.newInstance(sm, false);
  }


  public Expression getLValue() {
    return (Expression)this.getChild(AssignmentExpression.L_VALUE);
  }

  public void setLValue(Expression node) {
    super.setChild(AssignmentExpression.L_VALUE, node);
  }

  public Expression getRValue() {
    return (Expression)this.getChild(AssignmentExpression.R_VALUE);
  }

  public void setRValue(Expression node) {
    super.setChild(AssignmentExpression.R_VALUE, node);
  }

}
