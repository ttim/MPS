package jetbrains.mps.bootstrap.helgins.structure;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.patterns.structure.PatternExpression;

public class PatternCondition extends ApplicableNodeCondition {
  public static String PATTERN = "pattern";

  public  PatternCondition(SNode node) {
    super(node);
  }

  public static PatternCondition newInstance(SModel sm, boolean init) {
    return (PatternCondition)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.helgins.PatternCondition", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static PatternCondition newInstance(SModel sm) {
    return PatternCondition.newInstance(sm, false);
  }

  public PatternExpression getPattern() {
    return (PatternExpression)this.getChild(PatternCondition.PATTERN);
  }
  public void setPattern(PatternExpression node) {
    super.setChild(PatternCondition.PATTERN, node);
  }
}
