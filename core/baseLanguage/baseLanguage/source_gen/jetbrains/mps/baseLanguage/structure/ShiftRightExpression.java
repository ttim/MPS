package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.BinaryBitwiseOperation;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ShiftRightExpression extends BinaryBitwiseOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.ShiftRightExpression";

  public ShiftRightExpression(SNode node) {
    super(node);
  }

  public static ShiftRightExpression newInstance(SModel sm, boolean init) {
    return (ShiftRightExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ShiftRightExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ShiftRightExpression newInstance(SModel sm) {
    return ShiftRightExpression.newInstance(sm, false);
  }

}
