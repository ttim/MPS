package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class OperationAssignmentExpression extends BaseAssignmentExpression {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.OperationAssignmentExpression";

  public OperationAssignmentExpression(SNode node) {
    super(node);
  }

  public static OperationAssignmentExpression newInstance(SModel sm, boolean init) {
    return (OperationAssignmentExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.OperationAssignmentExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static OperationAssignmentExpression newInstance(SModel sm) {
    return OperationAssignmentExpression.newInstance(sm, false);
  }
}
