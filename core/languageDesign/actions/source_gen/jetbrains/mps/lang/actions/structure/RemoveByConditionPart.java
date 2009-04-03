package jetbrains.mps.lang.actions.structure;

/*Generated by MPS */

import jetbrains.mps.lang.actions.structure.MenuBuilderPart;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.actions.structure.QueryFunction_RemoveBy_Condition;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class RemoveByConditionPart extends MenuBuilderPart {
  public static final String concept = "jetbrains.mps.lang.actions.structure.RemoveByConditionPart";
  public static final String CONDITION = "condition";

  public RemoveByConditionPart(SNode node) {
    super(node);
  }

  public QueryFunction_RemoveBy_Condition getCondition() {
    return (QueryFunction_RemoveBy_Condition)this.getChild(QueryFunction_RemoveBy_Condition.class, RemoveByConditionPart.CONDITION);
  }

  public void setCondition(QueryFunction_RemoveBy_Condition node) {
    super.setChild(RemoveByConditionPart.CONDITION, node);
  }


  public static RemoveByConditionPart newInstance(SModel sm, boolean init) {
    return (RemoveByConditionPart)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.actions.structure.RemoveByConditionPart", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static RemoveByConditionPart newInstance(SModel sm) {
    return RemoveByConditionPart.newInstance(sm, false);
  }

}
