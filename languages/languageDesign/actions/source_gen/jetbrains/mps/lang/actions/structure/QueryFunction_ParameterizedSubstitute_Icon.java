package jetbrains.mps.lang.actions.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class QueryFunction_ParameterizedSubstitute_Icon extends ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.actions.structure.QueryFunction_ParameterizedSubstitute_Icon";

  public QueryFunction_ParameterizedSubstitute_Icon(SNode node) {
    super(node);
  }

  public static QueryFunction_ParameterizedSubstitute_Icon newInstance(SModel sm, boolean init) {
    return (QueryFunction_ParameterizedSubstitute_Icon) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.actions.structure.QueryFunction_ParameterizedSubstitute_Icon", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static QueryFunction_ParameterizedSubstitute_Icon newInstance(SModel sm) {
    return QueryFunction_ParameterizedSubstitute_Icon.newInstance(sm, false);
  }
}
