package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InequationReplacementRule extends AbstractSubtypingRule {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.InequationReplacementRule";
  public static final String SUPERTYPE_NODE = "supertypeNode";
  public static final String IS_APPLICABLE_CLAUSE = "isApplicableClause";

  public InequationReplacementRule(SNode node) {
    super(node);
  }

  public ApplicableNodeCondition getSupertypeNode() {
    return (ApplicableNodeCondition) this.getChild(ApplicableNodeCondition.class, InequationReplacementRule.SUPERTYPE_NODE);
  }

  public void setSupertypeNode(ApplicableNodeCondition node) {
    super.setChild(InequationReplacementRule.SUPERTYPE_NODE, node);
  }

  public IsReplacementRuleApplicable_ConceptFunction getIsApplicableClause() {
    return (IsReplacementRuleApplicable_ConceptFunction) this.getChild(IsReplacementRuleApplicable_ConceptFunction.class, InequationReplacementRule.IS_APPLICABLE_CLAUSE);
  }

  public void setIsApplicableClause(IsReplacementRuleApplicable_ConceptFunction node) {
    super.setChild(InequationReplacementRule.IS_APPLICABLE_CLAUSE, node);
  }

  public static InequationReplacementRule newInstance(SModel sm, boolean init) {
    return (InequationReplacementRule) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.InequationReplacementRule", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InequationReplacementRule newInstance(SModel sm) {
    return InequationReplacementRule.newInstance(sm, false);
  }
}
