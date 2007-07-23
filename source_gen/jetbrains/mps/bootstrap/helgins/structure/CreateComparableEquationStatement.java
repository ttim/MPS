package jetbrains.mps.bootstrap.helgins.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CreateComparableEquationStatement extends AbstractEquationStatement {

  public  CreateComparableEquationStatement(SNode node) {
    super(node);
  }

  public static CreateComparableEquationStatement newInstance(SModel sm, boolean init) {
    return (CreateComparableEquationStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.helgins.CreateComparableEquationStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CreateComparableEquationStatement newInstance(SModel sm) {
    return CreateComparableEquationStatement.newInstance(sm, false);
  }

}
