package jetbrains.mps.bootstrap.helgins.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CreateComparableEquationStatementStrong extends AbstractEquationStatement {

  public  CreateComparableEquationStatementStrong(SNode node) {
    super(node);
  }

  public static CreateComparableEquationStatementStrong newInstance(SModel sm, boolean init) {
    return (CreateComparableEquationStatementStrong)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.helgins.CreateComparableEquationStatementStrong", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CreateComparableEquationStatementStrong newInstance(SModel sm) {
    return CreateComparableEquationStatementStrong.newInstance(sm, false);
  }

}
