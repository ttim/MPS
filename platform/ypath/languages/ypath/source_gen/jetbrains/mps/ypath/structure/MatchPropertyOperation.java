package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.baseLanguage.structure.Expression;

public class MatchPropertyOperation extends MatchKindOperation {
  public static String MATCH_EXPRESSION = "matchExpression";
  public static String PROPERTY = "property";

  public  MatchPropertyOperation(SNode node) {
    super(node);
  }

  public static MatchPropertyOperation newInstance(SModel sm, boolean init) {
    return (MatchPropertyOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.MatchPropertyOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MatchPropertyOperation newInstance(SModel sm) {
    return MatchPropertyOperation.newInstance(sm, false);
  }


  public Expression getMatchExpression() {
    return (Expression)this.getChild(MatchPropertyOperation.MATCH_EXPRESSION);
  }

  public void setMatchExpression(Expression node) {
    super.setChild(MatchPropertyOperation.MATCH_EXPRESSION, node);
  }

  public TreeNodeKindProperty getProperty() {
    return (TreeNodeKindProperty)this.getReferent(MatchPropertyOperation.PROPERTY);
  }

  public void setProperty(TreeNodeKindProperty node) {
    super.setReferent(MatchPropertyOperation.PROPERTY, node);
  }

}
