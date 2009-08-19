package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SubMapOperation extends SortedMapOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.SubMapOperation";
  public static final String FROM_KEY = "fromKey";
  public static final String TO_KEY = "toKey";

  public SubMapOperation(SNode node) {
    super(node);
  }

  public Expression getFromKey() {
    return (Expression)this.getChild(Expression.class, SubMapOperation.FROM_KEY);
  }

  public void setFromKey(Expression node) {
    super.setChild(SubMapOperation.FROM_KEY, node);
  }

  public Expression getToKey() {
    return (Expression)this.getChild(Expression.class, SubMapOperation.TO_KEY);
  }

  public void setToKey(Expression node) {
    super.setChild(SubMapOperation.TO_KEY, node);
  }

  public static SubMapOperation newInstance(SModel sm, boolean init) {
    return (SubMapOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SubMapOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SubMapOperation newInstance(SModel sm) {
    return SubMapOperation.newInstance(sm, false);
  }
}
