package jetbrains.mps.lang.refactoring.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MoveNodesToModelExpression extends AbstractMoveNodesExpression {
  public static final String concept = "jetbrains.mps.lang.refactoring.structure.MoveNodesToModelExpression";

  public MoveNodesToModelExpression(SNode node) {
    super(node);
  }

  public static MoveNodesToModelExpression newInstance(SModel sm, boolean init) {
    return (MoveNodesToModelExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.refactoring.structure.MoveNodesToModelExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MoveNodesToModelExpression newInstance(SModel sm) {
    return MoveNodesToModelExpression.newInstance(sm, false);
  }

}
