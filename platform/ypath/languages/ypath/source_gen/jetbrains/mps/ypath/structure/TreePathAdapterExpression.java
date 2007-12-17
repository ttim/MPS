package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TreePathAdapterExpression extends Expression {
  public static final String concept = "jetbrains.mps.ypath.structure.TreePathAdapterExpression";
  public static String EXPRESSION = "expression";
  public static String TREEPATH_ASPECT = "treepathAspect";

  public  TreePathAdapterExpression(SNode node) {
    super(node);
  }

  public static TreePathAdapterExpression newInstance(SModel sm, boolean init) {
    return (TreePathAdapterExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.TreePathAdapterExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TreePathAdapterExpression newInstance(SModel sm) {
    return TreePathAdapterExpression.newInstance(sm, false);
  }


  public Expression getExpression() {
    return (Expression)this.getChild(TreePathAdapterExpression.EXPRESSION);
  }

  public void setExpression(Expression node) {
    super.setChild(TreePathAdapterExpression.EXPRESSION, node);
  }

  public TreePathAspect getTreepathAspect() {
    return (TreePathAspect)this.getReferent(TreePathAdapterExpression.TREEPATH_ASPECT);
  }

  public void setTreepathAspect(TreePathAspect node) {
    super.setReferent(TreePathAdapterExpression.TREEPATH_ASPECT, node);
  }

}
