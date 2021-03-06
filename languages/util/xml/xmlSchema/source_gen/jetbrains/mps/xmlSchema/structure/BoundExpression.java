package jetbrains.mps.xmlSchema.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BoundExpression extends MaxOccursExpression {
  public static final String concept = "jetbrains.mps.xmlSchema.structure.BoundExpression";
  public static final String MAX_OCCURS = "maxOccurs";

  public BoundExpression(SNode node) {
    super(node);
  }

  public int getMaxOccurs() {
    return this.getIntegerProperty(BoundExpression.MAX_OCCURS);
  }

  public void setMaxOccurs(int value) {
    this.setIntegerProperty(BoundExpression.MAX_OCCURS, value);
  }

  public static BoundExpression newInstance(SModel sm, boolean init) {
    return (BoundExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlSchema.structure.BoundExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BoundExpression newInstance(SModel sm) {
    return BoundExpression.newInstance(sm, false);
  }
}
