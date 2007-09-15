package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ForeachStatement extends AbstractForStatement {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.ForeachStatement";
  public static String ITERABLE = "iterable";

  public  ForeachStatement(SNode node) {
    super(node);
  }

  public static ForeachStatement newInstance(SModel sm, boolean init) {
    return (ForeachStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ForeachStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ForeachStatement newInstance(SModel sm) {
    return ForeachStatement.newInstance(sm, false);
  }


  public Expression getIterable() {
    return (Expression)this.getChild(ForeachStatement.ITERABLE);
  }

  public void setIterable(Expression node) {
    super.setChild(ForeachStatement.ITERABLE, node);
  }

}
