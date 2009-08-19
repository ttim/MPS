package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ForStatement extends AbstractForStatement {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.ForStatement";
  public static final String CONDITION = "condition";
  public static final String ITERATION = "iteration";

  public ForStatement(SNode node) {
    super(node);
  }

  public Expression getCondition() {
    return (Expression)this.getChild(Expression.class, ForStatement.CONDITION);
  }

  public void setCondition(Expression node) {
    super.setChild(ForStatement.CONDITION, node);
  }

  public Expression getIteration() {
    return (Expression)this.getChild(Expression.class, ForStatement.ITERATION);
  }

  public void setIteration(Expression node) {
    super.setChild(ForStatement.ITERATION, node);
  }

  public static ForStatement newInstance(SModel sm, boolean init) {
    return (ForStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ForStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ForStatement newInstance(SModel sm) {
    return ForStatement.newInstance(sm, false);
  }
}
