package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ShiftRightUnsignedExpression extends BinaryBitwiseOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.ShiftRightUnsignedExpression";

  public ShiftRightUnsignedExpression(SNode node) {
    super(node);
  }

  public static ShiftRightUnsignedExpression newInstance(SModel sm, boolean init) {
    return (ShiftRightUnsignedExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ShiftRightUnsignedExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ShiftRightUnsignedExpression newInstance(SModel sm) {
    return ShiftRightUnsignedExpression.newInstance(sm, false);
  }
}
