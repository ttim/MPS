package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ContainsKeyOperation extends MapOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.ContainsKeyOperation";
  public static final String KEY = "key";

  public ContainsKeyOperation(SNode node) {
    super(node);
  }

  public Expression getKey() {
    return (Expression) this.getChild(Expression.class, ContainsKeyOperation.KEY);
  }

  public void setKey(Expression node) {
    super.setChild(ContainsKeyOperation.KEY, node);
  }

  public static ContainsKeyOperation newInstance(SModel sm, boolean init) {
    return (ContainsKeyOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ContainsKeyOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ContainsKeyOperation newInstance(SModel sm) {
    return ContainsKeyOperation.newInstance(sm, false);
  }
}
