package jetbrains.mps.regexp.structure;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InlineRegexpExpression extends RegexpExpression {
  public static String REGEXP = "regexp";

  public  InlineRegexpExpression(SNode node) {
    super(node);
  }

  public static InlineRegexpExpression newInstance(SModel sm, boolean init) {
    return (InlineRegexpExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.regexp.InlineRegexpExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static InlineRegexpExpression newInstance(SModel sm) {
    return InlineRegexpExpression.newInstance(sm, false);
  }

  public Regexp getRegexp() {
    return (Regexp)this.getChild(InlineRegexpExpression.REGEXP);
  }
  public void setRegexp(Regexp node) {
    super.setChild(InlineRegexpExpression.REGEXP, node);
  }
}
