package jetbrains.mps.bootstrap.actionsLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConceptsSubstituteMenuPart extends SubstituteMenuPart {
  public static final String concept = "jetbrains.mps.bootstrap.actionsLanguage.structure.ConceptsSubstituteMenuPart";
  public static String QUERY = "query";

  public  ConceptsSubstituteMenuPart(SNode node) {
    super(node);
  }

  public static ConceptsSubstituteMenuPart newInstance(SModel sm, boolean init) {
    return (ConceptsSubstituteMenuPart)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.actionsLanguage.structure.ConceptsSubstituteMenuPart", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConceptsSubstituteMenuPart newInstance(SModel sm) {
    return ConceptsSubstituteMenuPart.newInstance(sm, false);
  }


  public QueryFunction_ParameterizedSubstitute_Query getQuery() {
    return (QueryFunction_ParameterizedSubstitute_Query)this.getChild(ConceptsSubstituteMenuPart.QUERY);
  }

  public void setQuery(QueryFunction_ParameterizedSubstitute_Query node) {
    super.setChild(ConceptsSubstituteMenuPart.QUERY, node);
  }

}
