package jetbrains.mps.buildlanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BinaryOperation extends PropertyValueExpression {
  public static final String concept = "jetbrains.mps.buildlanguage.structure.BinaryOperation";
  public static final String CPR_Operation = "operation";
  public static final String LEFT = "left";
  public static final String RIGHT = "right";

  public BinaryOperation(SNode node) {
    super(node);
  }


  public PropertyValueExpression getLeft() {
    return (PropertyValueExpression)this.getChild(PropertyValueExpression.class, BinaryOperation.LEFT);
  }

  public void setLeft(PropertyValueExpression node) {
    super.setChild(BinaryOperation.LEFT, node);
  }

  public PropertyValueExpression getRight() {
    return (PropertyValueExpression)this.getChild(PropertyValueExpression.class, BinaryOperation.RIGHT);
  }

  public void setRight(PropertyValueExpression node) {
    super.setChild(BinaryOperation.RIGHT, node);
  }

  public static BinaryOperation newInstance(SModel sm, boolean init) {
    return (BinaryOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildlanguage.structure.BinaryOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BinaryOperation newInstance(SModel sm) {
    return BinaryOperation.newInstance(sm, false);
  }
}
