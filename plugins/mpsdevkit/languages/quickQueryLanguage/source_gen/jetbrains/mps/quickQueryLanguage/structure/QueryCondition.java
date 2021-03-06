package jetbrains.mps.quickQueryLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class QueryCondition extends AbstractQueryFunction {
  public static final String concept = "jetbrains.mps.quickQueryLanguage.structure.QueryCondition";

  public QueryCondition(SNode node) {
    super(node);
  }

  public static QueryCondition newInstance(SModel sm, boolean init) {
    return (QueryCondition) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.quickQueryLanguage.structure.QueryCondition", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static QueryCondition newInstance(SModel sm) {
    return QueryCondition.newInstance(sm, false);
  }
}
