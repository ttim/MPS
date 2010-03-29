package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TreeSetCreator extends HashSetCreator {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.TreeSetCreator";
  public static final String COMPARATOR = "comparator";

  public TreeSetCreator(SNode node) {
    super(node);
  }

  public Expression getComparator() {
    return (Expression) this.getChild(Expression.class, TreeSetCreator.COMPARATOR);
  }

  public void setComparator(Expression node) {
    super.setChild(TreeSetCreator.COMPARATOR, node);
  }

  public static TreeSetCreator newInstance(SModel sm, boolean init) {
    return (TreeSetCreator) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.TreeSetCreator", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TreeSetCreator newInstance(SModel sm) {
    return TreeSetCreator.newInstance(sm, false);
  }
}
