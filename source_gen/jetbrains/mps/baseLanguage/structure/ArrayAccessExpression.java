package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ArrayAccessExpression extends Expression {
  public static String ARRAY = "array";
  public static String INDEX = "index";

  public  ArrayAccessExpression(SNode node) {
    super(node);
  }

  public static ArrayAccessExpression newInstance(SModel sm, boolean init) {
    return (ArrayAccessExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.ArrayAccessExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static ArrayAccessExpression newInstance(SModel sm) {
    return ArrayAccessExpression.newInstance(sm, false);
  }

  public Expression getArray() {
    return (Expression)this.getChild(ArrayAccessExpression.ARRAY);
  }
  public void setArray(Expression node) {
    super.setChild(ArrayAccessExpression.ARRAY, node);
  }
  public Expression getIndex() {
    return (Expression)this.getChild(ArrayAccessExpression.INDEX);
  }
  public void setIndex(Expression node) {
    super.setChild(ArrayAccessExpression.INDEX, node);
  }
}
