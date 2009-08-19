package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.AbstractLoopStatement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ForEachStatement extends AbstractLoopStatement {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.ForEachStatement";
  public static final String VARIABLE = "variable";
  public static final String INPUT_SEQUENCE = "inputSequence";

  public ForEachStatement(SNode node) {
    super(node);
  }

  public ForEachVariable getVariable() {
    return (ForEachVariable)this.getChild(ForEachVariable.class, ForEachStatement.VARIABLE);
  }

  public void setVariable(ForEachVariable node) {
    super.setChild(ForEachStatement.VARIABLE, node);
  }

  public Expression getInputSequence() {
    return (Expression)this.getChild(Expression.class, ForEachStatement.INPUT_SEQUENCE);
  }

  public void setInputSequence(Expression node) {
    super.setChild(ForEachStatement.INPUT_SEQUENCE, node);
  }

  public static ForEachStatement newInstance(SModel sm, boolean init) {
    return (ForEachStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ForEachStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ForEachStatement newInstance(SModel sm) {
    return ForEachStatement.newInstance(sm, false);
  }
}
