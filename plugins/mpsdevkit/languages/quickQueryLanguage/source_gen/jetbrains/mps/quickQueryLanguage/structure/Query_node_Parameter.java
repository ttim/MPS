package jetbrains.mps.quickQueryLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Query_node_Parameter extends ConceptFunctionParameter {
  public static final String concept = "jetbrains.mps.quickQueryLanguage.structure.Query_node_Parameter";

  public Query_node_Parameter(SNode node) {
    super(node);
  }

  public static Query_node_Parameter newInstance(SModel sm, boolean init) {
    return (Query_node_Parameter) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.quickQueryLanguage.structure.Query_node_Parameter", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Query_node_Parameter newInstance(SModel sm) {
    return Query_node_Parameter.newInstance(sm, false);
  }
}
