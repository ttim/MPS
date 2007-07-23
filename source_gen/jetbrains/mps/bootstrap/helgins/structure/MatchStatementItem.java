package jetbrains.mps.bootstrap.helgins.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.baseLanguage.structure.StatementList;

public class MatchStatementItem extends BaseConcept {
  public static String CONDITION = "condition";
  public static String IF_TRUE = "ifTrue";

  public  MatchStatementItem(SNode node) {
    super(node);
  }

  public static MatchStatementItem newInstance(SModel sm, boolean init) {
    return (MatchStatementItem)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.helgins.MatchStatementItem", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MatchStatementItem newInstance(SModel sm) {
    return MatchStatementItem.newInstance(sm, false);
  }


  public ApplicableNodeCondition getCondition() {
    return (ApplicableNodeCondition)this.getChild(MatchStatementItem.CONDITION);
  }

  public void setCondition(ApplicableNodeCondition node) {
    super.setChild(MatchStatementItem.CONDITION, node);
  }

  public StatementList getIfTrue() {
    return (StatementList)this.getChild(MatchStatementItem.IF_TRUE);
  }

  public void setIfTrue(StatementList node) {
    super.setChild(MatchStatementItem.IF_TRUE, node);
  }

}
