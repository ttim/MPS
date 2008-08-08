package jetbrains.mps.bootstrap.helgins.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ImmediateSupertypesExpression extends Expression {
  public static final String concept = "jetbrains.mps.bootstrap.helgins.structure.ImmediateSupertypesExpression";
  public static String SUBTYPE_EXPRESSION = "subtypeExpression";

  public ImmediateSupertypesExpression(SNode node) {
    super(node);
  }

  public Expression getSubtypeExpression() {
    return (Expression)this.getChild(ImmediateSupertypesExpression.SUBTYPE_EXPRESSION);
  }

  public void setSubtypeExpression(Expression node) {
    super.setChild(ImmediateSupertypesExpression.SUBTYPE_EXPRESSION, node);
  }


  public static ImmediateSupertypesExpression newInstance(SModel sm, boolean init) {
    return (ImmediateSupertypesExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.helgins.structure.ImmediateSupertypesExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ImmediateSupertypesExpression newInstance(SModel sm) {
    return ImmediateSupertypesExpression.newInstance(sm, false);
  }

}
