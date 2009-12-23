package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class IsReplacementRuleApplicable_ConceptFunction extends ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.IsReplacementRuleApplicable_ConceptFunction";

  public IsReplacementRuleApplicable_ConceptFunction(SNode node) {
    super(node);
  }

  public static IsReplacementRuleApplicable_ConceptFunction newInstance(SModel sm, boolean init) {
    return (IsReplacementRuleApplicable_ConceptFunction) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.IsReplacementRuleApplicable_ConceptFunction", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static IsReplacementRuleApplicable_ConceptFunction newInstance(SModel sm) {
    return IsReplacementRuleApplicable_ConceptFunction.newInstance(sm, false);
  }
}
