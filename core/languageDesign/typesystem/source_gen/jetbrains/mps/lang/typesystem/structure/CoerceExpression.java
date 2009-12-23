package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CoerceExpression extends Expression {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.CoerceExpression";
  public static final String PATTERN = "pattern";
  public static final String NODE_TO_COERCE = "nodeToCoerce";

  public CoerceExpression(SNode node) {
    super(node);
  }

  public ApplicableNodeCondition getPattern() {
    return (ApplicableNodeCondition) this.getChild(ApplicableNodeCondition.class, CoerceExpression.PATTERN);
  }

  public void setPattern(ApplicableNodeCondition node) {
    super.setChild(CoerceExpression.PATTERN, node);
  }

  public Expression getNodeToCoerce() {
    return (Expression) this.getChild(Expression.class, CoerceExpression.NODE_TO_COERCE);
  }

  public void setNodeToCoerce(Expression node) {
    super.setChild(CoerceExpression.NODE_TO_COERCE, node);
  }

  public static CoerceExpression newInstance(SModel sm, boolean init) {
    return (CoerceExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.CoerceExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CoerceExpression newInstance(SModel sm) {
    return CoerceExpression.newInstance(sm, false);
  }
}
